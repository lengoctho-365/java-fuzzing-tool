package report;

import security.SecurityDetector.SecurityIssue;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Generates detailed security vulnerability reports
 */
public class SecurityReportGenerator {

    public static class SecurityFinding {
        public String vulnerabilityType;
        public String severity;
        public String method;
        public String payload;
        public String details;
        public File crashFile;
        
        public SecurityFinding(String type, String severity, String method, 
                             String payload, String details, File crashFile) {
            this.vulnerabilityType = type;
            this.severity = severity;
            this.method = method;
            this.payload = payload;
            this.details = details;
            this.crashFile = crashFile;
        }
    }

    /**
     * Scan crash files và extract security findings
     */
    public static List<SecurityFinding> scanSecurityIssues() {
        List<SecurityFinding> findings = new ArrayList<>();
        
        // Scan crash files
        File root = new File(".");
        scanRecursive(root, findings);
        
        return findings;
    }

    private static void scanRecursive(File dir, List<SecurityFinding> findings) {
        if (!dir.isDirectory()) return;
        
        String name = dir.getName();
        if (name.equals("src") || name.equals("target") || 
            name.equals(".git") || name.equals(".idea")) {
            return;
        }
        
        File[] files = dir.listFiles();
        if (files == null) return;
        
        for (File f : files) {
            if (f.isDirectory()) {
                scanRecursive(f, findings);
            } else if (f.getName().startsWith("crash-") && !f.getName().contains(".")) {
                // Analyze crash file
                SecurityFinding finding = analyzeCrashFile(f);
                if (finding != null) {
                    findings.add(finding);
                }
            }
        }
    }

    private static SecurityFinding analyzeCrashFile(File crashFile) {
        // Tìm reproducer file
        String hash = crashFile.getName().replace("crash-", "");
        File reproducerFile = new File("Crash_" + hash + ".java");
        
        if (!reproducerFile.exists()) {
            return null;
        }
        
        try (BufferedReader br = new BufferedReader(new FileReader(reproducerFile))) {
            String line;
            String targetMethod = null;
            String payload = null;
            String vulnerabilityType = null;
            String severity = "UNKNOWN";
            
            while ((line = br.readLine()) != null) {
                // Extract target method
                if (line.contains("SecurityFuzz_")) {
                    targetMethod = extractMethodName(line);
                }
                
                // Extract payload
                if (line.contains("String payload =") || line.contains("payload =")) {
                    payload = extractPayload(line);
                }
                
                // Extract vulnerability type
                if (line.contains("SecurityException") && line.contains(":")) {
                    vulnerabilityType = extractVulnType(line);
                    severity = guessSeverity(vulnerabilityType);
                }
            }
            
            if (vulnerabilityType != null) {
                return new SecurityFinding(
                    vulnerabilityType,
                    severity,
                    targetMethod != null ? targetMethod : "Unknown",
                    payload != null ? payload : "Unknown",
                    "Security vulnerability detected by fuzzer",
                    crashFile
                );
            }
            
        } catch (IOException e) {
            // Ignore
        }
        
        return null;
    }

    private static String extractMethodName(String line) {
        try {
            // Extract from "fuzz.SecurityFuzz_0001" or similar
            if (line.contains("SecurityFuzz_")) {
                int start = line.indexOf("SecurityFuzz_");
                int end = line.indexOf("\"", start);
                if (end == -1) end = line.indexOf(")", start);
                if (end == -1) end = line.indexOf(";", start);
                if (end > start) {
                    return line.substring(start, end);
                }
            }
        } catch (Exception e) {
            // Ignore
        }
        return "Unknown";
    }

    private static String extractPayload(String line) {
        try {
            int start = line.indexOf("\"");
            int end = line.lastIndexOf("\"");
            if (start >= 0 && end > start) {
                return line.substring(start + 1, end);
            }
        } catch (Exception e) {
            // Ignore
        }
        return "Unknown";
    }

