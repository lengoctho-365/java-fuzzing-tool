package generator;

import scanner.MethodInfo;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Enhanced version - supports multiple parameter types and exceptions
 */
public class EnhancedIndividualMethodFuzzer {

    public static List<String> generateIndividualTests(List<MethodInfo> methods) throws Exception {
        List<String> output = new ArrayList<>();
        
        int index = 0;
        for (MethodInfo mi : methods) {
            // Skip if method has too many complex parameters
            if (mi.paramTypes.size() > 5) {
                System.out.println("Skipping " + mi.methodName + " - too many params");
                continue;
            }
            
            String className = "IndividualFuzz_" + String.format("%04d", index);
            String fullClassName = generateSingleMethodTest(mi, className);
            output.add(fullClassName);
            index++;
        }
        
        System.out.println("Generated " + output.size() + " individual fuzz tests");
        return output;
    }

    private static String generateSingleMethodTest(MethodInfo mi, String className) throws Exception {
        File out = new File("src/test/java/fuzz/" + className + ".java");
        out.getParentFile().mkdirs();

        StringBuilder sb = new StringBuilder();
        sb.append("package fuzz;\n");
        sb.append("import com.code_intelligence.jazzer.api.*;\n");
        sb.append("import java.lang.reflect.*;\n");
        sb.append("import java.util.*;\n");
        sb.append("import java.io.*;\n\n");

        sb.append("/**\n");
        sb.append(" * Target: ").append(mi.className).append(".").append(mi.methodName).append("\n");
        sb.append(" * Params: ").append(mi.paramTypes).append("\n");
        sb.append(" */\n");
        sb.append("public class ").append(className).append(" {\n\n");

        sb.append("  public static void fuzzerTestOneInput(FuzzedDataProvider data) {\n");
        sb.append("    try {\n");
        sb.append("      Class<?> cls = Class.forName(\"").append(mi.className).append("\");\n");
        sb.append("      Constructor<?> ctor = cls.getDeclaredConstructor();\n");
        sb.append("      ctor.setAccessible(true);\n");
        sb.append("      Object instance = ctor.newInstance();\n\n");

        // Create parameter types
        sb.append("      // Parameter types\n");
        sb.append("      Class<?>[] paramTypes = new Class<?>[] {");
        for (int i = 0; i < mi.paramTypes.size(); i++) {
            if (i > 0) sb.append(", ");
            String type = mi.paramTypes.get(i);
            sb.append(getClassLiteral(type));
        }
        sb.append("};\n\n");

        // Create arguments
        sb.append("      // Generate arguments\n");
        sb.append("      Object[] args = new Object[").append(mi.paramTypes.size()).append("];\n");
        for (int i = 0; i < mi.paramTypes.size(); i++) {
            String type = mi.paramTypes.get(i);
            sb.append("      ").append(generateArgumentCode(i, type, "data")).append("\n");
        }

        sb.append("\n");
        sb.append("      // Invoke method\n");
        sb.append("      Method m = cls.getDeclaredMethod(\"").append(mi.methodName).append("\", paramTypes);\n");
        sb.append("      m.setAccessible(true);\n");
        sb.append("      m.invoke(instance, args);\n\n");

        // Enhanced exception handling
        sb.append("    } catch (InvocationTargetException ite) {\n");
        sb.append("      Throwable cause = ite.getCause();\n");
        sb.append("      if (cause == null) return;\n");
        sb.append("      \n");
        sb.append("      String bugType = cause.getClass().getSimpleName();\n");
        sb.append("      String methodName = \"").append(mi.className).append(".").append(mi.methodName).append("\";\n");
        sb.append("      \n");
        sb.append("      // Log different bug types\n");
        sb.append("      System.err.println(\"\\n=== BUG FOUND ===\");\n");
        sb.append("      System.err.println(\"Type: \" + bugType);\n");
        sb.append("      System.err.println(\"Method: \" + methodName);\n");
        sb.append("      System.err.println(\"Message: \" + cause.getMessage());\n");
        sb.append("      System.err.println(\"================\\n\");\n");
        sb.append("      \n");
        sb.append("      // Re-throw so Jazzer records the crash\n");
        sb.append("      if (cause instanceof RuntimeException) throw (RuntimeException) cause;\n");
        sb.append("      if (cause instanceof Error) throw (Error) cause;\n");
        sb.append("      throw new RuntimeException(cause);\n");
        sb.append("      \n");
        sb.append("    } catch (NoSuchMethodException e) {\n");
        sb.append("      System.err.println(\"Method not found: ").append(mi.methodName).append("\");\n");
        sb.append("    } catch (InstantiationException | IllegalAccessException e) {\n");
        sb.append("      // Cannot instantiate class - skip silently\n");
        sb.append("    } catch (Throwable t) {\n");
        sb.append("      // Other reflection errors - skip\n");
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
            case "java.lang.Object": return "Object.class";
            default:
                // For other classes
                if (type.startsWith("java.")) {
                    return type.substring(type.lastIndexOf('.') + 1) + ".class";
                }
                return type + ".class";
        }
    }

    private static String generateArgumentCode(int index, String type, String dataProvider) {
        switch (type) {
            case "java.lang.String":
                return "args[" + index + "] = " + dataProvider + ".consumeString(1024);";
            
            case "int":
                return "args[" + index + "] = " + dataProvider + ".consumeInt();";
            
            case "long":
                return "args[" + index + "] = " + dataProvider + ".consumeLong();";
            
            case "double":
                return "args[" + index + "] = " + dataProvider + ".consumeDouble();";
            
            case "float":
                return "args[" + index + "] = " + dataProvider + ".consumeFloat();";
            
            case "boolean":
                return "args[" + index + "] = " + dataProvider + ".consumeBoolean();";
            
            case "byte":
                return "args[" + index + "] = (byte) " + dataProvider + ".consumeInt();";
            
            case "short":
                return "args[" + index + "] = (short) " + dataProvider + ".consumeInt();";
            
            case "char":
                return "args[" + index + "] = (char) " + dataProvider + ".consumeInt();";
            
            case "byte[]":
                return "args[" + index + "] = " + dataProvider + ".consumeBytes(2048);";
            
            case "java.lang.Object":
                // Create random object types
                return "args[" + index + "] = " + dataProvider + ".pickValue(new Object[]{\n" +
                       "        " + dataProvider + ".consumeString(100),\n" +
                       "        " + dataProvider + ".consumeInt(),\n" +
                       "        " + dataProvider + ".consumeBoolean(),\n" +
                       "        null\n" +
                       "      });";
            
            default:
                // Default: null or string
                return "args[" + index + "] = null; // Unsupported type: " + type;
        }
    }
}