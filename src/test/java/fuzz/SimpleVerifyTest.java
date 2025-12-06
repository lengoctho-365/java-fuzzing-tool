package fuzz;

import com.code_intelligence.jazzer.api.*;

/**
 * Test đơn giản để kiểm tra Jazzer hoạt động.
 *
 * Chạy test này trước để đảm bảo Jazzer setup đúng:
 *
 * java -cp "target/test-classes;target/dependency/*;C:\Users\ASUS\jazzer\jazzer_standalone.jar" \
 *   com.code_intelligence.jazzer.Jazzer \
 *   --target_class=fuzz.SimpleVerifyTest \
 *   --target_method=fuzzerTestOneInput \
 *   -max_total_time=10
 */
public class SimpleVerifyTest {
    
    public static void fuzzerTestOneInput(FuzzedDataProvider data) {
        // Test đơn giản - chỉ consume data
        String input = data.consumeString(100);
        int number = data.consumeInt();
        
        // Logic đơn giản để kiểm tra coverage
        if (input != null && input.length() > 10) {
            System.out.println("Long input: " + input.length());
        }
        
        if (number > 1000) {
            System.out.println("Large number: " + number);
        }
        
        // Thử load một class đơn giản từ JDK
        try {
            Class<?> cls = Class.forName("java.util.ArrayList");
            Object instance = cls.getDeclaredConstructor().newInstance();
            System.out.println("Created instance: " + instance.getClass().getName());
        } catch (Exception e) {
            System.err.println("Failed to create ArrayList: " + e.getMessage());
        }
    }
}
