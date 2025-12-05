package fuzz;
import com.code_intelligence.jazzer.api.*;
import java.lang.reflect.*;
import java.util.*;

public class GeneratedFuzzTest_31 {
  static class Target { final String c, m; Target(String c, String m) { this.c=c; this.m=m; }}
  static Target[] targets = new Target[] {
    new Target("BenchmarkTest01507", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01508", "doGet"),
    new Target("BenchmarkTest01508", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01509", "doGet"),
    new Target("BenchmarkTest01509", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01510", "doGet"),
    new Target("BenchmarkTest01510", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01511", "doGet"),
    new Target("BenchmarkTest01511", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01512", "doGet"),
    new Target("BenchmarkTest01512", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01513", "doGet"),
    new Target("BenchmarkTest01513", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01514", "doGet"),
    new Target("BenchmarkTest01514", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01515", "doGet"),
    new Target("BenchmarkTest01515", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01516", "doGet"),
    new Target("BenchmarkTest01516", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01517", "doGet"),
    new Target("BenchmarkTest01517", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01518", "doGet"),
    new Target("BenchmarkTest01518", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01519", "doGet"),
    new Target("BenchmarkTest01519", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01520", "doGet"),
    new Target("BenchmarkTest01520", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01521", "doGet"),
    new Target("BenchmarkTest01521", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01522", "doGet"),
    new Target("BenchmarkTest01522", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01523", "doGet"),
    new Target("BenchmarkTest01523", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01524", "doGet"),
    new Target("BenchmarkTest01524", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01525", "doGet"),
    new Target("BenchmarkTest01525", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01526", "doGet"),
    new Target("BenchmarkTest01526", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01527", "doGet"),
    new Target("BenchmarkTest01527", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01528", "doGet"),
    new Target("BenchmarkTest01528", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01529", "doGet"),
    new Target("BenchmarkTest01529", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01530", "doGet"),
    new Target("BenchmarkTest01530", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01531", "doGet"),
    new Target("BenchmarkTest01531", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01532", "doGet"),
    new Target("BenchmarkTest01532", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01533", "doGet"),
    new Target("BenchmarkTest01533", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01534", "doGet"),
    new Target("BenchmarkTest01534", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01535", "doGet"),
    new Target("BenchmarkTest01535", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01536", "doGet"),
    new Target("BenchmarkTest01536", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01537", "doGet"),
    new Target("BenchmarkTest01537", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01538", "doGet"),
    new Target("BenchmarkTest01538", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01539", "doGet"),
    new Target("BenchmarkTest01539", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01540", "doGet"),
    new Target("BenchmarkTest01540", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01541", "doGet"),
    new Target("BenchmarkTest01541", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01542", "doGet"),
    new Target("BenchmarkTest01542", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01543", "doGet"),
    new Target("BenchmarkTest01543", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01544", "doGet"),
    new Target("BenchmarkTest01544", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01545", "doGet"),
    new Target("BenchmarkTest01545", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01546", "doGet"),
    new Target("BenchmarkTest01546", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01547", "doGet"),
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
