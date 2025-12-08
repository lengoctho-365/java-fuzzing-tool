import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Crash_be03437a02dde772a9de2d24b8f5bd5f7f4fc9f2 {
    static final String base64Bytes = String.join("", "rO0ABXNyABNqYXZhLnV0aWwuQXJyYXlMaXN0eIHSHZnHYZ0DAAFJAARzaXpleHAAAAABdwQAAAABdAATCsCAwIDAgMCAwIDAgMCAwIDAgHg=");

    public static void main(String[] args) throws Throwable {
        Crash_be03437a02dde772a9de2d24b8f5bd5f7f4fc9f2.class.getClassLoader().setDefaultAssertionStatus(true);
        try {
            Method fuzzerInitialize = fuzz.IndividualFuzz_0003.class.getMethod("fuzzerInitialize");
            fuzzerInitialize.invoke(null);
        } catch (NoSuchMethodException ignored) {
            try {
                Method fuzzerInitialize = fuzz.IndividualFuzz_0003.class.getMethod("fuzzerInitialize", String[].class);
                fuzzerInitialize.invoke(null, (Object) args);
            } catch (NoSuchMethodException ignored1) {
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
                System.exit(1);
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            System.exit(1);
        }
        com.code_intelligence.jazzer.api.CannedFuzzedDataProvider input = new com.code_intelligence.jazzer.api.CannedFuzzedDataProvider(base64Bytes);
        fuzz.IndividualFuzz_0003.fuzzerTestOneInput(input);
    }
}