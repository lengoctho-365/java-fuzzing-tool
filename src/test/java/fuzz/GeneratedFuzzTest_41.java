package fuzz;
import com.code_intelligence.jazzer.api.*;
import java.lang.reflect.*;
import java.util.*;

public class GeneratedFuzzTest_41 {
  static class Target { final String c, m; Target(String c, String m) { this.c=c; this.m=m; }}
  static Target[] targets = new Target[] {
    new Target("BenchmarkTest01950", "doGet"),
    new Target("BenchmarkTest01950", "doPost"),
    new Target("BenchmarkTest01951", "doGet"),
    new Target("BenchmarkTest01951", "doPost"),
    new Target("BenchmarkTest01952", "doGet"),
    new Target("BenchmarkTest01952", "doPost"),
    new Target("BenchmarkTest01953", "doGet"),
    new Target("BenchmarkTest01953", "doPost"),
    new Target("BenchmarkTest01954", "doGet"),
    new Target("BenchmarkTest01954", "doPost"),
    new Target("BenchmarkTest01955", "doGet"),
    new Target("BenchmarkTest01955", "doPost"),
    new Target("BenchmarkTest01956", "doGet"),
    new Target("BenchmarkTest01956", "doPost"),
    new Target("BenchmarkTest01957", "doGet"),
    new Target("BenchmarkTest01957", "doPost"),
    new Target("BenchmarkTest01958", "doGet"),
    new Target("BenchmarkTest01958", "doPost"),
    new Target("BenchmarkTest01959", "doGet"),
    new Target("BenchmarkTest01959", "doPost"),
    new Target("BenchmarkTest01960", "doGet"),
    new Target("BenchmarkTest01960", "doPost"),
    new Target("BenchmarkTest01961", "doGet"),
    new Target("BenchmarkTest01961", "doPost"),
    new Target("BenchmarkTest01962", "doGet"),
    new Target("BenchmarkTest01962", "doPost"),
    new Target("BenchmarkTest01963", "doGet"),
    new Target("BenchmarkTest01963", "doPost"),
    new Target("BenchmarkTest01964", "doGet"),
    new Target("BenchmarkTest01964", "doPost"),
    new Target("BenchmarkTest01965", "doGet"),
    new Target("BenchmarkTest01965", "doPost"),
    new Target("BenchmarkTest01966", "doGet"),
    new Target("BenchmarkTest01966", "doPost"),
    new Target("BenchmarkTest01967", "doGet"),
    new Target("BenchmarkTest01967", "doPost"),
    new Target("BenchmarkTest01968", "doGet"),
    new Target("BenchmarkTest01968", "doPost"),
    new Target("BenchmarkTest01969", "doGet"),
    new Target("BenchmarkTest01969", "doPost"),
    new Target("BenchmarkTest01970", "doGet"),
    new Target("BenchmarkTest01970", "doPost"),
    new Target("BenchmarkTest01971", "doGet"),
    new Target("BenchmarkTest01971", "doPost"),
    new Target("BenchmarkTest01972", "doGet"),
    new Target("BenchmarkTest01972", "doPost"),
    new Target("BenchmarkTest01973", "doGet"),
    new Target("BenchmarkTest01973", "doPost"),
    new Target("BenchmarkTest01974", "doGet"),
    new Target("BenchmarkTest01974", "doPost"),
    new Target("BenchmarkTest01975", "doGet"),
    new Target("BenchmarkTest01975", "doPost"),
    new Target("BenchmarkTest01976", "doGet"),
    new Target("BenchmarkTest01976", "doPost"),
    new Target("BenchmarkTest01977", "doGet"),
    new Target("BenchmarkTest01977", "doPost"),
    new Target("BenchmarkTest01978", "doGet"),
    new Target("BenchmarkTest01978", "doPost"),
    new Target("BenchmarkTest01979", "doGet"),
    new Target("BenchmarkTest01979", "doPost"),
    new Target("BenchmarkTest01980", "doGet"),
    new Target("BenchmarkTest01980", "doPost"),
    new Target("BenchmarkTest01981", "doGet"),
    new Target("BenchmarkTest01981", "doPost"),
    new Target("BenchmarkTest01982", "doGet"),
    new Target("BenchmarkTest01982", "doPost"),
    new Target("BenchmarkTest01983", "doGet"),
    new Target("BenchmarkTest01983", "doPost"),
    new Target("BenchmarkTest01984", "doGet"),
    new Target("BenchmarkTest01984", "doPost"),
    new Target("BenchmarkTest01985", "doGet"),
    new Target("BenchmarkTest01985", "doPost"),
    new Target("BenchmarkTest01986", "doGet"),
    new Target("BenchmarkTest01986", "doPost"),
    new Target("BenchmarkTest01987", "doGet"),
    new Target("BenchmarkTest01987", "doPost"),
    new Target("BenchmarkTest01988", "doGet"),
    new Target("BenchmarkTest01988", "doPost"),
    new Target("BenchmarkTest01989", "doGet"),
    new Target("BenchmarkTest01989", "doPost"),
    new Target("BenchmarkTest01990", "doGet"),
    new Target("BenchmarkTest01990", "doPost"),
    new Target("BenchmarkTest01991", "doGet"),
    new Target("BenchmarkTest01991", "doPost"),
    new Target("BenchmarkTest01992", "doGet"),
    new Target("BenchmarkTest01992", "doPost"),
    new Target("BenchmarkTest01993", "doGet"),
    new Target("BenchmarkTest01993", "doPost"),
    new Target("BenchmarkTest01994", "doGet"),
    new Target("BenchmarkTest01994", "doPost"),
    new Target("BenchmarkTest01995", "doGet"),
    new Target("BenchmarkTest01995", "doPost"),
    new Target("BenchmarkTest01996", "doGet"),
    new Target("BenchmarkTest01996", "doPost"),
    new Target("BenchmarkTest01997", "doGet"),
    new Target("BenchmarkTest01997", "doPost"),
    new Target("BenchmarkTest01998", "doGet"),
    new Target("BenchmarkTest01998", "doPost"),
    new Target("BenchmarkTest01999", "doGet"),
    new Target("BenchmarkTest01999", "doPost"),
    new Target("BenchmarkTest02000", "doGet"),
    new Target("BenchmarkTest02000", "doPost"),
    new Target("BenchmarkTest02001", "doGet"),
    new Target("BenchmarkTest02001", "doPost"),
    new Target("BenchmarkTest02002", "doGet"),
    new Target("BenchmarkTest02002", "doPost"),
    new Target("BenchmarkTest02003", "doGet"),
    new Target("BenchmarkTest02003", "doPost"),
    new Target("BenchmarkTest02004", "doGet"),
    new Target("BenchmarkTest02004", "doPost"),
    new Target("BenchmarkTest02005", "doGet"),
    new Target("BenchmarkTest02005", "doPost"),
    new Target("BenchmarkTest02006", "doGet"),
    new Target("BenchmarkTest02006", "doPost"),
    new Target("BenchmarkTest02007", "doGet"),
    new Target("BenchmarkTest02007", "doPost"),
    new Target("BenchmarkTest02008", "doGet"),
    new Target("BenchmarkTest02008", "doPost"),
    new Target("BenchmarkTest02009", "doGet"),
    new Target("BenchmarkTest02009", "doPost"),
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
