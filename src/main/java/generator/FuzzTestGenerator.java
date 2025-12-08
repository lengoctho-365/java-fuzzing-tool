package generator;

import scanner.MethodInfo;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class FuzzTestGenerator {

    public static List<String> generateMultipleClasses(List<MethodInfo> methods) throws Exception {
        List<String> output = new ArrayList<>();
        int index = 0;
        int batchSize = 50;

        List<MethodInfo> batch = new ArrayList<>();

        for (MethodInfo mi : methods) {
            batch.add(mi);
            if (batch.size() >= batchSize) {
                output.add(writeBatchClass(batch, index++));
                batch.clear();
            }
        }

        if (!batch.isEmpty()) {
            output.add(writeBatchClass(batch, index++));
        }

        return output;
    }

    private static String writeBatchClass(List<MethodInfo> batch, int index) throws Exception {
        String className = "GeneratedFuzzTest_" + index;
        File out = new File("src/test/java/fuzz/" + className + ".java");
        out.getParentFile().mkdirs();

        StringBuilder sb = new StringBuilder();
        sb.append("package fuzz;\n");
        sb.append("import com.code_intelligence.jazzer.api.*;\n");
        sb.append("import java.lang.reflect.*;\n");
        sb.append("import java.util.*;\n\n");

        sb.append("public class ").append(className).append(" {\n");
        sb.append("  static class Target { final String c, m; Target(String c, String m) { this.c=c; this.m=m; }}\n");
        
        sb.append("  static Target[] targets = new Target[] {\n");
        for (int i = 0; i < batch.size(); i++) {
            MethodInfo mi = batch.get(i);
            sb.append("    new Target(\"").append(mi.className).append("\", \"").append(mi.methodName).append("\")");
            if (i < batch.size() - 1) sb.append(",");
            sb.append("\n");
        }
        sb.append("  };\n\n");

        sb.append("  public static void fuzzerTestOneInput(FuzzedDataProvider data) {\n");
        sb.append("    if (targets.length == 0) return;\n");
        sb.append("    int idx = Math.floorMod(data.consumeInt(), targets.length);\n");
        sb.append("    Target t = targets[idx];\n");
        sb.append("    Class<?> cls;\n");
        sb.append("    try { cls = Class.forName(t.c, false, Thread.currentThread().getContextClassLoader()); }\n");
        sb.append("    catch (ClassNotFoundException e) {\n");
        sb.append("      if (idx == 0) System.err.println(\"Class not found: \" + t.c + \" - Check classpath!\");\n");
        sb.append("      return;\n");
        sb.append("    }\n");
        sb.append("    catch (Throwable e) { return; }\n");
        
        sb.append("    Object instance = null;\n");
        sb.append("    try {\n");
        sb.append("      Constructor<?> ctor = cls.getDeclaredConstructor();\n");
        sb.append("      if (Modifier.isPublic(ctor.getModifiers())) instance = ctor.newInstance();\n");
        sb.append("    } catch (Throwable ignored) {}\n");
        
        sb.append("    for (Method m : cls.getDeclaredMethods()) {\n");
        sb.append("      if (!m.getName().equals(t.m)) continue;\n");
        
        // THAY ĐỔI: cho phép nhiều parameters hơn
        sb.append("      if (m.getParameterCount() > 5) continue;\n");
        sb.append("      m.setAccessible(true);\n");
        sb.append("      Object[] args = new Object[m.getParameterCount()];\n");
        sb.append("      Class<?>[] types = m.getParameterTypes();\n");
        sb.append("      boolean supported = true;\n");
        sb.append("      for (int i = 0; i < types.length; i++) {\n");
        
        // THÊM: hỗ trợ nhiều kiểu dữ liệu hơn
        sb.append("        if (types[i] == String.class) {\n");
        sb.append("          args[i] = data.consumeString(1024);\n"); // Tăng size
        sb.append("        } else if (types[i] == byte[].class) {\n");
        sb.append("          args[i] = data.consumeBytes(2048);\n");
        sb.append("        } else if (types[i] == int.class) {\n");
        sb.append("          args[i] = data.consumeInt();\n");
        sb.append("        } else if (types[i] == long.class) {\n");
        sb.append("          args[i] = data.consumeLong();\n");
        sb.append("        } else if (types[i] == boolean.class) {\n");
        sb.append("          args[i] = data.consumeBoolean();\n");
        sb.append("        } else if (types[i] == double.class) {\n");
        sb.append("          args[i] = data.consumeDouble();\n");
        sb.append("        } else if (types[i] == float.class) {\n");
        sb.append("          args[i] = data.consumeFloat();\n");
        sb.append("        } else {\n");
        sb.append("          args[i] = null;\n"); // Thử null thay vì skip
        sb.append("        }\n");
        sb.append("      }\n");
        
        // THÊM: timeout protection
        sb.append("      if (!supported) continue;\n");
        sb.append("      long startTime = System.currentTimeMillis();\n");
        sb.append("      try {\n");
        sb.append("        if (Modifier.isStatic(m.getModifiers())) m.invoke(null, args);\n");
        sb.append("        else if (instance != null) m.invoke(instance, args);\n");
        
        // THÊM: detect hangs
        sb.append("        long elapsed = System.currentTimeMillis() - startTime;\n");
        sb.append("        if (elapsed > 5000) {\n");
        sb.append("          System.err.println(\"Method took too long: \" + t.m);\n");
        sb.append("        }\n");
        
        sb.append("      } catch (InvocationTargetException ite) {\n");
        sb.append("        Throwable cause = ite.getCause();\n");
        
        // THÊM: log chi tiết hơn
        sb.append("        if (cause instanceof ArrayIndexOutOfBoundsException) {\n");
        sb.append("          System.err.println(\"FOUND BUG: ArrayIndexOutOfBounds in \" + t.c + \".\" + t.m);\n");
        sb.append("          throw (RuntimeException) cause;\n");
        sb.append("        } else if (cause instanceof NullPointerException) {\n");
        sb.append("          System.err.println(\"FOUND BUG: NullPointer in \" + t.c + \".\" + t.m);\n");
        sb.append("          throw (RuntimeException) cause;\n");
        sb.append("        } else if (cause instanceof ArithmeticException) {\n");
        sb.append("          System.err.println(\"FOUND BUG: Arithmetic in \" + t.c + \".\" + t.m);\n");
        sb.append("          throw (RuntimeException) cause;\n");
        sb.append("        } else if (cause instanceof Error) {\n");
        sb.append("          System.err.println(\"FOUND BUG: Error in \" + t.c + \".\" + t.m);\n");
        sb.append("          throw (Error) cause;\n");
        sb.append("        }\n");
        sb.append("      } catch (Throwable ignored) {}\n");
        sb.append("      break;\n");
        sb.append("    }\n");
        sb.append("  }\n");
        sb.append("}\n");

        try (FileWriter fw = new FileWriter(out)) {
            fw.write(sb.toString());
        }

        System.out.println("Generated: " + className + " with " + batch.size() + " targets");
        return "fuzz." + className;
    }
}