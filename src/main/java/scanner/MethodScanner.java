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

        // Lay package name
        String packageName = cu.getPackageDeclaration()
                .map(pd -> pd.getNameAsString())
                .orElse("");

        cu.findAll(ClassOrInterfaceDeclaration.class).forEach(cls -> {
            String className = cls.getNameAsString();
            
            // Tao full qualified class name
            String fullClassName = packageName.isEmpty() 
                ? className 
                : packageName + "." + className;

            for (MethodDeclaration method : cls.getMethods()) {

                if (!method.isPublic()) continue;

                String signature = "(" +
                        method.getParameters().toString()
                        + ") : "
                        + (method.getType() == null ? "void" : method.getType().asString());

                // Lay danh sach paramTypes voi FULL QUALIFIED NAME
                List<String> params = method.getParameters()
                        .stream()
                        .map(p -> {
                            String type = p.getType().asString();
                            return convertToFullyQualified(type, packageName);
                        })
                        .collect(Collectors.toList());

                result.add(new MethodInfo(
                        fullClassName,
                        method.getNameAsString(),
                        signature,
                        params));
            }
        });

        return result;
    }

    private static String convertToFullyQualified(String type, String currentPackage) {
        // Xu ly primitive types
        if (type.equals("int") || type.equals("boolean") || type.equals("long") 
            || type.equals("double") || type.equals("float") || type.equals("byte")
            || type.equals("short") || type.equals("char")) {
            return type;
        }
        
        // Neu da la fully qualified (co dau .)
        if (type.contains(".")) {
            return type;
        }
        
        // Common types
        if (type.equals("String")) return "java.lang.String";
        if (type.contains("HttpServletRequest")) return "javax.servlet.http.HttpServletRequest";
        if (type.contains("HttpServletResponse")) return "javax.servlet.http.HttpServletResponse";
        
        // Neu khong ro, tra ve type goc
        return type;
    }

    public static List<MethodInfo> scanAll(File folder) throws Exception {
        List<File> files = FileScanner.scanJavaFiles(folder);
        List<MethodInfo> all = new ArrayList<>();

        for (File f : files) {
            try {
                all.addAll(scan(f));
            } catch (Exception e) {
                System.err.println("Error scanning " + f.getName() + ": " + e.getMessage());
            }
        }

        return all;
    }
}
