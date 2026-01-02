package report;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.lang.String;

/**
 * Report Generator - Export full fuzzing session output
 */
public class ReportGenerator {

    /**
     * Export simple report - exactly what user saw on UI
     */
    public static void export(File outputFile, String uiContent) throws Exception {
        try (FileWriter w = new FileWriter(outputFile)) {
            writeHeader(w);

            w.write("===============================================================\n");
            w.write("                  FUZZING SESSION OUTPUT                       \n");
            w.write("===============================================================\n\n");

            w.write(uiContent);

            w.write("\n\n");
            w.write("===============================================================\n");
            w.write("                     END OF REPORT                             \n");
            w.write("===============================================================\n");
        }
    }

    /**
     * Export enhanced report with analysis and statistics
     */
    public static void exportEnhanced(File outputFile, String uiContent) throws Exception {
        try (FileWriter w = new FileWriter(outputFile)) {
            writeHeader(w);

            // Executive Summary
            writeSummary(w, uiContent);

            // Full session log
            w.write("\n");
            w.write("===============================================================\n");
            w.write("                  COMPLETE SESSION LOG                         \n");
            w.write("===============================================================\n\n");
            w.write(uiContent);

            // Analysis section
            w.write("\n\n");
            writeAnalysis(w, uiContent);

            // Footer with recommendations
            writeFooter(w);
        }
    }

    /**
     * Export to HTML format for better readability
     */
    public static void exportHTML(File outputFile, String uiContent) throws Exception {
        try (FileWriter w = new FileWriter(outputFile)) {
            w.write("<!DOCTYPE html>\n<html lang='vi'>\n<head>\n");
            w.write("<meta charset='UTF-8'>\n");
            w.write("<meta name='viewport' content='width=device-width, initial-scale=1.0'>\n");
            w.write("<title>Fuzzing Report</title>\n");
            w.write("<style>\n");
            w.write("  body { font-family: 'Consolas', 'Courier New', monospace; margin: 0; padding: 20px; background: #1e1e1e; color: #d4d4d4; }\n");
            w.write("  .container { max-width: 1200px; margin: 0 auto; background: #252526; padding: 30px; border-radius: 8px; box-shadow: 0 4px 6px rgba(0,0,0,0.3); }\n");
            w.write("  h1 { color: #4ec9b0; border-bottom: 2px solid #4ec9b0; padding-bottom: 10px; }\n");
            w.write("  h2 { color: #569cd6; margin-top: 30px; }\n");
            w.write("  .summary { background: #2d2d30; padding: 20px; border-radius: 5px; margin: 20px 0; border-left: 4px solid #4ec9b0; }\n");
            w.write("  .log-output { background: #1e1e1e; padding: 15px; border-radius: 5px; overflow-x: auto; white-space: pre-wrap; word-wrap: break-word; font-size: 13px; line-height: 1.6; }\n");
            w.write("  .crash { color: #f48771; font-weight: bold; }\n");
            w.write("  .success { color: #4ec9b0; }\n");
            w.write("  .warning { color: #dcdcaa; }\n");
            w.write("  .timestamp { color: #808080; font-size: 12px; }\n");
            w.write("  .stat { display: inline-block; margin: 10px 20px 10px 0; }\n");
            w.write("  .stat-label { color: #808080; }\n");
            w.write("  .stat-value { color: #4ec9b0; font-weight: bold; font-size: 18px; }\n");
            w.write("  .bug-tag { display: inline-block; background: #5a2d2d; color: #f48771; padding: 3px 8px; border-radius: 3px; margin: 3px; font-size: 12px; }\n");
            w.write("</style>\n");
            w.write("</head>\n<body>\n");
            w.write("<div class='container'>\n");

            // Header
            w.write("<h1>Java Fuzzing Tool - Report</h1>\n");
            w.write("<p class='timestamp'>Generated: " + LocalDateTime.now().format(
                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "</p>\n");

            // Summary stats
            int crashes = countOccurrences(uiContent, "CRASH");
            int bugs = countOccurrences(uiContent, "BUG");
            int vulnerabilities = countOccurrences(uiContent, "VULNERABILITY");

            w.write("<div class='summary'>\n");
            w.write("<h2>Summary</h2>\n");
            w.write("<div class='stat'><span class='stat-label'>Crashes:</span> <span class='stat-value'>" + crashes + "</span></div>\n");
            w.write("<div class='stat'><span class='stat-label'>Bugs:</span> <span class='stat-value'>" + bugs + "</span></div>\n");
            w.write("<div class='stat'><span class='stat-label'>Vulnerabilities:</span> <span class='stat-value'>" + vulnerabilities + "</span></div>\n");

            // Bug types
            w.write("<div style='margin-top: 15px;'>\n");
            if (uiContent.contains("ArrayIndexOutOfBounds")) w.write("<span class='bug-tag'>Array Index OOB</span>\n");
            if (uiContent.contains("NullPointer")) w.write("<span class='bug-tag'>Null Pointer</span>\n");
            if (uiContent.contains("ArithmeticException")) w.write("<span class='bug-tag'>Division by Zero</span>\n");
            if (uiContent.contains("SQL Injection")) w.write("<span class='bug-tag'>SQL Injection</span>\n");
            if (uiContent.contains("XSS")) w.write("<span class='bug-tag'>XSS</span>\n");
            w.write("</div>\n");
            w.write("</div>\n");

            // Full log
            w.write("<h2>Complete Session Log</h2>\n");
            w.write("<div class='log-output'>");
            w.write(highlightContent(uiContent));
            w.write("</div>\n");

            w.write("</div>\n");
            w.write("</body>\n</html>");
        }
    }

    private static void writeHeader(FileWriter w) throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timestamp = LocalDateTime.now().format(formatter);

        w.write("===============================================================\n");
        w.write("              JAVA FUZZING TOOL - REPORT                       \n");
        w.write("===============================================================\n\n");
        w.write("Generated: " + timestamp + "\n");
        w.write("Tool: Java Fuzzing Tool with Jazzer v0.19.0\n");
        w.write("JDK: 17.0.17.10-hotspot\n");
        w.write("\n");
    }

