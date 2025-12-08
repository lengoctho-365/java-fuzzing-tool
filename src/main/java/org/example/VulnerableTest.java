package org.example;

/**
 * Test class với các lỗi rõ ràng để fuzzer dễ phát hiện
 * Location: src/main/java/org/example/VulnerableTest.java
 */
public class VulnerableTest {
    
    /**
     * Lỗi 1: Array Index Out of Bounds
     */
    public void testArrayBounds(String input) {
        if (input == null) return;
        
        int[] array = new int[10];
        
        // Bug: không kiểm tra bounds
        if (input.startsWith("FUZZ")) {
            int index = input.length();
            array[index] = 42; // CRASH nếu length > 9
        }
    }
    
    /**
     * Lỗi 2: Null Pointer Exception
     */
    public void testNullPointer(String input) {
        String data = null;
        
        if (input != null && input.equals("NULL_TEST")) {
            // Bug: gọi method trên null object
            int len = data.length(); // CRASH
        }
    }
    
    /**
     * Lỗi 3: Stack Overflow từ đệ quy
     */
    public void testRecursion(String input, int depth) {
        if (input == null) return;
        
        // Bug: không giới hạn độ sâu đệ quy
        if (input.contains("RECURSE") && depth < 10000) {
            testRecursion(input, depth + 1); // CRASH
        }
    }
    
    /**
     * Lỗi 4: Division by Zero
     */
    public void testDivision(String input) {
        if (input == null) return;
        
        try {
            int denominator = Integer.parseInt(input);
            int result = 100 / denominator; // CRASH nếu input = "0"
            System.out.println("Result: " + result);
        } catch (NumberFormatException e) {
            // Ignore parse errors
        }
    }
    
    /**
     * Lỗi 5: Assertion Error
     */
    public void testAssertion(String input) {
        if (input != null && input.equals("ASSERT_FAIL")) {
            assert false : "Assertion triggered by fuzzer"; // CRASH
        }
    }
    
    /**
     * Lỗi 6: Out of Memory
     */
    public void testMemory(String input) {
        if (input == null) return;
        
        // Bug: tạo mảng quá lớn
        if (input.startsWith("MEMORY") && input.length() > 5) {
            try {
                int size = input.length() * 1000000;
                byte[] huge = new byte[size]; // CRASH nếu size quá lớn
            } catch (OutOfMemoryError e) {
                throw e; // Re-throw to crash
            }
        }
    }
    
    /**
     * Lỗi 7: Infinite Loop
     */
    public void testInfiniteLoop(String input) {
        if (input != null && input.equals("LOOP")) {
            // Bug: vòng lặp vô hạn
            while (true) {
                // HANG
            }
        }
    }
    
    /**
     * Lỗi 8: String Index Out of Bounds
     */
    public void testStringBounds(String input) {
        if (input == null) return;
        
        if (input.startsWith("STRING")) {
            // Bug: không kiểm tra length
            char c = input.charAt(100); // CRASH nếu length < 101
        }
    }
}