package fuzz;
import com.code_intelligence.jazzer.api.*;
import java.lang.reflect.*;
import java.util.*;

public class GeneratedFuzzTest_15 {
  static class Target { final String c, m; Target(String c, String m) { this.c=c; this.m=m; }}
  static Target[] targets = new Target[] {
    new Target("BenchmarkTest00830", "doGet"),
    new Target("BenchmarkTest00830", "doPost"),
    new Target("BenchmarkTest00831", "doGet"),
    new Target("BenchmarkTest00831", "doPost"),
    new Target("BenchmarkTest00832", "doGet"),
    new Target("BenchmarkTest00832", "doPost"),
    new Target("BenchmarkTest00833", "doGet"),
    new Target("BenchmarkTest00833", "doPost"),
    new Target("BenchmarkTest00834", "doGet"),
    new Target("BenchmarkTest00834", "doPost"),
    new Target("BenchmarkTest00835", "doGet"),
    new Target("BenchmarkTest00835", "doPost"),
    new Target("BenchmarkTest00836", "doGet"),
    new Target("BenchmarkTest00836", "doPost"),
    new Target("BenchmarkTest00837", "doGet"),
    new Target("BenchmarkTest00837", "doPost"),
    new Target("BenchmarkTest00838", "doGet"),
    new Target("BenchmarkTest00838", "doPost"),
    new Target("BenchmarkTest00839", "doGet"),
    new Target("BenchmarkTest00839", "doPost"),
    new Target("BenchmarkTest00840", "doGet"),
    new Target("BenchmarkTest00840", "doPost"),
    new Target("BenchmarkTest00841", "doGet"),
    new Target("BenchmarkTest00841", "doPost"),
    new Target("BenchmarkTest00842", "doGet"),
    new Target("BenchmarkTest00842", "doPost"),
    new Target("BenchmarkTest00843", "doGet"),
    new Target("BenchmarkTest00843", "doPost"),
    new Target("BenchmarkTest00844", "doGet"),
    new Target("BenchmarkTest00844", "doPost"),
    new Target("BenchmarkTest00845", "doGet"),
    new Target("BenchmarkTest00845", "doPost"),
    new Target("BenchmarkTest00846", "doGet"),
    new Target("BenchmarkTest00846", "doPost"),
    new Target("BenchmarkTest00847", "doGet"),
    new Target("BenchmarkTest00847", "doPost"),
    new Target("BenchmarkTest00848", "doGet"),
    new Target("BenchmarkTest00848", "doPost"),
    new Target("BenchmarkTest00849", "doGet"),
    new Target("BenchmarkTest00849", "doPost"),
    new Target("BenchmarkTest00850", "doGet"),
    new Target("BenchmarkTest00850", "doPost"),
    new Target("BenchmarkTest00851", "doGet"),
    new Target("BenchmarkTest00851", "doPost"),
    new Target("BenchmarkTest00852", "doGet"),
    new Target("BenchmarkTest00852", "doPost"),
    new Target("BenchmarkTest00853", "doGet"),
    new Target("BenchmarkTest00853", "doPost"),
    new Target("BenchmarkTest00854", "doGet"),
    new Target("BenchmarkTest00854", "doPost"),
    new Target("BenchmarkTest00855", "doGet"),
    new Target("BenchmarkTest00855", "doPost"),
    new Target("BenchmarkTest00856", "doGet"),
    new Target("BenchmarkTest00856", "doPost"),
    new Target("BenchmarkTest00857", "doGet"),
    new Target("BenchmarkTest00857", "doPost"),
    new Target("BenchmarkTest00858", "doGet"),
    new Target("BenchmarkTest00858", "doPost"),
    new Target("BenchmarkTest00859", "doGet"),
    new Target("BenchmarkTest00859", "doPost"),
    new Target("BenchmarkTest00860", "doGet"),
    new Target("BenchmarkTest00860", "doPost"),
    new Target("BenchmarkTest00861", "doGet"),
    new Target("BenchmarkTest00861", "doPost"),
    new Target("BenchmarkTest00862", "doGet"),
    new Target("BenchmarkTest00862", "doPost"),
    new Target("BenchmarkTest00863", "doGet"),
    new Target("BenchmarkTest00863", "doPost"),
    new Target("BenchmarkTest00864", "doGet"),
    new Target("BenchmarkTest00864", "doPost"),
    new Target("BenchmarkTest00865", "doGet"),
    new Target("BenchmarkTest00865", "doPost"),
    new Target("BenchmarkTest00866", "doGet"),
    new Target("BenchmarkTest00866", "doPost"),
    new Target("BenchmarkTest00867", "doGet"),
    new Target("BenchmarkTest00867", "doPost"),
    new Target("BenchmarkTest00868", "doGet"),
    new Target("BenchmarkTest00868", "doPost"),
    new Target("BenchmarkTest00869", "doGet"),
    new Target("BenchmarkTest00869", "doPost"),
    new Target("BenchmarkTest00870", "doGet"),
    new Target("BenchmarkTest00870", "doPost"),
    new Target("BenchmarkTest00871", "doGet"),
    new Target("BenchmarkTest00871", "doPost"),
    new Target("BenchmarkTest00872", "doGet"),
    new Target("BenchmarkTest00872", "doPost"),
    new Target("BenchmarkTest00873", "doGet"),
    new Target("BenchmarkTest00873", "doPost"),
    new Target("BenchmarkTest00874", "doGet"),
    new Target("BenchmarkTest00874", "doPost"),
    new Target("BenchmarkTest00875", "doGet"),
    new Target("BenchmarkTest00875", "doPost"),
    new Target("BenchmarkTest00876", "doGet"),
    new Target("BenchmarkTest00876", "doPost"),
    new Target("BenchmarkTest00877", "doGet"),
    new Target("BenchmarkTest00877", "doPost"),
    new Target("BenchmarkTest00878", "doGet"),
    new Target("BenchmarkTest00878", "doPost"),
    new Target("BenchmarkTest00879", "doGet"),
    new Target("BenchmarkTest00879", "doPost"),
    new Target("BenchmarkTest00880", "doGet"),
    new Target("BenchmarkTest00880", "doPost"),
    new Target("BenchmarkTest00881", "doGet"),
    new Target("BenchmarkTest00881", "doPost"),
    new Target("BenchmarkTest00882", "doGet"),
    new Target("BenchmarkTest00882", "doPost"),
    new Target("BenchmarkTest00883", "doGet"),
    new Target("BenchmarkTest00883", "doPost"),
    new Target("BenchmarkTest00884", "doGet"),
    new Target("BenchmarkTest00884", "doPost"),
    new Target("BenchmarkTest00885", "doGet"),
    new Target("BenchmarkTest00885", "doPost"),
    new Target("BenchmarkTest00886", "doGet"),
    new Target("BenchmarkTest00886", "doPost"),
    new Target("BenchmarkTest00887", "doGet"),
    new Target("BenchmarkTest00887", "doPost"),
    new Target("BenchmarkTest00888", "doGet"),
    new Target("BenchmarkTest00888", "doPost"),
    new Target("BenchmarkTest00889", "doGet"),
    new Target("BenchmarkTest00889", "doPost"),
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
