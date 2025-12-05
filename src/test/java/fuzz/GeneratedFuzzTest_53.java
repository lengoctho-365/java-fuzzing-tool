package fuzz;
import com.code_intelligence.jazzer.api.*;
import java.lang.reflect.*;
import java.util.*;

public class GeneratedFuzzTest_53 {
  static class Target { final String c, m; Target(String c, String m) { this.c=c; this.m=m; }}
  static Target[] targets = new Target[] {
    new Target("BenchmarkTest02670", "doGet"),
    new Target("BenchmarkTest02670", "doPost"),
    new Target("BenchmarkTest02671", "doGet"),
    new Target("BenchmarkTest02671", "doPost"),
    new Target("BenchmarkTest02672", "doGet"),
    new Target("BenchmarkTest02672", "doPost"),
    new Target("BenchmarkTest02673", "doGet"),
    new Target("BenchmarkTest02673", "doPost"),
    new Target("BenchmarkTest02674", "doGet"),
    new Target("BenchmarkTest02674", "doPost"),
    new Target("BenchmarkTest02675", "doGet"),
    new Target("BenchmarkTest02675", "doPost"),
    new Target("BenchmarkTest02676", "doGet"),
    new Target("BenchmarkTest02676", "doPost"),
    new Target("BenchmarkTest02677", "doGet"),
    new Target("BenchmarkTest02677", "doPost"),
    new Target("BenchmarkTest02678", "doGet"),
    new Target("BenchmarkTest02678", "doPost"),
    new Target("BenchmarkTest02679", "doGet"),
    new Target("BenchmarkTest02679", "doPost"),
    new Target("BenchmarkTest02680", "doGet"),
    new Target("BenchmarkTest02680", "doPost"),
    new Target("BenchmarkTest02681", "doGet"),
    new Target("BenchmarkTest02681", "doPost"),
    new Target("BenchmarkTest02682", "doGet"),
    new Target("BenchmarkTest02682", "doPost"),
    new Target("BenchmarkTest02683", "doGet"),
    new Target("BenchmarkTest02683", "doPost"),
    new Target("BenchmarkTest02684", "doGet"),
    new Target("BenchmarkTest02684", "doPost"),
    new Target("BenchmarkTest02685", "doGet"),
    new Target("BenchmarkTest02685", "doPost"),
    new Target("BenchmarkTest02686", "doGet"),
    new Target("BenchmarkTest02686", "doPost"),
    new Target("BenchmarkTest02687", "doGet"),
    new Target("BenchmarkTest02687", "doPost"),
    new Target("BenchmarkTest02688", "doGet"),
    new Target("BenchmarkTest02688", "doPost"),
    new Target("BenchmarkTest02689", "doGet"),
    new Target("BenchmarkTest02689", "doPost"),
    new Target("BenchmarkTest02690", "doGet"),
    new Target("BenchmarkTest02690", "doPost"),
    new Target("BenchmarkTest02691", "doGet"),
    new Target("BenchmarkTest02691", "doPost"),
    new Target("BenchmarkTest02692", "doGet"),
    new Target("BenchmarkTest02692", "doPost"),
    new Target("BenchmarkTest02693", "doGet"),
    new Target("BenchmarkTest02693", "doPost"),
    new Target("BenchmarkTest02694", "doGet"),
    new Target("BenchmarkTest02694", "doPost"),
    new Target("BenchmarkTest02695", "doGet"),
    new Target("BenchmarkTest02695", "doPost"),
    new Target("BenchmarkTest02696", "doGet"),
    new Target("BenchmarkTest02696", "doPost"),
    new Target("BenchmarkTest02697", "doGet"),
    new Target("BenchmarkTest02697", "doPost"),
    new Target("BenchmarkTest02698", "doGet"),
    new Target("BenchmarkTest02698", "doPost"),
    new Target("BenchmarkTest02699", "doGet"),
    new Target("BenchmarkTest02699", "doPost"),
    new Target("BenchmarkTest02700", "doGet"),
    new Target("BenchmarkTest02700", "doPost"),
    new Target("BenchmarkTest02701", "doGet"),
    new Target("BenchmarkTest02701", "doPost"),
    new Target("BenchmarkTest02702", "doGet"),
    new Target("BenchmarkTest02702", "doPost"),
    new Target("BenchmarkTest02703", "doGet"),
    new Target("BenchmarkTest02703", "doPost"),
    new Target("BenchmarkTest02704", "doGet"),
    new Target("BenchmarkTest02704", "doPost"),
    new Target("BenchmarkTest02705", "doGet"),
    new Target("BenchmarkTest02705", "doPost"),
    new Target("BenchmarkTest02706", "doGet"),
    new Target("BenchmarkTest02706", "doPost"),
    new Target("BenchmarkTest02707", "doGet"),
    new Target("BenchmarkTest02707", "doPost"),
    new Target("BenchmarkTest02708", "doGet"),
    new Target("BenchmarkTest02708", "doPost"),
    new Target("BenchmarkTest02709", "doGet"),
    new Target("BenchmarkTest02709", "doPost"),
    new Target("BenchmarkTest02710", "doGet"),
    new Target("BenchmarkTest02710", "doPost"),
    new Target("BenchmarkTest02711", "doGet"),
    new Target("BenchmarkTest02711", "doPost"),
    new Target("BenchmarkTest02712", "doGet"),
    new Target("BenchmarkTest02712", "doPost"),
    new Target("BenchmarkTest02713", "doGet"),
    new Target("BenchmarkTest02713", "doPost"),
    new Target("BenchmarkTest02714", "doGet"),
    new Target("BenchmarkTest02714", "doPost"),
    new Target("BenchmarkTest02715", "doGet"),
    new Target("BenchmarkTest02715", "doPost"),
    new Target("BenchmarkTest02716", "doGet"),
    new Target("BenchmarkTest02716", "doPost"),
    new Target("BenchmarkTest02717", "doGet"),
    new Target("BenchmarkTest02717", "doPost"),
    new Target("BenchmarkTest02718", "doGet"),
    new Target("BenchmarkTest02718", "doPost"),
    new Target("BenchmarkTest02719", "doGet"),
    new Target("BenchmarkTest02719", "doPost"),
    new Target("BenchmarkTest02720", "doGet"),
    new Target("BenchmarkTest02720", "doPost"),
    new Target("BenchmarkTest02721", "doGet"),
    new Target("BenchmarkTest02721", "doPost"),
    new Target("BenchmarkTest02722", "doGet"),
    new Target("BenchmarkTest02722", "doPost"),
    new Target("BenchmarkTest02723", "doGet"),
    new Target("BenchmarkTest02723", "doPost"),
    new Target("BenchmarkTest02724", "doGet"),
    new Target("BenchmarkTest02724", "doPost"),
    new Target("BenchmarkTest02725", "doGet"),
    new Target("BenchmarkTest02725", "doPost"),
    new Target("BenchmarkTest02726", "doGet"),
    new Target("BenchmarkTest02726", "doPost"),
    new Target("BenchmarkTest02727", "doGet"),
    new Target("BenchmarkTest02727", "doPost"),
    new Target("BenchmarkTest02728", "doGet"),
    new Target("BenchmarkTest02728", "doPost"),
    new Target("BenchmarkTest02729", "doGet"),
    new Target("BenchmarkTest02729", "doPost"),
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
