package fuzz;
import com.code_intelligence.jazzer.api.*;
import java.lang.reflect.*;
import java.util.*;

public class GeneratedFuzzTest_38 {
  static class Target { final String c, m; Target(String c, String m) { this.c=c; this.m=m; }}
  static Target[] targets = new Target[] {
    new Target("BenchmarkTest01787", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01788", "doGet"),
    new Target("BenchmarkTest01788", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01789", "doGet"),
    new Target("BenchmarkTest01789", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01790", "doGet"),
    new Target("BenchmarkTest01790", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01791", "doGet"),
    new Target("BenchmarkTest01791", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01792", "doGet"),
    new Target("BenchmarkTest01792", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01793", "doGet"),
    new Target("BenchmarkTest01793", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01794", "doGet"),
    new Target("BenchmarkTest01794", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01795", "doGet"),
    new Target("BenchmarkTest01795", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01796", "doGet"),
    new Target("BenchmarkTest01796", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01797", "doGet"),
    new Target("BenchmarkTest01797", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01798", "doGet"),
    new Target("BenchmarkTest01798", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01799", "doGet"),
    new Target("BenchmarkTest01799", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01800", "doGet"),
    new Target("BenchmarkTest01800", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01801", "doGet"),
    new Target("BenchmarkTest01801", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01802", "doGet"),
    new Target("BenchmarkTest01802", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01803", "doGet"),
    new Target("BenchmarkTest01803", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01804", "doGet"),
    new Target("BenchmarkTest01804", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01805", "doGet"),
    new Target("BenchmarkTest01805", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01806", "doGet"),
    new Target("BenchmarkTest01806", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01807", "doGet"),
    new Target("BenchmarkTest01807", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01808", "doGet"),
    new Target("BenchmarkTest01808", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01809", "doGet"),
    new Target("BenchmarkTest01809", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01810", "doGet"),
    new Target("BenchmarkTest01810", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01811", "doGet"),
    new Target("BenchmarkTest01811", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01812", "doGet"),
    new Target("BenchmarkTest01812", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01813", "doGet"),
    new Target("BenchmarkTest01813", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01814", "doGet"),
    new Target("BenchmarkTest01814", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01815", "doGet"),
    new Target("BenchmarkTest01815", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01816", "doGet"),
    new Target("BenchmarkTest01816", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01817", "doGet"),
    new Target("BenchmarkTest01817", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01818", "doGet"),
    new Target("BenchmarkTest01818", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01819", "doGet"),
    new Target("BenchmarkTest01819", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01820", "doGet"),
    new Target("BenchmarkTest01820", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01821", "doGet"),
    new Target("BenchmarkTest01821", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01822", "doGet"),
    new Target("BenchmarkTest01822", "doPost"),
    new Target("BenchmarkTest01823", "doGet"),
    new Target("BenchmarkTest01823", "doPost"),
    new Target("BenchmarkTest01824", "doGet"),
    new Target("BenchmarkTest01824", "doPost"),
    new Target("BenchmarkTest01825", "doGet"),
    new Target("BenchmarkTest01825", "doPost"),
    new Target("BenchmarkTest01826", "doGet"),
    new Target("BenchmarkTest01826", "doPost"),
    new Target("BenchmarkTest01827", "doGet"),
    new Target("BenchmarkTest01827", "doPost"),
    new Target("BenchmarkTest01828", "doGet"),
    new Target("BenchmarkTest01828", "doPost"),
    new Target("BenchmarkTest01829", "doGet"),
    new Target("BenchmarkTest01829", "doPost"),
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
