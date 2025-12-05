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
        int batchSize = 120;

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
        String className = "GeneratedFuzzBatch_" + index;
        File out = new File("src/test/java/fuzz/" + className + ".java");
        out.getParentFile().mkdirs();

        StringBuilder sb = new StringBuilder();
        sb.append("package fuzz;\n\n");
        sb.append("import com.code_intelligence.jazzer.api.*;\n");
        sb.append("import org.springframework.mock.web.*;\n");
        sb.append("import javax.servlet.http.*;\n");
        sb.append("import java.lang.reflect.*;\n\n");

        sb.append("public class ").append(className).append(" {\n\n");
        sb.append(" public static void fuzzerTestOneInput(FuzzedDataProvider data) {\n");

        for (MethodInfo mi : batch) {
            sb.append(generateFuzzLogic(mi));
        }

        sb.append(" }\n");
        sb.append("}\n");

        try (FileWriter fw = new FileWriter(out)) {
            fw.write(sb.toString());
        }

        return "fuzz." + className;
    }

    private static String generateFuzzLogic(MethodInfo mi) {
        String cls = mi.className;
        String method = mi.methodName;

        // 1) Spring Controller (req, res)
        if (mi.paramTypes.size() == 2 &&
                mi.paramTypes.get(0).contains("HttpServletRequest") &&
                mi.paramTypes.get(1).contains("HttpServletResponse")) {

            return String.format(
                    " try {\n" +
                            "   Class<?> c = Class.forName(\"%s\");\n" +
                            "   Object inst = c.getDeclaredConstructor().newInstance();\n" +
                            "   Method m = c.getDeclaredMethod(\"%s\", HttpServletRequest.class, HttpServletResponse.class);\n" +
                            "   MockHttpServletRequest req = new MockHttpServletRequest();\n" +
                            "   MockHttpServletResponse res = new MockHttpServletResponse();\n" +
                            "   req.setParameter(\"input\", data.consumeString(200));\n" +
                            "   m.invoke(inst, req, res);\n" +
                            " } catch (Throwable t) {}\n",
                    cls, method);
        }

        // 2) setter(String)
        if (mi.paramTypes.size() == 1 && mi.paramTypes.get(0).equals("java.lang.String")) {

            return String.format(
                    " try {\n" +
                            "   Class<?> c = Class.forName(\"%s\");\n" +
                            "   Object inst = c.getDeclaredConstructor().newInstance();\n" +
                            "   Method m = c.getDeclaredMethod(\"%s\", String.class);\n" +
                            "   String s = data.consumeString(300);\n" +
                            "   m.invoke(inst, s);\n" +
                            " } catch (Throwable t) {}\n",
                    cls, method);
        }

        // 3) no-arg method
        if (mi.paramTypes.isEmpty()) {

            return String.format(
                    " try {\n" +
                            "   Class<?> c = Class.forName(\"%s\");\n" +
                            "   Object inst = c.getDeclaredConstructor().newInstance();\n" +
                            "   Method m = c.getDeclaredMethod(\"%s\");\n" +
                            "   m.invoke(inst);\n" +
                            " } catch (Throwable t) {}\n",
                    cls, method);
        }

        // 4) unsupported → skip
        return String.format(" // Skipped %s.%s\n", cls, method);
    }
}
