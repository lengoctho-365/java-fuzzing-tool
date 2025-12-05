package fuzz;
import com.code_intelligence.jazzer.api.*;
import java.lang.reflect.*;
import java.util.*;

public class GeneratedFuzzTest_11 {
  static class Target { final String c, m; Target(String c, String m) { this.c=c; this.m=m; }}
  static Target[] targets = new Target[] {
    new Target("BenchmarkTest00590", "doGet"),
    new Target("BenchmarkTest00590", "doPost"),
    new Target("BenchmarkTest00591", "doGet"),
    new Target("BenchmarkTest00591", "doPost"),
    new Target("BenchmarkTest00592", "doGet"),
    new Target("BenchmarkTest00592", "doPost"),
    new Target("BenchmarkTest00593", "doGet"),
    new Target("BenchmarkTest00593", "doPost"),
    new Target("BenchmarkTest00594", "doGet"),
    new Target("BenchmarkTest00594", "doPost"),
    new Target("BenchmarkTest00595", "doGet"),
    new Target("BenchmarkTest00595", "doPost"),
    new Target("BenchmarkTest00596", "doGet"),
    new Target("BenchmarkTest00596", "doPost"),
    new Target("BenchmarkTest00597", "doGet"),
    new Target("BenchmarkTest00597", "doPost"),
    new Target("BenchmarkTest00598", "doGet"),
    new Target("BenchmarkTest00598", "doPost"),
    new Target("BenchmarkTest00599", "doGet"),
    new Target("BenchmarkTest00599", "doPost"),
    new Target("BenchmarkTest00600", "doGet"),
    new Target("BenchmarkTest00600", "doPost"),
    new Target("BenchmarkTest00601", "doGet"),
    new Target("BenchmarkTest00601", "doPost"),
    new Target("BenchmarkTest00602", "doGet"),
    new Target("BenchmarkTest00602", "doPost"),
    new Target("BenchmarkTest00603", "doGet"),
    new Target("BenchmarkTest00603", "doPost"),
    new Target("BenchmarkTest00604", "doGet"),
    new Target("BenchmarkTest00604", "doPost"),
    new Target("BenchmarkTest00605", "doGet"),
    new Target("BenchmarkTest00605", "doPost"),
    new Target("BenchmarkTest00606", "doGet"),
    new Target("BenchmarkTest00606", "doPost"),
    new Target("BenchmarkTest00607", "doGet"),
    new Target("BenchmarkTest00607", "doPost"),
    new Target("BenchmarkTest00608", "doGet"),
    new Target("BenchmarkTest00608", "doPost"),
    new Target("BenchmarkTest00609", "doGet"),
    new Target("BenchmarkTest00609", "doPost"),
    new Target("BenchmarkTest00610", "doGet"),
    new Target("BenchmarkTest00610", "doPost"),
    new Target("BenchmarkTest00611", "doGet"),
    new Target("BenchmarkTest00611", "doPost"),
    new Target("BenchmarkTest00612", "doGet"),
    new Target("BenchmarkTest00612", "doPost"),
    new Target("BenchmarkTest00613", "doGet"),
    new Target("BenchmarkTest00613", "doPost"),
    new Target("BenchmarkTest00614", "doGet"),
    new Target("BenchmarkTest00614", "doPost"),
    new Target("BenchmarkTest00615", "doGet"),
    new Target("BenchmarkTest00615", "doPost"),
    new Target("BenchmarkTest00616", "doGet"),
    new Target("BenchmarkTest00616", "doPost"),
    new Target("BenchmarkTest00617", "doGet"),
    new Target("BenchmarkTest00617", "doPost"),
    new Target("BenchmarkTest00618", "doGet"),
    new Target("BenchmarkTest00618", "doPost"),
    new Target("BenchmarkTest00619", "doGet"),
    new Target("BenchmarkTest00619", "doPost"),
    new Target("BenchmarkTest00620", "doGet"),
    new Target("BenchmarkTest00620", "doPost"),
    new Target("BenchmarkTest00621", "doGet"),
    new Target("BenchmarkTest00621", "doPost"),
    new Target("BenchmarkTest00622", "doGet"),
    new Target("BenchmarkTest00622", "doPost"),
    new Target("BenchmarkTest00623", "doGet"),
    new Target("BenchmarkTest00623", "doPost"),
    new Target("BenchmarkTest00624", "doGet"),
    new Target("BenchmarkTest00624", "doPost"),
    new Target("BenchmarkTest00625", "doGet"),
    new Target("BenchmarkTest00625", "doPost"),
    new Target("BenchmarkTest00626", "doGet"),
    new Target("BenchmarkTest00626", "doPost"),
    new Target("BenchmarkTest00627", "doGet"),
    new Target("BenchmarkTest00627", "doPost"),
    new Target("BenchmarkTest00628", "doGet"),
    new Target("BenchmarkTest00628", "doPost"),
    new Target("BenchmarkTest00629", "doGet"),
    new Target("BenchmarkTest00629", "doPost"),
    new Target("BenchmarkTest00630", "doGet"),
    new Target("BenchmarkTest00630", "doPost"),
    new Target("BenchmarkTest00631", "doGet"),
    new Target("BenchmarkTest00631", "doPost"),
    new Target("BenchmarkTest00632", "doGet"),
    new Target("BenchmarkTest00632", "doPost"),
    new Target("BenchmarkTest00633", "doGet"),
    new Target("BenchmarkTest00633", "doPost"),
    new Target("BenchmarkTest00634", "doGet"),
    new Target("BenchmarkTest00634", "doPost"),
    new Target("BenchmarkTest00635", "doGet"),
    new Target("BenchmarkTest00635", "doPost"),
    new Target("BenchmarkTest00636", "doGet"),
    new Target("BenchmarkTest00636", "doPost"),
    new Target("BenchmarkTest00637", "doGet"),
    new Target("BenchmarkTest00637", "doPost"),
    new Target("BenchmarkTest00638", "doGet"),
    new Target("BenchmarkTest00638", "doPost"),
    new Target("BenchmarkTest00639", "doGet"),
    new Target("BenchmarkTest00639", "doPost"),
    new Target("BenchmarkTest00640", "doGet"),
    new Target("BenchmarkTest00640", "doPost"),
    new Target("BenchmarkTest00641", "doGet"),
    new Target("BenchmarkTest00641", "doPost"),
    new Target("BenchmarkTest00642", "doGet"),
    new Target("BenchmarkTest00642", "doPost"),
    new Target("BenchmarkTest00643", "doGet"),
    new Target("BenchmarkTest00643", "doPost"),
    new Target("BenchmarkTest00644", "doGet"),
    new Target("BenchmarkTest00644", "doPost"),
    new Target("BenchmarkTest00645", "doGet"),
    new Target("BenchmarkTest00645", "doPost"),
    new Target("BenchmarkTest00646", "doGet"),
    new Target("BenchmarkTest00646", "doPost"),
    new Target("BenchmarkTest00647", "doGet"),
    new Target("BenchmarkTest00647", "doPost"),
    new Target("BenchmarkTest00648", "doGet"),
    new Target("BenchmarkTest00648", "doPost"),
    new Target("BenchmarkTest00649", "doGet"),
    new Target("BenchmarkTest00649", "doPost"),
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
