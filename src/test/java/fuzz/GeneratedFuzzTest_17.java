package fuzz;
import com.code_intelligence.jazzer.api.*;
import java.lang.reflect.*;
import java.util.*;

public class GeneratedFuzzTest_17 {
  static class Target { final String c, m; Target(String c, String m) { this.c=c; this.m=m; }}
  static Target[] targets = new Target[] {
    new Target("BenchmarkTest00947", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest00948", "doGet"),
    new Target("BenchmarkTest00948", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest00949", "doGet"),
    new Target("BenchmarkTest00949", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest00950", "doGet"),
    new Target("BenchmarkTest00950", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest00951", "doGet"),
    new Target("BenchmarkTest00951", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest00952", "doGet"),
    new Target("BenchmarkTest00952", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest00953", "doGet"),
    new Target("BenchmarkTest00953", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest00954", "doGet"),
    new Target("BenchmarkTest00954", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest00955", "doGet"),
    new Target("BenchmarkTest00955", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest00956", "doGet"),
    new Target("BenchmarkTest00956", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest00957", "doGet"),
    new Target("BenchmarkTest00957", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest00958", "doGet"),
    new Target("BenchmarkTest00958", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest00959", "doGet"),
    new Target("BenchmarkTest00959", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest00960", "doGet"),
    new Target("BenchmarkTest00960", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest00961", "doGet"),
    new Target("BenchmarkTest00961", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest00962", "doGet"),
    new Target("BenchmarkTest00962", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest00963", "doGet"),
    new Target("BenchmarkTest00963", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest00964", "doGet"),
    new Target("BenchmarkTest00964", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest00965", "doGet"),
    new Target("BenchmarkTest00965", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest00966", "doGet"),
    new Target("BenchmarkTest00966", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest00967", "doGet"),
    new Target("BenchmarkTest00967", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest00968", "doGet"),
    new Target("BenchmarkTest00968", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest00969", "doGet"),
    new Target("BenchmarkTest00969", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest00970", "doGet"),
    new Target("BenchmarkTest00970", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest00971", "doGet"),
    new Target("BenchmarkTest00971", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest00972", "doGet"),
    new Target("BenchmarkTest00972", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest00973", "doGet"),
    new Target("BenchmarkTest00973", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest00974", "doGet"),
    new Target("BenchmarkTest00974", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest00975", "doGet"),
    new Target("BenchmarkTest00975", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest00976", "doGet"),
    new Target("BenchmarkTest00976", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest00977", "doGet"),
    new Target("BenchmarkTest00977", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest00978", "doGet"),
    new Target("BenchmarkTest00978", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest00979", "doGet"),
    new Target("BenchmarkTest00979", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest00980", "doGet"),
    new Target("BenchmarkTest00980", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest00981", "doGet"),
    new Target("BenchmarkTest00981", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest00982", "doGet"),
    new Target("BenchmarkTest00982", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest00983", "doGet"),
    new Target("BenchmarkTest00983", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest00984", "doGet"),
    new Target("BenchmarkTest00984", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest00985", "doGet"),
    new Target("BenchmarkTest00985", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest00986", "doGet"),
    new Target("BenchmarkTest00986", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest00987", "doGet"),
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
