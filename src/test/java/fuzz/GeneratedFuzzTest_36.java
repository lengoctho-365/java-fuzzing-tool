package fuzz;
import com.code_intelligence.jazzer.api.*;
import java.lang.reflect.*;
import java.util.*;

public class GeneratedFuzzTest_36 {
  static class Target { final String c, m; Target(String c, String m) { this.c=c; this.m=m; }}
  static Target[] targets = new Target[] {
    new Target("BenchmarkTest01707", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01708", "doGet"),
    new Target("BenchmarkTest01708", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01709", "doGet"),
    new Target("BenchmarkTest01709", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01710", "doGet"),
    new Target("BenchmarkTest01710", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01711", "doGet"),
    new Target("BenchmarkTest01711", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01712", "doGet"),
    new Target("BenchmarkTest01712", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01713", "doGet"),
    new Target("BenchmarkTest01713", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01714", "doGet"),
    new Target("BenchmarkTest01714", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01715", "doGet"),
    new Target("BenchmarkTest01715", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01716", "doGet"),
    new Target("BenchmarkTest01716", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01717", "doGet"),
    new Target("BenchmarkTest01717", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01718", "doGet"),
    new Target("BenchmarkTest01718", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01719", "doGet"),
    new Target("BenchmarkTest01719", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01720", "doGet"),
    new Target("BenchmarkTest01720", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01721", "doGet"),
    new Target("BenchmarkTest01721", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01722", "doGet"),
    new Target("BenchmarkTest01722", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01723", "doGet"),
    new Target("BenchmarkTest01723", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01724", "doGet"),
    new Target("BenchmarkTest01724", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01725", "doGet"),
    new Target("BenchmarkTest01725", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01726", "doGet"),
    new Target("BenchmarkTest01726", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01727", "doGet"),
    new Target("BenchmarkTest01727", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01728", "doGet"),
    new Target("BenchmarkTest01728", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01729", "doGet"),
    new Target("BenchmarkTest01729", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01730", "doGet"),
    new Target("BenchmarkTest01730", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01731", "doGet"),
    new Target("BenchmarkTest01731", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01732", "doGet"),
    new Target("BenchmarkTest01732", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01733", "doGet"),
    new Target("BenchmarkTest01733", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01734", "doGet"),
    new Target("BenchmarkTest01734", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01735", "doGet"),
    new Target("BenchmarkTest01735", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01736", "doGet"),
    new Target("BenchmarkTest01736", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01737", "doGet"),
    new Target("BenchmarkTest01737", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01738", "doGet"),
    new Target("BenchmarkTest01738", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01739", "doGet"),
    new Target("BenchmarkTest01739", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01740", "doGet"),
    new Target("BenchmarkTest01740", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01741", "doGet"),
    new Target("BenchmarkTest01741", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01742", "doGet"),
    new Target("BenchmarkTest01742", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01743", "doGet"),
    new Target("BenchmarkTest01743", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01744", "doGet"),
    new Target("BenchmarkTest01744", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01745", "doGet"),
    new Target("BenchmarkTest01745", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01746", "doGet"),
    new Target("BenchmarkTest01746", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01747", "doGet"),
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
