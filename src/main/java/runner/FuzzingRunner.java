package runner;

import ui.MainFrame;
import java.io.*;
import java.util.*;

public class FuzzingRunner {

    private static final String JAVA = "C:\\Program Files\\Eclipse Adoptium\\jdk-17.0.17.10-hotspot\\bin\\java.exe";
    private static final String JAZZER_JAR = "C:\\Tool_duan\\jazzer-windows\\jazzer_standalone.jar";

    public static void runAllGeneratedTests(int timeSeconds, MainFrame ui, String benchmarkPath) {
        File simpleTest = new File("target/test-classes/fuzz/SimpleVerifyTest.class");
        if (simpleTest.exists()) {
            ui.appendOutput("\n=== Running SimpleVerifyTest ===");
            runSingle("fuzz.SimpleVerifyTest", timeSeconds, ui, benchmarkPath);
        }

        int index = 0;
        while (true) {
            String testClass = "fuzz.GeneratedFuzzTest_" + index;
            File classFile = new File("target/test-classes/fuzz/GeneratedFuzzTest_" + index + ".class");

            if (!classFile.exists()) {
                if (index == 0) ui.appendOutput("No generated fuzz tests found.");
                break;
            }

            ui.appendOutput("\n=== Running " + testClass + " ===");
            runSingle(testClass, timeSeconds, ui, benchmarkPath);
            index++;
        }

        ui.appendOutput("\n=== All fuzz tests finished ===");
    }

    private static void runSingle(String testClass, int timeSeconds, MainFrame ui, String benchmarkPath) {
        try {
            StringBuilder cpBuilder = new StringBuilder();
            cpBuilder.append("target\\test-classes;");
            cpBuilder.append("target\\classes;");
            cpBuilder.append("target\\dependency\\*;");
            
            if (benchmarkPath != null && !benchmarkPath.isEmpty()) {
                File benchmarkDir = new File(benchmarkPath);
                if (benchmarkDir.exists()) {
                    cpBuilder.append(benchmarkPath).append(";");
                    
                    File buildDir = new File(benchmarkDir, "build/classes");
                    if (buildDir.exists()) {
                        cpBuilder.append(buildDir.getAbsolutePath()).append(";");
                    }
                    
                    File binDir = new File(benchmarkDir, "bin");
                    if (binDir.exists()) {
                        cpBuilder.append(binDir.getAbsolutePath()).append(";");
                    }
                    
                    ui.appendOutput("✓ Benchmark added: " + benchmarkPath);
                }
            }
            
            cpBuilder.append(JAZZER_JAR);
            String cp = cpBuilder.toString();

            List<String> cmd = new ArrayList<>();
            cmd.add(JAVA);
            cmd.add("-cp");
            cmd.add(cp);
            
            // THÊM: memory settings
            cmd.add("-Xmx2g"); // Tăng heap size
            cmd.add("-XX:+UseG1GC"); // Better GC
            
            cmd.add("-Djazzer.hooks=false");
            
            cmd.add("com.code_intelligence.jazzer.Jazzer");
            cmd.add("--target_class=" + testClass);
            cmd.add("--target_method=fuzzerTestOneInput");
            
            // THÊM: aggressive settings
            cmd.add("-max_total_time=" + timeSeconds);
            cmd.add("-runs=1000000"); // Số lần chạy tối đa
            cmd.add("-max_len=8192"); // Độ dài input tối đa
            cmd.add("-len_control=1000"); // Control length strategy
            cmd.add("-timeout=10"); // Timeout mỗi test case (giây)
            
            // THÊM: coverage và mutation settings
            cmd.add("-use_value_profile=1"); // Track value comparisons
            cmd.add("-reduce_inputs=1"); // Minimize test cases
            
            cmd.add("--coverage_report=coverage_" + testClass.replace(".", "_") + ".html");
            
            if (benchmarkPath != null && !benchmarkPath.isEmpty()) {
                cmd.add("--instrumentation_includes=org.owasp.benchmark.**");
                cmd.add("--custom_hooks=org.owasp.benchmark.**"); // Hook vào benchmark code
            }
            
            // THÊM: corpus directory
            File corpusDir = new File("corpus_" + testClass.replace(".", "_"));
            if (!corpusDir.exists()) corpusDir.mkdirs();
            cmd.add(corpusDir.getAbsolutePath());

            ui.appendOutput("Command: " + String.join(" ", cmd));
            ui.appendOutput("--------------------------------------------------");

            ProcessBuilder pb = new ProcessBuilder(cmd);
            pb.directory(new File(System.getProperty("user.dir")));
            pb.redirectErrorStream(true);

            Process p = pb.start();

            try (BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
                String line;
                int lineCount = 0;
                boolean foundCrash = false;
                
                while ((line = r.readLine()) != null) {
                    ui.appendOutput(line);
                    lineCount++;
                    
                    // Detect issues
                    if (line.contains("FOUND BUG")) {
                        foundCrash = true;
                        ui.appendOutput("!!! BUG DETECTED !!!");
                    }
                    
                    if (line.contains("0 new") && lineCount > 20) {
                        ui.appendOutput("Warning: No new coverage - check classpath");
                    }
                    
                    if (line.contains("corp:") && !line.contains("corp: 1/1b")) {
                        ui.appendOutput("Good: Corpus growing");
                    }
                }
                
                if (foundCrash) {
                    ui.appendOutput("\nCRASH FOUND IN " + testClass);
                }
            }

            int exitCode = p.waitFor();
            ui.appendOutput("Process exited: " + exitCode);
            
            // Analyze corpus
            if (corpusDir.exists()) {
                File[] corpusFiles = corpusDir.listFiles();
                if (corpusFiles != null) {
                    ui.appendOutput("Corpus size: " + corpusFiles.length + " files");
                }
            }

        } catch (Exception e) {
            ui.appendOutput("ERROR in " + testClass + ": " + e.getMessage());
            e.printStackTrace();
        }
    }
}