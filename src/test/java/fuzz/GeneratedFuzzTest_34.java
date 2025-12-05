package fuzz;
import com.code_intelligence.jazzer.api.*;
import java.lang.reflect.*;
import java.util.*;

public class GeneratedFuzzTest_34 {
  static class Target { final String c, m; Target(String c, String m) { this.c=c; this.m=m; }}
  static Target[] targets = new Target[] {
    new Target("BenchmarkTest01627", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01628", "doGet"),
    new Target("BenchmarkTest01628", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01629", "doGet"),
    new Target("BenchmarkTest01629", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01630", "doGet"),
    new Target("BenchmarkTest01630", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01631", "doGet"),
    new Target("BenchmarkTest01631", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01632", "doGet"),
    new Target("BenchmarkTest01632", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01633", "doGet"),
    new Target("BenchmarkTest01633", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01634", "doGet"),
    new Target("BenchmarkTest01634", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01635", "doGet"),
    new Target("BenchmarkTest01635", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01636", "doGet"),
    new Target("BenchmarkTest01636", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01637", "doGet"),
    new Target("BenchmarkTest01637", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01638", "doGet"),
    new Target("BenchmarkTest01638", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01639", "doGet"),
    new Target("BenchmarkTest01639", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01640", "doGet"),
    new Target("BenchmarkTest01640", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01641", "doGet"),
    new Target("BenchmarkTest01641", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01642", "doGet"),
    new Target("BenchmarkTest01642", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01643", "doGet"),
    new Target("BenchmarkTest01643", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01644", "doGet"),
    new Target("BenchmarkTest01644", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01645", "doGet"),
    new Target("BenchmarkTest01645", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01646", "doGet"),
    new Target("BenchmarkTest01646", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01647", "doGet"),
    new Target("BenchmarkTest01647", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01648", "doGet"),
    new Target("BenchmarkTest01648", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01649", "doGet"),
    new Target("BenchmarkTest01649", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01650", "doGet"),
    new Target("BenchmarkTest01650", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01651", "doGet"),
    new Target("BenchmarkTest01651", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01652", "doGet"),
    new Target("BenchmarkTest01652", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01653", "doGet"),
    new Target("BenchmarkTest01653", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01654", "doGet"),
    new Target("BenchmarkTest01654", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01655", "doGet"),
    new Target("BenchmarkTest01655", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01656", "doGet"),
    new Target("BenchmarkTest01656", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01657", "doGet"),
    new Target("BenchmarkTest01657", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01658", "doGet"),
    new Target("BenchmarkTest01658", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01659", "doGet"),
    new Target("BenchmarkTest01659", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01660", "doGet"),
    new Target("BenchmarkTest01660", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01661", "doGet"),
    new Target("BenchmarkTest01661", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01662", "doGet"),
    new Target("BenchmarkTest01662", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01663", "doGet"),
    new Target("BenchmarkTest01663", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01664", "doGet"),
    new Target("BenchmarkTest01664", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01665", "doGet"),
    new Target("BenchmarkTest01665", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01666", "doGet"),
    new Target("BenchmarkTest01666", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01667", "doGet"),
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
