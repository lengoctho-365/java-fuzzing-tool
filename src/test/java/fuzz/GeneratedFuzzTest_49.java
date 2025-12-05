package fuzz;
import com.code_intelligence.jazzer.api.*;
import java.lang.reflect.*;
import java.util.*;

public class GeneratedFuzzTest_49 {
  static class Target { final String c, m; Target(String c, String m) { this.c=c; this.m=m; }}
  static Target[] targets = new Target[] {
    new Target("BenchmarkTest02430", "doGet"),
    new Target("BenchmarkTest02430", "doPost"),
    new Target("BenchmarkTest02431", "doGet"),
    new Target("BenchmarkTest02431", "doPost"),
    new Target("BenchmarkTest02432", "doGet"),
    new Target("BenchmarkTest02432", "doPost"),
    new Target("BenchmarkTest02433", "doGet"),
    new Target("BenchmarkTest02433", "doPost"),
    new Target("BenchmarkTest02434", "doGet"),
    new Target("BenchmarkTest02434", "doPost"),
    new Target("BenchmarkTest02435", "doGet"),
    new Target("BenchmarkTest02435", "doPost"),
    new Target("BenchmarkTest02436", "doGet"),
    new Target("BenchmarkTest02436", "doPost"),
    new Target("BenchmarkTest02437", "doGet"),
    new Target("BenchmarkTest02437", "doPost"),
    new Target("BenchmarkTest02438", "doGet"),
    new Target("BenchmarkTest02438", "doPost"),
    new Target("BenchmarkTest02439", "doGet"),
    new Target("BenchmarkTest02439", "doPost"),
    new Target("BenchmarkTest02440", "doGet"),
    new Target("BenchmarkTest02440", "doPost"),
    new Target("BenchmarkTest02441", "doGet"),
    new Target("BenchmarkTest02441", "doPost"),
    new Target("BenchmarkTest02442", "doGet"),
    new Target("BenchmarkTest02442", "doPost"),
    new Target("BenchmarkTest02443", "doGet"),
    new Target("BenchmarkTest02443", "doPost"),
    new Target("BenchmarkTest02444", "doGet"),
    new Target("BenchmarkTest02444", "doPost"),
    new Target("BenchmarkTest02445", "doGet"),
    new Target("BenchmarkTest02445", "doPost"),
    new Target("BenchmarkTest02446", "doGet"),
    new Target("BenchmarkTest02446", "doPost"),
    new Target("BenchmarkTest02447", "doGet"),
    new Target("BenchmarkTest02447", "doPost"),
    new Target("BenchmarkTest02448", "doGet"),
    new Target("BenchmarkTest02448", "doPost"),
    new Target("BenchmarkTest02449", "doGet"),
    new Target("BenchmarkTest02449", "doPost"),
    new Target("BenchmarkTest02450", "doGet"),
    new Target("BenchmarkTest02450", "doPost"),
    new Target("BenchmarkTest02451", "doGet"),
    new Target("BenchmarkTest02451", "doPost"),
    new Target("BenchmarkTest02452", "doGet"),
    new Target("BenchmarkTest02452", "doPost"),
    new Target("BenchmarkTest02453", "doGet"),
    new Target("BenchmarkTest02453", "doPost"),
    new Target("BenchmarkTest02454", "doGet"),
    new Target("BenchmarkTest02454", "doPost"),
    new Target("BenchmarkTest02455", "doGet"),
    new Target("BenchmarkTest02455", "doPost"),
    new Target("BenchmarkTest02456", "doGet"),
    new Target("BenchmarkTest02456", "doPost"),
    new Target("BenchmarkTest02457", "doGet"),
    new Target("BenchmarkTest02457", "doPost"),
    new Target("BenchmarkTest02458", "doGet"),
    new Target("BenchmarkTest02458", "doPost"),
    new Target("BenchmarkTest02459", "doGet"),
    new Target("BenchmarkTest02459", "doPost"),
    new Target("BenchmarkTest02460", "doGet"),
    new Target("BenchmarkTest02460", "doPost"),
    new Target("BenchmarkTest02461", "doGet"),
    new Target("BenchmarkTest02461", "doPost"),
    new Target("BenchmarkTest02462", "doGet"),
    new Target("BenchmarkTest02462", "doPost"),
    new Target("BenchmarkTest02463", "doGet"),
    new Target("BenchmarkTest02463", "doPost"),
    new Target("BenchmarkTest02464", "doGet"),
    new Target("BenchmarkTest02464", "doPost"),
    new Target("BenchmarkTest02465", "doGet"),
    new Target("BenchmarkTest02465", "doPost"),
    new Target("BenchmarkTest02466", "doGet"),
    new Target("BenchmarkTest02466", "doPost"),
    new Target("BenchmarkTest02467", "doGet"),
    new Target("BenchmarkTest02467", "doPost"),
    new Target("BenchmarkTest02468", "doGet"),
    new Target("BenchmarkTest02468", "doPost"),
    new Target("BenchmarkTest02469", "doGet"),
    new Target("BenchmarkTest02469", "doPost"),
    new Target("BenchmarkTest02470", "doGet"),
    new Target("BenchmarkTest02470", "doPost"),
    new Target("BenchmarkTest02471", "doGet"),
    new Target("BenchmarkTest02471", "doPost"),
    new Target("BenchmarkTest02472", "doGet"),
    new Target("BenchmarkTest02472", "doPost"),
    new Target("BenchmarkTest02473", "doGet"),
    new Target("BenchmarkTest02473", "doPost"),
    new Target("BenchmarkTest02474", "doGet"),
    new Target("BenchmarkTest02474", "doPost"),
    new Target("BenchmarkTest02475", "doGet"),
    new Target("BenchmarkTest02475", "doPost"),
    new Target("BenchmarkTest02476", "doGet"),
    new Target("BenchmarkTest02476", "doPost"),
    new Target("BenchmarkTest02477", "doGet"),
    new Target("BenchmarkTest02477", "doPost"),
    new Target("BenchmarkTest02478", "doGet"),
    new Target("BenchmarkTest02478", "doPost"),
    new Target("BenchmarkTest02479", "doGet"),
    new Target("BenchmarkTest02479", "doPost"),
    new Target("BenchmarkTest02480", "doGet"),
    new Target("BenchmarkTest02480", "doPost"),
    new Target("BenchmarkTest02481", "doGet"),
    new Target("BenchmarkTest02481", "doPost"),
    new Target("BenchmarkTest02482", "doGet"),
    new Target("BenchmarkTest02482", "doPost"),
    new Target("BenchmarkTest02483", "doGet"),
    new Target("BenchmarkTest02483", "doPost"),
    new Target("BenchmarkTest02484", "doGet"),
    new Target("BenchmarkTest02484", "doPost"),
    new Target("BenchmarkTest02485", "doGet"),
    new Target("BenchmarkTest02485", "doPost"),
    new Target("BenchmarkTest02486", "doGet"),
    new Target("BenchmarkTest02486", "doPost"),
    new Target("BenchmarkTest02487", "doGet"),
    new Target("BenchmarkTest02487", "doPost"),
    new Target("BenchmarkTest02488", "doGet"),
    new Target("BenchmarkTest02488", "doPost"),
    new Target("BenchmarkTest02489", "doGet"),
    new Target("BenchmarkTest02489", "doPost"),
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
