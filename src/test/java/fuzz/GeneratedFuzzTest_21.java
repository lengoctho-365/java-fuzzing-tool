package fuzz;
import com.code_intelligence.jazzer.api.*;
import java.lang.reflect.*;
import java.util.*;

public class GeneratedFuzzTest_21 {
  static class Target { final String c, m; Target(String c, String m) { this.c=c; this.m=m; }}
  static Target[] targets = new Target[] {
    new Target("BenchmarkTest01107", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01108", "doGet"),
    new Target("BenchmarkTest01108", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01109", "doGet"),
    new Target("BenchmarkTest01109", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01110", "doGet"),
    new Target("BenchmarkTest01110", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01111", "doGet"),
    new Target("BenchmarkTest01111", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01112", "doGet"),
    new Target("BenchmarkTest01112", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01113", "doGet"),
    new Target("BenchmarkTest01113", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01114", "doGet"),
    new Target("BenchmarkTest01114", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01115", "doGet"),
    new Target("BenchmarkTest01115", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01116", "doGet"),
    new Target("BenchmarkTest01116", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01117", "doGet"),
    new Target("BenchmarkTest01117", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01118", "doGet"),
    new Target("BenchmarkTest01118", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01119", "doGet"),
    new Target("BenchmarkTest01119", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01120", "doGet"),
    new Target("BenchmarkTest01120", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01121", "doGet"),
    new Target("BenchmarkTest01121", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01122", "doGet"),
    new Target("BenchmarkTest01122", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01123", "doGet"),
    new Target("BenchmarkTest01123", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01124", "doGet"),
    new Target("BenchmarkTest01124", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01125", "doGet"),
    new Target("BenchmarkTest01125", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01126", "doGet"),
    new Target("BenchmarkTest01126", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01127", "doGet"),
    new Target("BenchmarkTest01127", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01128", "doGet"),
    new Target("BenchmarkTest01128", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01129", "doGet"),
    new Target("BenchmarkTest01129", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01130", "doGet"),
    new Target("BenchmarkTest01130", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01131", "doGet"),
    new Target("BenchmarkTest01131", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01132", "doGet"),
    new Target("BenchmarkTest01132", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01133", "doGet"),
    new Target("BenchmarkTest01133", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01134", "doGet"),
    new Target("BenchmarkTest01134", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01135", "doGet"),
    new Target("BenchmarkTest01135", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01136", "doGet"),
    new Target("BenchmarkTest01136", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01137", "doGet"),
    new Target("BenchmarkTest01137", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01138", "doGet"),
    new Target("BenchmarkTest01138", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01139", "doGet"),
    new Target("BenchmarkTest01139", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01140", "doGet"),
    new Target("BenchmarkTest01140", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01141", "doGet"),
    new Target("BenchmarkTest01141", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01142", "doGet"),
    new Target("BenchmarkTest01142", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01143", "doGet"),
    new Target("BenchmarkTest01143", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01144", "doGet"),
    new Target("BenchmarkTest01144", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01145", "doGet"),
    new Target("BenchmarkTest01145", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01146", "doGet"),
    new Target("BenchmarkTest01146", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01147", "doGet"),
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
