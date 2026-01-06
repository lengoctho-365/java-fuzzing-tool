package scanner;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.type.Type;
import com.github.javaparser.ast.type.ClassOrInterfaceType;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Enhanced MethodScanner with Generic Type Support
 * Now supports: List<String>, Map<String,Integer>, etc.
 */
public class MethodScanner {

    public static List<MethodInfo> scan(File javaFile) throws Exception {
        List<MethodInfo> result = new ArrayList<>();

        FileInputStream fis = new FileInputStream(javaFile);
        CompilationUnit cu = new JavaParser().parse(fis).getResult().orElse(null);
        if (cu == null) return result;

        // Get package name
        String packageName = cu.getPackageDeclaration()
                .map(pd -> pd.getNameAsString())
                .orElse("");

        cu.findAll(ClassOrInterfaceDeclaration.class).forEach(cls -> {
            String className = cls.getNameAsString();
            
            // Create full qualified class name
            String fullClassName = packageName.isEmpty() 
                ? className 
                : packageName + "." + className;

            for (MethodDeclaration method : cls.getMethods()) {

                if (!method.isPublic()) continue;

                String signature = "(" +
                        method.getParameters().toString()
                        + ") : "
                        + (method.getType() == null ? "void" : method.getType().asString());

                // Get parameter types with FULL GENERIC SUPPORT
                List<String> params = method.getParameters()
                        .stream()
                        .map(p -> {
                            Type type = p.getType();
                            String typeString = extractFullTypeString(type);
                            return convertToFullyQualified(typeString, packageName);
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
    
    /**
     * Extract full type string including generics
     * Examples:
     *   - List<String> -> List<String>
     *   - Map<String,Integer> -> Map<String,Integer>
     *   - ArrayList<String> -> ArrayList<String>
     */
    private static String extractFullTypeString(Type type) {
        if (type.isClassOrInterfaceType()) {
            ClassOrInterfaceType classType = type.asClassOrInterfaceType();
            String baseName = classType.getNameAsString();
            
            // Check for generic type arguments
            if (classType.getTypeArguments().isPresent()) {
                List<Type> typeArgs = classType.getTypeArguments().get();
                
                // Build generic type string
                StringBuilder sb = new StringBuilder(baseName);
                sb.append("<");
                
                for (int i = 0; i < typeArgs.size(); i++) {
                    if (i > 0) sb.append(",");
                    
                    Type arg = typeArgs.get(i);
                    if (arg.isClassOrInterfaceType()) {
                        sb.append(arg.asClassOrInterfaceType().getNameAsString());
                    } else {
                        sb.append(arg.asString());
                    }
                }
                
                sb.append(">");
                return sb.toString();
            }
            
            return baseName;
        }
        
        // Primitive or other types
        return type.asString();
    }

    private static String convertToFullyQualified(String type, String currentPackage) {
        // Handle primitive types
        if (type.equals("int") || type.equals("boolean") || type.equals("long") 
            || type.equals("double") || type.equals("float") || type.equals("byte")
            || type.equals("short") || type.equals("char")) {
            return type;
        }
        
        // If already fully qualified (contains .)
        if (type.contains(".")) {
            return type;
        }
        
        // Handle generic types: List<String> -> java.util.List<java.lang.String>
        if (type.contains("<")) {
            return qualifyGenericType(type);
        }
        
        // Common types
        if (type.equals("String")) return "java.lang.String";
        if (type.equals("CharSequence")) return "java.lang.CharSequence";
        if (type.contains("HttpServletRequest")) return "javax.servlet.http.HttpServletRequest";
        if (type.contains("HttpServletResponse")) return "javax.servlet.http.HttpServletResponse";
        
        // Common collection types
        if (type.equals("List") || type.equals("ArrayList") || 
            type.equals("LinkedList") || type.equals("Set") || 
            type.equals("HashSet") || type.equals("TreeSet") ||
            type.equals("Map") || type.equals("HashMap") || 
            type.equals("TreeMap") || type.equals("LinkedHashMap")) {
            return "java.util." + type;
        }
        
        // If unknown, return as-is
        return type;
    }
    
    /**
     * Qualify generic types
     * Example: List<String> -> java.util.List<java.lang.String>
     */
    private static String qualifyGenericType(String type) {
        // Extract base type and generic args
        int bracketIdx = type.indexOf('<');
        if (bracketIdx == -1) return type;
        
        String baseType = type.substring(0, bracketIdx);
        String genericPart = type.substring(bracketIdx + 1, type.length() - 1);
        
        // Qualify base type
        String qualifiedBase = qualifySimpleType(baseType);
        
        // Qualify generic arguments
        String[] args = genericPart.split(",");
        StringBuilder qualifiedArgs = new StringBuilder();
        
        for (int i = 0; i < args.length; i++) {
            if (i > 0) qualifiedArgs.append(",");
            qualifiedArgs.append(qualifySimpleType(args[i].trim()));
        }
        
        return qualifiedBase + "<" + qualifiedArgs.toString() + ">";
    }
    
    /**
     * Qualify a simple (non-generic) type name
     */
    private static String qualifySimpleType(String type) {
        // Primitives
        if (type.equals("int") || type.equals("long") || type.equals("double") || 
            type.equals("float") || type.equals("boolean") || type.equals("byte") ||
            type.equals("short") || type.equals("char")) {
            return type;
        }
        
        // Already qualified
        if (type.contains(".")) return type;
        
        // java.lang types
        if (type.equals("String") || type.equals("Integer") || type.equals("Long") ||
            type.equals("Double") || type.equals("Float") || type.equals("Boolean") ||
            type.equals("Byte") || type.equals("Character") || type.equals("Object") ||
            type.equals("CharSequence")) {
            return "java.lang." + type;
        }
        
        // java.util types
        if (type.equals("List") || type.equals("ArrayList") || type.equals("LinkedList") ||
            type.equals("Set") || type.equals("HashSet") || type.equals("TreeSet") ||
            type.equals("Map") || type.equals("HashMap") || type.equals("TreeMap") ||
            type.equals("LinkedHashMap")) {
            return "java.util." + type;
        }
        
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