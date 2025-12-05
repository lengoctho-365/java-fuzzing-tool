package fuzz;
import com.code_intelligence.jazzer.api.*;
import java.lang.reflect.*;
import java.util.*;

public class GeneratedFuzzTest_22 {
  static class Target { final String c, m; Target(String c, String m) { this.c=c; this.m=m; }}
  static Target[] targets = new Target[] {
    new Target("BenchmarkTest01147", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01148", "doGet"),
    new Target("BenchmarkTest01148", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01149", "doGet"),
    new Target("BenchmarkTest01149", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01150", "doGet"),
    new Target("BenchmarkTest01150", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01151", "doGet"),
    new Target("BenchmarkTest01151", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01152", "doGet"),
    new Target("BenchmarkTest01152", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01153", "doGet"),
    new Target("BenchmarkTest01153", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01154", "doGet"),
    new Target("BenchmarkTest01154", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01155", "doGet"),
    new Target("BenchmarkTest01155", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01156", "doGet"),
    new Target("BenchmarkTest01156", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01157", "doGet"),
    new Target("BenchmarkTest01157", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01158", "doGet"),
    new Target("BenchmarkTest01158", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01159", "doGet"),
    new Target("BenchmarkTest01159", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01160", "doGet"),
    new Target("BenchmarkTest01160", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01161", "doGet"),
    new Target("BenchmarkTest01161", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01162", "doGet"),
    new Target("BenchmarkTest01162", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01163", "doGet"),
    new Target("BenchmarkTest01163", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01164", "doGet"),
    new Target("BenchmarkTest01164", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01165", "doGet"),
    new Target("BenchmarkTest01165", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01166", "doGet"),
    new Target("BenchmarkTest01166", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01167", "doGet"),
    new Target("BenchmarkTest01167", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01168", "doGet"),
    new Target("BenchmarkTest01168", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01169", "doGet"),
    new Target("BenchmarkTest01169", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01170", "doGet"),
    new Target("BenchmarkTest01170", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01171", "doGet"),
    new Target("BenchmarkTest01171", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01172", "doGet"),
    new Target("BenchmarkTest01172", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01173", "doGet"),
    new Target("BenchmarkTest01173", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01174", "doGet"),
    new Target("BenchmarkTest01174", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01175", "doGet"),
    new Target("BenchmarkTest01175", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01176", "doGet"),
    new Target("BenchmarkTest01176", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01177", "doGet"),
    new Target("BenchmarkTest01177", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01178", "doGet"),
    new Target("BenchmarkTest01178", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01179", "doGet"),
    new Target("BenchmarkTest01179", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01180", "doGet"),
    new Target("BenchmarkTest01180", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01181", "doGet"),
    new Target("BenchmarkTest01181", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01182", "doGet"),
    new Target("BenchmarkTest01182", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01183", "doGet"),
    new Target("BenchmarkTest01183", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01184", "doGet"),
    new Target("BenchmarkTest01184", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01185", "doGet"),
    new Target("BenchmarkTest01185", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01186", "doGet"),
    new Target("BenchmarkTest01186", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01187", "doGet"),
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
