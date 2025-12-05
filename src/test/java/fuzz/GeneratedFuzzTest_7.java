package fuzz;
import com.code_intelligence.jazzer.api.*;
import java.lang.reflect.*;
import java.util.*;

public class GeneratedFuzzTest_7 {
  static class Target { final String c, m; Target(String c, String m) { this.c=c; this.m=m; }}
  static Target[] targets = new Target[] {
    new Target("BenchmarkTest00350", "doGet"),
    new Target("BenchmarkTest00350", "doPost"),
    new Target("BenchmarkTest00351", "doGet"),
    new Target("BenchmarkTest00351", "doPost"),
    new Target("BenchmarkTest00352", "doGet"),
    new Target("BenchmarkTest00352", "doPost"),
    new Target("BenchmarkTest00353", "doGet"),
    new Target("BenchmarkTest00353", "doPost"),
    new Target("BenchmarkTest00354", "doGet"),
    new Target("BenchmarkTest00354", "doPost"),
    new Target("BenchmarkTest00355", "doGet"),
    new Target("BenchmarkTest00355", "doPost"),
    new Target("BenchmarkTest00356", "doGet"),
    new Target("BenchmarkTest00356", "doPost"),
    new Target("BenchmarkTest00357", "doGet"),
    new Target("BenchmarkTest00357", "doPost"),
    new Target("BenchmarkTest00358", "doGet"),
    new Target("BenchmarkTest00358", "doPost"),
    new Target("BenchmarkTest00359", "doGet"),
    new Target("BenchmarkTest00359", "doPost"),
    new Target("BenchmarkTest00360", "doGet"),
    new Target("BenchmarkTest00360", "doPost"),
    new Target("BenchmarkTest00361", "doGet"),
    new Target("BenchmarkTest00361", "doPost"),
    new Target("BenchmarkTest00362", "doGet"),
    new Target("BenchmarkTest00362", "doPost"),
    new Target("BenchmarkTest00363", "doGet"),
    new Target("BenchmarkTest00363", "doPost"),
    new Target("BenchmarkTest00364", "doGet"),
    new Target("BenchmarkTest00364", "doPost"),
    new Target("BenchmarkTest00365", "doGet"),
    new Target("BenchmarkTest00365", "doPost"),
    new Target("BenchmarkTest00366", "doGet"),
    new Target("BenchmarkTest00366", "doPost"),
    new Target("BenchmarkTest00367", "doGet"),
    new Target("BenchmarkTest00367", "doPost"),
    new Target("BenchmarkTest00368", "doGet"),
    new Target("BenchmarkTest00368", "doPost"),
    new Target("BenchmarkTest00369", "doGet"),
    new Target("BenchmarkTest00369", "doPost"),
    new Target("BenchmarkTest00370", "doGet"),
    new Target("BenchmarkTest00370", "doPost"),
    new Target("BenchmarkTest00371", "doGet"),
    new Target("BenchmarkTest00371", "doPost"),
    new Target("BenchmarkTest00372", "doGet"),
    new Target("BenchmarkTest00372", "doPost"),
    new Target("BenchmarkTest00373", "doGet"),
    new Target("BenchmarkTest00373", "doPost"),
    new Target("BenchmarkTest00374", "doGet"),
    new Target("BenchmarkTest00374", "doPost"),
    new Target("BenchmarkTest00375", "doGet"),
    new Target("BenchmarkTest00375", "doPost"),
    new Target("BenchmarkTest00376", "doGet"),
    new Target("BenchmarkTest00376", "doPost"),
    new Target("BenchmarkTest00377", "doGet"),
    new Target("BenchmarkTest00377", "doPost"),
    new Target("BenchmarkTest00378", "doGet"),
    new Target("BenchmarkTest00378", "doPost"),
    new Target("BenchmarkTest00379", "doGet"),
    new Target("BenchmarkTest00379", "doPost"),
    new Target("BenchmarkTest00380", "doGet"),
    new Target("BenchmarkTest00380", "doPost"),
    new Target("BenchmarkTest00381", "doGet"),
    new Target("BenchmarkTest00381", "doPost"),
    new Target("BenchmarkTest00382", "doGet"),
    new Target("BenchmarkTest00382", "doPost"),
    new Target("BenchmarkTest00383", "doGet"),
    new Target("BenchmarkTest00383", "doPost"),
    new Target("BenchmarkTest00384", "doGet"),
    new Target("BenchmarkTest00384", "doPost"),
    new Target("BenchmarkTest00385", "doGet"),
    new Target("BenchmarkTest00385", "doPost"),
    new Target("BenchmarkTest00386", "doGet"),
    new Target("BenchmarkTest00386", "doPost"),
    new Target("BenchmarkTest00387", "doGet"),
    new Target("BenchmarkTest00387", "doPost"),
    new Target("BenchmarkTest00388", "doGet"),
    new Target("BenchmarkTest00388", "doPost"),
    new Target("BenchmarkTest00389", "doGet"),
    new Target("BenchmarkTest00389", "doPost"),
    new Target("BenchmarkTest00390", "doGet"),
    new Target("BenchmarkTest00390", "doPost"),
    new Target("BenchmarkTest00391", "doGet"),
    new Target("BenchmarkTest00391", "doPost"),
    new Target("BenchmarkTest00392", "doGet"),
    new Target("BenchmarkTest00392", "doPost"),
    new Target("BenchmarkTest00393", "doGet"),
    new Target("BenchmarkTest00393", "doPost"),
    new Target("BenchmarkTest00394", "doGet"),
    new Target("BenchmarkTest00394", "doPost"),
    new Target("BenchmarkTest00395", "doGet"),
    new Target("BenchmarkTest00395", "doPost"),
    new Target("BenchmarkTest00396", "doGet"),
    new Target("BenchmarkTest00396", "doPost"),
    new Target("BenchmarkTest00397", "doGet"),
    new Target("BenchmarkTest00397", "doPost"),
    new Target("BenchmarkTest00398", "doGet"),
    new Target("BenchmarkTest00398", "doPost"),
    new Target("BenchmarkTest00399", "doGet"),
    new Target("BenchmarkTest00399", "doPost"),
    new Target("BenchmarkTest00400", "doGet"),
    new Target("BenchmarkTest00400", "doPost"),
    new Target("BenchmarkTest00401", "doGet"),
    new Target("BenchmarkTest00401", "doPost"),
    new Target("BenchmarkTest00402", "doGet"),
    new Target("BenchmarkTest00402", "doPost"),
    new Target("BenchmarkTest00403", "doGet"),
    new Target("BenchmarkTest00403", "doPost"),
    new Target("BenchmarkTest00404", "doGet"),
    new Target("BenchmarkTest00404", "doPost"),
    new Target("BenchmarkTest00405", "doGet"),
    new Target("BenchmarkTest00405", "doPost"),
    new Target("BenchmarkTest00406", "doGet"),
    new Target("BenchmarkTest00406", "doPost"),
    new Target("BenchmarkTest00407", "doGet"),
    new Target("BenchmarkTest00407", "doPost"),
    new Target("BenchmarkTest00408", "doGet"),
    new Target("BenchmarkTest00408", "doPost"),
    new Target("BenchmarkTest00409", "doGet"),
    new Target("BenchmarkTest00409", "doPost"),
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
