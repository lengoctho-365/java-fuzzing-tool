package report;

import crash.EnhancedCrashScanner;
import crash.EnhancedCrashScanner.CrashInfo;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class EnhancedReportGenerator {

    public static void export(File out) throws Exception {
        List<CrashInfo> crashes = EnhancedCrashScanner.scanWithDetails();
        Map<String, List<CrashInfo>> grouped = EnhancedCrashScanner.groupByBugType(crashes);
        
        try (FileWriter w = new FileWriter(out)) {
            writeHeader(w);
            writeSummary(w, crashes, grouped);
            writeDetailedReport(w, grouped);
            writeFooter(w);
        }
    }

    private static void writeHeader(FileWriter w) throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timestamp = LocalDateTime.now().format(formatter);
        
        w.write("╔══════════════════════════════════════════════════════════════╗\n");
        w.write("║           JAVA FUZZING TOOL - BUG REPORT                     ║\n");
        w.write("╚══════════════════════════════════════════════════════════════╝\n");
        w.write("\n");
        w.write("Generated: " + timestamp + "\n");
        w.write("Tool: Java Fuzzing Tool v1.0\n");
        w.write("Fuzzer: Jazzer (libFuzzer)\n");
        w.write("\n");
        w.write("══════════════════════════════════════════════════════════════\n");
        w.write("\n");
    }

    private static void writeSummary(FileWriter w, List<CrashInfo> crashes, 
                                     Map<String, List<CrashInfo>> grouped) throws Exception {
        w.write("SUMMARY\n");
        w.write("═══════\n\n");
        w.write("Total crashes found: " + crashes.size() + "\n");
        w.write("Unique bug types: " + grouped.size() + "\n");
        w.write("\n");
        
        w.write("Bug Type Distribution:\n");
        w.write("─────────────────────\n");
        
        // Sort by count
        List<Map.Entry<String, List<CrashInfo>>> sorted = new ArrayList<>(grouped.entrySet());
        sorted.sort((a, b) -> Integer.compare(b.getValue().size(), a.getValue().size()));
        
        for (Map.Entry<String, List<CrashInfo>> entry : sorted) {
            String bugType = entry.getKey();
            int count = entry.getValue().size();
            
            // Create simple bar chart
            String bar = "█".repeat(Math.min(count, 20));
            w.write(String.format("  %-35s: %3d %s\n", bugType, count, bar));
        }
        
        w.write("\n");
        w.write("══════════════════════════════════════════════════════════════\n");
        w.write("\n");
    }

    private static void writeDetailedReport(FileWriter w, Map<String, List<CrashInfo>> grouped) 
            throws Exception {
        w.write("DETAILED REPORT\n");
        w.write("═══════════════\n\n");
        
        // Sort by bug type
        List<String> bugTypes = new ArrayList<>(grouped.keySet());
        Collections.sort(bugTypes);
        
        int totalBugs = 0;
        for (String bugType : bugTypes) {
            List<CrashInfo> crashes = grouped.get(bugType);
            
            w.write("┌─ " + bugType + " (" + crashes.size() + " instances)\n");
            w.write("│\n");
            
            for (int i = 0; i < crashes.size(); i++) {
                CrashInfo crash = crashes.get(i);
                totalBugs++;
                
                w.write("│  [" + totalBugs + "] " + crash.methodName + "\n");
                w.write("│      File: " + crash.file.getName() + "\n");
                w.write("│      Size: " + crash.file.length() + " bytes\n");
                
                if (i < crashes.size() - 1) {
                    w.write("│\n");
                }
            }
            
            w.write("└" + "─".repeat(60) + "\n\n");
        }
        
        w.write("══════════════════════════════════════════════════════════════\n");
        w.write("\n");
    }

    private static void writeFooter(FileWriter w) throws Exception {
        w.write("RECOMMENDATIONS\n");
        w.write("═══════════════\n\n");
        w.write("1. Review each crash file to understand the root cause\n");
        w.write("2. Run corresponding Crash_*.java reproducers to verify bugs\n");
        w.write("3. Fix bugs in order of severity:\n");
        w.write("   - SecurityException, NullPointerException (High)\n");
        w.write("   - ArrayIndexOutOfBounds, ArithmeticException (Medium)\n");
        w.write("   - NumberFormatException (Low)\n");
        w.write("4. Re-run fuzzing after fixes to ensure bugs are resolved\n");
        w.write("\n");
        w.write("══════════════════════════════════════════════════════════════\n");
        w.write("\n");
        w.write("For more information:\n");
        w.write("  - Check individual crash-* files for fuzzer inputs\n");
        w.write("  - Run Crash_*.java files to reproduce bugs\n");
        w.write("  - Review source code methods listed above\n");
        w.write("\n");
        w.write("End of Report\n");
    }

    /**
     * Export HTML report
     */
    public static void exportHTML(File out) throws Exception {
        List<CrashInfo> crashes = EnhancedCrashScanner.scanWithDetails();
        Map<String, List<CrashInfo>> grouped = EnhancedCrashScanner.groupByBugType(crashes);
        
        try (FileWriter w = new FileWriter(out)) {
            w.write("<!DOCTYPE html>\n");
            w.write("<html>\n<head>\n");
            w.write("<meta charset='UTF-8'>\n");
            w.write("<title>Fuzzing Report</title>\n");
            w.write("<style>\n");
            w.write("body { font-family: Arial, sans-serif; margin: 20px; background: #f5f5f5; }\n");
            w.write("h1 { color: #333; border-bottom: 3px solid #e74c3c; }\n");
            w.write("h2 { color: #555; margin-top: 30px; }\n");
            w.write(".summary { background: white; padding: 20px; border-radius: 5px; margin: 20px 0; }\n");
            w.write(".bug-type { background: white; padding: 15px; margin: 10px 0; border-left: 4px solid #e74c3c; }\n");
            w.write(".crash-item { background: #fafafa; padding: 10px; margin: 5px 0; border-radius: 3px; }\n");
            w.write(".count { font-weight: bold; color: #e74c3c; }\n");
            w.write("</style>\n");
            w.write("</head>\n<body>\n");
            
            w.write("<h1>Java Fuzzing Report</h1>\n");
            w.write("<div class='summary'>\n");
            w.write("<h2>Summary</h2>\n");
            w.write("<p>Total crashes: <span class='count'>" + crashes.size() + "</span></p>\n");
            w.write("<p>Bug types: <span class='count'>" + grouped.size() + "</span></p>\n");
            w.write("</div>\n");
            
            for (Map.Entry<String, List<CrashInfo>> entry : grouped.entrySet()) {
                w.write("<div class='bug-type'>\n");
                w.write("<h3>" + entry.getKey() + " (" + entry.getValue().size() + ")</h3>\n");
                
                for (CrashInfo crash : entry.getValue()) {
                    w.write("<div class='crash-item'>\n");
                    w.write("<strong>" + crash.methodName + "</strong><br>\n");
                    w.write("File: <code>" + crash.file.getName() + "</code><br>\n");
                    w.write("</div>\n");
                }
                
                w.write("</div>\n");
            }
            
            w.write("</body>\n</html>\n");
        }
    }
}