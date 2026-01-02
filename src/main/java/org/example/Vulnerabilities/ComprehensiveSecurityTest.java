package org.example;

/**
 * COMPREHENSIVE SECURITY TEST FILE
 * Contains OBVIOUS vulnerabilities for easy detection
 * Location: src/main/java/org/example/ComprehensiveSecurityTest.java
 * 
 * ⚠️ Each method has ONE CLEAR vulnerability type
 */
public class ComprehensiveSecurityTest {
    
    // ============================================================
    // CATEGORY 1: SQL INJECTION (5 variants)
    // ============================================================
    
    /**
     * SQL-1: Simple authentication bypass
     */
    public void sqlLogin(String username) {
        String sql = "SELECT * FROM users WHERE username = '" + username + "'";
        System.out.println("Executing SQL: " + sql);
    }
    
    /**
     * SQL-2: Search with LIKE
     */
    public void sqlSearch(String keyword) {
        String query = "SELECT * FROM products WHERE name LIKE '%" + keyword + "%'";
        System.out.println("Search SQL: " + query);
    }
    
    /**
     * SQL-3: Update statement
     */
    public void sqlUpdate(String email) {
        String update = "UPDATE users SET email = '" + email + "' WHERE id = 1";
        System.out.println("Update SQL: " + update);
    }
    
    /**
     * SQL-4: DELETE with user input
     */
    public void sqlDelete(String userId) {
        String delete = "DELETE FROM sessions WHERE user_id = " + userId;
        System.out.println("Delete SQL: " + delete);
    }
    
    /**
     * SQL-5: ORDER BY injection
     */
    public void sqlSort(String column) {
        String sql = "SELECT * FROM users ORDER BY " + column;
        System.out.println("Sort SQL: " + sql);
    }
    
    // ============================================================
    // CATEGORY 2: CROSS-SITE SCRIPTING (5 variants)
    // ============================================================
    
    /**
     * XSS-1: Direct output to HTML
     */
    public void xssComment(String comment) {
        System.out.println("<html><body>");
        System.out.println("<div>" + comment + "</div>");
        System.out.println("</body></html>");
    }
    
    /**
     * XSS-2: JavaScript context
     */
    public void xssJavaScript(String name) {
        System.out.println("<script>");
        System.out.println("var username = '" + name + "';");
        System.out.println("</script>");
    }
    
    /**
     * XSS-3: HTML attribute injection
     */
    public void xssAttribute(String imageUrl) {
        System.out.println("<img src='" + imageUrl + "'>");
    }
    
    /**
     * XSS-4: URL parameter reflection
     */
    public void xssUrl(String redirect) {
        System.out.println("<a href='" + redirect + "'>Click here</a>");
    }
    
    /**
     * XSS-5: JSON response without escaping
     */
    public void xssJson(String data) {
        System.out.println("{\"user_input\":\"" + data + "\"}");
    }
    
    // ============================================================
    // CATEGORY 3: PATH TRAVERSAL (5 variants)
    // ============================================================
    
    /**
     * PATH-1: File read with concatenation
     */
    public void pathRead(String filename) {
        String path = "/var/www/files/" + filename;
        System.out.println("Reading file: " + path);
    }
    
    /**
     * PATH-2: File download
     */
    public void pathDownload(String file) {
        String fullPath = "C:\\uploads\\" + file;
        System.out.println("Downloading: " + fullPath);
    }
    
    /**
     * PATH-3: Template loading
     */
    public void pathTemplate(String template) {
        String path = "/templates/" + template + ".html";
        System.out.println("Loading template: " + path);
    }
    
    /**
     * PATH-4: Log file access
     */
    public void pathLog(String logFile) {
        String logPath = "./logs/" + logFile;
        System.out.println("Accessing log: " + logPath);
    }
    
    /**
     * PATH-5: Config file load
     */
    public void pathConfig(String config) {
        String configPath = "/etc/app/" + config;
        System.out.println("Loading config: " + configPath);
    }
    
    // ============================================================
    // CATEGORY 4: COMMAND INJECTION (5 variants)
    // ============================================================
    
    /**
     * CMD-1: Ping command
     */
    public void cmdPing(String host) {
        String command = "ping -c 4 " + host;
        System.out.println("Executing command: " + command);
    }
    
    /**
     * CMD-2: File compression
     */
    public void cmdZip(String filename) {
        String cmd = "zip archive.zip " + filename;
        System.out.println("Command: " + cmd);
    }
    
    /**
     * CMD-3: Process listing
     */
    public void cmdPs(String filter) {
        String command = "ps aux | grep " + filter;
        System.out.println("Process command: " + command);
    }
    
    /**
     * CMD-4: Network tools
     */
    public void cmdNetstat(String options) {
        String cmd = "netstat " + options;
        System.out.println("Netstat: " + cmd);
    }
    
    /**
     * CMD-5: System info
     */
    public void cmdInfo(String param) {
        String command = "systeminfo " + param;
        System.out.println("System command: " + command);
    }
    
    // ============================================================
    // CATEGORY 5: XXE (XML External Entity) (3 variants)
    // ============================================================
    
