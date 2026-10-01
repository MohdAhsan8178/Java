// Question: How do you process custom annotations using Java's Annotation interface? Write a program to demonstrate how custom annotations can be used with reflection.

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BenchmarkTest {
    int iterations() default 1;
    String description() default "Standard Benchmark";
}

class SystemPerformanceBenchmark {

    @BenchmarkTest(iterations = 3, description = "Matrix Multiplication Latency")
    public void benchmarkMatrixMath() {
        System.out.println("  -> Running Matrix Math benchmark...");
    }

    @BenchmarkTest(iterations = 5, description = "QuickSort on Random Array")
    public void benchmarkSorting() {
        System.out.println("  -> Running QuickSort benchmark...");
    }

    public void nonAnnotatedUtilityMethod() {
        System.out.println("  -> Helper method not marked for benchmarking.");
    }
}

public class Q07_AnnotationReflectionProcessor {
    public static void main(String[] args) throws Exception {
        System.out.println("--- Section 2: Creating Custom Annotations ---");
        System.out.println("--- Q07: Processing Custom Annotations via Java Reflection API ---\n");

        Class<?> clazz = SystemPerformanceBenchmark.class;
        Object instance = clazz.getDeclaredConstructor().newInstance();

        System.out.println("Inspecting methods of class: " + clazz.getSimpleName());
        System.out.println("------------------------------------------------------------------");

        for (Method method : clazz.getDeclaredMethods()) {
            // Method 1: Checking specific annotation presence
            if (method.isAnnotationPresent(BenchmarkTest.class)) {
                BenchmarkTest benchmark = method.getAnnotation(BenchmarkTest.class);
                System.out.println("[FOUND ANNOTATED METHOD] Name: " + method.getName() + "()");
                System.out.println("  - Description : " + benchmark.description());
                System.out.println("  - Iterations  : " + benchmark.iterations());

                // Dynamically executing the annotated method
                System.out.println("  - Dynamic Execution Output:");
                method.invoke(instance);
                System.out.println("------------------------------------------------------------------");
            }

            // Method 2: Inspecting all annotations as java.lang.annotation.Annotation instances
            for (Annotation ann : method.getAnnotations()) {
                System.out.println("  (Generic Annotation Interface Type: " + ann.annotationType().getName() + ")");
            }
        }

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
