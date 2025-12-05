package fuzz;
import com.code_intelligence.jazzer.api.*;
import java.lang.reflect.*;
import java.util.*;

public class GeneratedFuzzTest_44 {
  static class Target { final String c, m; Target(String c, String m) { this.c=c; this.m=m; }}
  static Target[] targets = new Target[] {
    new Target("BenchmarkTest02130", "doGet"),
    new Target("BenchmarkTest02130", "doPost"),
    new Target("BenchmarkTest02131", "doGet"),
    new Target("BenchmarkTest02131", "doPost"),
    new Target("BenchmarkTest02132", "doGet"),
    new Target("BenchmarkTest02132", "doPost"),
    new Target("BenchmarkTest02133", "doGet"),
    new Target("BenchmarkTest02133", "doPost"),
    new Target("BenchmarkTest02134", "doGet"),
    new Target("BenchmarkTest02134", "doPost"),
    new Target("BenchmarkTest02135", "doGet"),
    new Target("BenchmarkTest02135", "doPost"),
    new Target("BenchmarkTest02136", "doGet"),
    new Target("BenchmarkTest02136", "doPost"),
    new Target("BenchmarkTest02137", "doGet"),
    new Target("BenchmarkTest02137", "doPost"),
    new Target("BenchmarkTest02138", "doGet"),
    new Target("BenchmarkTest02138", "doPost"),
    new Target("BenchmarkTest02139", "doGet"),
    new Target("BenchmarkTest02139", "doPost"),
    new Target("BenchmarkTest02140", "doGet"),
    new Target("BenchmarkTest02140", "doPost"),
    new Target("BenchmarkTest02141", "doGet"),
    new Target("BenchmarkTest02141", "doPost"),
    new Target("BenchmarkTest02142", "doGet"),
    new Target("BenchmarkTest02142", "doPost"),
    new Target("BenchmarkTest02143", "doGet"),
    new Target("BenchmarkTest02143", "doPost"),
    new Target("BenchmarkTest02144", "doGet"),
    new Target("BenchmarkTest02144", "doPost"),
    new Target("BenchmarkTest02145", "doGet"),
    new Target("BenchmarkTest02145", "doPost"),
    new Target("BenchmarkTest02146", "doGet"),
    new Target("BenchmarkTest02146", "doPost"),
    new Target("BenchmarkTest02147", "doGet"),
    new Target("BenchmarkTest02147", "doPost"),
    new Target("BenchmarkTest02148", "doGet"),
    new Target("BenchmarkTest02148", "doPost"),
    new Target("BenchmarkTest02149", "doGet"),
    new Target("BenchmarkTest02149", "doPost"),
    new Target("BenchmarkTest02150", "doGet"),
    new Target("BenchmarkTest02150", "doPost"),
    new Target("BenchmarkTest02151", "doGet"),
    new Target("BenchmarkTest02151", "doPost"),
    new Target("BenchmarkTest02152", "doGet"),
    new Target("BenchmarkTest02152", "doPost"),
    new Target("BenchmarkTest02153", "doGet"),
    new Target("BenchmarkTest02153", "doPost"),
    new Target("BenchmarkTest02154", "doGet"),
    new Target("BenchmarkTest02154", "doPost"),
    new Target("BenchmarkTest02155", "doGet"),
    new Target("BenchmarkTest02155", "doPost"),
    new Target("BenchmarkTest02156", "doGet"),
    new Target("BenchmarkTest02156", "doPost"),
    new Target("BenchmarkTest02157", "doGet"),
    new Target("BenchmarkTest02157", "doPost"),
    new Target("BenchmarkTest02158", "doGet"),
    new Target("BenchmarkTest02158", "doPost"),
    new Target("BenchmarkTest02159", "doGet"),
    new Target("BenchmarkTest02159", "doPost"),
    new Target("BenchmarkTest02160", "doGet"),
    new Target("BenchmarkTest02160", "doPost"),
    new Target("BenchmarkTest02161", "doGet"),
    new Target("BenchmarkTest02161", "doPost"),
    new Target("BenchmarkTest02162", "doGet"),
    new Target("BenchmarkTest02162", "doPost"),
    new Target("BenchmarkTest02163", "doGet"),
    new Target("BenchmarkTest02163", "doPost"),
    new Target("BenchmarkTest02164", "doGet"),
    new Target("BenchmarkTest02164", "doPost"),
    new Target("BenchmarkTest02165", "doGet"),
    new Target("BenchmarkTest02165", "doPost"),
    new Target("BenchmarkTest02166", "doGet"),
    new Target("BenchmarkTest02166", "doPost"),
    new Target("BenchmarkTest02167", "doGet"),
    new Target("BenchmarkTest02167", "doPost"),
    new Target("BenchmarkTest02168", "doGet"),
    new Target("BenchmarkTest02168", "doPost"),
    new Target("BenchmarkTest02169", "doGet"),
    new Target("BenchmarkTest02169", "doPost"),
    new Target("BenchmarkTest02170", "doGet"),
    new Target("BenchmarkTest02170", "doPost"),
    new Target("BenchmarkTest02171", "doGet"),
    new Target("BenchmarkTest02171", "doPost"),
    new Target("BenchmarkTest02172", "doGet"),
    new Target("BenchmarkTest02172", "doPost"),
    new Target("BenchmarkTest02173", "doGet"),
    new Target("BenchmarkTest02173", "doPost"),
    new Target("BenchmarkTest02174", "doGet"),
    new Target("BenchmarkTest02174", "doPost"),
    new Target("BenchmarkTest02175", "doGet"),
    new Target("BenchmarkTest02175", "doPost"),
    new Target("BenchmarkTest02176", "doGet"),
    new Target("BenchmarkTest02176", "doPost"),
    new Target("BenchmarkTest02177", "doGet"),
    new Target("BenchmarkTest02177", "doPost"),
    new Target("BenchmarkTest02178", "doGet"),
    new Target("BenchmarkTest02178", "doPost"),
    new Target("BenchmarkTest02179", "doGet"),
    new Target("BenchmarkTest02179", "doPost"),
    new Target("BenchmarkTest02180", "doGet"),
    new Target("BenchmarkTest02180", "doPost"),
    new Target("BenchmarkTest02181", "doGet"),
    new Target("BenchmarkTest02181", "doPost"),
    new Target("BenchmarkTest02182", "doGet"),
    new Target("BenchmarkTest02182", "doPost"),
    new Target("BenchmarkTest02183", "doGet"),
    new Target("BenchmarkTest02183", "doPost"),
    new Target("BenchmarkTest02184", "doGet"),
    new Target("BenchmarkTest02184", "doPost"),
    new Target("BenchmarkTest02185", "doGet"),
    new Target("BenchmarkTest02185", "doPost"),
    new Target("BenchmarkTest02186", "doGet"),
    new Target("BenchmarkTest02186", "doPost"),
    new Target("BenchmarkTest02187", "doGet"),
    new Target("BenchmarkTest02187", "doPost"),
    new Target("BenchmarkTest02188", "doGet"),
    new Target("BenchmarkTest02188", "doPost"),
    new Target("BenchmarkTest02189", "doGet"),
    new Target("BenchmarkTest02189", "doPost"),
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
