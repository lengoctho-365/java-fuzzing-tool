package fuzz;
import com.code_intelligence.jazzer.api.*;
import java.lang.reflect.*;
import java.util.*;

public class GeneratedFuzzTest_35 {
  static class Target { final String c, m; Target(String c, String m) { this.c=c; this.m=m; }}
  static Target[] targets = new Target[] {
    new Target("BenchmarkTest01667", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01668", "doGet"),
    new Target("BenchmarkTest01668", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01669", "doGet"),
    new Target("BenchmarkTest01669", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01670", "doGet"),
    new Target("BenchmarkTest01670", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01671", "doGet"),
    new Target("BenchmarkTest01671", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01672", "doGet"),
    new Target("BenchmarkTest01672", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01673", "doGet"),
    new Target("BenchmarkTest01673", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01674", "doGet"),
    new Target("BenchmarkTest01674", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01675", "doGet"),
    new Target("BenchmarkTest01675", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01676", "doGet"),
    new Target("BenchmarkTest01676", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01677", "doGet"),
    new Target("BenchmarkTest01677", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01678", "doGet"),
    new Target("BenchmarkTest01678", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01679", "doGet"),
    new Target("BenchmarkTest01679", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01680", "doGet"),
    new Target("BenchmarkTest01680", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01681", "doGet"),
    new Target("BenchmarkTest01681", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01682", "doGet"),
    new Target("BenchmarkTest01682", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01683", "doGet"),
    new Target("BenchmarkTest01683", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01684", "doGet"),
    new Target("BenchmarkTest01684", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01685", "doGet"),
    new Target("BenchmarkTest01685", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01686", "doGet"),
    new Target("BenchmarkTest01686", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01687", "doGet"),
    new Target("BenchmarkTest01687", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01688", "doGet"),
    new Target("BenchmarkTest01688", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01689", "doGet"),
    new Target("BenchmarkTest01689", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01690", "doGet"),
    new Target("BenchmarkTest01690", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01691", "doGet"),
    new Target("BenchmarkTest01691", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01692", "doGet"),
    new Target("BenchmarkTest01692", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01693", "doGet"),
    new Target("BenchmarkTest01693", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01694", "doGet"),
    new Target("BenchmarkTest01694", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01695", "doGet"),
    new Target("BenchmarkTest01695", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01696", "doGet"),
    new Target("BenchmarkTest01696", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01697", "doGet"),
    new Target("BenchmarkTest01697", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01698", "doGet"),
    new Target("BenchmarkTest01698", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01699", "doGet"),
    new Target("BenchmarkTest01699", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01700", "doGet"),
    new Target("BenchmarkTest01700", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01701", "doGet"),
    new Target("BenchmarkTest01701", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01702", "doGet"),
    new Target("BenchmarkTest01702", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01703", "doGet"),
    new Target("BenchmarkTest01703", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01704", "doGet"),
    new Target("BenchmarkTest01704", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01705", "doGet"),
    new Target("BenchmarkTest01705", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01706", "doGet"),
    new Target("BenchmarkTest01706", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01707", "doGet"),
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
