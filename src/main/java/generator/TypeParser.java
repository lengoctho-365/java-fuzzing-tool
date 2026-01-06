package generator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Parser for Java types including generics
 * Supports: List<String>, ArrayList<Integer>, Map<String,Integer>, etc.
 */
public class TypeParser {
    
    public static class ParsedType {
        public String rawType;           // e.g., "List", "ArrayList", "Map"
        public String genericType1;      // e.g., "String" from List<String>
        public String genericType2;      // e.g., "Integer" from Map<String,Integer>
        public boolean isGeneric;
        public boolean isCollection;
        public boolean isMap;
        
        public ParsedType(String rawType) {
            this.rawType = rawType;
            this.isGeneric = false;
            this.isCollection = false;
            this.isMap = false;
        }
        
        @Override
        public String toString() {
            if (!isGeneric) return rawType;
            if (isMap) return rawType + "<" + genericType1 + "," + genericType2 + ">";
            return rawType + "<" + genericType1 + ">";
        }
    }
    
    // Pattern for generic types: List<String>, Map<String,Integer>, etc.
    private static final Pattern GENERIC_PATTERN = 
        Pattern.compile("([A-Za-z\\.]+)<([A-Za-z\\.]+)(?:,\\s*([A-Za-z\\.]+))?>");
    
    /**
     * Parse type string to extract raw type and generic parameters
     */
    public static ParsedType parse(String typeString) {
        if (typeString == null || typeString.isEmpty()) {
            return new ParsedType("Object");
        }
        
        // Remove java.util. prefix for simplicity
        typeString = typeString.replace("java.util.", "");
        typeString = typeString.replace("java.lang.", "");
        
        // Check if generic type
        Matcher matcher = GENERIC_PATTERN.matcher(typeString);
        
        if (matcher.find()) {
            ParsedType result = new ParsedType(matcher.group(1));
            result.isGeneric = true;
            result.genericType1 = matcher.group(2);
            result.genericType2 = matcher.group(3); // null if not Map
            
            // Classify type
            String raw = result.rawType;
            if (raw.equals("List") || raw.equals("ArrayList") || 
                raw.equals("LinkedList") || raw.equals("Set") || 
                raw.equals("HashSet") || raw.equals("TreeSet")) {
                result.isCollection = true;
            } else if (raw.equals("Map") || raw.equals("HashMap") || 
                       raw.equals("TreeMap") || raw.equals("LinkedHashMap")) {
                result.isMap = true;
            }
            
            return result;
        }
        
        // Not generic - return as-is
        return new ParsedType(typeString);
    }
    
    /**
     * Check if type is supported for fuzzing
     */
    public static boolean isSupported(String typeString) {
        ParsedType parsed = parse(typeString);
        
        // Primitive types
        if (isPrimitive(parsed.rawType)) return true;
        
        // Basic types
        if (parsed.rawType.equals("String") || 
            parsed.rawType.equals("Object") || 
            parsed.rawType.equals("CharSequence") ||
            parsed.rawType.equals("byte[]")) {
            return true;
        }
        
        // Collections with supported generic types
        if (parsed.isCollection) {
            return isSupportedGenericType(parsed.genericType1);
        }
        
        // Maps with supported key/value types
        if (parsed.isMap) {
            return isSupportedGenericType(parsed.genericType1) && 
                   isSupportedGenericType(parsed.genericType2);
        }
        
        return false;
    }
    
    private static boolean isPrimitive(String type) {
        return type.equals("int") || type.equals("long") || 
               type.equals("double") || type.equals("float") || 
               type.equals("boolean") || type.equals("byte") || 
               type.equals("short") || type.equals("char");
    }
    
    private static boolean isSupportedGenericType(String type) {
        if (type == null) return false;
        return type.equals("String") || type.equals("Integer") || 
               type.equals("Long") || type.equals("Double") || 
               type.equals("Boolean") || type.equals("Float") ||
               type.equals("Byte") || type.equals("Character") ||
               type.equals("CharSequence") || type.equals("Object");
    }
    
    /**
     * Get fully qualified class name
     */
    public static String getFullyQualifiedName(ParsedType parsed) {
        String raw = parsed.rawType;
        
        // Already qualified
        if (raw.contains(".")) return raw;
        
        // Common java.util types
        if (raw.equals("List") || raw.equals("ArrayList") || 
            raw.equals("LinkedList") || raw.equals("Set") || 
            raw.equals("HashSet") || raw.equals("TreeSet") ||
            raw.equals("Map") || raw.equals("HashMap") || 
            raw.equals("TreeMap") || raw.equals("LinkedHashMap")) {
            return "java.util." + raw;
        }
        
        // Common java.lang types
        if (raw.equals("String") || raw.equals("Integer") || 
            raw.equals("Long") || raw.equals("Double") || 
            raw.equals("Boolean") || raw.equals("Float") ||
            raw.equals("Byte") || raw.equals("Character") ||
            raw.equals("Object")) {
            return "java.lang." + raw;
        }
        
        return raw;
    }
}