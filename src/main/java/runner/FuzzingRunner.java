package runner;

import ui.MainFrame;
import java.io.*;
import java.util.*;

public class FuzzingRunner {

    private static final String JAVA = "C:\\Program Files\\Eclipse Adoptium\\jdk-17.0.17.10-hotspot\\bin\\java.exe";
    private static final String JAZZER_JAR = "C:\\Tool_duan\\jazzer-windows\\jazzer_standalone.jar";

    /**
     * Run Jazzer for all generated tests with BENCHMARK in classpath
     */
    public static void runAllGeneratedTests(int timeSeconds, MainFrame ui, String benchmarkPath) {

        //Chạy SimpleVerifyTest trước để kiểm tra Jazzer hoạt động
        File simpleTest = new File("target/test-classes/fuzz/SimpleVerifyTest.class");
        if (simpleTest.exists()) {
            ui.appendOutput("\n Running fuzz.SimpleVerifyTest");
            runSingle("fuzz.SimpleVerifyTest", timeSeconds, ui, benchmarkPath);
        } else {
            ui.appendOutput("SimpleVerifyTest not found. Skipping.");
        }


        // Chay tat ca GeneratedFuzzTest_X
        int index = 0;
        while (true) {
            String testClass = "fuzz.GeneratedFuzzTest_" + index;
            File classFile = new File("target/test-classes/fuzz/GeneratedFuzzTest_" + index + ".class");

            if (!classFile.exists()) {
                if (index == 0) {
                    ui.appendOutput("No generated fuzz tests found.");
                }
                break;
            }

            ui.appendOutput("\nRunning " + testClass);
            runSingle(testClass, timeSeconds, ui, benchmarkPath);
            index++;
        }

        ui.appendOutput("\nAll fuzz tests finished.");
    }

    private static void runSingle(String testClass, int timeSeconds, MainFrame ui, String benchmarkPath) {
        try {
            // Build classpath - bat buoc phai co benchmark
            StringBuilder cpBuilder = new StringBuilder();
            cpBuilder.append("target\\test-classes;");
            cpBuilder.append("target\\classes;");
            cpBuilder.append("target\\dependency\\*;");
            
            // Them benchmark path
            if (benchmarkPath != null && !benchmarkPath.isEmpty()) {
                File benchmarkDir = new File(benchmarkPath);
                if (benchmarkDir.exists()) {
                    cpBuilder.append(benchmarkPath).append(";");
                    
                    // Neu co thu muc build hoac bin trong benchmark
                    File buildDir = new File(benchmarkDir, "build/classes");
                    if (buildDir.exists()) {
                        cpBuilder.append(buildDir.getAbsolutePath()).append(";");
                    }
                    
                    File binDir = new File(benchmarkDir, "bin");
                    if (binDir.exists()) {
                        cpBuilder.append(binDir.getAbsolutePath()).append(";");
                    }
                    
                    ui.appendOutput("Benchmark added to classpath: " + benchmarkPath);
                } else {
                    ui.appendOutput("Warning: Benchmark path not found: " + benchmarkPath);
                }
            }
            
            cpBuilder.append(JAZZER_JAR);
            String cp = cpBuilder.toString();

            List<String> cmd = new ArrayList<>();
            cmd.add(JAVA);
            cmd.add("-cp");
            cmd.add(cp);
            
            // Them debug flag
            cmd.add("-Djazzer.hooks=false");
            
            cmd.add("com.code_intelligence.jazzer.Jazzer");
            cmd.add("--target_class=" + testClass);
            cmd.add("--target_method=fuzzerTestOneInput");
            cmd.add("-max_total_time=" + timeSeconds);
            cmd.add("--coverage_report=coverage_" + testClass.replace(".", "_") + ".html");
            
            // Them instrumentation cho benchmark
            if (benchmarkPath != null && !benchmarkPath.isEmpty()) {
                cmd.add("--instrumentation_includes=org.owasp.benchmark.**");
            }

            ui.appendOutput("Command: " + String.join(" ", cmd));
            ui.appendOutput("--------------------------------------------------");

            ProcessBuilder pb = new ProcessBuilder(cmd);
            pb.directory(new File(System.getProperty("user.dir")));
            pb.redirectErrorStream(true);

            Process p = pb.start();

            try (BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
                String line;
                int lineCount = 0;
                while ((line = r.readLine()) != null) {
                    ui.appendOutput(line);
                    lineCount++;
                    
                    // Canh bao neu khong co coverage
                    if (line.contains("0 new") && lineCount > 20) {
                        ui.appendOutput("Warning: No new coverage detected. Check if benchmark classes are in classpath!");
                    }
                }
            }

            int exitCode = p.waitFor();
            ui.appendOutput("Process exited with code: " + exitCode);

        } catch (Exception e) {
            ui.appendOutput("Jazzer error in " + testClass + ": " + e.getMessage());
            e.printStackTrace();
        }
    }
}
