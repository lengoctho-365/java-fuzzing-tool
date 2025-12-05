package fuzz;
import com.code_intelligence.jazzer.api.*;
import java.lang.reflect.*;
import java.util.*;

public class GeneratedFuzzTest_26 {
  static class Target { final String c, m; Target(String c, String m) { this.c=c; this.m=m; }}
  static Target[] targets = new Target[] {
    new Target("BenchmarkTest01307", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01308", "doGet"),
    new Target("BenchmarkTest01308", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01309", "doGet"),
    new Target("BenchmarkTest01309", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01310", "doGet"),
    new Target("BenchmarkTest01310", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01311", "doGet"),
    new Target("BenchmarkTest01311", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01312", "doGet"),
    new Target("BenchmarkTest01312", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01313", "doGet"),
    new Target("BenchmarkTest01313", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01314", "doGet"),
    new Target("BenchmarkTest01314", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01315", "doGet"),
    new Target("BenchmarkTest01315", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01316", "doGet"),
    new Target("BenchmarkTest01316", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01317", "doGet"),
    new Target("BenchmarkTest01317", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01318", "doGet"),
    new Target("BenchmarkTest01318", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01319", "doGet"),
    new Target("BenchmarkTest01319", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01320", "doGet"),
    new Target("BenchmarkTest01320", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01321", "doGet"),
    new Target("BenchmarkTest01321", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01322", "doGet"),
    new Target("BenchmarkTest01322", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01323", "doGet"),
    new Target("BenchmarkTest01323", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01324", "doGet"),
    new Target("BenchmarkTest01324", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01325", "doGet"),
    new Target("BenchmarkTest01325", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01326", "doGet"),
    new Target("BenchmarkTest01326", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01327", "doGet"),
    new Target("BenchmarkTest01327", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01328", "doGet"),
    new Target("BenchmarkTest01328", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01329", "doGet"),
    new Target("BenchmarkTest01329", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01330", "doGet"),
    new Target("BenchmarkTest01330", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01331", "doGet"),
    new Target("BenchmarkTest01331", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01332", "doGet"),
    new Target("BenchmarkTest01332", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01333", "doGet"),
    new Target("BenchmarkTest01333", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01334", "doGet"),
    new Target("BenchmarkTest01334", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01335", "doGet"),
    new Target("BenchmarkTest01335", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01336", "doGet"),
    new Target("BenchmarkTest01336", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01337", "doGet"),
    new Target("BenchmarkTest01337", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01338", "doGet"),
    new Target("BenchmarkTest01338", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01339", "doGet"),
    new Target("BenchmarkTest01339", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01340", "doGet"),
    new Target("BenchmarkTest01340", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01341", "doGet"),
    new Target("BenchmarkTest01341", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01342", "doGet"),
    new Target("BenchmarkTest01342", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01343", "doGet"),
    new Target("BenchmarkTest01343", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01344", "doGet"),
    new Target("BenchmarkTest01344", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01345", "doGet"),
    new Target("BenchmarkTest01345", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01346", "doGet"),
    new Target("BenchmarkTest01346", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01347", "doGet"),
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
