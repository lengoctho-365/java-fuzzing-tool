package org.example;

import java.util.*;
import java.io.*;

/**
 * Extended test class with MULTIPLE BUG TYPES
 * Location: src/main/java/org/example/ExtendedVulnerableTest.java
 */
public class ExtendedVulnerableTest {
    
    // ============ CATEGORY 1: ARITHMETIC ERRORS ============
    
    public void divisionByZero(int number) {
        int result = 100 / number; // Crash when number = 0
        System.out.println(result);
    }

    public void moduloByZero(String input) {
        int num = Integer.parseInt(input);
        int result = 100 % num; // Crash when num = 0
        System.out.println(result);
    }
    
     //============ CATEGORY 2: ARRAY ERRORS ============
    
    public void arrayIndexError(int index) {
        int[] array = {1, 2, 3, 4, 5};
        int value = array[index]; // Crash when index < 0 or >= 5
        System.out.println(value);
    }

    public void arrayIndexFromString(String input) {
        int[] array = new int[10];
        int index = input.length(); // Crash when length >= 10
        array[index] = 42;
    }

    public void negativeArraySize(int size) {
        int[] array = new int[size]; // Crash when size < 0
        System.out.println(array.length);
    }
    
    // ============ CATEGORY 3: NULL POINTER ERRORS ============
    
    public void nullPointerBasic(String input) {
        String data = null;
        if (input.equals("NULL")) {
            int len = data.length(); // Crash
        }
    }
    
    public void nullPointerArray() {
        String[] array = null;
        int len = array.length; // Crash immediately
    }
    
    public void nullPointerInLoop(String input) {
        List<String> list = null;
        if (input.contains("LOOP")) {
            for (String s : list) { // Crash
                System.out.println(s);
            }
        }
    }
    
    // ============ CATEGORY 4: STRING ERRORS ============
    
    public void stringIndexOutOfBounds(String input) {
        if (input != null && input.length() > 0) {
            char c = input.charAt(100); // Crash if length < 101
        }
    }
    
    public void substringError(String input) {
        String sub = input.substring(10, 20); // Crash if length < 20
        System.out.println(sub);
    }
    
    public void emptyStringSplit(String input) {
        String[] parts = input.split(",");
        String first = parts[10]; // Crash if < 11 elements
        System.out.println(first);
    }
    
    // ============ CATEGORY 5: NUMBER FORMAT ERRORS ============
    
    public void parseIntError(String input) {
        int num = Integer.parseInt(input); // Crash if not a number
        System.out.println(num);
    }
    
    public void parseLongError(String input) {
        long num = Long.parseLong(input); // Crash if not a number
        System.out.println(num);
    }
    
    public void parseDoubleError(String input) {
        double num = Double.parseDouble(input); // Crash if not a number
        System.out.println(num);
    }
    
    // ============ CATEGORY 6: COLLECTION ERRORS ============
    
    public void listIndexError(int index) {
        List<String> list = Arrays.asList("a", "b", "c");
        String item = list.get(index); // Crash if index < 0 or >= 3
        System.out.println(item);
    }
    
    public void emptyListAccess() {
        List<String> list = new ArrayList<>();
        String first = list.get(0); // Crash
        System.out.println(first);
    }
    
    public void mapKeyError(String key) {
        Map<String, String> map = new HashMap<>();
        map.put("valid", "data");
        String value = map.get(key).toUpperCase(); // Crash if key not exists
        System.out.println(value);
    }
    
    // ============ CATEGORY 7: STACK OVERFLOW ============
    
    public void infiniteRecursion(int depth) {
        if (depth > 0) {
            infiniteRecursion(depth + 1); // Crash when stack full
        }
    }
    
    public void recursionWithString(String input) {
        if (input.contains("RECURSE")) {
            recursionWithString(input); // Crash
        }
    }
    
    // ============ CATEGORY 8: ASSERTION ERRORS ============
    
    public void assertionFail(boolean condition) {
        assert condition : "Assertion failed!"; // Crash if false and assertions enabled
    }
    
    public void assertionWithString(String input) {
        assert !input.equals("FAIL") : "Test failed"; // Crash
    }
    
    // ============ CATEGORY 9: CLASS CAST ERRORS ============
    
    public void classCastError(Object obj) {
        String str = (String) obj; // Crash if obj not String
        System.out.println(str);
    }
    
    public void numberCastError(Object obj) {
        Integer num = (Integer) obj; // Crash if obj not Integer
        System.out.println(num);
    }
    
    // ============ CATEGORY 10: ILLEGAL ARGUMENT ============
    
    public void illegalArgumentNegative(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("Value must be positive");
        }
    }
    
    public void illegalArgumentString(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input cannot be empty");
        }
    }
    
    // ============ CATEGORY 11: CONCURRENT MODIFICATION ============
    
    public void concurrentModification(int count) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("item" + i);
        }
        
        for (String item : list) {
            if (count > 5) {
                list.remove(item); // Crash: ConcurrentModificationException
            }
        }
    }
    
    // ============ CATEGORY 12: FILE/IO ERRORS ============
    
    public void fileNotFound(String filename) throws IOException {
        FileReader fr = new FileReader(filename); // Crash if file not exists
        fr.close();
    }
    
    public void readInvalidFile(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line = br.readLine();
        br.close();
    }
    
    // ============ CATEGORY 13: REGEX ERRORS ============
    
    public void regexPatternError(String pattern) {
        java.util.regex.Pattern.compile(pattern); // Crash if pattern invalid
    }
    
    public void regexMatchError(String input) {
        if (input.matches("[[[")) { // Invalid regex
            System.out.println("Match");
        }
    }
    
    // ============ CATEGORY 14: MATH ERRORS ============
    
    public void sqrtNegative(double value) {
        if (value < 0) {
            double result = Math.sqrt(value); // Returns NaN
            if (Double.isNaN(result)) {
                throw new ArithmeticException("Cannot sqrt negative");
            }
        }
    }
    
    public void logZero(double value) {
        double result = Math.log(value); // -Infinity if value = 0
        if (Double.isInfinite(result)) {
            throw new ArithmeticException("Log of zero");
        }
    }
    
    // ============ CATEGORY 15: BUFFER ERRORS ============
    
    public void bufferOverflow(String input) {
        byte[] buffer = new byte[10];
        byte[] inputBytes = input.getBytes();
        for (int i = 0; i < inputBytes.length; i++) {
            buffer[i] = inputBytes[i]; // Crash if input > 10 bytes
        }
    }
    
    // ============ CATEGORY 16: COMPLEX LOGIC BUGS ============
    
    public void complexCondition(String input, int value) {
        if (input != null && input.length() > value) {
            if (value == 0) {
                int result = 100 / value; // Crash
            }
        }
    }
    
    public void nestedConditions(String a, String b, int c) {
        if (a.equals(b)) {
            if (c > 10) {
                int[] array = new int[c];
                array[c] = 100; // Crash: index out of bounds
            }
        }
    }
    
    public void multipleChecks(String input) {
        if (input.startsWith("TEST")) {
            if (input.contains("CRASH")) {
                if (input.length() > 20) {
                    String[] parts = input.split("_");
                    int num = Integer.parseInt(parts[5]); // Crash if < 6 parts
                }
            }
        }
    }
}