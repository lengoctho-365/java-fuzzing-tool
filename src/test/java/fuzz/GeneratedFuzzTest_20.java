package fuzz;
import com.code_intelligence.jazzer.api.*;
import java.lang.reflect.*;
import java.util.*;

public class GeneratedFuzzTest_20 {
  static class Target { final String c, m; Target(String c, String m) { this.c=c; this.m=m; }}
  static Target[] targets = new Target[] {
    new Target("BenchmarkTest01067", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01068", "doGet"),
    new Target("BenchmarkTest01068", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01069", "doGet"),
    new Target("BenchmarkTest01069", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01070", "doGet"),
    new Target("BenchmarkTest01070", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01071", "doGet"),
    new Target("BenchmarkTest01071", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01072", "doGet"),
    new Target("BenchmarkTest01072", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01073", "doGet"),
    new Target("BenchmarkTest01073", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01074", "doGet"),
    new Target("BenchmarkTest01074", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01075", "doGet"),
    new Target("BenchmarkTest01075", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01076", "doGet"),
    new Target("BenchmarkTest01076", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01077", "doGet"),
    new Target("BenchmarkTest01077", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01078", "doGet"),
    new Target("BenchmarkTest01078", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01079", "doGet"),
    new Target("BenchmarkTest01079", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01080", "doGet"),
    new Target("BenchmarkTest01080", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01081", "doGet"),
    new Target("BenchmarkTest01081", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01082", "doGet"),
    new Target("BenchmarkTest01082", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01083", "doGet"),
    new Target("BenchmarkTest01083", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01084", "doGet"),
    new Target("BenchmarkTest01084", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01085", "doGet"),
    new Target("BenchmarkTest01085", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01086", "doGet"),
    new Target("BenchmarkTest01086", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01087", "doGet"),
    new Target("BenchmarkTest01087", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01088", "doGet"),
    new Target("BenchmarkTest01088", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01089", "doGet"),
    new Target("BenchmarkTest01089", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01090", "doGet"),
    new Target("BenchmarkTest01090", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01091", "doGet"),
    new Target("BenchmarkTest01091", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01092", "doGet"),
    new Target("BenchmarkTest01092", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01093", "doGet"),
    new Target("BenchmarkTest01093", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01094", "doGet"),
    new Target("BenchmarkTest01094", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01095", "doGet"),
    new Target("BenchmarkTest01095", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01096", "doGet"),
    new Target("BenchmarkTest01096", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01097", "doGet"),
    new Target("BenchmarkTest01097", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01098", "doGet"),
    new Target("BenchmarkTest01098", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01099", "doGet"),
    new Target("BenchmarkTest01099", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01100", "doGet"),
    new Target("BenchmarkTest01100", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01101", "doGet"),
    new Target("BenchmarkTest01101", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01102", "doGet"),
    new Target("BenchmarkTest01102", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01103", "doGet"),
    new Target("BenchmarkTest01103", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01104", "doGet"),
    new Target("BenchmarkTest01104", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01105", "doGet"),
    new Target("BenchmarkTest01105", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01106", "doGet"),
    new Target("BenchmarkTest01106", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01107", "doGet"),
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
