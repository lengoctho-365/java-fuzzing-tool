package fuzz;
import com.code_intelligence.jazzer.api.*;
import java.lang.reflect.*;
import java.util.*;

public class GeneratedFuzzTest_43 {
  static class Target { final String c, m; Target(String c, String m) { this.c=c; this.m=m; }}
  static Target[] targets = new Target[] {
    new Target("BenchmarkTest02070", "doGet"),
    new Target("BenchmarkTest02070", "doPost"),
    new Target("BenchmarkTest02071", "doGet"),
    new Target("BenchmarkTest02071", "doPost"),
    new Target("BenchmarkTest02072", "doGet"),
    new Target("BenchmarkTest02072", "doPost"),
    new Target("BenchmarkTest02073", "doGet"),
    new Target("BenchmarkTest02073", "doPost"),
    new Target("BenchmarkTest02074", "doGet"),
    new Target("BenchmarkTest02074", "doPost"),
    new Target("BenchmarkTest02075", "doGet"),
    new Target("BenchmarkTest02075", "doPost"),
    new Target("BenchmarkTest02076", "doGet"),
    new Target("BenchmarkTest02076", "doPost"),
    new Target("BenchmarkTest02077", "doGet"),
    new Target("BenchmarkTest02077", "doPost"),
    new Target("BenchmarkTest02078", "doGet"),
    new Target("BenchmarkTest02078", "doPost"),
    new Target("BenchmarkTest02079", "doGet"),
    new Target("BenchmarkTest02079", "doPost"),
    new Target("BenchmarkTest02080", "doGet"),
    new Target("BenchmarkTest02080", "doPost"),
    new Target("BenchmarkTest02081", "doGet"),
    new Target("BenchmarkTest02081", "doPost"),
    new Target("BenchmarkTest02082", "doGet"),
    new Target("BenchmarkTest02082", "doPost"),
    new Target("BenchmarkTest02083", "doGet"),
    new Target("BenchmarkTest02083", "doPost"),
    new Target("BenchmarkTest02084", "doGet"),
    new Target("BenchmarkTest02084", "doPost"),
    new Target("BenchmarkTest02085", "doGet"),
    new Target("BenchmarkTest02085", "doPost"),
    new Target("BenchmarkTest02086", "doGet"),
    new Target("BenchmarkTest02086", "doPost"),
    new Target("BenchmarkTest02087", "doGet"),
    new Target("BenchmarkTest02087", "doPost"),
    new Target("BenchmarkTest02088", "doGet"),
    new Target("BenchmarkTest02088", "doPost"),
    new Target("BenchmarkTest02089", "doGet"),
    new Target("BenchmarkTest02089", "doPost"),
    new Target("BenchmarkTest02090", "doGet"),
    new Target("BenchmarkTest02090", "doPost"),
    new Target("BenchmarkTest02091", "doGet"),
    new Target("BenchmarkTest02091", "doPost"),
    new Target("BenchmarkTest02092", "doGet"),
    new Target("BenchmarkTest02092", "doPost"),
    new Target("BenchmarkTest02093", "doGet"),
    new Target("BenchmarkTest02093", "doPost"),
    new Target("BenchmarkTest02094", "doGet"),
    new Target("BenchmarkTest02094", "doPost"),
    new Target("BenchmarkTest02095", "doGet"),
    new Target("BenchmarkTest02095", "doPost"),
    new Target("BenchmarkTest02096", "doGet"),
    new Target("BenchmarkTest02096", "doPost"),
    new Target("BenchmarkTest02097", "doGet"),
    new Target("BenchmarkTest02097", "doPost"),
    new Target("BenchmarkTest02098", "doGet"),
    new Target("BenchmarkTest02098", "doPost"),
    new Target("BenchmarkTest02099", "doGet"),
    new Target("BenchmarkTest02099", "doPost"),
    new Target("BenchmarkTest02100", "doGet"),
    new Target("BenchmarkTest02100", "doPost"),
    new Target("BenchmarkTest02101", "doGet"),
    new Target("BenchmarkTest02101", "doPost"),
    new Target("BenchmarkTest02102", "doGet"),
    new Target("BenchmarkTest02102", "doPost"),
    new Target("BenchmarkTest02103", "doGet"),
    new Target("BenchmarkTest02103", "doPost"),
    new Target("BenchmarkTest02104", "doGet"),
    new Target("BenchmarkTest02104", "doPost"),
    new Target("BenchmarkTest02105", "doGet"),
    new Target("BenchmarkTest02105", "doPost"),
    new Target("BenchmarkTest02106", "doGet"),
    new Target("BenchmarkTest02106", "doPost"),
    new Target("BenchmarkTest02107", "doGet"),
    new Target("BenchmarkTest02107", "doPost"),
    new Target("BenchmarkTest02108", "doGet"),
    new Target("BenchmarkTest02108", "doPost"),
    new Target("BenchmarkTest02109", "doGet"),
    new Target("BenchmarkTest02109", "doPost"),
    new Target("BenchmarkTest02110", "doGet"),
    new Target("BenchmarkTest02110", "doPost"),
    new Target("BenchmarkTest02111", "doGet"),
    new Target("BenchmarkTest02111", "doPost"),
    new Target("BenchmarkTest02112", "doGet"),
    new Target("BenchmarkTest02112", "doPost"),
    new Target("BenchmarkTest02113", "doGet"),
    new Target("BenchmarkTest02113", "doPost"),
    new Target("BenchmarkTest02114", "doGet"),
    new Target("BenchmarkTest02114", "doPost"),
    new Target("BenchmarkTest02115", "doGet"),
    new Target("BenchmarkTest02115", "doPost"),
    new Target("BenchmarkTest02116", "doGet"),
    new Target("BenchmarkTest02116", "doPost"),
    new Target("BenchmarkTest02117", "doGet"),
    new Target("BenchmarkTest02117", "doPost"),
    new Target("BenchmarkTest02118", "doGet"),
    new Target("BenchmarkTest02118", "doPost"),
    new Target("BenchmarkTest02119", "doGet"),
    new Target("BenchmarkTest02119", "doPost"),
    new Target("BenchmarkTest02120", "doGet"),
    new Target("BenchmarkTest02120", "doPost"),
    new Target("BenchmarkTest02121", "doGet"),
    new Target("BenchmarkTest02121", "doPost"),
    new Target("BenchmarkTest02122", "doGet"),
    new Target("BenchmarkTest02122", "doPost"),
    new Target("BenchmarkTest02123", "doGet"),
    new Target("BenchmarkTest02123", "doPost"),
    new Target("BenchmarkTest02124", "doGet"),
    new Target("BenchmarkTest02124", "doPost"),
    new Target("BenchmarkTest02125", "doGet"),
    new Target("BenchmarkTest02125", "doPost"),
    new Target("BenchmarkTest02126", "doGet"),
    new Target("BenchmarkTest02126", "doPost"),
    new Target("BenchmarkTest02127", "doGet"),
    new Target("BenchmarkTest02127", "doPost"),
    new Target("BenchmarkTest02128", "doGet"),
    new Target("BenchmarkTest02128", "doPost"),
    new Target("BenchmarkTest02129", "doGet"),
    new Target("BenchmarkTest02129", "doPost"),
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
