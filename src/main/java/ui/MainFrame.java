package ui;

import javax.swing.*;
import java.io.File;
import java.util.List;

import generator.FuzzTestGenerator;
import generator.UniversalFuzzTestGenerator;
import runner.FuzzingRunner;
import scanner.FileScanner;
import scanner.MethodInfo;
import scanner.MethodScanner;
import crash.CrashScanner;
import report.ReportGenerator;

public class MainFrame extends JFrame {

    private JButton btnFuzzingAll;
    private JPanel panelMain;

    private JButton btnSelectFolder;
    private JButton btnScan;
    private JButton btnGenerateAndFuzz;
    private JButton btnGenerateUniversalAndFuzz;   // <-- NÚT MỚI
    private JButton btnExportReport;
    private JButton btnExit;

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
        btnGenerateUniversalAndFuzz = new JButton("Universal Fuzz");  // NEW BUTTON
        btnExportReport = new JButton("Export Report");
        btnExit = new JButton("Exit");

        top.add(btnSelectFolder);
        top.add(btnScan);
        top.add(btnGenerateAndFuzz);
        top.add(btnGenerateUniversalAndFuzz); // ADD TO UI
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
        btnGenerateUniversalAndFuzz.addActionListener(e -> generateUniversalAndFuzz()); // NEW ACTION
        btnExportReport.addActionListener(e -> exportReport());
        btnExit.addActionListener(e -> exitApp());
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
            appendOutput("📁 Selected benchmark: " + selectedFolder.getAbsolutePath());
        }
    }

    // ---------------------- SCAN ----------------------
    private void scanFolder() {
        if (selectedFolder == null) {
            JOptionPane.showMessageDialog(this, "Choose benchmark folder first.");
            return;
        }

        appendOutput("🔎 Scanning benchmark Java files and methods...");

        try {
            List<File> files = FileScanner.scanJavaFiles(selectedFolder);
            appendOutput("📄 Java files found: " + files.size());

            int totalMethods = 0;

            for (File f : files) {
                try {
                    List<MethodInfo> methods = MethodScanner.scan(f);
                    for (MethodInfo mi : methods) {
                        appendOutput("• " + mi);
                        totalMethods++;
                    }
                } catch (Exception ex) {
                    appendOutput("⚠ Skipped file: " + f.getName());
                }
            }

            List<MethodInfo> allMethods = MethodScanner.scanAll(selectedFolder);
            appendOutput("📌 Total unique methods (scanAll): " + allMethods.size());
            appendOutput("✅ Total benchmark methods found: " + totalMethods);

        } catch (Exception e) {
            appendOutput("❌ Scan error: " + e.getMessage());
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
                appendOutput("🎯 Target methods: " + allMethods.size());

                appendOutput("▶ Generating batch harness...");
                List<String> fuzzClasses = FuzzTestGenerator.generateMultipleClasses(allMethods);
                appendOutput("✅ Generated fuzz harness: " + fuzzClasses.size() + " classes");

                runMavenCompile();
                runJazzer();

            } catch (Exception e) {
                appendOutput("❌ Fuzz error: " + e.getMessage());
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
                appendOutput("🔄 Scanning methods...");
                List<MethodInfo> allMethods = MethodScanner.scanAll(selectedFolder);

                appendOutput("🛠 Generating Universal Fuzzer...");
                String className = UniversalFuzzTestGenerator.generateUniversalFuzzer(allMethods);
                appendOutput("✅ Generated: " + className);

                runMavenCompile();
                runJazzer();

            } catch (Exception e) {
                appendOutput("❌ Error: " + e.getMessage());
            }
        }).start();
    }

    // ---------------------- MAVEN COMPILE ----------------------
    private void runMavenCompile() throws Exception {
        appendOutput("▶ Compiling classes (mvn test-compile)...");

        String mavenCmd = "D:\\apache-maven-3.8.8\\bin\\mvn.cmd";
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
    private void runJazzer() throws Exception {
        appendOutput("▶ Running Jazzer...");
        FuzzingRunner.runAllGeneratedTests(30, this);

        appendOutput("✔ Jazzer finished");

        for (File crash : CrashScanner.scan()) {
            appendOutput("💥 Crash found: " + crash.getAbsolutePath());
        }
    }

    // ---------------------- EXPORT REPORT ----------------------
    private void exportReport() {
        JFileChooser chooser = new JFileChooser();
        chooser.setSelectedFile(new File("fuzz-report.txt"));

        if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                ReportGenerator.export(chooser.getSelectedFile());
                appendOutput("✅ Report exported");
            } catch (Exception e) {
                appendOutput("❌ Report error: " + e.getMessage());
            }
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