    private static void writeSummary(FileWriter w, String content) throws Exception {
        w.write("===============================================================\n");
        w.write("                   EXECUTIVE SUMMARY                           \n");
        w.write("===============================================================\n\n");

        // Count various metrics from content
        int totalTests = countOccurrences(content, "Running ");
        int crashesFound = countOccurrences(content, "CRASH FOUND") +
                countOccurrences(content, "crash-");
        int bugsFound = countOccurrences(content, "BUG FOUND") +
                countOccurrences(content, "=== BUG FOUND ===");
        int vulnerabilities = countOccurrences(content, "SECURITY VULNERABILITY") +
                countOccurrences(content, "SecurityException");
        int exceptions = countOccurrences(content, "Exception:") +
                countOccurrences(content, "Error:");

        w.write("Test Statistics:\n");
        w.write("   - Total tests run: " + totalTests + "\n");
        w.write("   - Crashes found: " + crashesFound + "\n");
        w.write("   - Bugs detected: " + bugsFound + "\n");
        w.write("   - Security issues: " + vulnerabilities + "\n");
        w.write("   - Exceptions caught: " + exceptions + "\n\n");

        // Bug types found
        w.write("Bug Types Detected:\n");
        if (content.contains("ArrayIndexOutOfBoundsException")) {
            w.write("   [X] Array Index Out of Bounds\n");
        }
        if (content.contains("NullPointerException")) {
            w.write("   [X] Null Pointer Exception\n");
        }
        if (content.contains("ArithmeticException")) {
            w.write("   [X] Arithmetic Exception (Division by Zero)\n");
        }
        if (content.contains("StackOverflowError")) {
            w.write("   [X] Stack Overflow\n");
        }
        if (content.contains("SQL Injection")) {
            w.write("   [X] SQL Injection Vulnerability\n");
        }
        if (content.contains("XSS") || content.contains("Cross-Site Scripting")) {
            w.write("   [X] Cross-Site Scripting (XSS)\n");
        }
        if (content.contains("Path Traversal")) {
            w.write("   [X] Path Traversal Vulnerability\n");
        }

        w.write("\n");

        // Coverage info
        if (content.contains("corp:")) {
            w.write("Coverage Information:\n");
            w.write("   - Corpus generated for input mutation\n");
            w.write("   - Multiple code paths explored\n\n");
        }

        // Status
        w.write("Status: ");
        if (crashesFound > 0 || bugsFound > 0 || vulnerabilities > 0) {
            w.write("ISSUES FOUND - Review Required\n\n");
        } else {
            w.write("No critical issues detected\n\n");
        }
    }

