package fuzz;
import com.code_intelligence.jazzer.api.*;
import java.lang.reflect.*;
import java.util.*;

public class GeneratedFuzzTest_50 {
  static class Target { final String c, m; Target(String c, String m) { this.c=c; this.m=m; }}
  static Target[] targets = new Target[] {
    new Target("BenchmarkTest02490", "doGet"),
    new Target("BenchmarkTest02490", "doPost"),
    new Target("BenchmarkTest02491", "doGet"),
    new Target("BenchmarkTest02491", "doPost"),
    new Target("BenchmarkTest02492", "doGet"),
    new Target("BenchmarkTest02492", "doPost"),
    new Target("BenchmarkTest02493", "doGet"),
    new Target("BenchmarkTest02493", "doPost"),
    new Target("BenchmarkTest02494", "doGet"),
    new Target("BenchmarkTest02494", "doPost"),
    new Target("BenchmarkTest02495", "doGet"),
    new Target("BenchmarkTest02495", "doPost"),
    new Target("BenchmarkTest02496", "doGet"),
    new Target("BenchmarkTest02496", "doPost"),
    new Target("BenchmarkTest02497", "doGet"),
    new Target("BenchmarkTest02497", "doPost"),
    new Target("BenchmarkTest02498", "doGet"),
    new Target("BenchmarkTest02498", "doPost"),
    new Target("BenchmarkTest02499", "doGet"),
    new Target("BenchmarkTest02499", "doPost"),
    new Target("BenchmarkTest02500", "doGet"),
    new Target("BenchmarkTest02500", "doPost"),
    new Target("BenchmarkTest02501", "doGet"),
    new Target("BenchmarkTest02501", "doPost"),
    new Target("BenchmarkTest02502", "doGet"),
    new Target("BenchmarkTest02502", "doPost"),
    new Target("BenchmarkTest02503", "doGet"),
    new Target("BenchmarkTest02503", "doPost"),
    new Target("BenchmarkTest02504", "doGet"),
    new Target("BenchmarkTest02504", "doPost"),
    new Target("BenchmarkTest02505", "doGet"),
    new Target("BenchmarkTest02505", "doPost"),
    new Target("BenchmarkTest02506", "doGet"),
    new Target("BenchmarkTest02506", "doPost"),
    new Target("BenchmarkTest02507", "doGet"),
    new Target("BenchmarkTest02507", "doPost"),
    new Target("BenchmarkTest02508", "doGet"),
    new Target("BenchmarkTest02508", "doPost"),
    new Target("BenchmarkTest02509", "doGet"),
    new Target("BenchmarkTest02509", "doPost"),
    new Target("BenchmarkTest02510", "doGet"),
    new Target("BenchmarkTest02510", "doPost"),
    new Target("BenchmarkTest02511", "doGet"),
    new Target("BenchmarkTest02511", "doPost"),
    new Target("BenchmarkTest02512", "doGet"),
    new Target("BenchmarkTest02512", "doPost"),
    new Target("BenchmarkTest02513", "doGet"),
    new Target("BenchmarkTest02513", "doPost"),
    new Target("BenchmarkTest02514", "doGet"),
    new Target("BenchmarkTest02514", "doPost"),
    new Target("BenchmarkTest02515", "doGet"),
    new Target("BenchmarkTest02515", "doPost"),
    new Target("BenchmarkTest02516", "doGet"),
    new Target("BenchmarkTest02516", "doPost"),
    new Target("BenchmarkTest02517", "doGet"),
    new Target("BenchmarkTest02517", "doPost"),
    new Target("BenchmarkTest02518", "doGet"),
    new Target("BenchmarkTest02518", "doPost"),
    new Target("BenchmarkTest02519", "doGet"),
    new Target("BenchmarkTest02519", "doPost"),
    new Target("BenchmarkTest02520", "doGet"),
    new Target("BenchmarkTest02520", "doPost"),
    new Target("BenchmarkTest02521", "doGet"),
    new Target("BenchmarkTest02521", "doPost"),
    new Target("BenchmarkTest02522", "doGet"),
    new Target("BenchmarkTest02522", "doPost"),
    new Target("BenchmarkTest02523", "doGet"),
    new Target("BenchmarkTest02523", "doPost"),
    new Target("BenchmarkTest02524", "doGet"),
    new Target("BenchmarkTest02524", "doPost"),
    new Target("BenchmarkTest02525", "doGet"),
    new Target("BenchmarkTest02525", "doPost"),
    new Target("BenchmarkTest02526", "doGet"),
    new Target("BenchmarkTest02526", "doPost"),
    new Target("BenchmarkTest02527", "doGet"),
    new Target("BenchmarkTest02527", "doPost"),
    new Target("BenchmarkTest02528", "doGet"),
    new Target("BenchmarkTest02528", "doPost"),
    new Target("BenchmarkTest02529", "doGet"),
    new Target("BenchmarkTest02529", "doPost"),
    new Target("BenchmarkTest02530", "doGet"),
    new Target("BenchmarkTest02530", "doPost"),
    new Target("BenchmarkTest02531", "doGet"),
    new Target("BenchmarkTest02531", "doPost"),
    new Target("BenchmarkTest02532", "doGet"),
    new Target("BenchmarkTest02532", "doPost"),
    new Target("BenchmarkTest02533", "doGet"),
    new Target("BenchmarkTest02533", "doPost"),
    new Target("BenchmarkTest02534", "doGet"),
    new Target("BenchmarkTest02534", "doPost"),
    new Target("BenchmarkTest02535", "doGet"),
    new Target("BenchmarkTest02535", "doPost"),
    new Target("BenchmarkTest02536", "doGet"),
    new Target("BenchmarkTest02536", "doPost"),
    new Target("BenchmarkTest02537", "doGet"),
    new Target("BenchmarkTest02537", "doPost"),
    new Target("BenchmarkTest02538", "doGet"),
    new Target("BenchmarkTest02538", "doPost"),
    new Target("BenchmarkTest02539", "doGet"),
    new Target("BenchmarkTest02539", "doPost"),
    new Target("BenchmarkTest02540", "doGet"),
    new Target("BenchmarkTest02540", "doPost"),
    new Target("BenchmarkTest02541", "doGet"),
    new Target("BenchmarkTest02541", "doPost"),
    new Target("BenchmarkTest02542", "doGet"),
    new Target("BenchmarkTest02542", "doPost"),
    new Target("BenchmarkTest02543", "doGet"),
    new Target("BenchmarkTest02543", "doPost"),
    new Target("BenchmarkTest02544", "doGet"),
    new Target("BenchmarkTest02544", "doPost"),
    new Target("BenchmarkTest02545", "doGet"),
    new Target("BenchmarkTest02545", "doPost"),
    new Target("BenchmarkTest02546", "doGet"),
    new Target("BenchmarkTest02546", "doPost"),
    new Target("BenchmarkTest02547", "doGet"),
    new Target("BenchmarkTest02547", "doPost"),
    new Target("BenchmarkTest02548", "doGet"),
    new Target("BenchmarkTest02548", "doPost"),
    new Target("BenchmarkTest02549", "doGet"),
    new Target("BenchmarkTest02549", "doPost"),
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
