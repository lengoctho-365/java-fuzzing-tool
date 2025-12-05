package fuzz;
import com.code_intelligence.jazzer.api.*;
import java.lang.reflect.*;
import java.util.*;

public class GeneratedFuzzTest_18 {
  static class Target { final String c, m; Target(String c, String m) { this.c=c; this.m=m; }}
  static Target[] targets = new Target[] {
    new Target("BenchmarkTest00987", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest00988", "doGet"),
    new Target("BenchmarkTest00988", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest00989", "doGet"),
    new Target("BenchmarkTest00989", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest00990", "doGet"),
    new Target("BenchmarkTest00990", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest00991", "doGet"),
    new Target("BenchmarkTest00991", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest00992", "doGet"),
    new Target("BenchmarkTest00992", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest00993", "doGet"),
    new Target("BenchmarkTest00993", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest00994", "doGet"),
    new Target("BenchmarkTest00994", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest00995", "doGet"),
    new Target("BenchmarkTest00995", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest00996", "doGet"),
    new Target("BenchmarkTest00996", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest00997", "doGet"),
    new Target("BenchmarkTest00997", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest00998", "doGet"),
    new Target("BenchmarkTest00998", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest00999", "doGet"),
    new Target("BenchmarkTest00999", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01000", "doGet"),
    new Target("BenchmarkTest01000", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01001", "doGet"),
    new Target("BenchmarkTest01001", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01002", "doGet"),
    new Target("BenchmarkTest01002", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01003", "doGet"),
    new Target("BenchmarkTest01003", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01004", "doGet"),
    new Target("BenchmarkTest01004", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01005", "doGet"),
    new Target("BenchmarkTest01005", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01006", "doGet"),
    new Target("BenchmarkTest01006", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01007", "doGet"),
    new Target("BenchmarkTest01007", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01008", "doGet"),
    new Target("BenchmarkTest01008", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01009", "doGet"),
    new Target("BenchmarkTest01009", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01010", "doGet"),
    new Target("BenchmarkTest01010", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01011", "doGet"),
    new Target("BenchmarkTest01011", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01012", "doGet"),
    new Target("BenchmarkTest01012", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01013", "doGet"),
    new Target("BenchmarkTest01013", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01014", "doGet"),
    new Target("BenchmarkTest01014", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01015", "doGet"),
    new Target("BenchmarkTest01015", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01016", "doGet"),
    new Target("BenchmarkTest01016", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01017", "doGet"),
    new Target("BenchmarkTest01017", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01018", "doGet"),
    new Target("BenchmarkTest01018", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01019", "doGet"),
    new Target("BenchmarkTest01019", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01020", "doGet"),
    new Target("BenchmarkTest01020", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01021", "doGet"),
    new Target("BenchmarkTest01021", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01022", "doGet"),
    new Target("BenchmarkTest01022", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01023", "doGet"),
    new Target("BenchmarkTest01023", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01024", "doGet"),
    new Target("BenchmarkTest01024", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01025", "doGet"),
    new Target("BenchmarkTest01025", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01026", "doGet"),
    new Target("BenchmarkTest01026", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01027", "doGet"),
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
