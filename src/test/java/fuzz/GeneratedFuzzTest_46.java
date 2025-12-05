package fuzz;
import com.code_intelligence.jazzer.api.*;
import java.lang.reflect.*;
import java.util.*;

public class GeneratedFuzzTest_46 {
  static class Target { final String c, m; Target(String c, String m) { this.c=c; this.m=m; }}
  static Target[] targets = new Target[] {
    new Target("BenchmarkTest02250", "doGet"),
    new Target("BenchmarkTest02250", "doPost"),
    new Target("BenchmarkTest02251", "doGet"),
    new Target("BenchmarkTest02251", "doPost"),
    new Target("BenchmarkTest02252", "doGet"),
    new Target("BenchmarkTest02252", "doPost"),
    new Target("BenchmarkTest02253", "doGet"),
    new Target("BenchmarkTest02253", "doPost"),
    new Target("BenchmarkTest02254", "doGet"),
    new Target("BenchmarkTest02254", "doPost"),
    new Target("BenchmarkTest02255", "doGet"),
    new Target("BenchmarkTest02255", "doPost"),
    new Target("BenchmarkTest02256", "doGet"),
    new Target("BenchmarkTest02256", "doPost"),
    new Target("BenchmarkTest02257", "doGet"),
    new Target("BenchmarkTest02257", "doPost"),
    new Target("BenchmarkTest02258", "doGet"),
    new Target("BenchmarkTest02258", "doPost"),
    new Target("BenchmarkTest02259", "doGet"),
    new Target("BenchmarkTest02259", "doPost"),
    new Target("BenchmarkTest02260", "doGet"),
    new Target("BenchmarkTest02260", "doPost"),
    new Target("BenchmarkTest02261", "doGet"),
    new Target("BenchmarkTest02261", "doPost"),
    new Target("BenchmarkTest02262", "doGet"),
    new Target("BenchmarkTest02262", "doPost"),
    new Target("BenchmarkTest02263", "doGet"),
    new Target("BenchmarkTest02263", "doPost"),
    new Target("BenchmarkTest02264", "doGet"),
    new Target("BenchmarkTest02264", "doPost"),
    new Target("BenchmarkTest02265", "doGet"),
    new Target("BenchmarkTest02265", "doPost"),
    new Target("BenchmarkTest02266", "doGet"),
    new Target("BenchmarkTest02266", "doPost"),
    new Target("BenchmarkTest02267", "doGet"),
    new Target("BenchmarkTest02267", "doPost"),
    new Target("BenchmarkTest02268", "doGet"),
    new Target("BenchmarkTest02268", "doPost"),
    new Target("BenchmarkTest02269", "doGet"),
    new Target("BenchmarkTest02269", "doPost"),
    new Target("BenchmarkTest02270", "doGet"),
    new Target("BenchmarkTest02270", "doPost"),
    new Target("BenchmarkTest02271", "doGet"),
    new Target("BenchmarkTest02271", "doPost"),
    new Target("BenchmarkTest02272", "doGet"),
    new Target("BenchmarkTest02272", "doPost"),
    new Target("BenchmarkTest02273", "doGet"),
    new Target("BenchmarkTest02273", "doPost"),
    new Target("BenchmarkTest02274", "doGet"),
    new Target("BenchmarkTest02274", "doPost"),
    new Target("BenchmarkTest02275", "doGet"),
    new Target("BenchmarkTest02275", "doPost"),
    new Target("BenchmarkTest02276", "doGet"),
    new Target("BenchmarkTest02276", "doPost"),
    new Target("BenchmarkTest02277", "doGet"),
    new Target("BenchmarkTest02277", "doPost"),
    new Target("BenchmarkTest02278", "doGet"),
    new Target("BenchmarkTest02278", "doPost"),
    new Target("BenchmarkTest02279", "doGet"),
    new Target("BenchmarkTest02279", "doPost"),
    new Target("BenchmarkTest02280", "doGet"),
    new Target("BenchmarkTest02280", "doPost"),
    new Target("BenchmarkTest02281", "doGet"),
    new Target("BenchmarkTest02281", "doPost"),
    new Target("BenchmarkTest02282", "doGet"),
    new Target("BenchmarkTest02282", "doPost"),
    new Target("BenchmarkTest02283", "doGet"),
    new Target("BenchmarkTest02283", "doPost"),
    new Target("BenchmarkTest02284", "doGet"),
    new Target("BenchmarkTest02284", "doPost"),
    new Target("BenchmarkTest02285", "doGet"),
    new Target("BenchmarkTest02285", "doPost"),
    new Target("BenchmarkTest02286", "doGet"),
    new Target("BenchmarkTest02286", "doPost"),
    new Target("BenchmarkTest02287", "doGet"),
    new Target("BenchmarkTest02287", "doPost"),
    new Target("BenchmarkTest02288", "doGet"),
    new Target("BenchmarkTest02288", "doPost"),
    new Target("BenchmarkTest02289", "doGet"),
    new Target("BenchmarkTest02289", "doPost"),
    new Target("BenchmarkTest02290", "doGet"),
    new Target("BenchmarkTest02290", "doPost"),
    new Target("BenchmarkTest02291", "doGet"),
    new Target("BenchmarkTest02291", "doPost"),
    new Target("BenchmarkTest02292", "doGet"),
    new Target("BenchmarkTest02292", "doPost"),
    new Target("BenchmarkTest02293", "doGet"),
    new Target("BenchmarkTest02293", "doPost"),
    new Target("BenchmarkTest02294", "doGet"),
    new Target("BenchmarkTest02294", "doPost"),
    new Target("BenchmarkTest02295", "doGet"),
    new Target("BenchmarkTest02295", "doPost"),
    new Target("BenchmarkTest02296", "doGet"),
    new Target("BenchmarkTest02296", "doPost"),
    new Target("BenchmarkTest02297", "doGet"),
    new Target("BenchmarkTest02297", "doPost"),
    new Target("BenchmarkTest02298", "doGet"),
    new Target("BenchmarkTest02298", "doPost"),
    new Target("BenchmarkTest02299", "doGet"),
    new Target("BenchmarkTest02299", "doPost"),
    new Target("BenchmarkTest02300", "doGet"),
    new Target("BenchmarkTest02300", "doPost"),
    new Target("BenchmarkTest02301", "doGet"),
    new Target("BenchmarkTest02301", "doPost"),
    new Target("BenchmarkTest02302", "doGet"),
    new Target("BenchmarkTest02302", "doPost"),
    new Target("BenchmarkTest02303", "doGet"),
    new Target("BenchmarkTest02303", "doPost"),
    new Target("BenchmarkTest02304", "doGet"),
    new Target("BenchmarkTest02304", "doPost"),
    new Target("BenchmarkTest02305", "doGet"),
    new Target("BenchmarkTest02305", "doPost"),
    new Target("BenchmarkTest02306", "doGet"),
    new Target("BenchmarkTest02306", "doPost"),
    new Target("BenchmarkTest02307", "doGet"),
    new Target("BenchmarkTest02307", "doPost"),
    new Target("BenchmarkTest02308", "doGet"),
    new Target("BenchmarkTest02308", "doPost"),
    new Target("BenchmarkTest02309", "doGet"),
    new Target("BenchmarkTest02309", "doPost"),
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
