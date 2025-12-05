package fuzz;
import com.code_intelligence.jazzer.api.*;
import java.lang.reflect.*;
import java.util.*;

public class GeneratedFuzzTest_52 {
  static class Target { final String c, m; Target(String c, String m) { this.c=c; this.m=m; }}
  static Target[] targets = new Target[] {
    new Target("BenchmarkTest02610", "doGet"),
    new Target("BenchmarkTest02610", "doPost"),
    new Target("BenchmarkTest02611", "doGet"),
    new Target("BenchmarkTest02611", "doPost"),
    new Target("BenchmarkTest02612", "doGet"),
    new Target("BenchmarkTest02612", "doPost"),
    new Target("BenchmarkTest02613", "doGet"),
    new Target("BenchmarkTest02613", "doPost"),
    new Target("BenchmarkTest02614", "doGet"),
    new Target("BenchmarkTest02614", "doPost"),
    new Target("BenchmarkTest02615", "doGet"),
    new Target("BenchmarkTest02615", "doPost"),
    new Target("BenchmarkTest02616", "doGet"),
    new Target("BenchmarkTest02616", "doPost"),
    new Target("BenchmarkTest02617", "doGet"),
    new Target("BenchmarkTest02617", "doPost"),
    new Target("BenchmarkTest02618", "doGet"),
    new Target("BenchmarkTest02618", "doPost"),
    new Target("BenchmarkTest02619", "doGet"),
    new Target("BenchmarkTest02619", "doPost"),
    new Target("BenchmarkTest02620", "doGet"),
    new Target("BenchmarkTest02620", "doPost"),
    new Target("BenchmarkTest02621", "doGet"),
    new Target("BenchmarkTest02621", "doPost"),
    new Target("BenchmarkTest02622", "doGet"),
    new Target("BenchmarkTest02622", "doPost"),
    new Target("BenchmarkTest02623", "doGet"),
    new Target("BenchmarkTest02623", "doPost"),
    new Target("BenchmarkTest02624", "doGet"),
    new Target("BenchmarkTest02624", "doPost"),
    new Target("BenchmarkTest02625", "doGet"),
    new Target("BenchmarkTest02625", "doPost"),
    new Target("BenchmarkTest02626", "doGet"),
    new Target("BenchmarkTest02626", "doPost"),
    new Target("BenchmarkTest02627", "doGet"),
    new Target("BenchmarkTest02627", "doPost"),
    new Target("BenchmarkTest02628", "doGet"),
    new Target("BenchmarkTest02628", "doPost"),
    new Target("BenchmarkTest02629", "doGet"),
    new Target("BenchmarkTest02629", "doPost"),
    new Target("BenchmarkTest02630", "doGet"),
    new Target("BenchmarkTest02630", "doPost"),
    new Target("BenchmarkTest02631", "doGet"),
    new Target("BenchmarkTest02631", "doPost"),
    new Target("BenchmarkTest02632", "doGet"),
    new Target("BenchmarkTest02632", "doPost"),
    new Target("BenchmarkTest02633", "doGet"),
    new Target("BenchmarkTest02633", "doPost"),
    new Target("BenchmarkTest02634", "doGet"),
    new Target("BenchmarkTest02634", "doPost"),
    new Target("BenchmarkTest02635", "doGet"),
    new Target("BenchmarkTest02635", "doPost"),
    new Target("BenchmarkTest02636", "doGet"),
    new Target("BenchmarkTest02636", "doPost"),
    new Target("BenchmarkTest02637", "doGet"),
    new Target("BenchmarkTest02637", "doPost"),
    new Target("BenchmarkTest02638", "doGet"),
    new Target("BenchmarkTest02638", "doPost"),
    new Target("BenchmarkTest02639", "doGet"),
    new Target("BenchmarkTest02639", "doPost"),
    new Target("BenchmarkTest02640", "doGet"),
    new Target("BenchmarkTest02640", "doPost"),
    new Target("BenchmarkTest02641", "doGet"),
    new Target("BenchmarkTest02641", "doPost"),
    new Target("BenchmarkTest02642", "doGet"),
    new Target("BenchmarkTest02642", "doPost"),
    new Target("BenchmarkTest02643", "doGet"),
    new Target("BenchmarkTest02643", "doPost"),
    new Target("BenchmarkTest02644", "doGet"),
    new Target("BenchmarkTest02644", "doPost"),
    new Target("BenchmarkTest02645", "doGet"),
    new Target("BenchmarkTest02645", "doPost"),
    new Target("BenchmarkTest02646", "doGet"),
    new Target("BenchmarkTest02646", "doPost"),
    new Target("BenchmarkTest02647", "doGet"),
    new Target("BenchmarkTest02647", "doPost"),
    new Target("BenchmarkTest02648", "doGet"),
    new Target("BenchmarkTest02648", "doPost"),
    new Target("BenchmarkTest02649", "doGet"),
    new Target("BenchmarkTest02649", "doPost"),
    new Target("BenchmarkTest02650", "doGet"),
    new Target("BenchmarkTest02650", "doPost"),
    new Target("BenchmarkTest02651", "doGet"),
    new Target("BenchmarkTest02651", "doPost"),
    new Target("BenchmarkTest02652", "doGet"),
    new Target("BenchmarkTest02652", "doPost"),
    new Target("BenchmarkTest02653", "doGet"),
    new Target("BenchmarkTest02653", "doPost"),
    new Target("BenchmarkTest02654", "doGet"),
    new Target("BenchmarkTest02654", "doPost"),
    new Target("BenchmarkTest02655", "doGet"),
    new Target("BenchmarkTest02655", "doPost"),
    new Target("BenchmarkTest02656", "doGet"),
    new Target("BenchmarkTest02656", "doPost"),
    new Target("BenchmarkTest02657", "doGet"),
    new Target("BenchmarkTest02657", "doPost"),
    new Target("BenchmarkTest02658", "doGet"),
    new Target("BenchmarkTest02658", "doPost"),
    new Target("BenchmarkTest02659", "doGet"),
    new Target("BenchmarkTest02659", "doPost"),
    new Target("BenchmarkTest02660", "doGet"),
    new Target("BenchmarkTest02660", "doPost"),
    new Target("BenchmarkTest02661", "doGet"),
    new Target("BenchmarkTest02661", "doPost"),
    new Target("BenchmarkTest02662", "doGet"),
    new Target("BenchmarkTest02662", "doPost"),
    new Target("BenchmarkTest02663", "doGet"),
    new Target("BenchmarkTest02663", "doPost"),
    new Target("BenchmarkTest02664", "doGet"),
    new Target("BenchmarkTest02664", "doPost"),
    new Target("BenchmarkTest02665", "doGet"),
    new Target("BenchmarkTest02665", "doPost"),
    new Target("BenchmarkTest02666", "doGet"),
    new Target("BenchmarkTest02666", "doPost"),
    new Target("BenchmarkTest02667", "doGet"),
    new Target("BenchmarkTest02667", "doPost"),
    new Target("BenchmarkTest02668", "doGet"),
    new Target("BenchmarkTest02668", "doPost"),
    new Target("BenchmarkTest02669", "doGet"),
    new Target("BenchmarkTest02669", "doPost"),
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
