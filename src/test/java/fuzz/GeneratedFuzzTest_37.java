package fuzz;
import com.code_intelligence.jazzer.api.*;
import java.lang.reflect.*;
import java.util.*;

public class GeneratedFuzzTest_37 {
  static class Target { final String c, m; Target(String c, String m) { this.c=c; this.m=m; }}
  static Target[] targets = new Target[] {
    new Target("BenchmarkTest01747", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01748", "doGet"),
    new Target("BenchmarkTest01748", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01749", "doGet"),
    new Target("BenchmarkTest01749", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01750", "doGet"),
    new Target("BenchmarkTest01750", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01751", "doGet"),
    new Target("BenchmarkTest01751", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01752", "doGet"),
    new Target("BenchmarkTest01752", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01753", "doGet"),
    new Target("BenchmarkTest01753", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01754", "doGet"),
    new Target("BenchmarkTest01754", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01755", "doGet"),
    new Target("BenchmarkTest01755", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01756", "doGet"),
    new Target("BenchmarkTest01756", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01757", "doGet"),
    new Target("BenchmarkTest01757", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01758", "doGet"),
    new Target("BenchmarkTest01758", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01759", "doGet"),
    new Target("BenchmarkTest01759", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01760", "doGet"),
    new Target("BenchmarkTest01760", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01761", "doGet"),
    new Target("BenchmarkTest01761", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01762", "doGet"),
    new Target("BenchmarkTest01762", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01763", "doGet"),
    new Target("BenchmarkTest01763", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01764", "doGet"),
    new Target("BenchmarkTest01764", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01765", "doGet"),
    new Target("BenchmarkTest01765", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01766", "doGet"),
    new Target("BenchmarkTest01766", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01767", "doGet"),
    new Target("BenchmarkTest01767", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01768", "doGet"),
    new Target("BenchmarkTest01768", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01769", "doGet"),
    new Target("BenchmarkTest01769", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01770", "doGet"),
    new Target("BenchmarkTest01770", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01771", "doGet"),
    new Target("BenchmarkTest01771", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01772", "doGet"),
    new Target("BenchmarkTest01772", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01773", "doGet"),
    new Target("BenchmarkTest01773", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01774", "doGet"),
    new Target("BenchmarkTest01774", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01775", "doGet"),
    new Target("BenchmarkTest01775", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01776", "doGet"),
    new Target("BenchmarkTest01776", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01777", "doGet"),
    new Target("BenchmarkTest01777", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01778", "doGet"),
    new Target("BenchmarkTest01778", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01779", "doGet"),
    new Target("BenchmarkTest01779", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01780", "doGet"),
    new Target("BenchmarkTest01780", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01781", "doGet"),
    new Target("BenchmarkTest01781", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01782", "doGet"),
    new Target("BenchmarkTest01782", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01783", "doGet"),
    new Target("BenchmarkTest01783", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01784", "doGet"),
    new Target("BenchmarkTest01784", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01785", "doGet"),
    new Target("BenchmarkTest01785", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01786", "doGet"),
    new Target("BenchmarkTest01786", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01787", "doGet"),
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
