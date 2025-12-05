package fuzz;
import com.code_intelligence.jazzer.api.*;
import java.lang.reflect.*;
import java.util.*;

public class GeneratedFuzzTest_3 {
  static class Target { final String c, m; Target(String c, String m) { this.c=c; this.m=m; }}
  static Target[] targets = new Target[] {
    new Target("BenchmarkTest00110", "doGet"),
    new Target("BenchmarkTest00110", "doPost"),
    new Target("BenchmarkTest00111", "doGet"),
    new Target("BenchmarkTest00111", "doPost"),
    new Target("BenchmarkTest00112", "doGet"),
    new Target("BenchmarkTest00112", "doPost"),
    new Target("BenchmarkTest00113", "doGet"),
    new Target("BenchmarkTest00113", "doPost"),
    new Target("BenchmarkTest00114", "doGet"),
    new Target("BenchmarkTest00114", "doPost"),
    new Target("BenchmarkTest00115", "doGet"),
    new Target("BenchmarkTest00115", "doPost"),
    new Target("BenchmarkTest00116", "doGet"),
    new Target("BenchmarkTest00116", "doPost"),
    new Target("BenchmarkTest00117", "doGet"),
    new Target("BenchmarkTest00117", "doPost"),
    new Target("BenchmarkTest00118", "doGet"),
    new Target("BenchmarkTest00118", "doPost"),
    new Target("BenchmarkTest00119", "doGet"),
    new Target("BenchmarkTest00119", "doPost"),
    new Target("BenchmarkTest00120", "doGet"),
    new Target("BenchmarkTest00120", "doPost"),
    new Target("BenchmarkTest00121", "doGet"),
    new Target("BenchmarkTest00121", "doPost"),
    new Target("BenchmarkTest00122", "doGet"),
    new Target("BenchmarkTest00122", "doPost"),
    new Target("BenchmarkTest00123", "doGet"),
    new Target("BenchmarkTest00123", "doPost"),
    new Target("BenchmarkTest00124", "doGet"),
    new Target("BenchmarkTest00124", "doPost"),
    new Target("BenchmarkTest00125", "doGet"),
    new Target("BenchmarkTest00125", "doPost"),
    new Target("BenchmarkTest00126", "doGet"),
    new Target("BenchmarkTest00126", "doPost"),
    new Target("BenchmarkTest00127", "doGet"),
    new Target("BenchmarkTest00127", "doPost"),
    new Target("BenchmarkTest00128", "doGet"),
    new Target("BenchmarkTest00128", "doPost"),
    new Target("BenchmarkTest00129", "doGet"),
    new Target("BenchmarkTest00129", "doPost"),
    new Target("BenchmarkTest00130", "doGet"),
    new Target("BenchmarkTest00130", "doPost"),
    new Target("BenchmarkTest00131", "doGet"),
    new Target("BenchmarkTest00131", "doPost"),
    new Target("BenchmarkTest00132", "doGet"),
    new Target("BenchmarkTest00132", "doPost"),
    new Target("BenchmarkTest00133", "doGet"),
    new Target("BenchmarkTest00133", "doPost"),
    new Target("BenchmarkTest00134", "doGet"),
    new Target("BenchmarkTest00134", "doPost"),
    new Target("BenchmarkTest00135", "doGet"),
    new Target("BenchmarkTest00135", "doPost"),
    new Target("BenchmarkTest00136", "doGet"),
    new Target("BenchmarkTest00136", "doPost"),
    new Target("BenchmarkTest00137", "doGet"),
    new Target("BenchmarkTest00137", "doPost"),
    new Target("BenchmarkTest00138", "doGet"),
    new Target("BenchmarkTest00138", "doPost"),
    new Target("BenchmarkTest00139", "doGet"),
    new Target("BenchmarkTest00139", "doPost"),
    new Target("BenchmarkTest00140", "doGet"),
    new Target("BenchmarkTest00140", "doPost"),
    new Target("BenchmarkTest00141", "doGet"),
    new Target("BenchmarkTest00141", "doPost"),
    new Target("BenchmarkTest00142", "doGet"),
    new Target("BenchmarkTest00142", "doPost"),
    new Target("BenchmarkTest00143", "doGet"),
    new Target("BenchmarkTest00143", "doPost"),
    new Target("BenchmarkTest00144", "doGet"),
    new Target("BenchmarkTest00144", "doPost"),
    new Target("BenchmarkTest00145", "doGet"),
    new Target("BenchmarkTest00145", "doPost"),
    new Target("BenchmarkTest00146", "doGet"),
    new Target("BenchmarkTest00146", "doPost"),
    new Target("BenchmarkTest00147", "doGet"),
    new Target("BenchmarkTest00147", "doPost"),
    new Target("BenchmarkTest00148", "doGet"),
    new Target("BenchmarkTest00148", "doPost"),
    new Target("BenchmarkTest00149", "doGet"),
    new Target("BenchmarkTest00149", "doPost"),
    new Target("BenchmarkTest00150", "doGet"),
    new Target("BenchmarkTest00150", "doPost"),
    new Target("BenchmarkTest00151", "doGet"),
    new Target("BenchmarkTest00151", "doPost"),
    new Target("BenchmarkTest00152", "doGet"),
    new Target("BenchmarkTest00152", "doPost"),
    new Target("BenchmarkTest00153", "doGet"),
    new Target("BenchmarkTest00153", "doPost"),
    new Target("BenchmarkTest00154", "doGet"),
    new Target("BenchmarkTest00154", "doPost"),
    new Target("BenchmarkTest00155", "doGet"),
    new Target("BenchmarkTest00155", "doPost"),
    new Target("BenchmarkTest00156", "doGet"),
    new Target("BenchmarkTest00156", "doPost"),
    new Target("BenchmarkTest00157", "doGet"),
    new Target("BenchmarkTest00157", "doPost"),
    new Target("BenchmarkTest00158", "doGet"),
    new Target("BenchmarkTest00158", "doPost"),
    new Target("BenchmarkTest00159", "doGet"),
    new Target("BenchmarkTest00159", "doPost"),
    new Target("BenchmarkTest00160", "doGet"),
    new Target("BenchmarkTest00160", "doPost"),
    new Target("BenchmarkTest00161", "doGet"),
    new Target("BenchmarkTest00161", "doPost"),
    new Target("BenchmarkTest00162", "doGet"),
    new Target("BenchmarkTest00162", "doPost"),
    new Target("BenchmarkTest00163", "doGet"),
    new Target("BenchmarkTest00163", "doPost"),
    new Target("BenchmarkTest00164", "doGet"),
    new Target("BenchmarkTest00164", "doPost"),
    new Target("BenchmarkTest00165", "doGet"),
    new Target("BenchmarkTest00165", "doPost"),
    new Target("BenchmarkTest00166", "doGet"),
    new Target("BenchmarkTest00166", "doPost"),
    new Target("BenchmarkTest00167", "doGet"),
    new Target("BenchmarkTest00167", "doPost"),
    new Target("BenchmarkTest00168", "doGet"),
    new Target("BenchmarkTest00168", "doPost"),
    new Target("BenchmarkTest00169", "doGet"),
    new Target("BenchmarkTest00169", "doPost"),
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
