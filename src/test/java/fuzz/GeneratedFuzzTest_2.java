package fuzz;
import com.code_intelligence.jazzer.api.*;
import java.lang.reflect.*;
import java.util.*;

public class GeneratedFuzzTest_2 {
  static class Target { final String c, m; Target(String c, String m) { this.c=c; this.m=m; }}
  static Target[] targets = new Target[] {
    new Target("BenchmarkTest00050", "doGet"),
    new Target("BenchmarkTest00050", "doPost"),
    new Target("BenchmarkTest00051", "doGet"),
    new Target("BenchmarkTest00051", "doPost"),
    new Target("BenchmarkTest00052", "doGet"),
    new Target("BenchmarkTest00052", "doPost"),
    new Target("BenchmarkTest00053", "doGet"),
    new Target("BenchmarkTest00053", "doPost"),
    new Target("BenchmarkTest00054", "doGet"),
    new Target("BenchmarkTest00054", "doPost"),
    new Target("BenchmarkTest00055", "doGet"),
    new Target("BenchmarkTest00055", "doPost"),
    new Target("BenchmarkTest00056", "doGet"),
    new Target("BenchmarkTest00056", "doPost"),
    new Target("BenchmarkTest00057", "doGet"),
    new Target("BenchmarkTest00057", "doPost"),
    new Target("BenchmarkTest00058", "doGet"),
    new Target("BenchmarkTest00058", "doPost"),
    new Target("BenchmarkTest00059", "doGet"),
    new Target("BenchmarkTest00059", "doPost"),
    new Target("BenchmarkTest00060", "doGet"),
    new Target("BenchmarkTest00060", "doPost"),
    new Target("BenchmarkTest00061", "doGet"),
    new Target("BenchmarkTest00061", "doPost"),
    new Target("BenchmarkTest00062", "doGet"),
    new Target("BenchmarkTest00062", "doPost"),
    new Target("BenchmarkTest00063", "doGet"),
    new Target("BenchmarkTest00063", "doPost"),
    new Target("BenchmarkTest00064", "doGet"),
    new Target("BenchmarkTest00064", "doPost"),
    new Target("BenchmarkTest00065", "doGet"),
    new Target("BenchmarkTest00065", "doPost"),
    new Target("BenchmarkTest00066", "doGet"),
    new Target("BenchmarkTest00066", "doPost"),
    new Target("BenchmarkTest00067", "doGet"),
    new Target("BenchmarkTest00067", "doPost"),
    new Target("BenchmarkTest00068", "doGet"),
    new Target("BenchmarkTest00068", "doPost"),
    new Target("BenchmarkTest00069", "doGet"),
    new Target("BenchmarkTest00069", "doPost"),
    new Target("BenchmarkTest00070", "doGet"),
    new Target("BenchmarkTest00070", "doPost"),
    new Target("BenchmarkTest00071", "doGet"),
    new Target("BenchmarkTest00071", "doPost"),
    new Target("BenchmarkTest00072", "doGet"),
    new Target("BenchmarkTest00072", "doPost"),
    new Target("BenchmarkTest00073", "doGet"),
    new Target("BenchmarkTest00073", "doPost"),
    new Target("BenchmarkTest00074", "doGet"),
    new Target("BenchmarkTest00074", "doPost"),
    new Target("BenchmarkTest00075", "doGet"),
    new Target("BenchmarkTest00075", "doPost"),
    new Target("BenchmarkTest00076", "doGet"),
    new Target("BenchmarkTest00076", "doPost"),
    new Target("BenchmarkTest00077", "doGet"),
    new Target("BenchmarkTest00077", "doPost"),
    new Target("BenchmarkTest00078", "doGet"),
    new Target("BenchmarkTest00078", "doPost"),
    new Target("BenchmarkTest00079", "doGet"),
    new Target("BenchmarkTest00079", "doPost"),
    new Target("BenchmarkTest00080", "doGet"),
    new Target("BenchmarkTest00080", "doPost"),
    new Target("BenchmarkTest00081", "doGet"),
    new Target("BenchmarkTest00081", "doPost"),
    new Target("BenchmarkTest00082", "doGet"),
    new Target("BenchmarkTest00082", "doPost"),
    new Target("BenchmarkTest00083", "doGet"),
    new Target("BenchmarkTest00083", "doPost"),
    new Target("BenchmarkTest00084", "doGet"),
    new Target("BenchmarkTest00084", "doPost"),
    new Target("BenchmarkTest00085", "doGet"),
    new Target("BenchmarkTest00085", "doPost"),
    new Target("BenchmarkTest00086", "doGet"),
    new Target("BenchmarkTest00086", "doPost"),
    new Target("BenchmarkTest00087", "doGet"),
    new Target("BenchmarkTest00087", "doPost"),
    new Target("BenchmarkTest00088", "doGet"),
    new Target("BenchmarkTest00088", "doPost"),
    new Target("BenchmarkTest00089", "doGet"),
    new Target("BenchmarkTest00089", "doPost"),
    new Target("BenchmarkTest00090", "doGet"),
    new Target("BenchmarkTest00090", "doPost"),
    new Target("BenchmarkTest00091", "doGet"),
    new Target("BenchmarkTest00091", "doPost"),
    new Target("BenchmarkTest00092", "doGet"),
    new Target("BenchmarkTest00092", "doPost"),
    new Target("BenchmarkTest00093", "doGet"),
    new Target("BenchmarkTest00093", "doPost"),
    new Target("BenchmarkTest00094", "doGet"),
    new Target("BenchmarkTest00094", "doPost"),
    new Target("BenchmarkTest00095", "doGet"),
    new Target("BenchmarkTest00095", "doPost"),
    new Target("BenchmarkTest00096", "doGet"),
    new Target("BenchmarkTest00096", "doPost"),
    new Target("BenchmarkTest00097", "doGet"),
    new Target("BenchmarkTest00097", "doPost"),
    new Target("BenchmarkTest00098", "doGet"),
    new Target("BenchmarkTest00098", "doPost"),
    new Target("BenchmarkTest00099", "doGet"),
    new Target("BenchmarkTest00099", "doPost"),
    new Target("BenchmarkTest00100", "doGet"),
    new Target("BenchmarkTest00100", "doPost"),
    new Target("BenchmarkTest00101", "doGet"),
    new Target("BenchmarkTest00101", "doPost"),
    new Target("BenchmarkTest00102", "doGet"),
    new Target("BenchmarkTest00102", "doPost"),
    new Target("BenchmarkTest00103", "doGet"),
    new Target("BenchmarkTest00103", "doPost"),
    new Target("BenchmarkTest00104", "doGet"),
    new Target("BenchmarkTest00104", "doPost"),
    new Target("BenchmarkTest00105", "doGet"),
    new Target("BenchmarkTest00105", "doPost"),
    new Target("BenchmarkTest00106", "doGet"),
    new Target("BenchmarkTest00106", "doPost"),
    new Target("BenchmarkTest00107", "doGet"),
    new Target("BenchmarkTest00107", "doPost"),
    new Target("BenchmarkTest00108", "doGet"),
    new Target("BenchmarkTest00108", "doPost"),
    new Target("BenchmarkTest00109", "doGet"),
    new Target("BenchmarkTest00109", "doPost"),
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
