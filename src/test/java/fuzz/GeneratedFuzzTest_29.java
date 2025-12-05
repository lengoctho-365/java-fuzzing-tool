package fuzz;
import com.code_intelligence.jazzer.api.*;
import java.lang.reflect.*;
import java.util.*;

public class GeneratedFuzzTest_29 {
  static class Target { final String c, m; Target(String c, String m) { this.c=c; this.m=m; }}
  static Target[] targets = new Target[] {
    new Target("BenchmarkTest01427", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01428", "doGet"),
    new Target("BenchmarkTest01428", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01429", "doGet"),
    new Target("BenchmarkTest01429", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01430", "doGet"),
    new Target("BenchmarkTest01430", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01431", "doGet"),
    new Target("BenchmarkTest01431", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01432", "doGet"),
    new Target("BenchmarkTest01432", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01433", "doGet"),
    new Target("BenchmarkTest01433", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01434", "doGet"),
    new Target("BenchmarkTest01434", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01435", "doGet"),
    new Target("BenchmarkTest01435", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01436", "doGet"),
    new Target("BenchmarkTest01436", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01437", "doGet"),
    new Target("BenchmarkTest01437", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01438", "doGet"),
    new Target("BenchmarkTest01438", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01439", "doGet"),
    new Target("BenchmarkTest01439", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01440", "doGet"),
    new Target("BenchmarkTest01440", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01441", "doGet"),
    new Target("BenchmarkTest01441", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01442", "doGet"),
    new Target("BenchmarkTest01442", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01443", "doGet"),
    new Target("BenchmarkTest01443", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01444", "doGet"),
    new Target("BenchmarkTest01444", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01445", "doGet"),
    new Target("BenchmarkTest01445", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01446", "doGet"),
    new Target("BenchmarkTest01446", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01447", "doGet"),
    new Target("BenchmarkTest01447", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01448", "doGet"),
    new Target("BenchmarkTest01448", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01449", "doGet"),
    new Target("BenchmarkTest01449", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01450", "doGet"),
    new Target("BenchmarkTest01450", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01451", "doGet"),
    new Target("BenchmarkTest01451", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01452", "doGet"),
    new Target("BenchmarkTest01452", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01453", "doGet"),
    new Target("BenchmarkTest01453", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01454", "doGet"),
    new Target("BenchmarkTest01454", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01455", "doGet"),
    new Target("BenchmarkTest01455", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01456", "doGet"),
    new Target("BenchmarkTest01456", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01457", "doGet"),
    new Target("BenchmarkTest01457", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01458", "doGet"),
    new Target("BenchmarkTest01458", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01459", "doGet"),
    new Target("BenchmarkTest01459", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01460", "doGet"),
    new Target("BenchmarkTest01460", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01461", "doGet"),
    new Target("BenchmarkTest01461", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01462", "doGet"),
    new Target("BenchmarkTest01462", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01463", "doGet"),
    new Target("BenchmarkTest01463", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01464", "doGet"),
    new Target("BenchmarkTest01464", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01465", "doGet"),
    new Target("BenchmarkTest01465", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01466", "doGet"),
    new Target("BenchmarkTest01466", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01467", "doGet"),
  };

  public static void fuzzerTestOneInput(FuzzedDataProvider data) {
    if (targets.length == 0) return;
    int idx = Math.floorMod(data.consumeInt(), targets.length);
    Target t = targets[idx];
    Class<?> cls;
    try { cls = Class.forName(t.c, false, Thread.currentThread().getContextClassLoader()); }
    catch (Throwable e) { return; }
    Object instance = null;
    try {
      Constructor<?> ctor = cls.getDeclaredConstructor();
      if (Modifier.isPublic(ctor.getModifiers())) instance = ctor.newInstance();
    } catch (Throwable ignored) {}
    for (Method m : cls.getDeclaredMethods()) {
      if (!m.getName().equals(t.m)) continue;
      if (m.getParameterCount() > 2) continue;
      m.setAccessible(true);
      Object[] args = new Object[m.getParameterCount()];
      Class<?>[] types = m.getParameterTypes();
      boolean supported = true;
      for (int i = 0; i < types.length; i++) {
        if (types[i] == String.class) args[i] = data.consumeString(256);
        else if (types[i] == byte[].class) args[i] = data.consumeBytes(512);
        else if (types[i] == int.class) args[i] = data.consumeInt();
        else { supported = false; break; }
      }
      if (!supported) continue;
      try {
        if (Modifier.isStatic(m.getModifiers())) m.invoke(null, args);
        else if (instance != null) m.invoke(instance, args);
      } catch (InvocationTargetException ite) {
        Throwable cause = ite.getCause();
        if (cause instanceof Error) throw (Error) cause;
      } catch (Throwable ignored) {}
      break;
    }
  }
}
