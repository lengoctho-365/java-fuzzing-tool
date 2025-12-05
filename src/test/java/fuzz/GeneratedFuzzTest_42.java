package fuzz;
import com.code_intelligence.jazzer.api.*;
import java.lang.reflect.*;
import java.util.*;

public class GeneratedFuzzTest_42 {
  static class Target { final String c, m; Target(String c, String m) { this.c=c; this.m=m; }}
  static Target[] targets = new Target[] {
    new Target("BenchmarkTest02010", "doGet"),
    new Target("BenchmarkTest02010", "doPost"),
    new Target("BenchmarkTest02011", "doGet"),
    new Target("BenchmarkTest02011", "doPost"),
    new Target("BenchmarkTest02012", "doGet"),
    new Target("BenchmarkTest02012", "doPost"),
    new Target("BenchmarkTest02013", "doGet"),
    new Target("BenchmarkTest02013", "doPost"),
    new Target("BenchmarkTest02014", "doGet"),
    new Target("BenchmarkTest02014", "doPost"),
    new Target("BenchmarkTest02015", "doGet"),
    new Target("BenchmarkTest02015", "doPost"),
    new Target("BenchmarkTest02016", "doGet"),
    new Target("BenchmarkTest02016", "doPost"),
    new Target("BenchmarkTest02017", "doGet"),
    new Target("BenchmarkTest02017", "doPost"),
    new Target("BenchmarkTest02018", "doGet"),
    new Target("BenchmarkTest02018", "doPost"),
    new Target("BenchmarkTest02019", "doGet"),
    new Target("BenchmarkTest02019", "doPost"),
    new Target("BenchmarkTest02020", "doGet"),
    new Target("BenchmarkTest02020", "doPost"),
    new Target("BenchmarkTest02021", "doGet"),
    new Target("BenchmarkTest02021", "doPost"),
    new Target("BenchmarkTest02022", "doGet"),
    new Target("BenchmarkTest02022", "doPost"),
    new Target("BenchmarkTest02023", "doGet"),
    new Target("BenchmarkTest02023", "doPost"),
    new Target("BenchmarkTest02024", "doGet"),
    new Target("BenchmarkTest02024", "doPost"),
    new Target("BenchmarkTest02025", "doGet"),
    new Target("BenchmarkTest02025", "doPost"),
    new Target("BenchmarkTest02026", "doGet"),
    new Target("BenchmarkTest02026", "doPost"),
    new Target("BenchmarkTest02027", "doGet"),
    new Target("BenchmarkTest02027", "doPost"),
    new Target("BenchmarkTest02028", "doGet"),
    new Target("BenchmarkTest02028", "doPost"),
    new Target("BenchmarkTest02029", "doGet"),
    new Target("BenchmarkTest02029", "doPost"),
    new Target("BenchmarkTest02030", "doGet"),
    new Target("BenchmarkTest02030", "doPost"),
    new Target("BenchmarkTest02031", "doGet"),
    new Target("BenchmarkTest02031", "doPost"),
    new Target("BenchmarkTest02032", "doGet"),
    new Target("BenchmarkTest02032", "doPost"),
    new Target("BenchmarkTest02033", "doGet"),
    new Target("BenchmarkTest02033", "doPost"),
    new Target("BenchmarkTest02034", "doGet"),
    new Target("BenchmarkTest02034", "doPost"),
    new Target("BenchmarkTest02035", "doGet"),
    new Target("BenchmarkTest02035", "doPost"),
    new Target("BenchmarkTest02036", "doGet"),
    new Target("BenchmarkTest02036", "doPost"),
    new Target("BenchmarkTest02037", "doGet"),
    new Target("BenchmarkTest02037", "doPost"),
    new Target("BenchmarkTest02038", "doGet"),
    new Target("BenchmarkTest02038", "doPost"),
    new Target("BenchmarkTest02039", "doGet"),
    new Target("BenchmarkTest02039", "doPost"),
    new Target("BenchmarkTest02040", "doGet"),
    new Target("BenchmarkTest02040", "doPost"),
    new Target("BenchmarkTest02041", "doGet"),
    new Target("BenchmarkTest02041", "doPost"),
    new Target("BenchmarkTest02042", "doGet"),
    new Target("BenchmarkTest02042", "doPost"),
    new Target("BenchmarkTest02043", "doGet"),
    new Target("BenchmarkTest02043", "doPost"),
    new Target("BenchmarkTest02044", "doGet"),
    new Target("BenchmarkTest02044", "doPost"),
    new Target("BenchmarkTest02045", "doGet"),
    new Target("BenchmarkTest02045", "doPost"),
    new Target("BenchmarkTest02046", "doGet"),
    new Target("BenchmarkTest02046", "doPost"),
    new Target("BenchmarkTest02047", "doGet"),
    new Target("BenchmarkTest02047", "doPost"),
    new Target("BenchmarkTest02048", "doGet"),
    new Target("BenchmarkTest02048", "doPost"),
    new Target("BenchmarkTest02049", "doGet"),
    new Target("BenchmarkTest02049", "doPost"),
    new Target("BenchmarkTest02050", "doGet"),
    new Target("BenchmarkTest02050", "doPost"),
    new Target("BenchmarkTest02051", "doGet"),
    new Target("BenchmarkTest02051", "doPost"),
    new Target("BenchmarkTest02052", "doGet"),
    new Target("BenchmarkTest02052", "doPost"),
    new Target("BenchmarkTest02053", "doGet"),
    new Target("BenchmarkTest02053", "doPost"),
    new Target("BenchmarkTest02054", "doGet"),
    new Target("BenchmarkTest02054", "doPost"),
    new Target("BenchmarkTest02055", "doGet"),
    new Target("BenchmarkTest02055", "doPost"),
    new Target("BenchmarkTest02056", "doGet"),
    new Target("BenchmarkTest02056", "doPost"),
    new Target("BenchmarkTest02057", "doGet"),
    new Target("BenchmarkTest02057", "doPost"),
    new Target("BenchmarkTest02058", "doGet"),
    new Target("BenchmarkTest02058", "doPost"),
    new Target("BenchmarkTest02059", "doGet"),
    new Target("BenchmarkTest02059", "doPost"),
    new Target("BenchmarkTest02060", "doGet"),
    new Target("BenchmarkTest02060", "doPost"),
    new Target("BenchmarkTest02061", "doGet"),
    new Target("BenchmarkTest02061", "doPost"),
    new Target("BenchmarkTest02062", "doGet"),
    new Target("BenchmarkTest02062", "doPost"),
    new Target("BenchmarkTest02063", "doGet"),
    new Target("BenchmarkTest02063", "doPost"),
    new Target("BenchmarkTest02064", "doGet"),
    new Target("BenchmarkTest02064", "doPost"),
    new Target("BenchmarkTest02065", "doGet"),
    new Target("BenchmarkTest02065", "doPost"),
    new Target("BenchmarkTest02066", "doGet"),
    new Target("BenchmarkTest02066", "doPost"),
    new Target("BenchmarkTest02067", "doGet"),
    new Target("BenchmarkTest02067", "doPost"),
    new Target("BenchmarkTest02068", "doGet"),
    new Target("BenchmarkTest02068", "doPost"),
    new Target("BenchmarkTest02069", "doGet"),
    new Target("BenchmarkTest02069", "doPost"),
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
