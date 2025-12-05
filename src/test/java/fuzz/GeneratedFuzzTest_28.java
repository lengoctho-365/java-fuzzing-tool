package fuzz;
import com.code_intelligence.jazzer.api.*;
import java.lang.reflect.*;
import java.util.*;

public class GeneratedFuzzTest_28 {
  static class Target { final String c, m; Target(String c, String m) { this.c=c; this.m=m; }}
  static Target[] targets = new Target[] {
    new Target("BenchmarkTest01387", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01388", "doGet"),
    new Target("BenchmarkTest01388", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01389", "doGet"),
    new Target("BenchmarkTest01389", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01390", "doGet"),
    new Target("BenchmarkTest01390", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01391", "doGet"),
    new Target("BenchmarkTest01391", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01392", "doGet"),
    new Target("BenchmarkTest01392", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01393", "doGet"),
    new Target("BenchmarkTest01393", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01394", "doGet"),
    new Target("BenchmarkTest01394", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01395", "doGet"),
    new Target("BenchmarkTest01395", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01396", "doGet"),
    new Target("BenchmarkTest01396", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01397", "doGet"),
    new Target("BenchmarkTest01397", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01398", "doGet"),
    new Target("BenchmarkTest01398", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01399", "doGet"),
    new Target("BenchmarkTest01399", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01400", "doGet"),
    new Target("BenchmarkTest01400", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01401", "doGet"),
    new Target("BenchmarkTest01401", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01402", "doGet"),
    new Target("BenchmarkTest01402", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01403", "doGet"),
    new Target("BenchmarkTest01403", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01404", "doGet"),
    new Target("BenchmarkTest01404", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01405", "doGet"),
    new Target("BenchmarkTest01405", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01406", "doGet"),
    new Target("BenchmarkTest01406", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01407", "doGet"),
    new Target("BenchmarkTest01407", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01408", "doGet"),
    new Target("BenchmarkTest01408", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01409", "doGet"),
    new Target("BenchmarkTest01409", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01410", "doGet"),
    new Target("BenchmarkTest01410", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01411", "doGet"),
    new Target("BenchmarkTest01411", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01412", "doGet"),
    new Target("BenchmarkTest01412", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01413", "doGet"),
    new Target("BenchmarkTest01413", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01414", "doGet"),
    new Target("BenchmarkTest01414", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01415", "doGet"),
    new Target("BenchmarkTest01415", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01416", "doGet"),
    new Target("BenchmarkTest01416", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01417", "doGet"),
    new Target("BenchmarkTest01417", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01418", "doGet"),
    new Target("BenchmarkTest01418", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01419", "doGet"),
    new Target("BenchmarkTest01419", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01420", "doGet"),
    new Target("BenchmarkTest01420", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01421", "doGet"),
    new Target("BenchmarkTest01421", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01422", "doGet"),
    new Target("BenchmarkTest01422", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01423", "doGet"),
    new Target("BenchmarkTest01423", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01424", "doGet"),
    new Target("BenchmarkTest01424", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01425", "doGet"),
    new Target("BenchmarkTest01425", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01426", "doGet"),
    new Target("BenchmarkTest01426", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01427", "doGet"),
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
