package fuzz;
import com.code_intelligence.jazzer.api.*;
import java.lang.reflect.*;
import java.util.*;

public class GeneratedFuzzTest_23 {
  static class Target { final String c, m; Target(String c, String m) { this.c=c; this.m=m; }}
  static Target[] targets = new Target[] {
    new Target("BenchmarkTest01187", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01188", "doGet"),
    new Target("BenchmarkTest01188", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01189", "doGet"),
    new Target("BenchmarkTest01189", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01190", "doGet"),
    new Target("BenchmarkTest01190", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01191", "doGet"),
    new Target("BenchmarkTest01191", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01192", "doGet"),
    new Target("BenchmarkTest01192", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01193", "doGet"),
    new Target("BenchmarkTest01193", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01194", "doGet"),
    new Target("BenchmarkTest01194", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01195", "doGet"),
    new Target("BenchmarkTest01195", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01196", "doGet"),
    new Target("BenchmarkTest01196", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01197", "doGet"),
    new Target("BenchmarkTest01197", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01198", "doGet"),
    new Target("BenchmarkTest01198", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01199", "doGet"),
    new Target("BenchmarkTest01199", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01200", "doGet"),
    new Target("BenchmarkTest01200", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01201", "doGet"),
    new Target("BenchmarkTest01201", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01202", "doGet"),
    new Target("BenchmarkTest01202", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01203", "doGet"),
    new Target("BenchmarkTest01203", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01204", "doGet"),
    new Target("BenchmarkTest01204", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01205", "doGet"),
    new Target("BenchmarkTest01205", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01206", "doGet"),
    new Target("BenchmarkTest01206", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01207", "doGet"),
    new Target("BenchmarkTest01207", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01208", "doGet"),
    new Target("BenchmarkTest01208", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01209", "doGet"),
    new Target("BenchmarkTest01209", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01210", "doGet"),
    new Target("BenchmarkTest01210", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01211", "doGet"),
    new Target("BenchmarkTest01211", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01212", "doGet"),
    new Target("BenchmarkTest01212", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01213", "doGet"),
    new Target("BenchmarkTest01213", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01214", "doGet"),
    new Target("BenchmarkTest01214", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01215", "doGet"),
    new Target("BenchmarkTest01215", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01216", "doGet"),
    new Target("BenchmarkTest01216", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01217", "doGet"),
    new Target("BenchmarkTest01217", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01218", "doGet"),
    new Target("BenchmarkTest01218", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01219", "doGet"),
    new Target("BenchmarkTest01219", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01220", "doGet"),
    new Target("BenchmarkTest01220", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01221", "doGet"),
    new Target("BenchmarkTest01221", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01222", "doGet"),
    new Target("BenchmarkTest01222", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01223", "doGet"),
    new Target("BenchmarkTest01223", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01224", "doGet"),
    new Target("BenchmarkTest01224", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01225", "doGet"),
    new Target("BenchmarkTest01225", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01226", "doGet"),
    new Target("BenchmarkTest01226", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01227", "doGet"),
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
