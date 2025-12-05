package fuzz;
import com.code_intelligence.jazzer.api.*;
import java.lang.reflect.*;
import java.util.*;

public class GeneratedFuzzTest_54 {
  static class Target { final String c, m; Target(String c, String m) { this.c=c; this.m=m; }}
  static Target[] targets = new Target[] {
    new Target("BenchmarkTest02730", "doGet"),
    new Target("BenchmarkTest02730", "doPost"),
    new Target("BenchmarkTest02731", "doGet"),
    new Target("BenchmarkTest02731", "doPost"),
    new Target("BenchmarkTest02732", "doGet"),
    new Target("BenchmarkTest02732", "doPost"),
    new Target("BenchmarkTest02733", "doGet"),
    new Target("BenchmarkTest02733", "doPost"),
    new Target("BenchmarkTest02734", "doGet"),
    new Target("BenchmarkTest02734", "doPost"),
    new Target("BenchmarkTest02735", "doGet"),
    new Target("BenchmarkTest02735", "doPost"),
    new Target("BenchmarkTest02736", "doGet"),
    new Target("BenchmarkTest02736", "doPost"),
    new Target("BenchmarkTest02737", "doGet"),
    new Target("BenchmarkTest02737", "doPost"),
    new Target("BenchmarkTest02738", "doGet"),
    new Target("BenchmarkTest02738", "doPost"),
    new Target("BenchmarkTest02739", "doGet"),
    new Target("BenchmarkTest02739", "doPost"),
    new Target("BenchmarkTest02740", "doGet"),
    new Target("BenchmarkTest02740", "doPost"),
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
