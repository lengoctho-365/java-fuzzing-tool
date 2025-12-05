package fuzz;
import com.code_intelligence.jazzer.api.*;
import java.lang.reflect.*;
import java.util.*;

public class GeneratedFuzzTest_24 {
  static class Target { final String c, m; Target(String c, String m) { this.c=c; this.m=m; }}
  static Target[] targets = new Target[] {
    new Target("BenchmarkTest01227", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01228", "doGet"),
    new Target("BenchmarkTest01228", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01229", "doGet"),
    new Target("BenchmarkTest01229", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01230", "doGet"),
    new Target("BenchmarkTest01230", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01231", "doGet"),
    new Target("BenchmarkTest01231", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01232", "doGet"),
    new Target("BenchmarkTest01232", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01233", "doGet"),
    new Target("BenchmarkTest01233", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01234", "doGet"),
    new Target("BenchmarkTest01234", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01235", "doGet"),
    new Target("BenchmarkTest01235", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01236", "doGet"),
    new Target("BenchmarkTest01236", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01237", "doGet"),
    new Target("BenchmarkTest01237", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01238", "doGet"),
    new Target("BenchmarkTest01238", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01239", "doGet"),
    new Target("BenchmarkTest01239", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01240", "doGet"),
    new Target("BenchmarkTest01240", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01241", "doGet"),
    new Target("BenchmarkTest01241", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01242", "doGet"),
    new Target("BenchmarkTest01242", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01243", "doGet"),
    new Target("BenchmarkTest01243", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01244", "doGet"),
    new Target("BenchmarkTest01244", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01245", "doGet"),
    new Target("BenchmarkTest01245", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01246", "doGet"),
    new Target("BenchmarkTest01246", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01247", "doGet"),
    new Target("BenchmarkTest01247", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01248", "doGet"),
    new Target("BenchmarkTest01248", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01249", "doGet"),
    new Target("BenchmarkTest01249", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01250", "doGet"),
    new Target("BenchmarkTest01250", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01251", "doGet"),
    new Target("BenchmarkTest01251", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01252", "doGet"),
    new Target("BenchmarkTest01252", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01253", "doGet"),
    new Target("BenchmarkTest01253", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01254", "doGet"),
    new Target("BenchmarkTest01254", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01255", "doGet"),
    new Target("BenchmarkTest01255", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01256", "doGet"),
    new Target("BenchmarkTest01256", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01257", "doGet"),
    new Target("BenchmarkTest01257", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01258", "doGet"),
    new Target("BenchmarkTest01258", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01259", "doGet"),
    new Target("BenchmarkTest01259", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01260", "doGet"),
    new Target("BenchmarkTest01260", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01261", "doGet"),
    new Target("BenchmarkTest01261", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01262", "doGet"),
    new Target("BenchmarkTest01262", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01263", "doGet"),
    new Target("BenchmarkTest01263", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01264", "doGet"),
    new Target("BenchmarkTest01264", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01265", "doGet"),
    new Target("BenchmarkTest01265", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01266", "doGet"),
    new Target("BenchmarkTest01266", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01267", "doGet"),
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
