package fuzz;
import com.code_intelligence.jazzer.api.*;
import java.lang.reflect.*;
import java.util.*;

public class GeneratedFuzzTest_0 {
  static class Target { final String c, m; Target(String c, String m) { this.c=c; this.m=m; }}
  static Target[] targets = new Target[] {
    new Target("org.example.ExtendedVulnerableTest", "divisionByZero"),
    new Target("org.example.ExtendedVulnerableTest", "moduloByZero"),
    new Target("org.example.ExtendedVulnerableTest", "arrayIndexError"),
    new Target("org.example.ExtendedVulnerableTest", "arrayIndexFromString"),
    new Target("org.example.ExtendedVulnerableTest", "negativeArraySize"),
    new Target("org.example.ExtendedVulnerableTest", "nullPointerBasic"),
    new Target("org.example.ExtendedVulnerableTest", "nullPointerArray"),
    new Target("org.example.ExtendedVulnerableTest", "nullPointerInLoop"),
    new Target("org.example.ExtendedVulnerableTest", "stringIndexOutOfBounds"),
    new Target("org.example.ExtendedVulnerableTest", "substringError"),
    new Target("org.example.ExtendedVulnerableTest", "emptyStringSplit"),
    new Target("org.example.ExtendedVulnerableTest", "parseIntError"),
    new Target("org.example.ExtendedVulnerableTest", "parseLongError"),
    new Target("org.example.ExtendedVulnerableTest", "parseDoubleError"),
    new Target("org.example.ExtendedVulnerableTest", "listIndexError"),
    new Target("org.example.ExtendedVulnerableTest", "emptyListAccess"),
    new Target("org.example.ExtendedVulnerableTest", "mapKeyError"),
    new Target("org.example.ExtendedVulnerableTest", "infiniteRecursion"),
    new Target("org.example.ExtendedVulnerableTest", "recursionWithString"),
    new Target("org.example.ExtendedVulnerableTest", "assertionFail"),
    new Target("org.example.ExtendedVulnerableTest", "assertionWithString"),
    new Target("org.example.ExtendedVulnerableTest", "classCastError"),
    new Target("org.example.ExtendedVulnerableTest", "numberCastError"),
    new Target("org.example.ExtendedVulnerableTest", "illegalArgumentNegative"),
    new Target("org.example.ExtendedVulnerableTest", "illegalArgumentString"),
    new Target("org.example.ExtendedVulnerableTest", "concurrentModification"),
    new Target("org.example.ExtendedVulnerableTest", "fileNotFound"),
    new Target("org.example.ExtendedVulnerableTest", "readInvalidFile"),
    new Target("org.example.ExtendedVulnerableTest", "regexPatternError"),
    new Target("org.example.ExtendedVulnerableTest", "regexMatchError"),
    new Target("org.example.ExtendedVulnerableTest", "sqrtNegative"),
    new Target("org.example.ExtendedVulnerableTest", "logZero"),
    new Target("org.example.ExtendedVulnerableTest", "bufferOverflow"),
    new Target("org.example.ExtendedVulnerableTest", "complexCondition"),
    new Target("org.example.ExtendedVulnerableTest", "nestedConditions"),
    new Target("org.example.ExtendedVulnerableTest", "multipleChecks"),
    new Target("org.example.Test", "doSomething"),
    new Target("org.example.Test", "doSomething"),
    new Target("org.example.Test", "processData")
  };

  public static void fuzzerTestOneInput(FuzzedDataProvider data) {
    if (targets.length == 0) return;
    int idx = Math.floorMod(data.consumeInt(), targets.length);
    Target t = targets[idx];
    Class<?> cls;
    try { cls = Class.forName(t.c, false, Thread.currentThread().getContextClassLoader()); }
    catch (ClassNotFoundException e) {
      if (idx == 0) System.err.println("Class not found: " + t.c + " - Check classpath!");
      return;
    }
    catch (Throwable e) { return; }
    Object instance = null;
    try {
      Constructor<?> ctor = cls.getDeclaredConstructor();
      if (Modifier.isPublic(ctor.getModifiers())) instance = ctor.newInstance();
    } catch (Throwable ignored) {}
    for (Method m : cls.getDeclaredMethods()) {
      if (!m.getName().equals(t.m)) continue;
      if (m.getParameterCount() > 5) continue;
      m.setAccessible(true);
      Object[] args = new Object[m.getParameterCount()];
      Class<?>[] types = m.getParameterTypes();
      boolean supported = true;
      for (int i = 0; i < types.length; i++) {
        if (types[i] == String.class) {
          args[i] = data.consumeString(1024);
        } else if (types[i] == byte[].class) {
          args[i] = data.consumeBytes(2048);
        } else if (types[i] == int.class) {
          args[i] = data.consumeInt();
        } else if (types[i] == long.class) {
          args[i] = data.consumeLong();
        } else if (types[i] == boolean.class) {
          args[i] = data.consumeBoolean();
        } else if (types[i] == double.class) {
          args[i] = data.consumeDouble();
        } else if (types[i] == float.class) {
          args[i] = data.consumeFloat();
        } else {
          args[i] = null;
        }
      }
      if (!supported) continue;
      long startTime = System.currentTimeMillis();
      try {
        if (Modifier.isStatic(m.getModifiers())) m.invoke(null, args);
        else if (instance != null) m.invoke(instance, args);
        long elapsed = System.currentTimeMillis() - startTime;
        if (elapsed > 5000) {
          System.err.println("Method took too long: " + t.m);
        }
      } catch (InvocationTargetException ite) {
        Throwable cause = ite.getCause();
        if (cause instanceof ArrayIndexOutOfBoundsException) {
          System.err.println("FOUND BUG: ArrayIndexOutOfBounds in " + t.c + "." + t.m);
          throw (RuntimeException) cause;
        } else if (cause instanceof NullPointerException) {
          System.err.println("FOUND BUG: NullPointer in " + t.c + "." + t.m);
          throw (RuntimeException) cause;
        } else if (cause instanceof ArithmeticException) {
          System.err.println("FOUND BUG: Arithmetic in " + t.c + "." + t.m);
          throw (RuntimeException) cause;
        } else if (cause instanceof Error) {
          System.err.println("FOUND BUG: Error in " + t.c + "." + t.m);
          throw (Error) cause;
        }
      } catch (Throwable ignored) {}
      break;
    }
  }
}
