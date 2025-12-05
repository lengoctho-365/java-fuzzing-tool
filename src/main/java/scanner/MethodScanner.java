package scanner;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MethodScanner {

    public static List<MethodInfo> scan(File javaFile) throws Exception {
        List<MethodInfo> result = new ArrayList<>();

        FileInputStream fis = new FileInputStream(javaFile);
        CompilationUnit cu = new JavaParser().parse(fis).getResult().orElse(null);
        if (cu == null) return result;

        cu.findAll(ClassOrInterfaceDeclaration.class).forEach(cls -> {
            String className = cls.getNameAsString();

            for (MethodDeclaration method : cls.getMethods()) {

                if (!method.isPublic()) continue;

                String signature = "(" +
                        method.getParameters().toString()
                        + ") : "
                        + (method.getType() == null ? "void" : method.getType().asString());

                // Lấy danh sách paramTypes
                List<String> params = method.getParameters()
                        .stream()
                        .map(p -> p.getType().asString())
                        .collect(Collectors.toList());

                result.add(new MethodInfo(className,
                        method.getNameAsString(),
                        signature,
                        params));
            }
        });

        return result;
    }

    public static List<MethodInfo> scanAll(File folder) throws Exception {
        List<File> files = FileScanner.scanJavaFiles(folder);
        List<MethodInfo> all = new ArrayList<>();

        for (File f : files) {
            try {
                all.addAll(scan(f));
            } catch (Exception ignored) {}
        }

        return all;
    }
}
