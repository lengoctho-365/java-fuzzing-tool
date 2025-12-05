package fuzz;
import com.code_intelligence.jazzer.api.*;
import java.lang.reflect.*;
import java.util.*;

public class GeneratedFuzzTest_45 {
  static class Target { final String c, m; Target(String c, String m) { this.c=c; this.m=m; }}
  static Target[] targets = new Target[] {
    new Target("BenchmarkTest02190", "doGet"),
    new Target("BenchmarkTest02190", "doPost"),
    new Target("BenchmarkTest02191", "doGet"),
    new Target("BenchmarkTest02191", "doPost"),
    new Target("BenchmarkTest02192", "doGet"),
    new Target("BenchmarkTest02192", "doPost"),
    new Target("BenchmarkTest02193", "doGet"),
    new Target("BenchmarkTest02193", "doPost"),
    new Target("BenchmarkTest02194", "doGet"),
    new Target("BenchmarkTest02194", "doPost"),
    new Target("BenchmarkTest02195", "doGet"),
    new Target("BenchmarkTest02195", "doPost"),
    new Target("BenchmarkTest02196", "doGet"),
    new Target("BenchmarkTest02196", "doPost"),
    new Target("BenchmarkTest02197", "doGet"),
    new Target("BenchmarkTest02197", "doPost"),
    new Target("BenchmarkTest02198", "doGet"),
    new Target("BenchmarkTest02198", "doPost"),
    new Target("BenchmarkTest02199", "doGet"),
    new Target("BenchmarkTest02199", "doPost"),
    new Target("BenchmarkTest02200", "doGet"),
    new Target("BenchmarkTest02200", "doPost"),
    new Target("BenchmarkTest02201", "doGet"),
    new Target("BenchmarkTest02201", "doPost"),
    new Target("BenchmarkTest02202", "doGet"),
    new Target("BenchmarkTest02202", "doPost"),
    new Target("BenchmarkTest02203", "doGet"),
    new Target("BenchmarkTest02203", "doPost"),
    new Target("BenchmarkTest02204", "doGet"),
    new Target("BenchmarkTest02204", "doPost"),
    new Target("BenchmarkTest02205", "doGet"),
    new Target("BenchmarkTest02205", "doPost"),
    new Target("BenchmarkTest02206", "doGet"),
    new Target("BenchmarkTest02206", "doPost"),
    new Target("BenchmarkTest02207", "doGet"),
    new Target("BenchmarkTest02207", "doPost"),
    new Target("BenchmarkTest02208", "doGet"),
    new Target("BenchmarkTest02208", "doPost"),
    new Target("BenchmarkTest02209", "doGet"),
    new Target("BenchmarkTest02209", "doPost"),
    new Target("BenchmarkTest02210", "doGet"),
    new Target("BenchmarkTest02210", "doPost"),
    new Target("BenchmarkTest02211", "doGet"),
    new Target("BenchmarkTest02211", "doPost"),
    new Target("BenchmarkTest02212", "doGet"),
    new Target("BenchmarkTest02212", "doPost"),
    new Target("BenchmarkTest02213", "doGet"),
    new Target("BenchmarkTest02213", "doPost"),
    new Target("BenchmarkTest02214", "doGet"),
    new Target("BenchmarkTest02214", "doPost"),
    new Target("BenchmarkTest02215", "doGet"),
    new Target("BenchmarkTest02215", "doPost"),
    new Target("BenchmarkTest02216", "doGet"),
    new Target("BenchmarkTest02216", "doPost"),
    new Target("BenchmarkTest02217", "doGet"),
    new Target("BenchmarkTest02217", "doPost"),
    new Target("BenchmarkTest02218", "doGet"),
    new Target("BenchmarkTest02218", "doPost"),
    new Target("BenchmarkTest02219", "doGet"),
    new Target("BenchmarkTest02219", "doPost"),
    new Target("BenchmarkTest02220", "doGet"),
    new Target("BenchmarkTest02220", "doPost"),
    new Target("BenchmarkTest02221", "doGet"),
    new Target("BenchmarkTest02221", "doPost"),
    new Target("BenchmarkTest02222", "doGet"),
    new Target("BenchmarkTest02222", "doPost"),
    new Target("BenchmarkTest02223", "doGet"),
    new Target("BenchmarkTest02223", "doPost"),
    new Target("BenchmarkTest02224", "doGet"),
    new Target("BenchmarkTest02224", "doPost"),
    new Target("BenchmarkTest02225", "doGet"),
    new Target("BenchmarkTest02225", "doPost"),
    new Target("BenchmarkTest02226", "doGet"),
    new Target("BenchmarkTest02226", "doPost"),
    new Target("BenchmarkTest02227", "doGet"),
    new Target("BenchmarkTest02227", "doPost"),
    new Target("BenchmarkTest02228", "doGet"),
    new Target("BenchmarkTest02228", "doPost"),
    new Target("BenchmarkTest02229", "doGet"),
    new Target("BenchmarkTest02229", "doPost"),
    new Target("BenchmarkTest02230", "doGet"),
    new Target("BenchmarkTest02230", "doPost"),
    new Target("BenchmarkTest02231", "doGet"),
    new Target("BenchmarkTest02231", "doPost"),
    new Target("BenchmarkTest02232", "doGet"),
    new Target("BenchmarkTest02232", "doPost"),
    new Target("BenchmarkTest02233", "doGet"),
    new Target("BenchmarkTest02233", "doPost"),
    new Target("BenchmarkTest02234", "doGet"),
    new Target("BenchmarkTest02234", "doPost"),
    new Target("BenchmarkTest02235", "doGet"),
    new Target("BenchmarkTest02235", "doPost"),
    new Target("BenchmarkTest02236", "doGet"),
    new Target("BenchmarkTest02236", "doPost"),
    new Target("BenchmarkTest02237", "doGet"),
    new Target("BenchmarkTest02237", "doPost"),
    new Target("BenchmarkTest02238", "doGet"),
    new Target("BenchmarkTest02238", "doPost"),
    new Target("BenchmarkTest02239", "doGet"),
    new Target("BenchmarkTest02239", "doPost"),
    new Target("BenchmarkTest02240", "doGet"),
    new Target("BenchmarkTest02240", "doPost"),
    new Target("BenchmarkTest02241", "doGet"),
    new Target("BenchmarkTest02241", "doPost"),
    new Target("BenchmarkTest02242", "doGet"),
    new Target("BenchmarkTest02242", "doPost"),
    new Target("BenchmarkTest02243", "doGet"),
    new Target("BenchmarkTest02243", "doPost"),
    new Target("BenchmarkTest02244", "doGet"),
    new Target("BenchmarkTest02244", "doPost"),
    new Target("BenchmarkTest02245", "doGet"),
    new Target("BenchmarkTest02245", "doPost"),
    new Target("BenchmarkTest02246", "doGet"),
    new Target("BenchmarkTest02246", "doPost"),
    new Target("BenchmarkTest02247", "doGet"),
    new Target("BenchmarkTest02247", "doPost"),
    new Target("BenchmarkTest02248", "doGet"),
    new Target("BenchmarkTest02248", "doPost"),
    new Target("BenchmarkTest02249", "doGet"),
    new Target("BenchmarkTest02249", "doPost"),
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
