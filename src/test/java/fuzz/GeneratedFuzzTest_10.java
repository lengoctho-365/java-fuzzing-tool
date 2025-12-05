package fuzz;
import com.code_intelligence.jazzer.api.*;
import java.lang.reflect.*;
import java.util.*;

public class GeneratedFuzzTest_10 {
  static class Target { final String c, m; Target(String c, String m) { this.c=c; this.m=m; }}
  static Target[] targets = new Target[] {
    new Target("BenchmarkTest00530", "doGet"),
    new Target("BenchmarkTest00530", "doPost"),
    new Target("BenchmarkTest00531", "doGet"),
    new Target("BenchmarkTest00531", "doPost"),
    new Target("BenchmarkTest00532", "doGet"),
    new Target("BenchmarkTest00532", "doPost"),
    new Target("BenchmarkTest00533", "doGet"),
    new Target("BenchmarkTest00533", "doPost"),
    new Target("BenchmarkTest00534", "doGet"),
    new Target("BenchmarkTest00534", "doPost"),
    new Target("BenchmarkTest00535", "doGet"),
    new Target("BenchmarkTest00535", "doPost"),
    new Target("BenchmarkTest00536", "doGet"),
    new Target("BenchmarkTest00536", "doPost"),
    new Target("BenchmarkTest00537", "doGet"),
    new Target("BenchmarkTest00537", "doPost"),
    new Target("BenchmarkTest00538", "doGet"),
    new Target("BenchmarkTest00538", "doPost"),
    new Target("BenchmarkTest00539", "doGet"),
    new Target("BenchmarkTest00539", "doPost"),
    new Target("BenchmarkTest00540", "doGet"),
    new Target("BenchmarkTest00540", "doPost"),
    new Target("BenchmarkTest00541", "doGet"),
    new Target("BenchmarkTest00541", "doPost"),
    new Target("BenchmarkTest00542", "doGet"),
    new Target("BenchmarkTest00542", "doPost"),
    new Target("BenchmarkTest00543", "doGet"),
    new Target("BenchmarkTest00543", "doPost"),
    new Target("BenchmarkTest00544", "doGet"),
    new Target("BenchmarkTest00544", "doPost"),
    new Target("BenchmarkTest00545", "doGet"),
    new Target("BenchmarkTest00545", "doPost"),
    new Target("BenchmarkTest00546", "doGet"),
    new Target("BenchmarkTest00546", "doPost"),
    new Target("BenchmarkTest00547", "doGet"),
    new Target("BenchmarkTest00547", "doPost"),
    new Target("BenchmarkTest00548", "doGet"),
    new Target("BenchmarkTest00548", "doPost"),
    new Target("BenchmarkTest00549", "doGet"),
    new Target("BenchmarkTest00549", "doPost"),
    new Target("BenchmarkTest00550", "doGet"),
    new Target("BenchmarkTest00550", "doPost"),
    new Target("BenchmarkTest00551", "doGet"),
    new Target("BenchmarkTest00551", "doPost"),
    new Target("BenchmarkTest00552", "doGet"),
    new Target("BenchmarkTest00552", "doPost"),
    new Target("BenchmarkTest00553", "doGet"),
    new Target("BenchmarkTest00553", "doPost"),
    new Target("BenchmarkTest00554", "doGet"),
    new Target("BenchmarkTest00554", "doPost"),
    new Target("BenchmarkTest00555", "doGet"),
    new Target("BenchmarkTest00555", "doPost"),
    new Target("BenchmarkTest00556", "doGet"),
    new Target("BenchmarkTest00556", "doPost"),
    new Target("BenchmarkTest00557", "doGet"),
    new Target("BenchmarkTest00557", "doPost"),
    new Target("BenchmarkTest00558", "doGet"),
    new Target("BenchmarkTest00558", "doPost"),
    new Target("BenchmarkTest00559", "doGet"),
    new Target("BenchmarkTest00559", "doPost"),
    new Target("BenchmarkTest00560", "doGet"),
    new Target("BenchmarkTest00560", "doPost"),
    new Target("BenchmarkTest00561", "doGet"),
    new Target("BenchmarkTest00561", "doPost"),
    new Target("BenchmarkTest00562", "doGet"),
    new Target("BenchmarkTest00562", "doPost"),
    new Target("BenchmarkTest00563", "doGet"),
    new Target("BenchmarkTest00563", "doPost"),
    new Target("BenchmarkTest00564", "doGet"),
    new Target("BenchmarkTest00564", "doPost"),
    new Target("BenchmarkTest00565", "doGet"),
    new Target("BenchmarkTest00565", "doPost"),
    new Target("BenchmarkTest00566", "doGet"),
    new Target("BenchmarkTest00566", "doPost"),
    new Target("BenchmarkTest00567", "doGet"),
    new Target("BenchmarkTest00567", "doPost"),
    new Target("BenchmarkTest00568", "doGet"),
    new Target("BenchmarkTest00568", "doPost"),
    new Target("BenchmarkTest00569", "doGet"),
    new Target("BenchmarkTest00569", "doPost"),
    new Target("BenchmarkTest00570", "doGet"),
    new Target("BenchmarkTest00570", "doPost"),
    new Target("BenchmarkTest00571", "doGet"),
    new Target("BenchmarkTest00571", "doPost"),
    new Target("BenchmarkTest00572", "doGet"),
    new Target("BenchmarkTest00572", "doPost"),
    new Target("BenchmarkTest00573", "doGet"),
    new Target("BenchmarkTest00573", "doPost"),
    new Target("BenchmarkTest00574", "doGet"),
    new Target("BenchmarkTest00574", "doPost"),
    new Target("BenchmarkTest00575", "doGet"),
    new Target("BenchmarkTest00575", "doPost"),
    new Target("BenchmarkTest00576", "doGet"),
    new Target("BenchmarkTest00576", "doPost"),
    new Target("BenchmarkTest00577", "doGet"),
    new Target("BenchmarkTest00577", "doPost"),
    new Target("BenchmarkTest00578", "doGet"),
    new Target("BenchmarkTest00578", "doPost"),
    new Target("BenchmarkTest00579", "doGet"),
    new Target("BenchmarkTest00579", "doPost"),
    new Target("BenchmarkTest00580", "doGet"),
    new Target("BenchmarkTest00580", "doPost"),
    new Target("BenchmarkTest00581", "doGet"),
    new Target("BenchmarkTest00581", "doPost"),
    new Target("BenchmarkTest00582", "doGet"),
    new Target("BenchmarkTest00582", "doPost"),
    new Target("BenchmarkTest00583", "doGet"),
    new Target("BenchmarkTest00583", "doPost"),
    new Target("BenchmarkTest00584", "doGet"),
    new Target("BenchmarkTest00584", "doPost"),
    new Target("BenchmarkTest00585", "doGet"),
    new Target("BenchmarkTest00585", "doPost"),
    new Target("BenchmarkTest00586", "doGet"),
    new Target("BenchmarkTest00586", "doPost"),
    new Target("BenchmarkTest00587", "doGet"),
    new Target("BenchmarkTest00587", "doPost"),
    new Target("BenchmarkTest00588", "doGet"),
    new Target("BenchmarkTest00588", "doPost"),
    new Target("BenchmarkTest00589", "doGet"),
    new Target("BenchmarkTest00589", "doPost"),
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
