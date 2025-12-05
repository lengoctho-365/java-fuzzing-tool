package registry;

import scanner.MethodInfo;
import java.util.List;

public class MethodInfoRegistry {
    public static List<MethodInfo> methods;

    public static void setMethods(List<MethodInfo> list) {
        methods = list;
    }
}
