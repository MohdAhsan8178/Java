package java_files;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Question 12: Create a custom annotation and a processor that injects
 * dependencies (similar to a very simple version of Spring's @Autowired or @Inject).
 *
 * Demonstrates:
 * 1. Defining @Component and @Inject annotations.
 * 2. Implementing a lightweight Inversion of Control (IoC) DI Container.
 * 3. Reflection-driven bean registration, instantiation, and field dependency wiring.
 */
public class Q12_CustomAnnotationDependencyInjection {

    // --- DI Annotations ---

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    public @interface Component {}

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface Inject {}

    // --- Service Components ---

    @Component
    public static class DatabaseService {
        public void persist(String record) {
            System.out.println("  [DatabaseService] Successfully wrote to database: '" + record + "'");
        }
    }

    @Component
    public static class NotificationService {
        public void sendNotification(String message, String recipient) {
            System.out.println("  [NotificationService] Sent message to " + recipient + ": " + message);
        }
    }

    @Component
    public static class OrderProcessingController {

        @Inject
        private DatabaseService databaseService;

        @Inject
        private NotificationService notificationService;

        public void processOrder(String orderId, String customerEmail, double amount) {
            System.out.println("[OrderProcessingController] Handling incoming order: " + orderId + " ($" + amount + ")");
            databaseService.persist("ORDER_ID=" + orderId + ";TOTAL=" + amount);
            notificationService.sendNotification("Your order " + orderId + " has been confirmed!", customerEmail);
            System.out.println("[OrderProcessingController] Order processing workflow completed successfully.");
        }
    }

    // --- Micro Dependency Injection Container ---

    public static class SimpleContainer {
        private final Map<Class<?>, Object> singletonRegistry = new HashMap<>();

        public <T> T getBean(Class<T> clazz) {
            if (singletonRegistry.containsKey(clazz)) {
                return clazz.cast(singletonRegistry.get(clazz));
            }

            if (!clazz.isAnnotationPresent(Component.class)) {
                throw new IllegalStateException("Class " + clazz.getName() + " is not registered as a @Component");
            }

            try {
                // 1. Instantiate the bean via no-arg constructor
                Constructor<T> constructor = clazz.getDeclaredConstructor();
                constructor.setAccessible(true);
                T instance = constructor.newInstance();
                singletonRegistry.put(clazz, instance);

                // 2. Resolve and inject @Inject annotated fields
                for (Field field : clazz.getDeclaredFields()) {
                    if (field.isAnnotationPresent(Inject.class)) {
                        field.setAccessible(true);
                        Class<?> fieldType = field.getType();
                        Object dependency = getBean(fieldType); // Recursive dependency resolution
                        field.set(instance, dependency);
                    }
                }

                return instance;
            } catch (Exception e) {
                throw new RuntimeException("Failed to instantiate and inject bean: " + clazz.getName(), e);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Custom Annotation-Driven Dependency Injection Container Demo ===");

        SimpleContainer container = new SimpleContainer();

        System.out.println("\nResolving OrderProcessingController from SimpleContainer...");
        OrderProcessingController controller = container.getBean(OrderProcessingController.class);

        System.out.println("\nExecuting Controller Workflow:");
        controller.processOrder("ORD-2026-8891", "student@university.edu", 249.99);

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