    private static void writeAnalysis(FileWriter w, String content) throws Exception {
        w.write("===============================================================\n");
        w.write("                   DETAILED ANALYSIS                           \n");
        w.write("===============================================================\n\n");

        // Extract crash files
        w.write("Generated Artifacts:\n");
        if (content.contains("crash-")) {
            w.write("   Crash files have been generated for reproduction.\n");
            w.write("   Check the project root for files matching: crash-*\n");
            w.write("   Reproducer files: Crash_*.java\n\n");
        } else {
            w.write("   No crash files generated.\n\n");
        }

        // Extract coverage reports
        if (content.contains("coverage_")) {
            w.write("Coverage Reports:\n");
            w.write("   HTML coverage reports generated.\n");
            w.write("   Check files matching: coverage_*.html\n\n");
        }

        // Corpus information
        if (content.contains("corpus_")) {
            w.write("Test Corpus:\n");
            w.write("   Input corpus generated for future fuzzing runs.\n");
            w.write("   Location: corpus_* directories\n\n");
        }

        // Performance metrics
        w.write("Performance Metrics:\n");
        if (content.contains("exec/s")) {
            w.write("   Execution speed recorded in logs.\n");
        }
        if (content.contains("cov:")) {
            w.write("   Code coverage metrics available.\n");
        }
        w.write("   See full log above for detailed timing information.\n\n");
    }

    private static void writeFooter(FileWriter w) throws Exception {
        w.write("===============================================================\n");
        w.write("                   RECOMMENDATIONS                             \n");
        w.write("===============================================================\n\n");

        w.write("Next Steps:\n\n");
        w.write("1. Review Crashes:\n");
        w.write("   - Examine all crash-* files\n");
        w.write("   - Run Crash_*.java reproducers to verify bugs\n");
        w.write("   - Prioritize fixes by severity\n\n");

        w.write("2. Fix Identified Issues:\n");
        w.write("   - Add input validation\n");
        w.write("   - Handle edge cases (null, empty, out-of-bounds)\n");
        w.write("   - Add proper error handling\n\n");

        w.write("3. Re-test:\n");
        w.write("   - Run fuzzer again after fixes\n");
        w.write("   - Verify crashes no longer occur\n");
        w.write("   - Increase fuzzing time for thorough testing\n\n");

        w.write("4. Security Hardening:\n");
        w.write("   - Use PreparedStatement for SQL queries\n");
        w.write("   - Encode HTML output to prevent XSS\n");
        w.write("   - Validate file paths against traversal attacks\n");
        w.write("   - Sanitize all user inputs\n\n");

        w.write("===============================================================\n");
        w.write("For support: https://github.com/CodeIntelligenceTesting/jazzer\n");
        w.write("===============================================================\n");
    }

    private static int countOccurrences(String content, String searchTerm) {
        if (content == null || searchTerm == null) return 0;

        int count = 0;
        int index = 0;

        while ((index = content.indexOf(searchTerm, index)) != -1) {
            count++;
            index += searchTerm.length();
        }

        return count;
    }

    private static String highlightContent(String content) {
        // Escape HTML first
        content = content
                .replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;");

        // Then add highlights
        content = content
                .replace("CRASH FOUND", "<span class='crash'>CRASH FOUND</span>")
                .replace("BUG FOUND", "<span class='crash'>BUG FOUND</span>")
                .replace("VULNERABILITY", "<span class='crash'>VULNERABILITY</span>")
                .replace("WARNING", "<span class='warning'>WARNING</span>");

        return content;
    }
}