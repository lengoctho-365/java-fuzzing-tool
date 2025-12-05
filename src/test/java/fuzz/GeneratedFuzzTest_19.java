package fuzz;
import com.code_intelligence.jazzer.api.*;
import java.lang.reflect.*;
import java.util.*;

public class GeneratedFuzzTest_19 {
  static class Target { final String c, m; Target(String c, String m) { this.c=c; this.m=m; }}
  static Target[] targets = new Target[] {
    new Target("BenchmarkTest01027", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01028", "doGet"),
    new Target("BenchmarkTest01028", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01029", "doGet"),
    new Target("BenchmarkTest01029", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01030", "doGet"),
    new Target("BenchmarkTest01030", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01031", "doGet"),
    new Target("BenchmarkTest01031", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01032", "doGet"),
    new Target("BenchmarkTest01032", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01033", "doGet"),
    new Target("BenchmarkTest01033", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01034", "doGet"),
    new Target("BenchmarkTest01034", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01035", "doGet"),
    new Target("BenchmarkTest01035", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01036", "doGet"),
    new Target("BenchmarkTest01036", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01037", "doGet"),
    new Target("BenchmarkTest01037", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01038", "doGet"),
    new Target("BenchmarkTest01038", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01039", "doGet"),
    new Target("BenchmarkTest01039", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01040", "doGet"),
    new Target("BenchmarkTest01040", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01041", "doGet"),
    new Target("BenchmarkTest01041", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01042", "doGet"),
    new Target("BenchmarkTest01042", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01043", "doGet"),
    new Target("BenchmarkTest01043", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01044", "doGet"),
    new Target("BenchmarkTest01044", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01045", "doGet"),
    new Target("BenchmarkTest01045", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01046", "doGet"),
    new Target("BenchmarkTest01046", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01047", "doGet"),
    new Target("BenchmarkTest01047", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01048", "doGet"),
    new Target("BenchmarkTest01048", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01049", "doGet"),
    new Target("BenchmarkTest01049", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01050", "doGet"),
    new Target("BenchmarkTest01050", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01051", "doGet"),
    new Target("BenchmarkTest01051", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01052", "doGet"),
    new Target("BenchmarkTest01052", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01053", "doGet"),
    new Target("BenchmarkTest01053", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01054", "doGet"),
    new Target("BenchmarkTest01054", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01055", "doGet"),
    new Target("BenchmarkTest01055", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01056", "doGet"),
    new Target("BenchmarkTest01056", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01057", "doGet"),
    new Target("BenchmarkTest01057", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01058", "doGet"),
    new Target("BenchmarkTest01058", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01059", "doGet"),
    new Target("BenchmarkTest01059", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01060", "doGet"),
    new Target("BenchmarkTest01060", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01061", "doGet"),
    new Target("BenchmarkTest01061", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01062", "doGet"),
    new Target("BenchmarkTest01062", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01063", "doGet"),
    new Target("BenchmarkTest01063", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01064", "doGet"),
    new Target("BenchmarkTest01064", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01065", "doGet"),
    new Target("BenchmarkTest01065", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01066", "doGet"),
    new Target("BenchmarkTest01066", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01067", "doGet"),
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
