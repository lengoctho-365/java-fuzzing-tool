package crash;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class EnhancedCrashScanner {

    public static class CrashInfo {
        public File file;
        public String bugType;
        public String methodName;
        public String message;
        
        public CrashInfo(File file, String bugType, String methodName, String message) {
            this.file = file;
            this.bugType = bugType;
            this.methodName = methodName;
            this.message = message;
        }
        
        @Override
        public String toString() {
            return bugType + " in " + methodName + " (" + file.getName() + ")";
        }
    }

    public static List<CrashInfo> scanWithDetails() {
        List<CrashInfo> crashes = new ArrayList<>();
        File root = new File(".");
        scanRecursive(root, crashes);
        return crashes;
    }

    private static void scanRecursive(File f, List<CrashInfo> crashes) {
        if (f.isDirectory()) {
            String name = f.getName();
            if (name.equals("src") || name.equals("target") || 
                name.equals(".git") || name.equals(".idea")) {
                return;
            }
            
            File[] children = f.listFiles();
            if (children == null) return;
            for (File c : children) scanRecursive(c, crashes);
        } else {
            String name = f.getName();
            
            // Crash files from Jazzer
            if (name.startsWith("crash-") && !name.contains(".") && f.length() > 0) {
                CrashInfo info = analyzeCrashFile(f);
                crashes.add(info);
            }
            
            // Java reproducer files
            if (name.startsWith("Crash_") && name.endsWith(".java")) {
                CrashInfo info = analyzeReproducerFile(f);
                if (info != null) {
                    crashes.add(info);
                }
            }
        }
    }

    private static CrashInfo analyzeCrashFile(File crashFile) {
        // Find corresponding reproducer file
        String hash = crashFile.getName().replace("crash-", "");
        File reproducerFile = new File("Crash_" + hash + ".java");
        
        if (reproducerFile.exists()) {
            return analyzeReproducerFile(reproducerFile);
        }
        
        // No reproducer found, return basic info
        return new CrashInfo(crashFile, "Unknown", "Unknown", "No reproducer found");
    }

    private static CrashInfo analyzeReproducerFile(File reproducerFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(reproducerFile))) {
            String line;
            String targetClass = null;
            
            while ((line = br.readLine()) != null) {
                // Find target class
                if (line.contains("fuzz.IndividualFuzz_")) {
                    Pattern pattern = Pattern.compile("fuzz\\.IndividualFuzz_\\d+");
                    Matcher matcher = pattern.matcher(line);
                    if (matcher.find()) {
                        targetClass = matcher.group();
                    }
                }
            }
            
            // If found target class, read comment in fuzz test file
            if (targetClass != null) {
                String testClassName = targetClass.replace("fuzz.", "");
                File testFile = new File("src/test/java/fuzz/" + testClassName + ".java");
                
                if (testFile.exists()) {
                    return extractBugInfoFromTest(testFile, reproducerFile);
                }
            }
            
        } catch (IOException e) {
            // Ignore
        }
        
        return new CrashInfo(reproducerFile, "Unknown", "Unknown", "Could not parse");
    }

    private static CrashInfo extractBugInfoFromTest(File testFile, File crashFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(testFile))) {
            String line;
            String methodName = "Unknown";
            
            while ((line = br.readLine()) != null) {
                // Find comment with target method
                if (line.contains("* Target:")) {
                    methodName = line.substring(line.indexOf("Target:") + 7).trim();
                    break;
                }
            }
            
            // Guess bug type from method name
            String bugType = guessBugType(methodName);
            
            return new CrashInfo(crashFile, bugType, methodName, "");
            
        } catch (IOException e) {
            return new CrashInfo(crashFile, "Unknown", "Unknown", e.getMessage());
        }
    }

    private static String guessBugType(String methodName) {
        methodName = methodName.toLowerCase();
        
        if (methodName.contains("division") || methodName.contains("modulo")) {
            return "ArithmeticException";
        } else if (methodName.contains("array") || methodName.contains("index")) {
            return "ArrayIndexOutOfBoundsException";
        } else if (methodName.contains("null")) {
            return "NullPointerException";
        } else if (methodName.contains("string") && methodName.contains("index")) {
            return "StringIndexOutOfBoundsException";
        } else if (methodName.contains("parse")) {
            return "NumberFormatException";
        } else if (methodName.contains("recursion") || methodName.contains("infinite")) {
            return "StackOverflowError";
        } else if (methodName.contains("assertion") || methodName.contains("assert")) {
            return "AssertionError";
        } else if (methodName.contains("cast")) {
            return "ClassCastException";
        } else if (methodName.contains("file") || methodName.contains("io")) {
            return "IOException";
        } else if (methodName.contains("concurrent")) {
            return "ConcurrentModificationException";
        }
        
        return "Unknown";
    }

    public static Map<String, List<CrashInfo>> groupByBugType(List<CrashInfo> crashes) {
        Map<String, List<CrashInfo>> grouped = new HashMap<>();
        
        for (CrashInfo crash : crashes) {
            grouped.computeIfAbsent(crash.bugType, k -> new ArrayList<>()).add(crash);
        }
        
        return grouped;
    }
}