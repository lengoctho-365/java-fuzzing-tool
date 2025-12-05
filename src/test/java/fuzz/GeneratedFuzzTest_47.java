package fuzz;
import com.code_intelligence.jazzer.api.*;
import java.lang.reflect.*;
import java.util.*;

public class GeneratedFuzzTest_47 {
  static class Target { final String c, m; Target(String c, String m) { this.c=c; this.m=m; }}
  static Target[] targets = new Target[] {
    new Target("BenchmarkTest02310", "doGet"),
    new Target("BenchmarkTest02310", "doPost"),
    new Target("BenchmarkTest02311", "doGet"),
    new Target("BenchmarkTest02311", "doPost"),
    new Target("BenchmarkTest02312", "doGet"),
    new Target("BenchmarkTest02312", "doPost"),
    new Target("BenchmarkTest02313", "doGet"),
    new Target("BenchmarkTest02313", "doPost"),
    new Target("BenchmarkTest02314", "doGet"),
    new Target("BenchmarkTest02314", "doPost"),
    new Target("BenchmarkTest02315", "doGet"),
    new Target("BenchmarkTest02315", "doPost"),
    new Target("BenchmarkTest02316", "doGet"),
    new Target("BenchmarkTest02316", "doPost"),
    new Target("BenchmarkTest02317", "doGet"),
    new Target("BenchmarkTest02317", "doPost"),
    new Target("BenchmarkTest02318", "doGet"),
    new Target("BenchmarkTest02318", "doPost"),
    new Target("BenchmarkTest02319", "doGet"),
    new Target("BenchmarkTest02319", "doPost"),
    new Target("BenchmarkTest02320", "doGet"),
    new Target("BenchmarkTest02320", "doPost"),
    new Target("BenchmarkTest02321", "doGet"),
    new Target("BenchmarkTest02321", "doPost"),
    new Target("BenchmarkTest02322", "doGet"),
    new Target("BenchmarkTest02322", "doPost"),
    new Target("BenchmarkTest02323", "doGet"),
    new Target("BenchmarkTest02323", "doPost"),
    new Target("BenchmarkTest02324", "doGet"),
    new Target("BenchmarkTest02324", "doPost"),
    new Target("BenchmarkTest02325", "doGet"),
    new Target("BenchmarkTest02325", "doPost"),
    new Target("BenchmarkTest02326", "doGet"),
    new Target("BenchmarkTest02326", "doPost"),
    new Target("BenchmarkTest02327", "doGet"),
    new Target("BenchmarkTest02327", "doPost"),
    new Target("BenchmarkTest02328", "doGet"),
    new Target("BenchmarkTest02328", "doPost"),
    new Target("BenchmarkTest02329", "doGet"),
    new Target("BenchmarkTest02329", "doPost"),
    new Target("BenchmarkTest02330", "doGet"),
    new Target("BenchmarkTest02330", "doPost"),
    new Target("BenchmarkTest02331", "doGet"),
    new Target("BenchmarkTest02331", "doPost"),
    new Target("BenchmarkTest02332", "doGet"),
    new Target("BenchmarkTest02332", "doPost"),
    new Target("BenchmarkTest02333", "doGet"),
    new Target("BenchmarkTest02333", "doPost"),
    new Target("BenchmarkTest02334", "doGet"),
    new Target("BenchmarkTest02334", "doPost"),
    new Target("BenchmarkTest02335", "doGet"),
    new Target("BenchmarkTest02335", "doPost"),
    new Target("BenchmarkTest02336", "doGet"),
    new Target("BenchmarkTest02336", "doPost"),
    new Target("BenchmarkTest02337", "doGet"),
    new Target("BenchmarkTest02337", "doPost"),
    new Target("BenchmarkTest02338", "doGet"),
    new Target("BenchmarkTest02338", "doPost"),
    new Target("BenchmarkTest02339", "doGet"),
    new Target("BenchmarkTest02339", "doPost"),
    new Target("BenchmarkTest02340", "doGet"),
    new Target("BenchmarkTest02340", "doPost"),
    new Target("BenchmarkTest02341", "doGet"),
    new Target("BenchmarkTest02341", "doPost"),
    new Target("BenchmarkTest02342", "doGet"),
    new Target("BenchmarkTest02342", "doPost"),
    new Target("BenchmarkTest02343", "doGet"),
    new Target("BenchmarkTest02343", "doPost"),
    new Target("BenchmarkTest02344", "doGet"),
    new Target("BenchmarkTest02344", "doPost"),
    new Target("BenchmarkTest02345", "doGet"),
    new Target("BenchmarkTest02345", "doPost"),
    new Target("BenchmarkTest02346", "doGet"),
    new Target("BenchmarkTest02346", "doPost"),
    new Target("BenchmarkTest02347", "doGet"),
    new Target("BenchmarkTest02347", "doPost"),
    new Target("BenchmarkTest02348", "doGet"),
    new Target("BenchmarkTest02348", "doPost"),
    new Target("BenchmarkTest02349", "doGet"),
    new Target("BenchmarkTest02349", "doPost"),
    new Target("BenchmarkTest02350", "doGet"),
    new Target("BenchmarkTest02350", "doPost"),
    new Target("BenchmarkTest02351", "doGet"),
    new Target("BenchmarkTest02351", "doPost"),
    new Target("BenchmarkTest02352", "doGet"),
    new Target("BenchmarkTest02352", "doPost"),
    new Target("BenchmarkTest02353", "doGet"),
    new Target("BenchmarkTest02353", "doPost"),
    new Target("BenchmarkTest02354", "doGet"),
    new Target("BenchmarkTest02354", "doPost"),
    new Target("BenchmarkTest02355", "doGet"),
    new Target("BenchmarkTest02355", "doPost"),
    new Target("BenchmarkTest02356", "doGet"),
    new Target("BenchmarkTest02356", "doPost"),
    new Target("BenchmarkTest02357", "doGet"),
    new Target("BenchmarkTest02357", "doPost"),
    new Target("BenchmarkTest02358", "doGet"),
    new Target("BenchmarkTest02358", "doPost"),
    new Target("BenchmarkTest02359", "doGet"),
    new Target("BenchmarkTest02359", "doPost"),
    new Target("BenchmarkTest02360", "doGet"),
    new Target("BenchmarkTest02360", "doPost"),
    new Target("BenchmarkTest02361", "doGet"),
    new Target("BenchmarkTest02361", "doPost"),
    new Target("BenchmarkTest02362", "doGet"),
    new Target("BenchmarkTest02362", "doPost"),
    new Target("BenchmarkTest02363", "doGet"),
    new Target("BenchmarkTest02363", "doPost"),
    new Target("BenchmarkTest02364", "doGet"),
    new Target("BenchmarkTest02364", "doPost"),
    new Target("BenchmarkTest02365", "doGet"),
    new Target("BenchmarkTest02365", "doPost"),
    new Target("BenchmarkTest02366", "doGet"),
    new Target("BenchmarkTest02366", "doPost"),
    new Target("BenchmarkTest02367", "doGet"),
    new Target("BenchmarkTest02367", "doPost"),
    new Target("BenchmarkTest02368", "doGet"),
    new Target("BenchmarkTest02368", "doPost"),
    new Target("BenchmarkTest02369", "doGet"),
    new Target("BenchmarkTest02369", "doPost"),
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
