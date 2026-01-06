package generator;

import generator.TypeParser.ParsedType;

/**
 * Generates code to create Collection/Map objects from FuzzedDataProvider
 */
public class CollectionCodeGenerator {
    
    /**
     * Generate code to create a collection/map argument
     * 
     * @param index Argument index
     * @param typeString Type string (e.g., "List<String>", "Map<String,Integer>")
     * @param dataProvider Name of FuzzedDataProvider variable
     * @return Java code string
     */
    public static String generateCode(int index, String typeString, String dataProvider) {
        ParsedType parsed = TypeParser.parse(typeString);
        
        if (!parsed.isGeneric) {
            // Not a collection - use standard generation
            return generateBasicType(index, parsed.rawType, dataProvider);
        }
        
        if (parsed.isCollection) {
            return generateCollection(index, parsed, dataProvider);
        }
        
        if (parsed.isMap) {
            return generateMap(index, parsed, dataProvider);
        }
        
        return "args[" + index + "] = null; // Unsupported type: " + typeString;
    }
    
    /**
     * Generate code for List<String>, ArrayList<Integer>, etc.
     */
    private static String generateCollection(int index, ParsedType parsed, String dataProvider) {
        StringBuilder code = new StringBuilder();
        
        // Create collection instance
        String implType = getCollectionImpl(parsed.rawType);
        code.append("args[").append(index).append("] = new ").append(implType).append("<>();\n");
        
        // Add random number of elements
        code.append("      int size").append(index).append(" = ").append(dataProvider)
            .append(".consumeInt(0, 10); // 0-10 elements\n");
        code.append("      for (int i").append(index).append(" = 0; i").append(index)
            .append(" < size").append(index).append("; i").append(index).append("++) {\n");
        code.append("        ((").append(implType).append(")args[").append(index).append("])")
            .append(".add(").append(generateElement(parsed.genericType1, dataProvider)).append(");\n");
        code.append("      }");
        
        return code.toString();
    }
    
    /**
     * Generate code for Map<String,Integer>, HashMap<String,String>, etc.
     */
    private static String generateMap(int index, ParsedType parsed, String dataProvider) {
        StringBuilder code = new StringBuilder();
        
        // Create map instance
        String implType = getMapImpl(parsed.rawType);
        code.append("args[").append(index).append("] = new ").append(implType).append("<>();\n");
        
        // Add random number of entries
        code.append("      int size").append(index).append(" = ").append(dataProvider)
            .append(".consumeInt(0, 10); // 0-10 entries\n");
        code.append("      for (int i").append(index).append(" = 0; i").append(index)
            .append(" < size").append(index).append("; i").append(index).append("++) {\n");
        
        String keyCode = generateElement(parsed.genericType1, dataProvider);
        String valueCode = generateElement(parsed.genericType2, dataProvider);
        
        code.append("        ((").append(implType).append(")args[").append(index).append("])")
            .append(".put(").append(keyCode).append(", ").append(valueCode).append(");\n");
        code.append("      }");
        
        return code.toString();
    }
    
    /**
     * Generate code to create a single element
     */
    private static String generateElement(String type, String dataProvider) {
        switch (type) {
            case "String":
            case "CharSequence":
                return dataProvider + ".consumeString(50)";
            case "Integer":
                return dataProvider + ".consumeInt()";
            case "Long":
                return dataProvider + ".consumeLong()";
            case "Double":
                return dataProvider + ".consumeDouble()";
            case "Float":
                return dataProvider + ".consumeFloat()";
            case "Boolean":
                return dataProvider + ".consumeBoolean()";
            case "Byte":
                return "(byte)" + dataProvider + ".consumeInt()";
            case "Character":
                return "(char)" + dataProvider + ".consumeInt()";
            default:
                return "null";
        }
    }
    
    /**
     * Get concrete implementation for collection interfaces
     */
    private static String getCollectionImpl(String type) {
        switch (type) {
            case "List":
            case "ArrayList":
                return "ArrayList";
            case "LinkedList":
                return "LinkedList";
            case "Set":
            case "HashSet":
                return "HashSet";
            case "TreeSet":
                return "TreeSet";
            default:
                return "ArrayList"; // Default
        }
    }
    
    /**
     * Get concrete implementation for map interfaces
     */
    private static String getMapImpl(String type) {
        switch (type) {
            case "Map":
            case "HashMap":
                return "HashMap";
            case "TreeMap":
                return "TreeMap";
            case "LinkedHashMap":
                return "LinkedHashMap";
            default:
                return "HashMap"; // Default
        }
    }
    
    /**
     * Generate code for basic (non-collection) types
     */
    private static String generateBasicType(int index, String type, String dataProvider) {
        switch (type) {
            case "String":
            case "CharSequence":
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
                return "args[" + index + "] = (byte)" + dataProvider + ".consumeInt();";
            case "short":
                return "args[" + index + "] = (short)" + dataProvider + ".consumeInt();";
            case "char":
                return "args[" + index + "] = (char)" + dataProvider + ".consumeInt();";
            case "byte[]":
                return "args[" + index + "] = " + dataProvider + ".consumeBytes(2048);";
            default:
                return "args[" + index + "] = null; // Unsupported: " + type;
        }
    }
    
    /**
     * Get class literal for Class.forName()
     */
    public static String getClassLiteral(String typeString) {
        ParsedType parsed = TypeParser.parse(typeString);
        
        if (!parsed.isGeneric) {
            // Primitive or simple type
            switch (parsed.rawType) {
                case "int": return "int.class";
                case "long": return "long.class";
                case "double": return "double.class";
                case "float": return "float.class";
                case "boolean": return "boolean.class";
                case "byte": return "byte.class";
                case "short": return "short.class";
                case "char": return "char.class";
                case "String": return "String.class";
                case "CharSequence": return "CharSequence.class";
                case "byte[]": return "byte[].class";
                default:
                    if (parsed.rawType.contains(".")) {
                        return parsed.rawType + ".class";
                    }
                    return parsed.rawType + ".class";
            }
        }
        
        // Generic type - return interface class
        String fullName = TypeParser.getFullyQualifiedName(parsed);
        if (fullName.startsWith("java.util.")) {
            return fullName.substring("java.util.".length()) + ".class";
        }
        if (fullName.startsWith("java.lang.")) {
            return fullName.substring("java.lang.".length()) + ".class";
        }
        
        return fullName + ".class";
    }
}