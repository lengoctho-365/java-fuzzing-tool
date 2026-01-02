package ui;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;

import generator.FuzzTestGenerator;
import generator.UniversalFuzzTestGenerator;
import runner.FuzzingRunner;
import scanner.FileScanner;
import generator.EnhancedIndividualMethodFuzzer;
import scanner.MethodInfo;
import scanner.MethodScanner;
import crash.CrashScanner;
import report.ReportGenerator;
import generator.SecurityAwareFuzzTestGenerator;
import report.SecurityReportGenerator;
import java.lang.String;


public class MainFrame extends JFrame {

    private JButton btnFuzzingAll;
    private JPanel panelMain;

    private JButton btnSelectFolder;
    private JButton btnScan;
    private JButton btnGenerateAndFuzz;
    private JButton btnGenerateUniversalAndFuzz;   // Nut moi
    private JButton btnExportReport;
    private JButton btnExit;
    private JButton btnFuzzEachMethod;
    private JButton btnSecurityFuzz;


    private JTextArea txtOutput;
    private JScrollPane panelResult;

    private File selectedFolder;

    public MainFrame() {

        setTitle("Java Fuzzing Tool");
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        panelMain = new JPanel();
        panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));

        JPanel top = new JPanel();

        btnSelectFolder = new JButton("Select Benchmark Folder");
        btnScan = new JButton("Scan");
        btnGenerateAndFuzz = new JButton("Generate & Fuzz");

// Trong phần tạo buttons:
        btnFuzzEachMethod = new JButton("Fuzz Each Method");
        top.add(btnFuzzEachMethod);
        btnFuzzEachMethod.addActionListener(e -> fuzzEachMethod());
        btnGenerateUniversalAndFuzz = new JButton("Universal Fuzz");  // New button
        btnExportReport = new JButton("Export Report");
        btnExit = new JButton("Exit");

        top.add(btnSelectFolder);
        top.add(btnScan);
        top.add(btnGenerateAndFuzz);
        top.add(btnGenerateUniversalAndFuzz); // Add to UI
        top.add(btnExportReport);
        top.add(btnExit);

        panelMain.add(top);

        txtOutput = new JTextArea();
        panelResult = new JScrollPane(txtOutput);
        panelResult.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        panelResult.setPreferredSize(new java.awt.Dimension(900, 600));
        panelMain.add(panelResult);

        setContentPane(panelMain);

        // Event listeners
        btnSelectFolder.addActionListener(e -> selectFolder());
        btnScan.addActionListener(e -> scanFolder());
        btnGenerateAndFuzz.addActionListener(e -> generateAndFuzz());
        btnGenerateUniversalAndFuzz.addActionListener(e -> generateUniversalAndFuzz()); // New action
        btnExportReport.addActionListener(e -> exportReport());
        btnExit.addActionListener(e -> exitApp());

        btnSecurityFuzz = new JButton("Security Fuzzing");
        top.add(btnSecurityFuzz);
        btnSecurityFuzz.addActionListener(e -> runSecurityFuzzing());
    }

    public void appendOutput(String text) {
        SwingUtilities.invokeLater(() -> txtOutput.append(text + "\n"));
    }

    // ---------------------- SELECT FOLDER ----------------------
    private void selectFolder() {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            selectedFolder = chooser.getSelectedFile();
            appendOutput("Selected benchmark: " + selectedFolder.getAbsolutePath());
        }
    }

    // ---------------------- SCAN ----------------------
    private void scanFolder() {
        if (selectedFolder == null) {
            JOptionPane.showMessageDialog(this, "Choose benchmark folder first.");
            return;
        }

        appendOutput("Scanning benchmark Java files and methods...");

        try {
            List<File> files = FileScanner.scanJavaFiles(selectedFolder);
            appendOutput("Java files found: " + files.size());

            int totalMethods = 0;

            for (File f : files) {
                try {
                    List<MethodInfo> methods = MethodScanner.scan(f);
                    for (MethodInfo mi : methods) {
                        appendOutput("- " + mi);
                        totalMethods++;
                    }
                } catch (Exception ex) {
                    appendOutput("Skipped file: " + f.getName());
                }
            }

            List<MethodInfo> allMethods = MethodScanner.scanAll(selectedFolder);
            appendOutput("Total unique methods (scanAll): " + allMethods.size());
            appendOutput("Total benchmark methods found: " + totalMethods);

        } catch (Exception e) {
            appendOutput("Scan error: " + e.getMessage());
        }
    }

    // ---------------------- GENERATE & FUZZ (BATCH) ----------------------
    private void generateAndFuzz() {
        if (selectedFolder == null) {
            JOptionPane.showMessageDialog(this, "Choose benchmark folder first.");
            return;
        }

        new Thread(() -> {
            try {
                List<MethodInfo> allMethods = MethodScanner.scanAll(selectedFolder);
                appendOutput("Target methods: " + allMethods.size());
                
                // DEBUG: Hien thi vai methods dau tien
                appendOutput("\nSample methods:");
                for (int i = 0; i < Math.min(5, allMethods.size()); i++) {
                    appendOutput("  - " + allMethods.get(i));
                }

                appendOutput("\nGenerating batch harness...");
                List<String> fuzzClasses = FuzzTestGenerator.generateMultipleClasses(allMethods);
                appendOutput("Generated fuzz harness: " + fuzzClasses.size() + " classes");

                runMavenCompile();
                
                // Truyen benchmark path vao Jazzer
                runJazzer(selectedFolder.getAbsolutePath());

            } catch (Exception e) {
                appendOutput("Fuzz error: " + e.getMessage());
                e.printStackTrace();
            }
        }).start();
    }

    // ---------------------- UNIVERSAL FUZZ BUTTON ----------------------
    private void generateUniversalAndFuzz() {
        if (selectedFolder == null) {
            JOptionPane.showMessageDialog(this, "Choose benchmark folder first.");
            return;
        }

        new Thread(() -> {
            try {
                appendOutput("Scanning methods...");
                List<MethodInfo> allMethods = MethodScanner.scanAll(selectedFolder);
                appendOutput("Found " + allMethods.size() + " methods");

                appendOutput("Generating Universal Fuzzer...");
                String className = UniversalFuzzTestGenerator.generateUniversalFuzzer(allMethods);
                appendOutput("Generated: " + className);

                runMavenCompile();
                
                // Truyen benchmark path vao Jazzer
                runJazzer(selectedFolder.getAbsolutePath());

            } catch (Exception e) {
                appendOutput("Error: " + e.getMessage());
                e.printStackTrace();
            }
        }).start();
    }
    // ADD TO MainFrame.java


