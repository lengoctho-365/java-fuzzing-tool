package fuzz;
import com.code_intelligence.jazzer.api.*;
import java.lang.reflect.*;
import java.util.*;

public class GeneratedFuzzTest_9 {
  static class Target { final String c, m; Target(String c, String m) { this.c=c; this.m=m; }}
  static Target[] targets = new Target[] {
    new Target("BenchmarkTest00470", "doGet"),
    new Target("BenchmarkTest00470", "doPost"),
    new Target("BenchmarkTest00471", "doGet"),
    new Target("BenchmarkTest00471", "doPost"),
    new Target("BenchmarkTest00472", "doGet"),
    new Target("BenchmarkTest00472", "doPost"),
    new Target("BenchmarkTest00473", "doGet"),
    new Target("BenchmarkTest00473", "doPost"),
    new Target("BenchmarkTest00474", "doGet"),
    new Target("BenchmarkTest00474", "doPost"),
    new Target("BenchmarkTest00475", "doGet"),
    new Target("BenchmarkTest00475", "doPost"),
    new Target("BenchmarkTest00476", "doGet"),
    new Target("BenchmarkTest00476", "doPost"),
    new Target("BenchmarkTest00477", "doGet"),
    new Target("BenchmarkTest00477", "doPost"),
    new Target("BenchmarkTest00478", "doGet"),
    new Target("BenchmarkTest00478", "doPost"),
    new Target("BenchmarkTest00479", "doGet"),
    new Target("BenchmarkTest00479", "doPost"),
    new Target("BenchmarkTest00480", "doGet"),
    new Target("BenchmarkTest00480", "doPost"),
    new Target("BenchmarkTest00481", "doGet"),
    new Target("BenchmarkTest00481", "doPost"),
    new Target("BenchmarkTest00482", "doGet"),
    new Target("BenchmarkTest00482", "doPost"),
    new Target("BenchmarkTest00483", "doGet"),
    new Target("BenchmarkTest00483", "doPost"),
    new Target("BenchmarkTest00484", "doGet"),
    new Target("BenchmarkTest00484", "doPost"),
    new Target("BenchmarkTest00485", "doGet"),
    new Target("BenchmarkTest00485", "doPost"),
    new Target("BenchmarkTest00486", "doGet"),
    new Target("BenchmarkTest00486", "doPost"),
    new Target("BenchmarkTest00487", "doGet"),
    new Target("BenchmarkTest00487", "doPost"),
    new Target("BenchmarkTest00488", "doGet"),
    new Target("BenchmarkTest00488", "doPost"),
    new Target("BenchmarkTest00489", "doGet"),
    new Target("BenchmarkTest00489", "doPost"),
    new Target("BenchmarkTest00490", "doGet"),
    new Target("BenchmarkTest00490", "doPost"),
    new Target("BenchmarkTest00491", "doGet"),
    new Target("BenchmarkTest00491", "doPost"),
    new Target("BenchmarkTest00492", "doGet"),
    new Target("BenchmarkTest00492", "doPost"),
    new Target("BenchmarkTest00493", "doGet"),
    new Target("BenchmarkTest00493", "doPost"),
    new Target("BenchmarkTest00494", "doGet"),
    new Target("BenchmarkTest00494", "doPost"),
    new Target("BenchmarkTest00495", "doGet"),
    new Target("BenchmarkTest00495", "doPost"),
    new Target("BenchmarkTest00496", "doGet"),
    new Target("BenchmarkTest00496", "doPost"),
    new Target("BenchmarkTest00497", "doGet"),
    new Target("BenchmarkTest00497", "doPost"),
    new Target("BenchmarkTest00498", "doGet"),
    new Target("BenchmarkTest00498", "doPost"),
    new Target("BenchmarkTest00499", "doGet"),
    new Target("BenchmarkTest00499", "doPost"),
    new Target("BenchmarkTest00500", "doGet"),
    new Target("BenchmarkTest00500", "doPost"),
    new Target("BenchmarkTest00501", "doGet"),
    new Target("BenchmarkTest00501", "doPost"),
    new Target("BenchmarkTest00502", "doGet"),
    new Target("BenchmarkTest00502", "doPost"),
    new Target("BenchmarkTest00503", "doGet"),
    new Target("BenchmarkTest00503", "doPost"),
    new Target("BenchmarkTest00504", "doGet"),
    new Target("BenchmarkTest00504", "doPost"),
    new Target("BenchmarkTest00505", "doGet"),
    new Target("BenchmarkTest00505", "doPost"),
    new Target("BenchmarkTest00506", "doGet"),
    new Target("BenchmarkTest00506", "doPost"),
    new Target("BenchmarkTest00507", "doGet"),
    new Target("BenchmarkTest00507", "doPost"),
    new Target("BenchmarkTest00508", "doGet"),
    new Target("BenchmarkTest00508", "doPost"),
    new Target("BenchmarkTest00509", "doGet"),
    new Target("BenchmarkTest00509", "doPost"),
    new Target("BenchmarkTest00510", "doGet"),
    new Target("BenchmarkTest00510", "doPost"),
    new Target("BenchmarkTest00511", "doGet"),
    new Target("BenchmarkTest00511", "doPost"),
    new Target("BenchmarkTest00512", "doGet"),
    new Target("BenchmarkTest00512", "doPost"),
    new Target("BenchmarkTest00513", "doGet"),
    new Target("BenchmarkTest00513", "doPost"),
    new Target("BenchmarkTest00514", "doGet"),
    new Target("BenchmarkTest00514", "doPost"),
    new Target("BenchmarkTest00515", "doGet"),
    new Target("BenchmarkTest00515", "doPost"),
    new Target("BenchmarkTest00516", "doGet"),
    new Target("BenchmarkTest00516", "doPost"),
    new Target("BenchmarkTest00517", "doGet"),
    new Target("BenchmarkTest00517", "doPost"),
    new Target("BenchmarkTest00518", "doGet"),
    new Target("BenchmarkTest00518", "doPost"),
    new Target("BenchmarkTest00519", "doGet"),
    new Target("BenchmarkTest00519", "doPost"),
    new Target("BenchmarkTest00520", "doGet"),
    new Target("BenchmarkTest00520", "doPost"),
    new Target("BenchmarkTest00521", "doGet"),
    new Target("BenchmarkTest00521", "doPost"),
    new Target("BenchmarkTest00522", "doGet"),
    new Target("BenchmarkTest00522", "doPost"),
    new Target("BenchmarkTest00523", "doGet"),
    new Target("BenchmarkTest00523", "doPost"),
    new Target("BenchmarkTest00524", "doGet"),
    new Target("BenchmarkTest00524", "doPost"),
    new Target("BenchmarkTest00525", "doGet"),
    new Target("BenchmarkTest00525", "doPost"),
    new Target("BenchmarkTest00526", "doGet"),
    new Target("BenchmarkTest00526", "doPost"),
    new Target("BenchmarkTest00527", "doGet"),
    new Target("BenchmarkTest00527", "doPost"),
    new Target("BenchmarkTest00528", "doGet"),
    new Target("BenchmarkTest00528", "doPost"),
    new Target("BenchmarkTest00529", "doGet"),
    new Target("BenchmarkTest00529", "doPost"),
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
