package generator;

import scanner.MethodInfo;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Generates fuzz tests with SECURITY DETECTION capabilities
 */
public class SecurityAwareFuzzTestGenerator {

    public static List<String> generateSecurityTests(List<MethodInfo> methods) throws Exception {
        List<String> output = new ArrayList<>();
        
        int index = 0;
        for (MethodInfo mi : methods) {
            // Chỉ test các method có khả năng chứa lỗi bảo mật
            if (isSecurityRelevant(mi)) {
                String className = "SecurityFuzz_" + String.format("%04d", index);
                String fullClassName = generateSingleSecurityTest(mi, className);
                output.add(fullClassName);
                index++;
            }
        }
        
        System.out.println("Generated " + output.size() + " security fuzz tests");
        return output;
    }

    /**
     * Kiểm tra method có liên quan đến security không
     */
    private static boolean isSecurityRelevant(MethodInfo mi) {
        String methodName = mi.methodName.toLowerCase();
        String className = mi.className.toLowerCase();
        
        // SQL-related
        if (methodName.contains("sql") || methodName.contains("query") || 
            methodName.contains("database") || methodName.contains("execute")) {
            return true;
        }
        
        // Output-related (XSS)
        if (methodName.contains("write") || methodName.contains("print") || 
            methodName.contains("output") || methodName.contains("render")) {
            return true;
        }
        
        // File-related (Path Traversal)
        if (methodName.contains("file") || methodName.contains("path") || 
            methodName.contains("read") || methodName.contains("load")) {
            return true;
        }
        
        // Command-related
        if (methodName.contains("command") || methodName.contains("exec") || 
            methodName.contains("process") || methodName.contains("run")) {
            return true;
        }
        
        // Servlet methods (often vulnerable)
        if (methodName.contains("get") || methodName.contains("post") || 
            methodName.contains("doget") || methodName.contains("dopost")) {
            return true;
        }
        
        return false;
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
        sb.append(" * Security-focused fuzz test\n");
        sb.append(" * Target: ").append(mi.className).append(".").append(mi.methodName).append("\n");
        sb.append(" * Params: ").append(mi.paramTypes).append("\n");
        sb.append(" */\n");
        sb.append("public class ").append(className).append(" {\n\n");

        // Security payloads
        sb.append("  // Security test payloads\n");
        sb.append("  private static final String[] SQL_PAYLOADS = {\n");
        sb.append("    \"' OR '1'='1\",\n");
        sb.append("    \"'; DROP TABLE users--\",\n");
        sb.append("    \"1' AND 1=1--\",\n");
        sb.append("    \"admin'--\",\n");
        sb.append("    \"' UNION SELECT * FROM users--\"\n");
        sb.append("  };\n\n");

        sb.append("  private static final String[] XSS_PAYLOADS = {\n");
        sb.append("    \"<script>alert('XSS')</script>\",\n");
        sb.append("    \"<img src=x onerror=alert('XSS')>\",\n");
        sb.append("    \"javascript:alert('XSS')\",\n");
        sb.append("    \"<iframe src='javascript:alert(1)'></iframe>\"\n");
        sb.append("  };\n\n");

        sb.append("  private static final String[] PATH_PAYLOADS = {\n");
        sb.append("    \"../../../etc/passwd\",\n");
        sb.append("    \"..\\\\..\\\\..\\\\windows\\\\system32\",\n");
        sb.append("    \"%2e%2e%2f%2e%2e%2f\",\n");
        sb.append("    \"....//....//\"\n");
        sb.append("  };\n\n");

        sb.append("  private static final String[] CMD_PAYLOADS = {\n");
        sb.append("    \"; ls -la\",\n");
        sb.append("    \"| whoami\",\n");
        sb.append("    \"& dir\",\n");
        sb.append("    \"`cat /etc/passwd`\"\n");
        sb.append("  };\n\n");

        // Output capture
        sb.append("  private static ByteArrayOutputStream capturedOutput;\n");
        sb.append("  private static PrintStream originalOut;\n\n");

        // Fuzzing method
        sb.append("  public static void fuzzerTestOneInput(FuzzedDataProvider data) {\n");
        sb.append("    try {\n");
        
        // Chọn payload type
        sb.append("      // Pick payload type\n");
        sb.append("      int payloadType = data.consumeInt(0, 3);\n");
        sb.append("      String payload;\n");
        sb.append("      \n");
        sb.append("      switch (payloadType) {\n");
        sb.append("        case 0: payload = SQL_PAYLOADS[data.consumeInt(0, SQL_PAYLOADS.length - 1)]; break;\n");
        sb.append("        case 1: payload = XSS_PAYLOADS[data.consumeInt(0, XSS_PAYLOADS.length - 1)]; break;\n");
        sb.append("        case 2: payload = PATH_PAYLOADS[data.consumeInt(0, PATH_PAYLOADS.length - 1)]; break;\n");
        sb.append("        case 3: payload = CMD_PAYLOADS[data.consumeInt(0, CMD_PAYLOADS.length - 1)]; break;\n");
        sb.append("        default: payload = data.consumeString(256);\n");
        sb.append("      }\n\n");

        // Capture output
        sb.append("      // Capture output\n");
        sb.append("      capturedOutput = new ByteArrayOutputStream();\n");
        sb.append("      originalOut = System.out;\n");
        sb.append("      System.setOut(new PrintStream(capturedOutput));\n\n");

        // Load class and invoke method
        sb.append("      // Load target class\n");
        sb.append("      Class<?> cls = Class.forName(\"").append(mi.className).append("\");\n");
        sb.append("      Constructor<?> ctor = cls.getDeclaredConstructor();\n");
        sb.append("      ctor.setAccessible(true);\n");
        sb.append("      Object instance = ctor.newInstance();\n\n");

        // Prepare parameters
        sb.append("      // Prepare parameters\n");
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
                sb.append("      args[").append(i).append("] = payload;\n");
            } else {
                sb.append("      ").append(generateArgumentCode(i, type)).append("\n");
            }
        }

        // Variables để tracking
        sb.append("\n      String sqlQuery = null;\n");
        sb.append("      String filePath = null;\n");
        sb.append("      String command = null;\n\n");

        // Invoke method
        sb.append("      // Invoke method\n");
        sb.append("      Method m = cls.getDeclaredMethod(\"").append(mi.methodName).append("\", paramTypes);\n");
        sb.append("      m.setAccessible(true);\n");
        sb.append("      Object result = m.invoke(instance, args);\n\n");

        // Restore output
        sb.append("      // Restore output\n");
        sb.append("      System.setOut(originalOut);\n");
        sb.append("      String output = capturedOutput.toString();\n\n");

        // Security detection
        sb.append("      // Security Detection\n");
        sb.append("      List<SecurityIssue> issues = new ArrayList<>();\n\n");

        sb.append("      // Try to detect SQL queries in output\n");
        sb.append("      if (output.toLowerCase().contains(\"select\") || \n");
        sb.append("          output.toLowerCase().contains(\"insert\") ||\n");
        sb.append("          output.toLowerCase().contains(\"update\")) {\n");
        sb.append("        sqlQuery = output;\n");
        sb.append("      }\n\n");

        sb.append("      // Detect HTML output\n");
        sb.append("      if (output.contains(\"<html>\") || output.contains(\"<body>\")) {\n");
        sb.append("        SecurityIssue xss = SecurityDetector.detectXSS(output, payload);\n");
        sb.append("        if (xss != null) issues.add(xss);\n");
        sb.append("      }\n\n");

        sb.append("      // Detect SQL injection\n");
        sb.append("      if (sqlQuery != null) {\n");
        sb.append("        SecurityIssue sql = SecurityDetector.detectSQLInjection(sqlQuery, payload);\n");
        sb.append("        if (sql != null) issues.add(sql);\n");
        sb.append("      }\n\n");

        sb.append("      // Report issues\n");
        sb.append("      if (!issues.isEmpty()) {\n");
        sb.append("        System.err.println(\"\\n╔════════════════════════════════════════╗\");\n");
        sb.append("        System.err.println(\"║  SECURITY VULNERABILITY FOUND!         ║\");\n");
        sb.append("        System.err.println(\"╚════════════════════════════════════════╝\");\n");
        sb.append("        System.err.println(\"Method: ").append(mi.className).append(".").append(mi.methodName).append("\");\n");
        sb.append("        System.err.println(\"Payload: \" + payload);\n");
        sb.append("        for (SecurityIssue issue : issues) {\n");
        sb.append("          System.err.println(\"\\n\" + issue);\n");
        sb.append("        }\n");
        sb.append("        System.err.println(\"\\n════════════════════════════════════════\\n\");\n");
        sb.append("        \n");
        sb.append("        // Throw to create crash file\n");
        sb.append("        throw new SecurityException(\"Security vulnerability detected: \" + issues.get(0).type);\n");
        sb.append("      }\n\n");

        // Exception handling
        sb.append("    } catch (InvocationTargetException ite) {\n");
        sb.append("      Throwable cause = ite.getCause();\n");
        sb.append("      if (cause instanceof SecurityException) {\n");
        sb.append("        throw (SecurityException) cause;\n");
        sb.append("      }\n");
        sb.append("      // Ignore other exceptions in security testing\n");
        sb.append("    } catch (SecurityException se) {\n");
        sb.append("      throw se;\n");
        sb.append("    } catch (Throwable t) {\n");
        sb.append("      // Ignore reflection errors\n");
        sb.append("    } finally {\n");
        sb.append("      if (originalOut != null) System.setOut(originalOut);\n");
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
            case "java.lang.String": return "String.class";
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
            default: return "args[" + index + "] = null;";
        }
    }
}