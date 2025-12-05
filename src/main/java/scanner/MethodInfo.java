package scanner;

import java.util.List;

public class MethodInfo {
    public final String className;
    public final String methodName;
    public final String signature;
    public final List<String> paramTypes;

    public MethodInfo(String cls, String method, String sig, List<String> params) {
        this.className = cls;
        this.methodName = method;
        this.signature = sig;
        this.paramTypes = params;
    }

    @Override
    public String toString() {
        return className + "." + methodName + paramTypes;
    }
}
