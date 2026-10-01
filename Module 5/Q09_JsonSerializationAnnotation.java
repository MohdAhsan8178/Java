package java_files;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Question 9: Create a custom annotation to map a Java class to a JSON string.
 *
 * Demonstrates:
 * 1. Defining custom @JsonSerializable and @JsonElement annotations.
 * 2. Implementing a reflection-based JSON serialization engine.
 * 3. Handling custom field key mappings and data types (String, Number, Boolean, nested/null).
 */
public class Q09_JsonSerializationAnnotation {

    // Annotation to mark a class as JSON-serializable
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    public @interface JsonSerializable {}

    // Annotation to mark fields that should be included in JSON output
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface JsonElement {
        String key() default "";
    }

    // Annotation to explicitly ignore a field
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface JsonIgnore {}

    // Model class using custom JSON annotations
    @JsonSerializable
    public static class UserProfile {
        @JsonElement(key = "user_id")
        private final int id;

        @JsonElement(key = "full_name")
        private final String name;

        @JsonElement(key = "email_address")
        private final String email;

        @JsonElement(key = "is_active")
        private final boolean active;

        @JsonElement(key = "account_balance")
        private final double balance;

        @JsonIgnore
        private final String internalPasswordHash;

        public UserProfile(int id, String name, String email, boolean active, double balance, String internalPasswordHash) {
            this.id = id;
            this.name = name;
            this.email = email;
            this.active = active;
            this.balance = balance;
            this.internalPasswordHash = internalPasswordHash;
        }
    }

    // Model class without @JsonSerializable to test exception handling
    public static class UnannotatedClass {
        private final String data = "unsupported";
    }

    // Reflection-based JSON Serializer Engine
    public static class SimpleJsonSerializer {

        public static String toJson(Object object) throws IllegalAccessException {
            if (object == null) {
                return "null";
            }

            Class<?> clazz = object.getClass();
            if (!clazz.isAnnotationPresent(JsonSerializable.class)) {
                throw new IllegalArgumentException("The class " + clazz.getSimpleName() + " is not annotated with @JsonSerializable");
            }

            Map<String, String> jsonElementsMap = new LinkedHashMap<>();

            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true); // Allow access to private fields

                if (field.isAnnotationPresent(JsonIgnore.class)) {
                    continue; // Skip ignored fields
                }

                if (field.isAnnotationPresent(JsonElement.class)) {
                    JsonElement jsonElement = field.getAnnotation(JsonElement.class);
                    String key = jsonElement.key().isEmpty() ? field.getName() : jsonElement.key();
                    Object value = field.get(object);

                    jsonElementsMap.put(key, formatJsonValue(value));
                }
            }

            String jsonString = jsonElementsMap.entrySet()
                    .stream()
                    .map(entry -> "\"" + entry.getKey() + "\": " + entry.getValue())
                    .collect(Collectors.joining(",\n  "));

            return "{\n  " + jsonString + "\n}";
        }

        private static String formatJsonValue(Object value) {
            if (value == null) {
                return "null";
            }
            if (value instanceof String || value instanceof Character) {
                return "\"" + escapeJson(value.toString()) + "\"";
            }
            if (value instanceof Number || value instanceof Boolean) {
                return value.toString();
            }
            return "\"" + escapeJson(value.toString()) + "\"";
        }

        private static String escapeJson(String input) {
            return input.replace("\"", "\\\"").replace("\n", "\\n").replace("\r", "\\r");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Custom Annotation JSON Serialization Demo ===");

        UserProfile user = new UserProfile(
                101,
                "Mohd Ahsan",
                "mohd.ahsan@example.com",
                true,
                1250.75,
                "secret_hashed_password_xyz"
        );

        try {
            System.out.println("Serializing UserProfile object to JSON:");
            String jsonOutput = SimpleJsonSerializer.toJson(user);
            System.out.println(jsonOutput);

            System.out.println("\nTesting non-serializable object handling:");
            try {
                SimpleJsonSerializer.toJson(new UnannotatedClass());
            } catch (IllegalArgumentException e) {
                System.out.println("Caught Expected Error: " + e.getMessage());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