// ========== ADD THESE METHODS BEFORE THE LAST } OF CLASS ==========

    /**
     * Fuzz EACH method separately to find ALL bugs
     */
    private void fuzzEachMethod() {
        if (selectedFolder == null) {
            JOptionPane.showMessageDialog(this, "Choose folder first.");
            return;
        }

        // Ask for time per method
        String timeInput = JOptionPane.showInputDialog(this,
                "Time per method (seconds):", "30");

        int timePerMethod = 30;
        try {
            timePerMethod = Integer.parseInt(timeInput);
        } catch (NumberFormatException e) {
            appendOutput("Invalid time, using default: 30s");
        }

        final int finalTime = timePerMethod;

        new Thread(() -> {
            try {
                appendOutput("==============================================");
                appendOutput("    FUZZING EACH METHOD INDIVIDUALLY");
                appendOutput("==============================================");
                appendOutput("Target folder: " + selectedFolder.getAbsolutePath());
                appendOutput("Time per method: " + finalTime + "s");

                // Scan all methods
                appendOutput("\n[1/4] Scanning Java files...");
                List<MethodInfo> allMethods = MethodScanner.scanAll(selectedFolder);
                appendOutput("Found " + allMethods.size() + " total methods");

                // Filter only VulnerableTest and ExtendedVulnerableTest
                appendOutput("\n[2/4] Filtering target classes...");
                List<MethodInfo> targetMethods = new ArrayList<>();
                for (MethodInfo mi : allMethods) {
                    if (mi.className.contains("VulnerableTest") ||
                            mi.className.contains("ExtendedVulnerableTest")) {
                        targetMethods.add(mi);
                        appendOutput("  + " + mi.className + "." + mi.methodName);
                    }
                }

                if (targetMethods.isEmpty()) {
                    appendOutput("\nERROR: No VulnerableTest methods found!");
                    appendOutput("Make sure you have VulnerableTest.java or ExtendedVulnerableTest.java");
                    return;
                }

                appendOutput("\nTarget methods: " + targetMethods.size());

                // Generate individual tests
                appendOutput("\n[3/4] Generating individual fuzz tests...");
                List<String> testClasses = EnhancedIndividualMethodFuzzer.generateIndividualTests(targetMethods);
                appendOutput("Generated " + testClasses.size() + " fuzz test classes");

                // Compile
                appendOutput("\n[4/4] Compiling...");
                runMavenCompile();
                appendOutput("Compilation complete");

                // Run fuzzing
                appendOutput("\n==============================================");
                appendOutput("    STARTING FUZZING - " + testClasses.size() + " TESTS");
                appendOutput("==============================================\n");

                int successCount = 0;
                int crashCount = 0;
                List<String> foundBugs = new ArrayList<>();

                for (int i = 0; i < testClasses.size(); i++) {
                    String testClass = testClasses.get(i);
                    int methodNum = i + 1;

                    appendOutput("\n");
                    appendOutput("╔════════════════════════════════════════════════╗");
                    appendOutput("║  TEST " + methodNum + "/" + testClasses.size() + ": " + testClass);
                    appendOutput("╚════════════════════════════════════════════════╝");

                    try {
                        // Create temporary file to capture output
                        File tempLog = File.createTempFile("fuzz_", ".log");

                        boolean foundCrash = runSingleMethodFuzz(testClass, finalTime, tempLog);

                        if (foundCrash) {
                            crashCount++;
                            foundBugs.add(testClass);
                            appendOutput("CRASH FOUND!");
                        } else {
                            successCount++;
                            appendOutput("No crash");
                        }

                    } catch (Exception e) {
                        appendOutput("Error: " + e.getMessage());
                    }
                }

                // Summary
                appendOutput("\n");
                appendOutput("==============================================");
                appendOutput("           FUZZING COMPLETE");
                appendOutput("==============================================");
                appendOutput("Total tests: " + testClasses.size());
                appendOutput("Successful: " + successCount);
                appendOutput("Crashes found: " + crashCount);
                appendOutput("");

                if (crashCount > 0) {
                    appendOutput("BUGS FOUND IN:");
                    for (String bug : foundBugs) {
                        appendOutput("  - " + bug);
                    }
                    appendOutput("\nCheck crash-* files for details");
                } else {
                    appendOutput("No crashes found - code seems safe!");
                }

                appendOutput("==============================================");

            } catch (Exception e) {
                appendOutput("ERROR: " + e.getMessage());
                e.printStackTrace();
            }
        }).start();
    }

    /**
     * Helper method to run single fuzz test and detect crash
     */
    private boolean runSingleMethodFuzz(String testClass, int timeSeconds, File logFile) throws Exception {
        String javaPath = "C:\\Program Files\\Eclipse Adoptium\\jdk-17.0.17.10-hotspot\\bin\\java.exe";
        String jazzerJar = "C:\\Tool_duan\\jazzer-windows\\jazzer_standalone.jar";

        StringBuilder cpBuilder = new StringBuilder();
        cpBuilder.append("target\\test-classes;");
        cpBuilder.append("target\\classes;");
        cpBuilder.append("target\\dependency\\*;");

        if (selectedFolder != null) {
            cpBuilder.append(selectedFolder.getAbsolutePath()).append(";");
        }

        cpBuilder.append(jazzerJar);

        List<String> cmd = new ArrayList<>();
        cmd.add(javaPath);
        cmd.add("-cp");
        cmd.add(cpBuilder.toString());
        cmd.add("-Xmx2g");
        cmd.add("-ea"); // Enable assertions
        cmd.add("-Djazzer.hooks=false");
        cmd.add("com.code_intelligence.jazzer.Jazzer");
        cmd.add("--target_class=" + testClass);
        cmd.add("--target_method=fuzzerTestOneInput");
        cmd.add("-max_total_time=" + timeSeconds);
        cmd.add("-max_len=4096");
        cmd.add("-timeout=5");

        ProcessBuilder pb = new ProcessBuilder(cmd);
        pb.directory(new File(System.getProperty("user.dir")));
        pb.redirectErrorStream(true);

        Process p = pb.start();

        boolean foundCrash = false;
        try (BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
            String line;
            while ((line = r.readLine()) != null) {
                // Only log important lines
                if (line.contains("=== BUG FOUND ===") ||
                        line.contains("crash-") ||
                        line.contains("FOUND BUG") ||
                        line.contains("ERROR") ||
                        line.contains("Exception")) {
                    appendOutput(line);
                    foundCrash = true;
                }

                // Log progress every 100 execs
                if (line.contains("pulse") || line.matches(".*#\\d+.*")) {
                    // Skip frequent progress lines
                    continue;
                }
            }
        }

        p.waitFor();
        return foundCrash;
    }

    // ---------------------- MAVEN COMPILE ----------------------
    private void runMavenCompile() throws Exception {
        appendOutput("Compiling classes (mvn test-compile)...");

        String mavenCmd = "C:\\Tool_duan\\apache-maven-3.9.11-bin\\apache-maven-3.9.11\\bin\\mvn.cmd";
        ProcessBuilder pb = new ProcessBuilder(mavenCmd, "test-compile");

        pb.directory(new File(System.getProperty("user.dir")));
        pb.redirectErrorStream(true);

        Process p = pb.start();
        try (var r = new java.io.BufferedReader(new java.io.InputStreamReader(p.getInputStream()))) {
            String line;
            while ((line = r.readLine()) != null) appendOutput(line);
        }
        p.waitFor();
    }

    // ---------------------- RUN JAZZER ----------------------
    private void runJazzer(String benchmarkPath) throws Exception {
        appendOutput("Running Jazzer with benchmark: " + benchmarkPath);
        FuzzingRunner.runAllGeneratedTests(30, this, benchmarkPath);

        appendOutput("Jazzer finished");

        for (File crash : CrashScanner.scan()) {
            appendOutput("Crash found: " + crash.getAbsolutePath());
        }
    }

    private void exportReport() {
        JFileChooser chooser = new JFileChooser();
        chooser.setSelectedFile(new File("fuzz-report.txt"));

        if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                String uiContent = txtOutput.getText();

                ReportGenerator.export(chooser.getSelectedFile(), uiContent);

                appendOutput("\nReport exported successfully to: "
                        + chooser.getSelectedFile().getAbsolutePath() + "\n");
            } catch (Exception e) {
                appendOutput("Report export failed: " + e.getMessage() + "\n");
                e.printStackTrace();
            }
        }
    }

    private void runSecurityFuzzing() {
        if (selectedFolder == null) {
            JOptionPane.showMessageDialog(this, "Choose benchmark folder first.");
            return;
        }
        
        String timeInput = JOptionPane.showInputDialog(this, 
            "Fuzzing time per test (seconds):", "60");
        
        int timePerTest = 60;
        try {
            timePerTest = Integer.parseInt(timeInput);
        } catch (NumberFormatException e) {
            appendOutput("Invalid time, using default: 60s");
        }
        
        final int finalTime = timePerTest;
        
        new Thread(() -> {
            try {
                appendOutput("══════════════════════════════════════════════════");
                appendOutput("    SECURITY VULNERABILITY FUZZING");
                appendOutput("══════════════════════════════════════════════════");
                
                // Step 1: Scan methods
                appendOutput("\n[1/5] Scanning for security-relevant methods...");
                List<MethodInfo> allMethods = MethodScanner.scanAll(selectedFolder);
                appendOutput("Found " + allMethods.size() + " total methods");
                
                // Step 2: Generate security tests
                appendOutput("\n[2/5] Generating security fuzz tests...");
                List<String> securityTests = SecurityAwareFuzzTestGenerator
                    .generateSecurityTests(allMethods);
                appendOutput("Generated " + securityTests.size() + " security tests");
                
                if (securityTests.isEmpty()) {
                    appendOutput("No security-relevant methods found!");
                    return;
                }
                
                // Step 3: Compile
                appendOutput("\n[3/5] Compiling...");
                runMavenCompile();
                
                // Step 4: Run fuzzing
                appendOutput("\n[4/5] Running security fuzzing...");
                int vulnCount = 0;
                
                for (int i = 0; i < securityTests.size(); i++) {
                    String testClass = securityTests.get(i);
                    appendOutput("\n[" + (i+1) + "/" + securityTests.size() + "] " + testClass);
                    
                    boolean foundVuln = runSingleSecurityFuzz(testClass, finalTime);
                    if (foundVuln) {
                        vulnCount++;
                        appendOutput("  ⚠️  VULNERABILITY FOUND!");
                    }
                }
                
                // Step 5: Generate report
                appendOutput("\n[5/5] Generating security report...");
                File txtReport = new File("security-report.txt");
                File htmlReport = new File("security-report.html");
                
                SecurityReportGenerator.generateReport(txtReport);
                SecurityReportGenerator.generateHTMLReport(htmlReport);
                
                appendOutput("\n══════════════════════════════════════════════════");
                appendOutput("    SECURITY FUZZING COMPLETE");
                appendOutput("══════════════════════════════════════════════════");
                appendOutput("Total vulnerabilities found: " + vulnCount);
                appendOutput("Reports generated:");
                appendOutput("  • " + txtReport.getAbsolutePath());
                appendOutput("  • " + htmlReport.getAbsolutePath());
                appendOutput("══════════════════════════════════════════════════");
                
            } catch (Exception e) {
                appendOutput("ERROR: " + e.getMessage());
                e.printStackTrace();
            }
        }).start();
    }

    private boolean runSingleSecurityFuzz(String testClass, int timeSeconds) {
        try {
            String javaPath = "C:\\Program Files\\Eclipse Adoptium\\jdk-17.0.17.10-hotspot\\bin\\java.exe";
            String jazzerJar = "C:\\Tool_duan\\jazzer-windows\\jazzer_standalone.jar";
            
            StringBuilder cpBuilder = new StringBuilder();
            cpBuilder.append("target\\test-classes;");
            cpBuilder.append("target\\classes;");
            cpBuilder.append("target\\dependency\\*;");
            
            if (selectedFolder != null) {
                cpBuilder.append(selectedFolder.getAbsolutePath()).append(";");
            }
            
            cpBuilder.append(jazzerJar);
            
            List<String> cmd = new ArrayList<>();
            cmd.add(javaPath);
            cmd.add("-cp");
            cmd.add(cpBuilder.toString());
            cmd.add("-Xmx2g");
            cmd.add("-ea");
            cmd.add("-Djazzer.hooks=false");
            cmd.add("com.code_intelligence.jazzer.Jazzer");
            cmd.add("--target_class=" + testClass);
            cmd.add("--target_method=fuzzerTestOneInput");
            cmd.add("-max_total_time=" + timeSeconds);
            cmd.add("-max_len=4096");
            cmd.add("-timeout=10");
            
            ProcessBuilder pb = new ProcessBuilder(cmd);
            pb.directory(new File(System.getProperty("user.dir")));
            pb.redirectErrorStream(true);
            
            Process p = pb.start();
            
            boolean foundVuln = false;
            try (BufferedReader r = new BufferedReader(
                    new InputStreamReader(p.getInputStream()))) {
                String line;
                while ((line = r.readLine()) != null) {
                    if (line.contains("SECURITY VULNERABILITY FOUND") ||
                        line.contains("SecurityException")) {
                        foundVuln = true;
                        appendOutput("    " + line);
                    }
                }
            }
            
            p.waitFor();
            return foundVuln;
            
        } catch (Exception e) {
            appendOutput("    Error: " + e.getMessage());
            return false;
        }
    }

    private void exitApp() {
        if (JOptionPane.showConfirmDialog(this, "Exit?", "Exit", JOptionPane.YES_NO_OPTION)
                == JOptionPane.YES_OPTION) System.exit(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame().setVisible(true));
    }
}
