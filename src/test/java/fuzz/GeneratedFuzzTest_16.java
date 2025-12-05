package fuzz;
import com.code_intelligence.jazzer.api.*;
import java.lang.reflect.*;
import java.util.*;

public class GeneratedFuzzTest_16 {
  static class Target { final String c, m; Target(String c, String m) { this.c=c; this.m=m; }}
  static Target[] targets = new Target[] {
    new Target("BenchmarkTest00890", "doGet"),
    new Target("BenchmarkTest00890", "doPost"),
    new Target("BenchmarkTest00891", "doGet"),
    new Target("BenchmarkTest00891", "doPost"),
    new Target("BenchmarkTest00892", "doGet"),
    new Target("BenchmarkTest00892", "doPost"),
    new Target("BenchmarkTest00893", "doGet"),
    new Target("BenchmarkTest00893", "doPost"),
    new Target("BenchmarkTest00894", "doGet"),
    new Target("BenchmarkTest00894", "doPost"),
    new Target("BenchmarkTest00895", "doGet"),
    new Target("BenchmarkTest00895", "doPost"),
    new Target("BenchmarkTest00896", "doGet"),
    new Target("BenchmarkTest00896", "doPost"),
    new Target("BenchmarkTest00897", "doGet"),
    new Target("BenchmarkTest00897", "doPost"),
    new Target("BenchmarkTest00898", "doGet"),
    new Target("BenchmarkTest00898", "doPost"),
    new Target("BenchmarkTest00899", "doGet"),
    new Target("BenchmarkTest00899", "doPost"),
    new Target("BenchmarkTest00900", "doGet"),
    new Target("BenchmarkTest00900", "doPost"),
    new Target("BenchmarkTest00901", "doGet"),
    new Target("BenchmarkTest00901", "doPost"),
    new Target("BenchmarkTest00902", "doGet"),
    new Target("BenchmarkTest00902", "doPost"),
    new Target("BenchmarkTest00903", "doGet"),
    new Target("BenchmarkTest00903", "doPost"),
    new Target("BenchmarkTest00904", "doGet"),
    new Target("BenchmarkTest00904", "doPost"),
    new Target("BenchmarkTest00905", "doGet"),
    new Target("BenchmarkTest00905", "doPost"),
    new Target("BenchmarkTest00906", "doGet"),
    new Target("BenchmarkTest00906", "doPost"),
    new Target("BenchmarkTest00907", "doGet"),
    new Target("BenchmarkTest00907", "doPost"),
    new Target("BenchmarkTest00908", "doGet"),
    new Target("BenchmarkTest00908", "doPost"),
    new Target("BenchmarkTest00909", "doGet"),
    new Target("BenchmarkTest00909", "doPost"),
    new Target("BenchmarkTest00910", "doGet"),
    new Target("BenchmarkTest00910", "doPost"),
    new Target("BenchmarkTest00911", "doGet"),
    new Target("BenchmarkTest00911", "doPost"),
    new Target("BenchmarkTest00912", "doGet"),
    new Target("BenchmarkTest00912", "doPost"),
    new Target("BenchmarkTest00913", "doGet"),
    new Target("BenchmarkTest00913", "doPost"),
    new Target("BenchmarkTest00914", "doGet"),
    new Target("BenchmarkTest00914", "doPost"),
    new Target("BenchmarkTest00915", "doGet"),
    new Target("BenchmarkTest00915", "doPost"),
    new Target("BenchmarkTest00916", "doGet"),
    new Target("BenchmarkTest00916", "doPost"),
    new Target("BenchmarkTest00917", "doGet"),
    new Target("BenchmarkTest00917", "doPost"),
    new Target("BenchmarkTest00918", "doGet"),
    new Target("BenchmarkTest00918", "doPost"),
    new Target("BenchmarkTest00919", "doGet"),
    new Target("BenchmarkTest00919", "doPost"),
    new Target("BenchmarkTest00920", "doGet"),
    new Target("BenchmarkTest00920", "doPost"),
    new Target("BenchmarkTest00921", "doGet"),
    new Target("BenchmarkTest00921", "doPost"),
    new Target("BenchmarkTest00922", "doGet"),
    new Target("BenchmarkTest00922", "doPost"),
    new Target("BenchmarkTest00923", "doGet"),
    new Target("BenchmarkTest00923", "doPost"),
    new Target("BenchmarkTest00924", "doGet"),
    new Target("BenchmarkTest00924", "doPost"),
    new Target("BenchmarkTest00925", "doGet"),
    new Target("BenchmarkTest00925", "doPost"),
    new Target("BenchmarkTest00926", "doGet"),
    new Target("BenchmarkTest00926", "doPost"),
    new Target("BenchmarkTest00927", "doGet"),
    new Target("BenchmarkTest00927", "doPost"),
    new Target("BenchmarkTest00928", "doGet"),
    new Target("BenchmarkTest00928", "doPost"),
    new Target("BenchmarkTest00929", "doGet"),
    new Target("BenchmarkTest00929", "doPost"),
    new Target("BenchmarkTest00930", "doGet"),
    new Target("BenchmarkTest00930", "doPost"),
    new Target("BenchmarkTest00931", "doGet"),
    new Target("BenchmarkTest00931", "doPost"),
    new Target("BenchmarkTest00932", "doGet"),
    new Target("BenchmarkTest00932", "doPost"),
    new Target("BenchmarkTest00933", "doGet"),
    new Target("BenchmarkTest00933", "doPost"),
    new Target("BenchmarkTest00934", "doGet"),
    new Target("BenchmarkTest00934", "doPost"),
    new Target("BenchmarkTest00935", "doGet"),
    new Target("BenchmarkTest00935", "doPost"),
    new Target("BenchmarkTest00936", "doGet"),
    new Target("BenchmarkTest00936", "doPost"),
    new Target("BenchmarkTest00937", "doGet"),
    new Target("BenchmarkTest00937", "doPost"),
    new Target("BenchmarkTest00938", "doGet"),
    new Target("BenchmarkTest00938", "doPost"),
    new Target("BenchmarkTest00939", "doGet"),
    new Target("BenchmarkTest00939", "doPost"),
    new Target("BenchmarkTest00940", "doGet"),
    new Target("BenchmarkTest00940", "doPost"),
    new Target("BenchmarkTest00941", "doGet"),
    new Target("BenchmarkTest00941", "doPost"),
    new Target("BenchmarkTest00942", "doGet"),
    new Target("BenchmarkTest00942", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest00943", "doGet"),
    new Target("BenchmarkTest00943", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest00944", "doGet"),
    new Target("BenchmarkTest00944", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest00945", "doGet"),
    new Target("BenchmarkTest00945", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest00946", "doGet"),
    new Target("BenchmarkTest00946", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest00947", "doGet"),
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
