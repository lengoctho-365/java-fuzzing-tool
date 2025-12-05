package fuzz;
import com.code_intelligence.jazzer.api.*;
import java.lang.reflect.*;
import java.util.*;

public class GeneratedFuzzTest_6 {
  static class Target { final String c, m; Target(String c, String m) { this.c=c; this.m=m; }}
  static Target[] targets = new Target[] {
    new Target("BenchmarkTest00290", "doGet"),
    new Target("BenchmarkTest00290", "doPost"),
    new Target("BenchmarkTest00291", "doGet"),
    new Target("BenchmarkTest00291", "doPost"),
    new Target("BenchmarkTest00292", "doGet"),
    new Target("BenchmarkTest00292", "doPost"),
    new Target("BenchmarkTest00293", "doGet"),
    new Target("BenchmarkTest00293", "doPost"),
    new Target("BenchmarkTest00294", "doGet"),
    new Target("BenchmarkTest00294", "doPost"),
    new Target("BenchmarkTest00295", "doGet"),
    new Target("BenchmarkTest00295", "doPost"),
    new Target("BenchmarkTest00296", "doGet"),
    new Target("BenchmarkTest00296", "doPost"),
    new Target("BenchmarkTest00297", "doGet"),
    new Target("BenchmarkTest00297", "doPost"),
    new Target("BenchmarkTest00298", "doGet"),
    new Target("BenchmarkTest00298", "doPost"),
    new Target("BenchmarkTest00299", "doGet"),
    new Target("BenchmarkTest00299", "doPost"),
    new Target("BenchmarkTest00300", "doGet"),
    new Target("BenchmarkTest00300", "doPost"),
    new Target("BenchmarkTest00301", "doGet"),
    new Target("BenchmarkTest00301", "doPost"),
    new Target("BenchmarkTest00302", "doGet"),
    new Target("BenchmarkTest00302", "doPost"),
    new Target("BenchmarkTest00303", "doGet"),
    new Target("BenchmarkTest00303", "doPost"),
    new Target("BenchmarkTest00304", "doGet"),
    new Target("BenchmarkTest00304", "doPost"),
    new Target("BenchmarkTest00305", "doGet"),
    new Target("BenchmarkTest00305", "doPost"),
    new Target("BenchmarkTest00306", "doGet"),
    new Target("BenchmarkTest00306", "doPost"),
    new Target("BenchmarkTest00307", "doGet"),
    new Target("BenchmarkTest00307", "doPost"),
    new Target("BenchmarkTest00308", "doGet"),
    new Target("BenchmarkTest00308", "doPost"),
    new Target("BenchmarkTest00309", "doGet"),
    new Target("BenchmarkTest00309", "doPost"),
    new Target("BenchmarkTest00310", "doGet"),
    new Target("BenchmarkTest00310", "doPost"),
    new Target("BenchmarkTest00311", "doGet"),
    new Target("BenchmarkTest00311", "doPost"),
    new Target("BenchmarkTest00312", "doGet"),
    new Target("BenchmarkTest00312", "doPost"),
    new Target("BenchmarkTest00313", "doGet"),
    new Target("BenchmarkTest00313", "doPost"),
    new Target("BenchmarkTest00314", "doGet"),
    new Target("BenchmarkTest00314", "doPost"),
    new Target("BenchmarkTest00315", "doGet"),
    new Target("BenchmarkTest00315", "doPost"),
    new Target("BenchmarkTest00316", "doGet"),
    new Target("BenchmarkTest00316", "doPost"),
    new Target("BenchmarkTest00317", "doGet"),
    new Target("BenchmarkTest00317", "doPost"),
    new Target("BenchmarkTest00318", "doGet"),
    new Target("BenchmarkTest00318", "doPost"),
    new Target("BenchmarkTest00319", "doGet"),
    new Target("BenchmarkTest00319", "doPost"),
    new Target("BenchmarkTest00320", "doGet"),
    new Target("BenchmarkTest00320", "doPost"),
    new Target("BenchmarkTest00321", "doGet"),
    new Target("BenchmarkTest00321", "doPost"),
    new Target("BenchmarkTest00322", "doGet"),
    new Target("BenchmarkTest00322", "doPost"),
    new Target("BenchmarkTest00323", "doGet"),
    new Target("BenchmarkTest00323", "doPost"),
    new Target("BenchmarkTest00324", "doGet"),
    new Target("BenchmarkTest00324", "doPost"),
    new Target("BenchmarkTest00325", "doGet"),
    new Target("BenchmarkTest00325", "doPost"),
    new Target("BenchmarkTest00326", "doGet"),
    new Target("BenchmarkTest00326", "doPost"),
    new Target("BenchmarkTest00327", "doGet"),
    new Target("BenchmarkTest00327", "doPost"),
    new Target("BenchmarkTest00328", "doGet"),
    new Target("BenchmarkTest00328", "doPost"),
    new Target("BenchmarkTest00329", "doGet"),
    new Target("BenchmarkTest00329", "doPost"),
    new Target("BenchmarkTest00330", "doGet"),
    new Target("BenchmarkTest00330", "doPost"),
    new Target("BenchmarkTest00331", "doGet"),
    new Target("BenchmarkTest00331", "doPost"),
    new Target("BenchmarkTest00332", "doGet"),
    new Target("BenchmarkTest00332", "doPost"),
    new Target("BenchmarkTest00333", "doGet"),
    new Target("BenchmarkTest00333", "doPost"),
    new Target("BenchmarkTest00334", "doGet"),
    new Target("BenchmarkTest00334", "doPost"),
    new Target("BenchmarkTest00335", "doGet"),
    new Target("BenchmarkTest00335", "doPost"),
    new Target("BenchmarkTest00336", "doGet"),
    new Target("BenchmarkTest00336", "doPost"),
    new Target("BenchmarkTest00337", "doGet"),
    new Target("BenchmarkTest00337", "doPost"),
    new Target("BenchmarkTest00338", "doGet"),
    new Target("BenchmarkTest00338", "doPost"),
    new Target("BenchmarkTest00339", "doGet"),
    new Target("BenchmarkTest00339", "doPost"),
    new Target("BenchmarkTest00340", "doGet"),
    new Target("BenchmarkTest00340", "doPost"),
    new Target("BenchmarkTest00341", "doGet"),
    new Target("BenchmarkTest00341", "doPost"),
    new Target("BenchmarkTest00342", "doGet"),
    new Target("BenchmarkTest00342", "doPost"),
    new Target("BenchmarkTest00343", "doGet"),
    new Target("BenchmarkTest00343", "doPost"),
    new Target("BenchmarkTest00344", "doGet"),
    new Target("BenchmarkTest00344", "doPost"),
    new Target("BenchmarkTest00345", "doGet"),
    new Target("BenchmarkTest00345", "doPost"),
    new Target("BenchmarkTest00346", "doGet"),
    new Target("BenchmarkTest00346", "doPost"),
    new Target("BenchmarkTest00347", "doGet"),
    new Target("BenchmarkTest00347", "doPost"),
    new Target("BenchmarkTest00348", "doGet"),
    new Target("BenchmarkTest00348", "doPost"),
    new Target("BenchmarkTest00349", "doGet"),
    new Target("BenchmarkTest00349", "doPost"),
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