    /**
     * XXE-1: XML parsing
     */
    public void xxeParse(String xml) {
        System.out.println("Parsing XML: " + xml);
        if (xml.contains("<!ENTITY")) {
            System.out.println("XML contains entity definitions");
        }
    }
    
    /**
     * XXE-2: SOAP request
     */
    public void xxeSoap(String soapBody) {
        System.out.println("Processing SOAP: " + soapBody);
    }
    
    /**
     * XXE-3: XML config
     */
    public void xxeConfig(String xmlConfig) {
        System.out.println("Loading XML config: " + xmlConfig);
    }
    
    // ============================================================
    // CATEGORY 6: SSRF (Server-Side Request Forgery) (4 variants)
    // ============================================================
    
    /**
     * SSRF-1: URL fetch
     */
    public void ssrfFetch(String url) {
        System.out.println("Fetching URL: " + url);
    }
    
    /**
     * SSRF-2: Webhook
     */
    public void ssrfWebhook(String webhookUrl) {
        System.out.println("Calling webhook: " + webhookUrl);
    }
    
    /**
     * SSRF-3: Image proxy
     */
    public void ssrfImage(String imageUrl) {
        System.out.println("Proxying image from: " + imageUrl);
    }
    
    /**
     * SSRF-4: API call
     */
    public void ssrfApi(String apiEndpoint) {
        System.out.println("Calling API: " + apiEndpoint);
    }
    
    // ============================================================
    // CATEGORY 7: LDAP INJECTION (3 variants)
    // ============================================================
    
    /**
     * LDAP-1: User search
     */
    public void ldapSearch(String username) {
        String filter = "(uid=" + username + ")";
        System.out.println("LDAP filter: " + filter);
    }
    
    /**
     * LDAP-2: Authentication
     */
    public void ldapAuth(String user) {
        String ldapQuery = "(&(uid=" + user + ")(objectClass=person))";
        System.out.println("LDAP auth: " + ldapQuery);
    }
    
    /**
     * LDAP-3: Group lookup
     */
    public void ldapGroup(String groupName) {
        String query = "(cn=" + groupName + ")";
        System.out.println("LDAP group query: " + query);
    }
    
    // ============================================================
    // CATEGORY 8: OPEN REDIRECT (3 variants)
    // ============================================================
    
    /**
     * REDIRECT-1: URL redirect
     */
    public void redirectUrl(String targetUrl) {
        System.out.println("Redirecting to: " + targetUrl);
    }
    
    /**
     * REDIRECT-2: Login redirect
     */
    public void redirectLogin(String returnUrl) {
        System.out.println("After login, redirect to: " + returnUrl);
    }
    
    /**
     * REDIRECT-3: OAuth callback
     */
    public void redirectOAuth(String callback) {
        System.out.println("OAuth callback: " + callback);
    }
    
    // ============================================================
    // CATEGORY 9: HARDCODED CREDENTIALS (3 variants)
    // ============================================================
    
    /**
     * CRED-1: Database password
     */
    public void credDatabase() {
        String password = "MySecretPassword123!";
        System.out.println("DB password = " + password);
    }
    
    /**
     * CRED-2: API key
     */
    public void credApiKey() {
        String apiKey = "sk-1234567890abcdef";
        System.out.println("API key = " + apiKey);
    }
    
    /**
     * CRED-3: Secret token
     */
    public void credToken() {
        String secret = "my_secret_token_xyz789";
        System.out.println("Secret token = " + secret);
    }
    
    // ============================================================
    // CATEGORY 10: INFORMATION DISCLOSURE (3 variants)
    // ============================================================
    
    /**
     * INFO-1: Stack trace exposure
     */
    public void infoStackTrace(String input) {
        try {
            int value = Integer.parseInt(input);
            int result = 100 / value;
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
            e.printStackTrace(); // VULNERABLE!
        }
    }
    
    /**
     * INFO-2: Detailed error message
     */
    public void infoError(String data) {
        try {
            processData(data);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getClass().getName());
            System.out.println("Message: " + e.getMessage());
            System.out.println("Cause: " + e.getCause());
        }
    }
    
    /**
     * INFO-3: Debug information
     */
    public void infoDebug(String request) {
        System.out.println("=== DEBUG INFO ===");
        System.out.println("Request: " + request);
        System.out.println("User: admin");
        System.out.println("Session: " + System.currentTimeMillis());
        System.out.println("==================");
    }
    
    // ============================================================
    // CATEGORY 11: INSECURE DESERIALIZATION (2 variants)
    // ============================================================
    
    /**
     * DESER-1: Object deserialization
     */
    public void deserObject(byte[] data) {
        System.out.println("Deserializing object of size: " + data.length);
        if (data.length > 2 && data[0] == (byte)0xAC && data[1] == (byte)0xED) {
            System.out.println("Java serialized object detected!");
        }
    }
    
    /**
     * DESER-2: Session deserialization
     */
    public void deserSession(byte[] sessionData) {
        System.out.println("Loading session from " + sessionData.length + " bytes");
    }
    
    // Helper method
    private void processData(String data) throws Exception {
        if (data == null) {
            throw new NullPointerException("Data cannot be null");
        }
    }
}