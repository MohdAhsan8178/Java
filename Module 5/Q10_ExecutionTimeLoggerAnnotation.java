package java_files;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * Question 10: Write a program that uses reflection to find and log the
 * execution time of methods annotated with a custom annotation.
 *
 * Demonstrates:
 * 1. Defining custom @LogExecutionTime annotation with configurable time units.
 * 2. Using reflection to scan class methods for the custom annotation.
 * 3. Measuring, benchmarking, and logging execution metrics dynamically.
 */
public class Q10_ExecutionTimeLoggerAnnotation {

    // Custom annotation to mark methods for execution timing
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface LogExecutionTime {
        TimeUnit unit() default TimeUnit.MILLISECONDS;
        String description() default "Execution Benchmark";
    }

    // Service class containing computational tasks
    public static class DataProcessingService {

        @LogExecutionTime(unit = TimeUnit.MILLISECONDS, description = "Array Sorting Algorithm")
        public void performHeavySorting() {
            int[] numbers = new int[50000];
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = (int) (Math.random() * 100000);
            }
            Arrays.sort(numbers);
        }

        @LogExecutionTime(unit = TimeUnit.MICROSECONDS, description = "Prime Number Computation")
        public int countPrimesUpTo(int limit) {
            int count = 0;
            for (int num = 2; num <= limit; num++) {
                if (isPrime(num)) {
                    count++;
                }
            }
            return count;
        }

        // Method without annotation (will not be logged by profiler)
        public void unmonitoredTask() {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        @LogExecutionTime(unit = TimeUnit.NANOSECONDS, description = "String Concatenation Test")
        public String concatenateStrings(int count) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < count; i++) {
                sb.append("Item").append(i).append(";");
            }
            return sb.toString();
        }

        private boolean isPrime(int n) {
            if (n <= 1) return false;
            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) return false;
            }
            return true;
        }
    }

    // Profiler Engine that inspects and invokes annotated methods
    public static class PerformanceProfiler {

        public static void profileMethods(Object target) {
            Class<?> clazz = target.getClass();
            System.out.println("--- Profiling Annotated Methods in " + clazz.getSimpleName() + " ---");

            Method[] methods = clazz.getDeclaredMethods();
            int annotatedMethodCount = 0;

            for (Method method : methods) {
                if (method.isAnnotationPresent(LogExecutionTime.class)) {
                    annotatedMethodCount++;
                    LogExecutionTime annotation = method.getAnnotation(LogExecutionTime.class);
                    method.setAccessible(true);

                    try {
                        long startNano = System.nanoTime();

                        // Invoke method with appropriate sample arguments if needed
                        Object result = null;
                        if (method.getParameterCount() == 0) {
                            result = method.invoke(target);
                        } else if (method.getParameterTypes()[0] == int.class) {
                            result = method.invoke(target, 5000);
                        }

                        long endNano = System.nanoTime();
                        long durationNano = endNano - startNano;

                        long convertedDuration;
                        String unitName;
                        switch (annotation.unit()) {
                            case NANOSECONDS:
                                convertedDuration = durationNano;
                                unitName = "ns";
                                break;
                            case MICROSECONDS:
                                convertedDuration = durationNano / 1_000;
                                unitName = "µs";
                                break;
                            case MILLISECONDS:
                            default:
                                convertedDuration = durationNano / 1_000_000;
                                unitName = "ms";
                                break;
                        }

                        System.out.printf("[PROFILER] Method: %-25s | Label: %-28s | Time: %6d %-3s | Result: %s%n",
                                method.getName(),
                                annotation.description(),
                                convertedDuration,
                                unitName,
                                result != null ? result : "void");

                    } catch (Exception e) {
                        System.err.println("Failed to execute method " + method.getName() + ": " + e.getMessage());
                    }
                }
            }

            System.out.println("Total annotated methods profiled: " + annotatedMethodCount);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Custom Annotation Execution Time Logger Demo ===");

        DataProcessingService service = new DataProcessingService();
        PerformanceProfiler.profileMethods(service);

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