    private static String extractVulnType(String line) {
        try {
            if (line.contains("SQL Injection") || line.contains("SQL injection")) {
                return "SQL Injection";
            }
            if (line.contains("XSS") || line.contains("Cross-Site Scripting")) {
                return "Cross-Site Scripting (XSS)";
            }
            if (line.contains("Path Traversal") || line.contains("Directory Traversal")) {
                return "Path Traversal";
            }
            if (line.contains("Command Injection")) {
                return "Command Injection";
            }
            if (line.contains("XXE")) {
                return "XML External Entity (XXE)";
            }
            if (line.contains("SSRF")) {
                return "Server-Side Request Forgery";
            }
        } catch (Exception e) {
            // Ignore
        }
        return "Unknown Vulnerability";
    }

    private static String guessSeverity(String vulnType) {
        if (vulnType.contains("SQL Injection") || 
            vulnType.contains("Command Injection") ||
            vulnType.contains("XXE") ||
            vulnType.contains("Deserialization")) {
            return "CRITICAL";
        }
        if (vulnType.contains("XSS") || 
            vulnType.contains("Path Traversal") ||
            vulnType.contains("SSRF")) {
            return "HIGH";
        }
        return "MEDIUM";
    }

    /**
     * Generate detailed security report
     */
    public static void generateReport(File outputFile) throws IOException {
        List<SecurityFinding> findings = scanSecurityIssues();
        
        try (FileWriter w = new FileWriter(outputFile)) {
            writeHeader(w, findings);
            writeSummary(w, findings);
            writeDetailedFindings(w, findings);
            writeRecommendations(w);
            writeFooter(w);
        }
    }

    private static void writeHeader(FileWriter w, List<SecurityFinding> findings) throws IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timestamp = LocalDateTime.now().format(formatter);
        
