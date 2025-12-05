package fuzz;
import com.code_intelligence.jazzer.api.*;
import java.lang.reflect.*;
import java.util.*;

public class GeneratedFuzzTest_14 {
  static class Target { final String c, m; Target(String c, String m) { this.c=c; this.m=m; }}
  static Target[] targets = new Target[] {
    new Target("BenchmarkTest00770", "doGet"),
    new Target("BenchmarkTest00770", "doPost"),
    new Target("BenchmarkTest00771", "doGet"),
    new Target("BenchmarkTest00771", "doPost"),
    new Target("BenchmarkTest00772", "doGet"),
    new Target("BenchmarkTest00772", "doPost"),
    new Target("BenchmarkTest00773", "doGet"),
    new Target("BenchmarkTest00773", "doPost"),
    new Target("BenchmarkTest00774", "doGet"),
    new Target("BenchmarkTest00774", "doPost"),
    new Target("BenchmarkTest00775", "doGet"),
    new Target("BenchmarkTest00775", "doPost"),
    new Target("BenchmarkTest00776", "doGet"),
    new Target("BenchmarkTest00776", "doPost"),
    new Target("BenchmarkTest00777", "doGet"),
    new Target("BenchmarkTest00777", "doPost"),
    new Target("BenchmarkTest00778", "doGet"),
    new Target("BenchmarkTest00778", "doPost"),
    new Target("BenchmarkTest00779", "doGet"),
    new Target("BenchmarkTest00779", "doPost"),
    new Target("BenchmarkTest00780", "doGet"),
    new Target("BenchmarkTest00780", "doPost"),
    new Target("BenchmarkTest00781", "doGet"),
    new Target("BenchmarkTest00781", "doPost"),
    new Target("BenchmarkTest00782", "doGet"),
    new Target("BenchmarkTest00782", "doPost"),
    new Target("BenchmarkTest00783", "doGet"),
    new Target("BenchmarkTest00783", "doPost"),
    new Target("BenchmarkTest00784", "doGet"),
    new Target("BenchmarkTest00784", "doPost"),
    new Target("BenchmarkTest00785", "doGet"),
    new Target("BenchmarkTest00785", "doPost"),
    new Target("BenchmarkTest00786", "doGet"),
    new Target("BenchmarkTest00786", "doPost"),
    new Target("BenchmarkTest00787", "doGet"),
    new Target("BenchmarkTest00787", "doPost"),
    new Target("BenchmarkTest00788", "doGet"),
    new Target("BenchmarkTest00788", "doPost"),
    new Target("BenchmarkTest00789", "doGet"),
    new Target("BenchmarkTest00789", "doPost"),
    new Target("BenchmarkTest00790", "doGet"),
    new Target("BenchmarkTest00790", "doPost"),
    new Target("BenchmarkTest00791", "doGet"),
    new Target("BenchmarkTest00791", "doPost"),
    new Target("BenchmarkTest00792", "doGet"),
    new Target("BenchmarkTest00792", "doPost"),
    new Target("BenchmarkTest00793", "doGet"),
    new Target("BenchmarkTest00793", "doPost"),
    new Target("BenchmarkTest00794", "doGet"),
    new Target("BenchmarkTest00794", "doPost"),
    new Target("BenchmarkTest00795", "doGet"),
    new Target("BenchmarkTest00795", "doPost"),
    new Target("BenchmarkTest00796", "doGet"),
    new Target("BenchmarkTest00796", "doPost"),
    new Target("BenchmarkTest00797", "doGet"),
    new Target("BenchmarkTest00797", "doPost"),
    new Target("BenchmarkTest00798", "doGet"),
    new Target("BenchmarkTest00798", "doPost"),
    new Target("BenchmarkTest00799", "doGet"),
    new Target("BenchmarkTest00799", "doPost"),
    new Target("BenchmarkTest00800", "doGet"),
    new Target("BenchmarkTest00800", "doPost"),
    new Target("BenchmarkTest00801", "doGet"),
    new Target("BenchmarkTest00801", "doPost"),
    new Target("BenchmarkTest00802", "doGet"),
    new Target("BenchmarkTest00802", "doPost"),
    new Target("BenchmarkTest00803", "doGet"),
    new Target("BenchmarkTest00803", "doPost"),
    new Target("BenchmarkTest00804", "doGet"),
    new Target("BenchmarkTest00804", "doPost"),
    new Target("BenchmarkTest00805", "doGet"),
    new Target("BenchmarkTest00805", "doPost"),
    new Target("BenchmarkTest00806", "doGet"),
    new Target("BenchmarkTest00806", "doPost"),
    new Target("BenchmarkTest00807", "doGet"),
    new Target("BenchmarkTest00807", "doPost"),
    new Target("BenchmarkTest00808", "doGet"),
    new Target("BenchmarkTest00808", "doPost"),
    new Target("BenchmarkTest00809", "doGet"),
    new Target("BenchmarkTest00809", "doPost"),
    new Target("BenchmarkTest00810", "doGet"),
    new Target("BenchmarkTest00810", "doPost"),
    new Target("BenchmarkTest00811", "doGet"),
    new Target("BenchmarkTest00811", "doPost"),
    new Target("BenchmarkTest00812", "doGet"),
    new Target("BenchmarkTest00812", "doPost"),
    new Target("BenchmarkTest00813", "doGet"),
    new Target("BenchmarkTest00813", "doPost"),
    new Target("BenchmarkTest00814", "doGet"),
    new Target("BenchmarkTest00814", "doPost"),
    new Target("BenchmarkTest00815", "doGet"),
    new Target("BenchmarkTest00815", "doPost"),
    new Target("BenchmarkTest00816", "doGet"),
    new Target("BenchmarkTest00816", "doPost"),
    new Target("BenchmarkTest00817", "doGet"),
    new Target("BenchmarkTest00817", "doPost"),
    new Target("BenchmarkTest00818", "doGet"),
    new Target("BenchmarkTest00818", "doPost"),
    new Target("BenchmarkTest00819", "doGet"),
    new Target("BenchmarkTest00819", "doPost"),
    new Target("BenchmarkTest00820", "doGet"),
    new Target("BenchmarkTest00820", "doPost"),
    new Target("BenchmarkTest00821", "doGet"),
    new Target("BenchmarkTest00821", "doPost"),
    new Target("BenchmarkTest00822", "doGet"),
    new Target("BenchmarkTest00822", "doPost"),
    new Target("BenchmarkTest00823", "doGet"),
    new Target("BenchmarkTest00823", "doPost"),
    new Target("BenchmarkTest00824", "doGet"),
    new Target("BenchmarkTest00824", "doPost"),
    new Target("BenchmarkTest00825", "doGet"),
    new Target("BenchmarkTest00825", "doPost"),
    new Target("BenchmarkTest00826", "doGet"),
    new Target("BenchmarkTest00826", "doPost"),
    new Target("BenchmarkTest00827", "doGet"),
    new Target("BenchmarkTest00827", "doPost"),
    new Target("BenchmarkTest00828", "doGet"),
    new Target("BenchmarkTest00828", "doPost"),
    new Target("BenchmarkTest00829", "doGet"),
    new Target("BenchmarkTest00829", "doPost"),
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
