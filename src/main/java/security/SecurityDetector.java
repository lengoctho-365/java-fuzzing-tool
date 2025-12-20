package security;

import java.util.*;
import java.util.regex.*;

/**
 * Security Detector - Phát hiện các lỗi bảo mật từ fuzzing input/output
 */
public class SecurityDetector {
    
    // ============ SQL INJECTION DETECTION ============
    
    private static final Pattern SQL_CONCAT_PATTERN = 
        Pattern.compile("(SELECT|INSERT|UPDATE|DELETE|DROP|CREATE).*['\"].*\\+.*['\"]", 
                       Pattern.CASE_INSENSITIVE);
    
    private static final Pattern SQL_INJECTION_PATTERN = 
        Pattern.compile("('.*(OR|AND).*'=')|('.*--)|('.*;--)", 
                       Pattern.CASE_INSENSITIVE);
    
    /**
     * Kiểm tra SQL Injection vulnerability
     */
    public static SecurityIssue detectSQLInjection(String sqlQuery, String input) {
        if (sqlQuery == null || input == null) return null;
        
        // Check 1: String concatenation trong SQL
        if (SQL_CONCAT_PATTERN.matcher(sqlQuery).find()) {
            if (sqlQuery.contains(input)) {
                return new SecurityIssue(
                    "SQL Injection",
                    "CRITICAL",
                    "SQL query uses string concatenation with user input",
                    "SQL: " + sqlQuery + "\nInput: " + input,
                    "Use PreparedStatement instead"
                );
            }
        }
        
        // Check 2: SQL injection patterns trong input
        if (SQL_INJECTION_PATTERN.matcher(input).find()) {
            return new SecurityIssue(
                "SQL Injection",
                "CRITICAL",
                "Input contains SQL injection pattern",
                "Input: " + input,
                "Validate and sanitize input"
            );
        }
        
        return null;
    }
    
    // ============ XSS DETECTION ============
    
    private static final Pattern XSS_PATTERN = 
        Pattern.compile("<script|javascript:|onerror=|onload=|<iframe|<img.*onerror", 
                       Pattern.CASE_INSENSITIVE);
    
    private static final Pattern HTML_OUTPUT_PATTERN = 
        Pattern.compile("(println|write|append).*<.*>", 
                       Pattern.CASE_INSENSITIVE);
    
    /**
     * Kiểm tra XSS vulnerability
     */
    public static SecurityIssue detectXSS(String output, String input) {
        if (output == null || input == null) return null;
        
        // Check 1: Input chứa XSS payload
        if (XSS_PATTERN.matcher(input).find()) {
            // Check 2: Input được output trực tiếp không escape
            if (output.contains(input)) {
                return new SecurityIssue(
                    "Cross-Site Scripting (XSS)",
                    "HIGH",
                    "User input reflected in HTML without escaping",
                    "Input: " + input + "\nOutput: " + output,
                    "Use HTML escaping: StringEscapeUtils.escapeHtml4(input)"
                );
            }
        }
        
        return null;
    }
    
    // ============ PATH TRAVERSAL DETECTION ============
    
    private static final Pattern PATH_TRAVERSAL_PATTERN = 
        Pattern.compile("\\.\\./|\\.\\.\\\\|%2e%2e/|%2e%2e\\\\", 
                       Pattern.CASE_INSENSITIVE);
    
    /**
     * Kiểm tra Path Traversal vulnerability
     */
    public static SecurityIssue detectPathTraversal(String filePath, String input) {
        if (filePath == null || input == null) return null;
        
        // Check 1: Input có chứa ../ hoặc ..\
        if (PATH_TRAVERSAL_PATTERN.matcher(input).find()) {
            if (filePath.contains(input)) {
                return new SecurityIssue(
                    "Path Traversal",
                    "HIGH",
                    "File path contains directory traversal sequence",
                    "Path: " + filePath + "\nInput: " + input,
                    "Validate path: new File(basePath, input).getCanonicalPath()"
                );
            }
        }
        
        // Check 2: Path đi ra ngoài base directory
        if (filePath.contains("../") || filePath.contains("..\\")) {
            return new SecurityIssue(
                "Path Traversal",
                "HIGH",
                "File path allows directory traversal",
                "Path: " + filePath,
                "Restrict to base directory"
            );
        }
        
        return null;
    }
    
    // ============ COMMAND INJECTION DETECTION ============
    
    private static final Pattern COMMAND_INJECTION_PATTERN = 
        Pattern.compile("[;&|`$()<>]", Pattern.CASE_INSENSITIVE);
    
