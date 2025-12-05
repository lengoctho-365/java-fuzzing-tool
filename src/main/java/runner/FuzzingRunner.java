package runner;

import ui.MainFrame;
import java.io.*;
import java.util.*;

public class FuzzingRunner {

    private static final String JAVA = "C:\\Users\\ASUS\\.jdks\\ms-11.0.29\\bin\\java.exe";
    private static final String JAZZER_JAR = "C:\\Users\\ASUS\\jazzer\\jazzer_standalone.jar";

    /**
     * Run Jazzer for Universal fuzzer (if exists)
     * then run all GeneratedFuzzTest_X files.
     */
    public static void runAllGeneratedTests(int timeSeconds, MainFrame ui) {

        // 1️⃣ Chạy Universal Fuzz nếu có
        File uni = new File("target/test-classes/fuzz/GeneratedUniversalFuzzTest.class");
        if (uni.exists()) {
            ui.appendOutput("\n🚀 Running fuzz.GeneratedUniversalFuzzTest");
            runSingle("fuzz.GeneratedUniversalFuzzTest", timeSeconds, ui);
        } else {
            ui.appendOutput("ℹ Universal fuzzer not found. Skipping.");
        }

        // 2️⃣ Chạy tất cả GeneratedFuzzTest_X
        int index = 0;
        while (true) {
            String testClass = "fuzz.GeneratedFuzzTest_" + index;

            File classFile = new File("target/test-classes/fuzz/GeneratedFuzzTest_" + index + ".class");

            if (!classFile.exists()) {
                if (index == 0) {
                    ui.appendOutput("❌ No generated fuzz tests found.");
                }
                break;
            }

            ui.appendOutput("\n🚀 Running " + testClass);
            runSingle(testClass, timeSeconds, ui);

            index++;
        }

        ui.appendOutput("\n✅ All fuzz tests finished.");
    }


    private static void runSingle(String testClass, int timeSeconds, MainFrame ui) {
        try {
            String cp =
                    "target\\test-classes;" +
                            "target\\classes;" +
                            "target\\dependency\\*;" +   // ⭐ load toàn bộ thư viện test (Spring Mock,...)
                            JAZZER_JAR;

            List<String> cmd = new ArrayList<>();
            cmd.add(JAVA);
            cmd.add("-cp");
            cmd.add(cp);
            cmd.add("com.code_intelligence.jazzer.Jazzer");
            cmd.add("--target_class=" + testClass);
            cmd.add("--target_method=fuzzerTestOneInput");
            cmd.add("-max_total_time=" + timeSeconds);
            cmd.add("--coverage_report=coverage.html");

            ui.appendOutput(String.join(" ", cmd));
            ui.appendOutput("--------------------------------------------------");

            ProcessBuilder pb = new ProcessBuilder(cmd);
            pb.directory(new File(System.getProperty("user.dir")));
            pb.redirectErrorStream(true);

            Process p = pb.start();

            try (BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
                String line;
                while ((line = r.readLine()) != null) {
                    ui.appendOutput(line);
                }
            }

            p.waitFor();

        } catch (Exception e) {
            ui.appendOutput("❌ Jazzer error in " + testClass + ": " + e.getMessage());
        }
    }
}
