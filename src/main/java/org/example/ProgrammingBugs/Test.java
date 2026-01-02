package org.example;

/**
 * Simple test class for fuzzer
 * Location: src/main/java/org/example/Test.java
 */
public class Test {
    
    public void doSomething(String input) {
        if (input == null) {
            return;
        }
        
        // Test case 1: Check length
        if (input.length() > 100) {
            System.out.println("Very long input: " + input.length());
        }
        
        // Test case 2: Check specific content
        if (input.contains("fuzz")) {
            System.out.println("Found 'fuzz' in input");
        }
        
        // Test case 3: Potential bug - division by zero
        if (input.equals("crash")) {
            int x = 1 / 0; // This will cause ArithmeticException
        }
    }
    
    public void doSomething(String input, int value) {
        if (input == null) {
            return;
        }
        
        // Test with multiple parameters
        if (input.length() > value) {
            System.out.println("Input longer than value");
        }
        
        // Potential bug
        if (value == 0 && input.equals("danger")) {
            throw new RuntimeException("Dangerous combination!");
        }
    }
    
    public static void processData(String data) {
        if (data == null) {
            return;
        }
        
        // Test static method
        if (data.startsWith("test")) {
            System.out.println("Test data detected");
        }
    }
}