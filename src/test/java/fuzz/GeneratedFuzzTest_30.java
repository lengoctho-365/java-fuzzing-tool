package fuzz;
import com.code_intelligence.jazzer.api.*;
import java.lang.reflect.*;
import java.util.*;

public class GeneratedFuzzTest_30 {
  static class Target { final String c, m; Target(String c, String m) { this.c=c; this.m=m; }}
  static Target[] targets = new Target[] {
    new Target("BenchmarkTest01467", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01468", "doGet"),
    new Target("BenchmarkTest01468", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01469", "doGet"),
    new Target("BenchmarkTest01469", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01470", "doGet"),
    new Target("BenchmarkTest01470", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01471", "doGet"),
    new Target("BenchmarkTest01471", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01472", "doGet"),
    new Target("BenchmarkTest01472", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01473", "doGet"),
    new Target("BenchmarkTest01473", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01474", "doGet"),
    new Target("BenchmarkTest01474", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01475", "doGet"),
    new Target("BenchmarkTest01475", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01476", "doGet"),
    new Target("BenchmarkTest01476", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01477", "doGet"),
    new Target("BenchmarkTest01477", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01478", "doGet"),
    new Target("BenchmarkTest01478", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01479", "doGet"),
    new Target("BenchmarkTest01479", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01480", "doGet"),
    new Target("BenchmarkTest01480", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01481", "doGet"),
    new Target("BenchmarkTest01481", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01482", "doGet"),
    new Target("BenchmarkTest01482", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01483", "doGet"),
    new Target("BenchmarkTest01483", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01484", "doGet"),
    new Target("BenchmarkTest01484", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01485", "doGet"),
    new Target("BenchmarkTest01485", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01486", "doGet"),
    new Target("BenchmarkTest01486", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01487", "doGet"),
    new Target("BenchmarkTest01487", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01488", "doGet"),
    new Target("BenchmarkTest01488", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01489", "doGet"),
    new Target("BenchmarkTest01489", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01490", "doGet"),
    new Target("BenchmarkTest01490", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01491", "doGet"),
    new Target("BenchmarkTest01491", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01492", "doGet"),
    new Target("BenchmarkTest01492", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01493", "doGet"),
    new Target("BenchmarkTest01493", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01494", "doGet"),
    new Target("BenchmarkTest01494", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01495", "doGet"),
    new Target("BenchmarkTest01495", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01496", "doGet"),
    new Target("BenchmarkTest01496", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01497", "doGet"),
    new Target("BenchmarkTest01497", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01498", "doGet"),
    new Target("BenchmarkTest01498", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01499", "doGet"),
    new Target("BenchmarkTest01499", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01500", "doGet"),
    new Target("BenchmarkTest01500", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01501", "doGet"),
    new Target("BenchmarkTest01501", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01502", "doGet"),
    new Target("BenchmarkTest01502", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01503", "doGet"),
    new Target("BenchmarkTest01503", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01504", "doGet"),
    new Target("BenchmarkTest01504", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01505", "doGet"),
    new Target("BenchmarkTest01505", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01506", "doGet"),
    new Target("BenchmarkTest01506", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01507", "doGet"),
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
