package fuzz;
import com.code_intelligence.jazzer.api.*;
import java.lang.reflect.*;
import java.util.*;
import java.io.*;

/**
 * Target: org.apache.commons.lang3.StringUtils.containsAny
 * Params: [java.lang.CharSequence, java.lang.CharSequence]
 * Enhanced: Supports Collections and Generic Types
 */
public class IndividualFuzz_0022 {

  public static void fuzzerTestOneInput(FuzzedDataProvider data) {
    try {
      Class<?> cls = Class.forName("org.apache.commons.lang3.StringUtils");
      Constructor<?> ctor = cls.getDeclaredConstructor();
      ctor.setAccessible(true);
      Object instance = ctor.newInstance();

      // Parameter types (with generics)
      Class<?>[] paramTypes = new Class<?>[] {CharSequence.class, CharSequence.class};

      // Generate arguments (including collections)
      Object[] args = new Object[2];
      args[0] = data.consumeString(1024);
      args[1] = data.consumeString(1024);

      // Invoke method
      Method m = cls.getDeclaredMethod("containsAny", paramTypes);
      m.setAccessible(true);
      m.invoke(instance, args);

    } catch (InvocationTargetException ite) {
      Throwable cause = ite.getCause();
      if (cause == null) return;
      
      String bugType = cause.getClass().getSimpleName();
      String methodName = "org.apache.commons.lang3.StringUtils.containsAny";
      
      // Log different bug types
      System.err.println("\n=== BUG FOUND ===");
      System.err.println("Type: " + bugType);
      System.err.println("Method: " + methodName);
      System.err.println("Message: " + cause.getMessage());
      System.err.println("================\n");
      
      // Re-throw so Jazzer records the crash
      if (cause instanceof RuntimeException) throw (RuntimeException) cause;
      if (cause instanceof Error) throw (Error) cause;
      throw new RuntimeException(cause);
      
    } catch (NoSuchMethodException e) {
      System.err.println("Method not found: containsAny");
    } catch (InstantiationException | IllegalAccessException e) {
      // Cannot instantiate class - skip silently
    } catch (Throwable t) {
      // Other reflection errors - skip
    }
  }
}