        w.write("╔══════════════════════════════════════════════════════════════╗\n");
        w.write("║        SECURITY VULNERABILITY ASSESSMENT REPORT              ║\n");
        w.write("╚══════════════════════════════════════════════════════════════╝\n");
        w.write("\n");
        w.write("Report Generated: " + timestamp + "\n");
        w.write("Tool: Java Security Fuzzer with Jazzer\n");
        w.write("Total Vulnerabilities Found: " + findings.size() + "\n");
        w.write("\n");
        w.write("══════════════════════════════════════════════════════════════\n");
        w.write("\n");
    }

    private static void writeSummary(FileWriter w, List<SecurityFinding> findings) throws IOException {
        w.write("EXECUTIVE SUMMARY\n");
        w.write("═════════════════\n\n");
        
        // Count by severity
        Map<String, Integer> bySeverity = new HashMap<>();
        Map<String, Integer> byType = new HashMap<>();
        
        for (SecurityFinding f : findings) {
            bySeverity.put(f.severity, bySeverity.getOrDefault(f.severity, 0) + 1);
            byType.put(f.vulnerabilityType, byType.getOrDefault(f.vulnerabilityType, 0) + 1);
        }
        
        w.write("Severity Distribution:\n");
        w.write("─────────────────────\n");
        int critical = bySeverity.getOrDefault("CRITICAL", 0);
        int high = bySeverity.getOrDefault("HIGH", 0);
        int medium = bySeverity.getOrDefault("MEDIUM", 0);
        
        w.write(String.format("  🔴 CRITICAL: %2d  %s\n", critical, "█".repeat(Math.min(critical, 20))));
        w.write(String.format("  🟠 HIGH:     %2d  %s\n", high, "█".repeat(Math.min(high, 20))));
        w.write(String.format("  🟡 MEDIUM:   %2d  %s\n", medium, "█".repeat(Math.min(medium, 20))));
        w.write("\n");
        
        w.write("Vulnerability Types:\n");
        w.write("────────────────────\n");
        List<Map.Entry<String, Integer>> sorted = new ArrayList<>(byType.entrySet());
        sorted.sort((a, b) -> Integer.compare(b.getValue(), a.getValue()));
        
        for (Map.Entry<String, Integer> entry : sorted) {
            w.write(String.format("  • %-35s: %2d\n", entry.getKey(), entry.getValue()));
        }
        w.write("\n");
        w.write("══════════════════════════════════════════════════════════════\n");
        w.write("\n");
    }

    private static void writeDetailedFindings(FileWriter w, List<SecurityFinding> findings) throws IOException {
        w.write("DETAILED FINDINGS\n");
        w.write("═════════════════\n\n");
        
        // Group by severity
        List<SecurityFinding> critical = new ArrayList<>();
        List<SecurityFinding> high = new ArrayList<>();
        List<SecurityFinding> medium = new ArrayList<>();
        
        for (SecurityFinding f : findings) {
            if (f.severity.equals("CRITICAL")) critical.add(f);
            else if (f.severity.equals("HIGH")) high.add(f);
            else medium.add(f);
        }
        
        writeFindingSection(w, "CRITICAL", critical);
        writeFindingSection(w, "HIGH", high);
        writeFindingSection(w, "MEDIUM", medium);
    }

    private static void writeFindingSection(FileWriter w, String severity, 
                                           List<SecurityFinding> findings) throws IOException {
        if (findings.isEmpty()) return;
        
        w.write("\n" + severity + " SEVERITY (" + findings.size() + " findings)\n");
        w.write("─".repeat(60) + "\n\n");
        
        int num = 1;
        for (SecurityFinding f : findings) {
            w.write("[" + severity.charAt(0) + "-" + num + "] " + f.vulnerabilityType + "\n");
            w.write("    Method:  " + f.method + "\n");
            w.write("    Payload: " + f.payload + "\n");
            w.write("    Details: " + f.details + "\n");
            w.write("    Evidence: " + f.crashFile.getName() + "\n");
            w.write("\n");
            num++;
        }
    }

    private static void writeRecommendations(FileWriter w) throws IOException {
        w.write("══════════════════════════════════════════════════════════════\n");
        w.write("\n");
        w.write("REMEDIATION RECOMMENDATIONS\n");
        w.write("═══════════════════════════\n\n");
        
        w.write("1. SQL Injection:\n");
        w.write("   • Use PreparedStatement instead of string concatenation\n");
        w.write("   • Implement input validation with whitelisting\n");
        w.write("   • Use ORM frameworks (JPA, Hibernate)\n\n");
        
        w.write("2. Cross-Site Scripting (XSS):\n");
        w.write("   • HTML-encode all user input before output\n");
        w.write("   • Use Content Security Policy (CSP)\n");
        w.write("   • Implement output encoding libraries\n\n");
        
        w.write("3. Path Traversal:\n");
        w.write("   • Validate and sanitize file paths\n");
        w.write("   • Use getCanonicalPath() for validation\n");
        w.write("   • Restrict file access to base directory\n\n");
        
        w.write("4. Command Injection:\n");
        w.write("   • Use ProcessBuilder with separate arguments\n");
        w.write("   • Avoid Runtime.exec() with user input\n");
        w.write("   • Implement strict input validation\n\n");
        
        w.write("Priority Actions:\n");
        w.write("─────────────────\n");
        w.write("1. Fix all CRITICAL vulnerabilities immediately\n");
        w.write("2. Review and patch HIGH severity issues\n");
        w.write("3. Implement input validation framework\n");
        w.write("4. Add security testing to CI/CD pipeline\n");
        w.write("5. Conduct security code review\n");
        w.write("\n");
    }

    private static void writeFooter(FileWriter w) throws IOException {
        w.write("══════════════════════════════════════════════════════════════\n");
        w.write("\n");
        w.write("For more information:\n");
        w.write("  • OWASP Top 10: https://owasp.org/www-project-top-ten/\n");
        w.write("  • CWE Database: https://cwe.mitre.org/\n");
        w.write("  • NIST CVE: https://nvd.nist.gov/\n");
        w.write("\n");
        w.write("End of Security Report\n");
    }

    /**
     * Generate HTML report
     */
    public static void generateHTMLReport(File outputFile) throws IOException {
        List<SecurityFinding> findings = scanSecurityIssues();
        
        try (FileWriter w = new FileWriter(outputFile)) {
            w.write("<!DOCTYPE html>\n<html>\n<head>\n");
            w.write("<meta charset='UTF-8'>\n");
            w.write("<title>Security Vulnerability Report</title>\n");
            w.write("<style>\n");
            w.write("body { font-family: 'Segoe UI', Arial, sans-serif; margin: 0; padding: 20px; background: #f5f5f5; }\n");
            w.write(".header { background: linear-gradient(135deg, #667eea 0%, #764ba2 100%); color: white; padding: 30px; border-radius: 10px; }\n");
            w.write("h1 { margin: 0; font-size: 32px; }\n");
            w.write(".summary { background: white; padding: 20px; margin: 20px 0; border-radius: 8px; box-shadow: 0 2px 4px rgba(0,0,0,0.1); }\n");
            w.write(".critical { border-left: 5px solid #e74c3c; }\n");
            w.write(".high { border-left: 5px solid #e67e22; }\n");
            w.write(".medium { border-left: 5px solid #f39c12; }\n");
            w.write(".finding { background: white; padding: 20px; margin: 10px 0; border-radius: 8px; box-shadow: 0 2px 4px rgba(0,0,0,0.1); }\n");
            w.write(".badge { display: inline-block; padding: 5px 10px; border-radius: 3px; color: white; font-weight: bold; }\n");
            w.write(".badge-critical { background: #e74c3c; }\n");
            w.write(".badge-high { background: #e67e22; }\n");
            w.write(".badge-medium { background: #f39c12; }\n");
            w.write("code { background: #f4f4f4; padding: 2px 6px; border-radius: 3px; }\n");
            w.write("</style>\n");
            w.write("</head>\n<body>\n");
            
            w.write("<div class='header'>\n");
            w.write("<h1>🔒 Security Vulnerability Report</h1>\n");
            w.write("<p>Total Vulnerabilities: " + findings.size() + "</p>\n");
            w.write("</div>\n");
            
            // Summary
            Map<String, Integer> bySeverity = new HashMap<>();
            for (SecurityFinding f : findings) {
                bySeverity.put(f.severity, bySeverity.getOrDefault(f.severity, 0) + 1);
            }
            
            w.write("<div class='summary'>\n");
            w.write("<h2>Summary</h2>\n");
            w.write("<p>🔴 Critical: " + bySeverity.getOrDefault("CRITICAL", 0) + "</p>\n");
            w.write("<p>🟠 High: " + bySeverity.getOrDefault("HIGH", 0) + "</p>\n");
            w.write("<p>🟡 Medium: " + bySeverity.getOrDefault("MEDIUM", 0) + "</p>\n");
            w.write("</div>\n");
            
            // Findings
            for (SecurityFinding f : findings) {
                String badgeClass = "badge-" + f.severity.toLowerCase();
                String findingClass = f.severity.toLowerCase();
                
                w.write("<div class='finding " + findingClass + "'>\n");
                w.write("<span class='badge " + badgeClass + "'>" + f.severity + "</span>\n");
                w.write("<h3>" + f.vulnerabilityType + "</h3>\n");
                w.write("<p><strong>Method:</strong> <code>" + f.method + "</code></p>\n");
                w.write("<p><strong>Payload:</strong> <code>" + escapeHTML(f.payload) + "</code></p>\n");
                w.write("<p><strong>Evidence:</strong> " + f.crashFile.getName() + "</p>\n");
                w.write("</div>\n");
            }
            
            w.write("</body>\n</html>\n");
        }
    }

    private static String escapeHTML(String s) {
        return s.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;");
    }
}