import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Crash_adc83b19e793491b1c6ea0fd8b46cd9f32e592fc {
    static final String base64Bytes = String.join("", "rO0ABXNyABNqYXZhLnV0aWwuQXJyYXlMaXN0eIHSHZnHYZ0DAAFJAARzaXpleHAAAAABdwQAAAABc3IAEGphdmEubGFuZy5Eb3VibGWAs8JKKWv7BAIAAUQABXZhbHVleHIAEGphdmEubGFuZy5OdW1iZXKGrJUdC5TgiwIAAHhw/+////////94");

    public static void main(String[] args) throws Throwable {
        Crash_adc83b19e793491b1c6ea0fd8b46cd9f32e592fc.class.getClassLoader().setDefaultAssertionStatus(true);
        try {
            Method fuzzerInitialize = fuzz.IndividualFuzz_0030.class.getMethod("fuzzerInitialize");
            fuzzerInitialize.invoke(null);
        } catch (NoSuchMethodException ignored) {
            try {
                Method fuzzerInitialize = fuzz.IndividualFuzz_0030.class.getMethod("fuzzerInitialize", String[].class);
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
        fuzz.IndividualFuzz_0030.fuzzerTestOneInput(input);
    }
}