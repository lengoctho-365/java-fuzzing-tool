package fuzz;
import com.code_intelligence.jazzer.api.*;
import java.lang.reflect.*;
import java.util.*;

public class GeneratedFuzzTest_25 {
  static class Target { final String c, m; Target(String c, String m) { this.c=c; this.m=m; }}
  static Target[] targets = new Target[] {
    new Target("BenchmarkTest01267", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01268", "doGet"),
    new Target("BenchmarkTest01268", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01269", "doGet"),
    new Target("BenchmarkTest01269", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01270", "doGet"),
    new Target("BenchmarkTest01270", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01271", "doGet"),
    new Target("BenchmarkTest01271", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01272", "doGet"),
    new Target("BenchmarkTest01272", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01273", "doGet"),
    new Target("BenchmarkTest01273", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01274", "doGet"),
    new Target("BenchmarkTest01274", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01275", "doGet"),
    new Target("BenchmarkTest01275", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01276", "doGet"),
    new Target("BenchmarkTest01276", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01277", "doGet"),
    new Target("BenchmarkTest01277", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01278", "doGet"),
    new Target("BenchmarkTest01278", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01279", "doGet"),
    new Target("BenchmarkTest01279", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01280", "doGet"),
    new Target("BenchmarkTest01280", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01281", "doGet"),
    new Target("BenchmarkTest01281", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01282", "doGet"),
    new Target("BenchmarkTest01282", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01283", "doGet"),
    new Target("BenchmarkTest01283", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01284", "doGet"),
    new Target("BenchmarkTest01284", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01285", "doGet"),
    new Target("BenchmarkTest01285", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01286", "doGet"),
    new Target("BenchmarkTest01286", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01287", "doGet"),
    new Target("BenchmarkTest01287", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01288", "doGet"),
    new Target("BenchmarkTest01288", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01289", "doGet"),
    new Target("BenchmarkTest01289", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01290", "doGet"),
    new Target("BenchmarkTest01290", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01291", "doGet"),
    new Target("BenchmarkTest01291", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01292", "doGet"),
    new Target("BenchmarkTest01292", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01293", "doGet"),
    new Target("BenchmarkTest01293", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01294", "doGet"),
    new Target("BenchmarkTest01294", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01295", "doGet"),
    new Target("BenchmarkTest01295", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01296", "doGet"),
    new Target("BenchmarkTest01296", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01297", "doGet"),
    new Target("BenchmarkTest01297", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01298", "doGet"),
    new Target("BenchmarkTest01298", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01299", "doGet"),
    new Target("BenchmarkTest01299", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01300", "doGet"),
    new Target("BenchmarkTest01300", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01301", "doGet"),
    new Target("BenchmarkTest01301", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01302", "doGet"),
    new Target("BenchmarkTest01302", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01303", "doGet"),
    new Target("BenchmarkTest01303", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01304", "doGet"),
    new Target("BenchmarkTest01304", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01305", "doGet"),
    new Target("BenchmarkTest01305", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01306", "doGet"),
    new Target("BenchmarkTest01306", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01307", "doGet"),
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