    /**
     * Kiểm tra Command Injection vulnerability
     */
    public static SecurityIssue detectCommandInjection(String command, String input) {
        if (command == null || input == null) return null;
        
        // Check: Input chứa shell metacharacters
        if (COMMAND_INJECTION_PATTERN.matcher(input).find()) {
            if (command.contains(input)) {
                return new SecurityIssue(
                    "Command Injection",
                    "CRITICAL",
                    "Command contains shell metacharacters from user input",
                    "Command: " + command + "\nInput: " + input,
                    "Use ProcessBuilder with separate arguments"
                );
            }
        }
        
        return null;
    }
    
    // ============ XXE DETECTION ============
    
    private static final Pattern XXE_PATTERN = 
        Pattern.compile("<!ENTITY|<!DOCTYPE.*ENTITY|SYSTEM|file://", 
                       Pattern.CASE_INSENSITIVE);
    
    /**
     * Kiểm tra XXE (XML External Entity) vulnerability
     */
    public static SecurityIssue detectXXE(String xmlContent) {
        if (xmlContent == null) return null;
        
        if (XXE_PATTERN.matcher(xmlContent).find()) {
            return new SecurityIssue(
                "XML External Entity (XXE)",
                "CRITICAL",
                "XML content may contain external entity references",
                "XML: " + xmlContent,
                "Disable external entities in XML parser"
            );
        }
        
        return null;
    }
    
    // ============ SSRF DETECTION ============
    
    private static final Pattern SSRF_PATTERN = 
        Pattern.compile("(http://|https://)(localhost|127\\.0\\.0\\.1|169\\.254|192\\.168|10\\.)", 
                       Pattern.CASE_INSENSITIVE);
    
    /**
     * Kiểm tra SSRF (Server-Side Request Forgery) vulnerability
     */
    public static SecurityIssue detectSSRF(String url) {
        if (url == null) return null;
        
        if (SSRF_PATTERN.matcher(url).find()) {
            return new SecurityIssue(
                "Server-Side Request Forgery (SSRF)",
                "HIGH",
                "URL may target internal/private network",
                "URL: " + url,
                "Validate and whitelist allowed URLs"
            );
        }
        
        return null;
    }
    
    // ============ INSECURE DESERIALIZATION ============
    
    /**
     * Kiểm tra Insecure Deserialization
     */
    public static SecurityIssue detectInsecureDeserialization(byte[] data) {
        if (data == null || data.length < 4) return null;
        
        // Java serialization magic bytes: 0xAC 0xED
        if (data[0] == (byte)0xAC && data[1] == (byte)0xED) {
            return new SecurityIssue(
                "Insecure Deserialization",
                "CRITICAL",
                "Untrusted data is being deserialized",
                "Data starts with Java serialization magic bytes",
                "Avoid deserializing untrusted data or use safe alternatives"
            );
        }
        
        return null;
    }
    
    // ============ SECURITY ISSUE CLASS ============
    
    public static class SecurityIssue {
        public final String type;
        public final String severity;
        public final String description;
        public final String details;
        public final String recommendation;
        
        public SecurityIssue(String type, String severity, String description, 
                           String details, String recommendation) {
            this.type = type;
            this.severity = severity;
            this.description = description;
            this.details = details;
            this.recommendation = recommendation;
        }
        
        @Override
        public String toString() {
            return String.format(
                "[%s] %s\n  Description: %s\n  Details: %s\n  Fix: %s",
                severity, type, description, details, recommendation
            );
        }
        
        public String toJSON() {
            return String.format(
                "{\"type\":\"%s\",\"severity\":\"%s\",\"description\":\"%s\",\"details\":\"%s\",\"recommendation\":\"%s\"}",
                escape(type), escape(severity), escape(description), 
                escape(details), escape(recommendation)
            );
        }
        
        private String escape(String s) {
            return s.replace("\"", "\\\"").replace("\n", "\\n");
        }
    }
    
    // ============ COMPREHENSIVE SCAN ============
    
    /**
     * Scan tổng hợp tất cả các lỗi bảo mật
     */
    public static List<SecurityIssue> scanAll(
            String input, 
            String sqlQuery, 
            String output, 
            String filePath, 
            String command) {
        
        List<SecurityIssue> issues = new ArrayList<>();
        
        SecurityIssue issue;
        
        if ((issue = detectSQLInjection(sqlQuery, input)) != null) {
            issues.add(issue);
        }
        
        if ((issue = detectXSS(output, input)) != null) {
            issues.add(issue);
        }
        
        if ((issue = detectPathTraversal(filePath, input)) != null) {
            issues.add(issue);
        }
        
        if ((issue = detectCommandInjection(command, input)) != null) {
            issues.add(issue);
        }
        
        if ((issue = detectXXE(input)) != null) {
            issues.add(issue);
        }
        
        if ((issue = detectSSRF(input)) != null) {
            issues.add(issue);
        }
        
        return issues;
    }
}