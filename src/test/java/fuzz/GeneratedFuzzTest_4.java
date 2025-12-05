package fuzz;
import com.code_intelligence.jazzer.api.*;
import java.lang.reflect.*;
import java.util.*;

public class GeneratedFuzzTest_4 {
  static class Target { final String c, m; Target(String c, String m) { this.c=c; this.m=m; }}
  static Target[] targets = new Target[] {
    new Target("BenchmarkTest00170", "doGet"),
    new Target("BenchmarkTest00170", "doPost"),
    new Target("BenchmarkTest00171", "doGet"),
    new Target("BenchmarkTest00171", "doPost"),
    new Target("BenchmarkTest00172", "doGet"),
    new Target("BenchmarkTest00172", "doPost"),
    new Target("BenchmarkTest00173", "doGet"),
    new Target("BenchmarkTest00173", "doPost"),
    new Target("BenchmarkTest00174", "doGet"),
    new Target("BenchmarkTest00174", "doPost"),
    new Target("BenchmarkTest00175", "doGet"),
    new Target("BenchmarkTest00175", "doPost"),
    new Target("BenchmarkTest00176", "doGet"),
    new Target("BenchmarkTest00176", "doPost"),
    new Target("BenchmarkTest00177", "doGet"),
    new Target("BenchmarkTest00177", "doPost"),
    new Target("BenchmarkTest00178", "doGet"),
    new Target("BenchmarkTest00178", "doPost"),
    new Target("BenchmarkTest00179", "doGet"),
    new Target("BenchmarkTest00179", "doPost"),
    new Target("BenchmarkTest00180", "doGet"),
    new Target("BenchmarkTest00180", "doPost"),
    new Target("BenchmarkTest00181", "doGet"),
    new Target("BenchmarkTest00181", "doPost"),
    new Target("BenchmarkTest00182", "doGet"),
    new Target("BenchmarkTest00182", "doPost"),
    new Target("BenchmarkTest00183", "doGet"),
    new Target("BenchmarkTest00183", "doPost"),
    new Target("BenchmarkTest00184", "doGet"),
    new Target("BenchmarkTest00184", "doPost"),
    new Target("BenchmarkTest00185", "doGet"),
    new Target("BenchmarkTest00185", "doPost"),
    new Target("BenchmarkTest00186", "doGet"),
    new Target("BenchmarkTest00186", "doPost"),
    new Target("BenchmarkTest00187", "doGet"),
    new Target("BenchmarkTest00187", "doPost"),
    new Target("BenchmarkTest00188", "doGet"),
    new Target("BenchmarkTest00188", "doPost"),
    new Target("BenchmarkTest00189", "doGet"),
    new Target("BenchmarkTest00189", "doPost"),
    new Target("BenchmarkTest00190", "doGet"),
    new Target("BenchmarkTest00190", "doPost"),
    new Target("BenchmarkTest00191", "doGet"),
    new Target("BenchmarkTest00191", "doPost"),
    new Target("BenchmarkTest00192", "doGet"),
    new Target("BenchmarkTest00192", "doPost"),
    new Target("BenchmarkTest00193", "doGet"),
    new Target("BenchmarkTest00193", "doPost"),
    new Target("BenchmarkTest00194", "doGet"),
    new Target("BenchmarkTest00194", "doPost"),
    new Target("BenchmarkTest00195", "doGet"),
    new Target("BenchmarkTest00195", "doPost"),
    new Target("BenchmarkTest00196", "doGet"),
    new Target("BenchmarkTest00196", "doPost"),
    new Target("BenchmarkTest00197", "doGet"),
    new Target("BenchmarkTest00197", "doPost"),
    new Target("BenchmarkTest00198", "doGet"),
    new Target("BenchmarkTest00198", "doPost"),
    new Target("BenchmarkTest00199", "doGet"),
    new Target("BenchmarkTest00199", "doPost"),
    new Target("BenchmarkTest00200", "doGet"),
    new Target("BenchmarkTest00200", "doPost"),
    new Target("BenchmarkTest00201", "doGet"),
    new Target("BenchmarkTest00201", "doPost"),
    new Target("BenchmarkTest00202", "doGet"),
    new Target("BenchmarkTest00202", "doPost"),
    new Target("BenchmarkTest00203", "doGet"),
    new Target("BenchmarkTest00203", "doPost"),
    new Target("BenchmarkTest00204", "doGet"),
    new Target("BenchmarkTest00204", "doPost"),
    new Target("BenchmarkTest00205", "doGet"),
    new Target("BenchmarkTest00205", "doPost"),
    new Target("BenchmarkTest00206", "doGet"),
    new Target("BenchmarkTest00206", "doPost"),
    new Target("BenchmarkTest00207", "doGet"),
    new Target("BenchmarkTest00207", "doPost"),
    new Target("BenchmarkTest00208", "doGet"),
    new Target("BenchmarkTest00208", "doPost"),
    new Target("BenchmarkTest00209", "doGet"),
    new Target("BenchmarkTest00209", "doPost"),
    new Target("BenchmarkTest00210", "doGet"),
    new Target("BenchmarkTest00210", "doPost"),
    new Target("BenchmarkTest00211", "doGet"),
    new Target("BenchmarkTest00211", "doPost"),
    new Target("BenchmarkTest00212", "doGet"),
    new Target("BenchmarkTest00212", "doPost"),
    new Target("BenchmarkTest00213", "doGet"),
    new Target("BenchmarkTest00213", "doPost"),
    new Target("BenchmarkTest00214", "doGet"),
    new Target("BenchmarkTest00214", "doPost"),
    new Target("BenchmarkTest00215", "doGet"),
    new Target("BenchmarkTest00215", "doPost"),
    new Target("BenchmarkTest00216", "doGet"),
    new Target("BenchmarkTest00216", "doPost"),
    new Target("BenchmarkTest00217", "doGet"),
    new Target("BenchmarkTest00217", "doPost"),
    new Target("BenchmarkTest00218", "doGet"),
    new Target("BenchmarkTest00218", "doPost"),
    new Target("BenchmarkTest00219", "doGet"),
    new Target("BenchmarkTest00219", "doPost"),
    new Target("BenchmarkTest00220", "doGet"),
    new Target("BenchmarkTest00220", "doPost"),
    new Target("BenchmarkTest00221", "doGet"),
    new Target("BenchmarkTest00221", "doPost"),
    new Target("BenchmarkTest00222", "doGet"),
    new Target("BenchmarkTest00222", "doPost"),
    new Target("BenchmarkTest00223", "doGet"),
    new Target("BenchmarkTest00223", "doPost"),
    new Target("BenchmarkTest00224", "doGet"),
    new Target("BenchmarkTest00224", "doPost"),
    new Target("BenchmarkTest00225", "doGet"),
    new Target("BenchmarkTest00225", "doPost"),
    new Target("BenchmarkTest00226", "doGet"),
    new Target("BenchmarkTest00226", "doPost"),
    new Target("BenchmarkTest00227", "doGet"),
    new Target("BenchmarkTest00227", "doPost"),
    new Target("BenchmarkTest00228", "doGet"),
    new Target("BenchmarkTest00228", "doPost"),
    new Target("BenchmarkTest00229", "doGet"),
    new Target("BenchmarkTest00229", "doPost"),
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
