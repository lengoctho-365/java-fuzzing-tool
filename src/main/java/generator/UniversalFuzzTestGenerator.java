package generator;

import scanner.MethodInfo;
import registry.MethodInfoRegistry;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

public class UniversalFuzzTestGenerator {

    public static String generateUniversalFuzzer(List<MethodInfo> methods) throws Exception {

        MethodInfoRegistry.setMethods(methods);

        String className = "GeneratedUniversalFuzzTest";
        File out = new File("src/test/java/fuzz/" + className + ".java");
        out.getParentFile().mkdirs();

        StringBuilder sb = new StringBuilder();

        sb.append("package fuzz;\n");
        sb.append("import com.code_intelligence.jazzer.api.*;\n");
        sb.append("import org.springframework.mock.web.*;\n");
        sb.append("import registry.MethodInfoRegistry;\n");
        sb.append("import scanner.MethodInfo;\n");
        sb.append("import java.lang.reflect.*;\n\n");

        sb.append("public class ").append(className).append(" {\n\n");
        sb.append(" public static void fuzzerTestOneInput(FuzzedDataProvider data) {\n");
        sb.append("   try {\n");
        sb.append("     String inputStr = data.consumeString(200);\n");
        sb.append("     int inputInt = data.consumeInt();\n");
        sb.append("     MockHttpServletRequest req = new MockHttpServletRequest();\n");
        sb.append("     MockHttpServletResponse res = new MockHttpServletResponse();\n");
        sb.append("     req.setParameter(\"input\", inputStr);\n\n");

        sb.append("     for (MethodInfo mi : MethodInfoRegistry.methods) {\n");
        sb.append("       try {\n");
        sb.append("         Class<?> cls = Class.forName(mi.className);\n");
        sb.append("         Object instance = cls.getDeclaredConstructor().newInstance();\n");
        sb.append("         Class<?>[] params = new Class<?>[mi.paramTypes.size()];\n");
        sb.append("         for (int i = 0; i < mi.paramTypes.size(); i++) {\n");
        sb.append("             params[i] = Class.forName(mi.paramTypes.get(i));\n");
        sb.append("         }\n");
        sb.append("         Method m = cls.getDeclaredMethod(mi.methodName, params);\n");
        sb.append("         m.setAccessible(true);\n\n");

        sb.append("         Object[] args = new Object[params.length];\n");
        sb.append("         for (int i = 0; i < params.length; i++) {\n");
        sb.append("             String p = params[i].getName();\n");
        sb.append("             if (p.equals(\"java.lang.String\")) args[i] = inputStr;\n");
        sb.append("             else if (p.equals(\"int\")) args[i] = inputInt;\n");
        sb.append("             else if (p.contains(\"HttpServletRequest\")) args[i] = req;\n");
        sb.append("             else if (p.contains(\"HttpServletResponse\")) args[i] = res;\n");
        sb.append("             else args[i] = null;\n");
        sb.append("         }\n");

        sb.append("         m.invoke(instance, args);\n");
        sb.append("       } catch (Throwable ignored) {}\n");
        sb.append("     }\n");

        sb.append("   } catch (Exception ignored) {}\n");
        sb.append(" }\n");
        sb.append("}\n");

        try (FileWriter fw = new FileWriter(out)) {
            fw.write(sb.toString());
        }

        return "fuzz." + className;
    }
}
