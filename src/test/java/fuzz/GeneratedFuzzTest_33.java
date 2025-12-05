package fuzz;
import com.code_intelligence.jazzer.api.*;
import java.lang.reflect.*;
import java.util.*;

public class GeneratedFuzzTest_33 {
  static class Target { final String c, m; Target(String c, String m) { this.c=c; this.m=m; }}
  static Target[] targets = new Target[] {
    new Target("BenchmarkTest01587", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01588", "doGet"),
    new Target("BenchmarkTest01588", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01589", "doGet"),
    new Target("BenchmarkTest01589", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01590", "doGet"),
    new Target("BenchmarkTest01590", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01591", "doGet"),
    new Target("BenchmarkTest01591", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01592", "doGet"),
    new Target("BenchmarkTest01592", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01593", "doGet"),
    new Target("BenchmarkTest01593", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01594", "doGet"),
    new Target("BenchmarkTest01594", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01595", "doGet"),
    new Target("BenchmarkTest01595", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01596", "doGet"),
    new Target("BenchmarkTest01596", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01597", "doGet"),
    new Target("BenchmarkTest01597", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01598", "doGet"),
    new Target("BenchmarkTest01598", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01599", "doGet"),
    new Target("BenchmarkTest01599", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01600", "doGet"),
    new Target("BenchmarkTest01600", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01601", "doGet"),
    new Target("BenchmarkTest01601", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01602", "doGet"),
    new Target("BenchmarkTest01602", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01603", "doGet"),
    new Target("BenchmarkTest01603", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01604", "doGet"),
    new Target("BenchmarkTest01604", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01605", "doGet"),
    new Target("BenchmarkTest01605", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01606", "doGet"),
    new Target("BenchmarkTest01606", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01607", "doGet"),
    new Target("BenchmarkTest01607", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01608", "doGet"),
    new Target("BenchmarkTest01608", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01609", "doGet"),
    new Target("BenchmarkTest01609", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01610", "doGet"),
    new Target("BenchmarkTest01610", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01611", "doGet"),
    new Target("BenchmarkTest01611", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01612", "doGet"),
    new Target("BenchmarkTest01612", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01613", "doGet"),
    new Target("BenchmarkTest01613", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01614", "doGet"),
    new Target("BenchmarkTest01614", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01615", "doGet"),
    new Target("BenchmarkTest01615", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01616", "doGet"),
    new Target("BenchmarkTest01616", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01617", "doGet"),
    new Target("BenchmarkTest01617", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01618", "doGet"),
    new Target("BenchmarkTest01618", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01619", "doGet"),
    new Target("BenchmarkTest01619", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01620", "doGet"),
    new Target("BenchmarkTest01620", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01621", "doGet"),
    new Target("BenchmarkTest01621", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01622", "doGet"),
    new Target("BenchmarkTest01622", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01623", "doGet"),
    new Target("BenchmarkTest01623", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01624", "doGet"),
    new Target("BenchmarkTest01624", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01625", "doGet"),
    new Target("BenchmarkTest01625", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01626", "doGet"),
    new Target("BenchmarkTest01626", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01627", "doGet"),
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
