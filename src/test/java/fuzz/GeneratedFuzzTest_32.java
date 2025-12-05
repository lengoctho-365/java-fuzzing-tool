package fuzz;
import com.code_intelligence.jazzer.api.*;
import java.lang.reflect.*;
import java.util.*;

public class GeneratedFuzzTest_32 {
  static class Target { final String c, m; Target(String c, String m) { this.c=c; this.m=m; }}
  static Target[] targets = new Target[] {
    new Target("BenchmarkTest01547", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01548", "doGet"),
    new Target("BenchmarkTest01548", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01549", "doGet"),
    new Target("BenchmarkTest01549", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01550", "doGet"),
    new Target("BenchmarkTest01550", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01551", "doGet"),
    new Target("BenchmarkTest01551", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01552", "doGet"),
    new Target("BenchmarkTest01552", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01553", "doGet"),
    new Target("BenchmarkTest01553", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01554", "doGet"),
    new Target("BenchmarkTest01554", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01555", "doGet"),
    new Target("BenchmarkTest01555", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01556", "doGet"),
    new Target("BenchmarkTest01556", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01557", "doGet"),
    new Target("BenchmarkTest01557", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01558", "doGet"),
    new Target("BenchmarkTest01558", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01559", "doGet"),
    new Target("BenchmarkTest01559", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01560", "doGet"),
    new Target("BenchmarkTest01560", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01561", "doGet"),
    new Target("BenchmarkTest01561", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01562", "doGet"),
    new Target("BenchmarkTest01562", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01563", "doGet"),
    new Target("BenchmarkTest01563", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01564", "doGet"),
    new Target("BenchmarkTest01564", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01565", "doGet"),
    new Target("BenchmarkTest01565", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01566", "doGet"),
    new Target("BenchmarkTest01566", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01567", "doGet"),
    new Target("BenchmarkTest01567", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01568", "doGet"),
    new Target("BenchmarkTest01568", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01569", "doGet"),
    new Target("BenchmarkTest01569", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01570", "doGet"),
    new Target("BenchmarkTest01570", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01571", "doGet"),
    new Target("BenchmarkTest01571", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01572", "doGet"),
    new Target("BenchmarkTest01572", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01573", "doGet"),
    new Target("BenchmarkTest01573", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01574", "doGet"),
    new Target("BenchmarkTest01574", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01575", "doGet"),
    new Target("BenchmarkTest01575", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01576", "doGet"),
    new Target("BenchmarkTest01576", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01577", "doGet"),
    new Target("BenchmarkTest01577", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01578", "doGet"),
    new Target("BenchmarkTest01578", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01579", "doGet"),
    new Target("BenchmarkTest01579", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01580", "doGet"),
    new Target("BenchmarkTest01580", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01581", "doGet"),
    new Target("BenchmarkTest01581", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01582", "doGet"),
    new Target("BenchmarkTest01582", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01583", "doGet"),
    new Target("BenchmarkTest01583", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01584", "doGet"),
    new Target("BenchmarkTest01584", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01585", "doGet"),
    new Target("BenchmarkTest01585", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01586", "doGet"),
    new Target("BenchmarkTest01586", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01587", "doGet"),
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
