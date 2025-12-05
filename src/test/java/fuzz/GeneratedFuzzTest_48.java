package fuzz;
import com.code_intelligence.jazzer.api.*;
import java.lang.reflect.*;
import java.util.*;

public class GeneratedFuzzTest_48 {
  static class Target { final String c, m; Target(String c, String m) { this.c=c; this.m=m; }}
  static Target[] targets = new Target[] {
    new Target("BenchmarkTest02370", "doGet"),
    new Target("BenchmarkTest02370", "doPost"),
    new Target("BenchmarkTest02371", "doGet"),
    new Target("BenchmarkTest02371", "doPost"),
    new Target("BenchmarkTest02372", "doGet"),
    new Target("BenchmarkTest02372", "doPost"),
    new Target("BenchmarkTest02373", "doGet"),
    new Target("BenchmarkTest02373", "doPost"),
    new Target("BenchmarkTest02374", "doGet"),
    new Target("BenchmarkTest02374", "doPost"),
    new Target("BenchmarkTest02375", "doGet"),
    new Target("BenchmarkTest02375", "doPost"),
    new Target("BenchmarkTest02376", "doGet"),
    new Target("BenchmarkTest02376", "doPost"),
    new Target("BenchmarkTest02377", "doGet"),
    new Target("BenchmarkTest02377", "doPost"),
    new Target("BenchmarkTest02378", "doGet"),
    new Target("BenchmarkTest02378", "doPost"),
    new Target("BenchmarkTest02379", "doGet"),
    new Target("BenchmarkTest02379", "doPost"),
    new Target("BenchmarkTest02380", "doGet"),
    new Target("BenchmarkTest02380", "doPost"),
    new Target("BenchmarkTest02381", "doGet"),
    new Target("BenchmarkTest02381", "doPost"),
    new Target("BenchmarkTest02382", "doGet"),
    new Target("BenchmarkTest02382", "doPost"),
    new Target("BenchmarkTest02383", "doGet"),
    new Target("BenchmarkTest02383", "doPost"),
    new Target("BenchmarkTest02384", "doGet"),
    new Target("BenchmarkTest02384", "doPost"),
    new Target("BenchmarkTest02385", "doGet"),
    new Target("BenchmarkTest02385", "doPost"),
    new Target("BenchmarkTest02386", "doGet"),
    new Target("BenchmarkTest02386", "doPost"),
    new Target("BenchmarkTest02387", "doGet"),
    new Target("BenchmarkTest02387", "doPost"),
    new Target("BenchmarkTest02388", "doGet"),
    new Target("BenchmarkTest02388", "doPost"),
    new Target("BenchmarkTest02389", "doGet"),
    new Target("BenchmarkTest02389", "doPost"),
    new Target("BenchmarkTest02390", "doGet"),
    new Target("BenchmarkTest02390", "doPost"),
    new Target("BenchmarkTest02391", "doGet"),
    new Target("BenchmarkTest02391", "doPost"),
    new Target("BenchmarkTest02392", "doGet"),
    new Target("BenchmarkTest02392", "doPost"),
    new Target("BenchmarkTest02393", "doGet"),
    new Target("BenchmarkTest02393", "doPost"),
    new Target("BenchmarkTest02394", "doGet"),
    new Target("BenchmarkTest02394", "doPost"),
    new Target("BenchmarkTest02395", "doGet"),
    new Target("BenchmarkTest02395", "doPost"),
    new Target("BenchmarkTest02396", "doGet"),
    new Target("BenchmarkTest02396", "doPost"),
    new Target("BenchmarkTest02397", "doGet"),
    new Target("BenchmarkTest02397", "doPost"),
    new Target("BenchmarkTest02398", "doGet"),
    new Target("BenchmarkTest02398", "doPost"),
    new Target("BenchmarkTest02399", "doGet"),
    new Target("BenchmarkTest02399", "doPost"),
    new Target("BenchmarkTest02400", "doGet"),
    new Target("BenchmarkTest02400", "doPost"),
    new Target("BenchmarkTest02401", "doGet"),
    new Target("BenchmarkTest02401", "doPost"),
    new Target("BenchmarkTest02402", "doGet"),
    new Target("BenchmarkTest02402", "doPost"),
    new Target("BenchmarkTest02403", "doGet"),
    new Target("BenchmarkTest02403", "doPost"),
    new Target("BenchmarkTest02404", "doGet"),
    new Target("BenchmarkTest02404", "doPost"),
    new Target("BenchmarkTest02405", "doGet"),
    new Target("BenchmarkTest02405", "doPost"),
    new Target("BenchmarkTest02406", "doGet"),
    new Target("BenchmarkTest02406", "doPost"),
    new Target("BenchmarkTest02407", "doGet"),
    new Target("BenchmarkTest02407", "doPost"),
    new Target("BenchmarkTest02408", "doGet"),
    new Target("BenchmarkTest02408", "doPost"),
    new Target("BenchmarkTest02409", "doGet"),
    new Target("BenchmarkTest02409", "doPost"),
    new Target("BenchmarkTest02410", "doGet"),
    new Target("BenchmarkTest02410", "doPost"),
    new Target("BenchmarkTest02411", "doGet"),
    new Target("BenchmarkTest02411", "doPost"),
    new Target("BenchmarkTest02412", "doGet"),
    new Target("BenchmarkTest02412", "doPost"),
    new Target("BenchmarkTest02413", "doGet"),
    new Target("BenchmarkTest02413", "doPost"),
    new Target("BenchmarkTest02414", "doGet"),
    new Target("BenchmarkTest02414", "doPost"),
    new Target("BenchmarkTest02415", "doGet"),
    new Target("BenchmarkTest02415", "doPost"),
    new Target("BenchmarkTest02416", "doGet"),
    new Target("BenchmarkTest02416", "doPost"),
    new Target("BenchmarkTest02417", "doGet"),
    new Target("BenchmarkTest02417", "doPost"),
    new Target("BenchmarkTest02418", "doGet"),
    new Target("BenchmarkTest02418", "doPost"),
    new Target("BenchmarkTest02419", "doGet"),
    new Target("BenchmarkTest02419", "doPost"),
    new Target("BenchmarkTest02420", "doGet"),
    new Target("BenchmarkTest02420", "doPost"),
    new Target("BenchmarkTest02421", "doGet"),
    new Target("BenchmarkTest02421", "doPost"),
    new Target("BenchmarkTest02422", "doGet"),
    new Target("BenchmarkTest02422", "doPost"),
    new Target("BenchmarkTest02423", "doGet"),
    new Target("BenchmarkTest02423", "doPost"),
    new Target("BenchmarkTest02424", "doGet"),
    new Target("BenchmarkTest02424", "doPost"),
    new Target("BenchmarkTest02425", "doGet"),
    new Target("BenchmarkTest02425", "doPost"),
    new Target("BenchmarkTest02426", "doGet"),
    new Target("BenchmarkTest02426", "doPost"),
    new Target("BenchmarkTest02427", "doGet"),
    new Target("BenchmarkTest02427", "doPost"),
    new Target("BenchmarkTest02428", "doGet"),
    new Target("BenchmarkTest02428", "doPost"),
    new Target("BenchmarkTest02429", "doGet"),
    new Target("BenchmarkTest02429", "doPost"),
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
