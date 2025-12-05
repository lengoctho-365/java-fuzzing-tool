package fuzz;
import com.code_intelligence.jazzer.api.*;
import java.lang.reflect.*;
import java.util.*;

public class GeneratedFuzzTest_27 {
  static class Target { final String c, m; Target(String c, String m) { this.c=c; this.m=m; }}
  static Target[] targets = new Target[] {
    new Target("BenchmarkTest01347", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01348", "doGet"),
    new Target("BenchmarkTest01348", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01349", "doGet"),
    new Target("BenchmarkTest01349", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01350", "doGet"),
    new Target("BenchmarkTest01350", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01351", "doGet"),
    new Target("BenchmarkTest01351", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01352", "doGet"),
    new Target("BenchmarkTest01352", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01353", "doGet"),
    new Target("BenchmarkTest01353", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01354", "doGet"),
    new Target("BenchmarkTest01354", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01355", "doGet"),
    new Target("BenchmarkTest01355", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01356", "doGet"),
    new Target("BenchmarkTest01356", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01357", "doGet"),
    new Target("BenchmarkTest01357", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01358", "doGet"),
    new Target("BenchmarkTest01358", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01359", "doGet"),
    new Target("BenchmarkTest01359", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01360", "doGet"),
    new Target("BenchmarkTest01360", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01361", "doGet"),
    new Target("BenchmarkTest01361", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01362", "doGet"),
    new Target("BenchmarkTest01362", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01363", "doGet"),
    new Target("BenchmarkTest01363", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01364", "doGet"),
    new Target("BenchmarkTest01364", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01365", "doGet"),
    new Target("BenchmarkTest01365", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01366", "doGet"),
    new Target("BenchmarkTest01366", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01367", "doGet"),
    new Target("BenchmarkTest01367", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01368", "doGet"),
    new Target("BenchmarkTest01368", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01369", "doGet"),
    new Target("BenchmarkTest01369", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01370", "doGet"),
    new Target("BenchmarkTest01370", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01371", "doGet"),
    new Target("BenchmarkTest01371", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01372", "doGet"),
    new Target("BenchmarkTest01372", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01373", "doGet"),
    new Target("BenchmarkTest01373", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01374", "doGet"),
    new Target("BenchmarkTest01374", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01375", "doGet"),
    new Target("BenchmarkTest01375", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01376", "doGet"),
    new Target("BenchmarkTest01376", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01377", "doGet"),
    new Target("BenchmarkTest01377", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01378", "doGet"),
    new Target("BenchmarkTest01378", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01379", "doGet"),
    new Target("BenchmarkTest01379", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01380", "doGet"),
    new Target("BenchmarkTest01380", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01381", "doGet"),
    new Target("BenchmarkTest01381", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01382", "doGet"),
    new Target("BenchmarkTest01382", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01383", "doGet"),
    new Target("BenchmarkTest01383", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01384", "doGet"),
    new Target("BenchmarkTest01384", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01385", "doGet"),
    new Target("BenchmarkTest01385", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01386", "doGet"),
    new Target("BenchmarkTest01386", "doPost"),
    new Target("Test", "doSomething"),
    new Target("BenchmarkTest01387", "doGet"),
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
