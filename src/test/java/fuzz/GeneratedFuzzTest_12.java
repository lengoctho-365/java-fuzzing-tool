package fuzz;
import com.code_intelligence.jazzer.api.*;
import java.lang.reflect.*;
import java.util.*;

public class GeneratedFuzzTest_12 {
  static class Target { final String c, m; Target(String c, String m) { this.c=c; this.m=m; }}
  static Target[] targets = new Target[] {
    new Target("BenchmarkTest00650", "doGet"),
    new Target("BenchmarkTest00650", "doPost"),
    new Target("BenchmarkTest00651", "doGet"),
    new Target("BenchmarkTest00651", "doPost"),
    new Target("BenchmarkTest00652", "doGet"),
    new Target("BenchmarkTest00652", "doPost"),
    new Target("BenchmarkTest00653", "doGet"),
    new Target("BenchmarkTest00653", "doPost"),
    new Target("BenchmarkTest00654", "doGet"),
    new Target("BenchmarkTest00654", "doPost"),
    new Target("BenchmarkTest00655", "doGet"),
    new Target("BenchmarkTest00655", "doPost"),
    new Target("BenchmarkTest00656", "doGet"),
    new Target("BenchmarkTest00656", "doPost"),
    new Target("BenchmarkTest00657", "doGet"),
    new Target("BenchmarkTest00657", "doPost"),
    new Target("BenchmarkTest00658", "doGet"),
    new Target("BenchmarkTest00658", "doPost"),
    new Target("BenchmarkTest00659", "doGet"),
    new Target("BenchmarkTest00659", "doPost"),
    new Target("BenchmarkTest00660", "doGet"),
    new Target("BenchmarkTest00660", "doPost"),
    new Target("BenchmarkTest00661", "doGet"),
    new Target("BenchmarkTest00661", "doPost"),
    new Target("BenchmarkTest00662", "doGet"),
    new Target("BenchmarkTest00662", "doPost"),
    new Target("BenchmarkTest00663", "doGet"),
    new Target("BenchmarkTest00663", "doPost"),
    new Target("BenchmarkTest00664", "doGet"),
    new Target("BenchmarkTest00664", "doPost"),
    new Target("BenchmarkTest00665", "doGet"),
    new Target("BenchmarkTest00665", "doPost"),
    new Target("BenchmarkTest00666", "doGet"),
    new Target("BenchmarkTest00666", "doPost"),
    new Target("BenchmarkTest00667", "doGet"),
    new Target("BenchmarkTest00667", "doPost"),
    new Target("BenchmarkTest00668", "doGet"),
    new Target("BenchmarkTest00668", "doPost"),
    new Target("BenchmarkTest00669", "doGet"),
    new Target("BenchmarkTest00669", "doPost"),
    new Target("BenchmarkTest00670", "doGet"),
    new Target("BenchmarkTest00670", "doPost"),
    new Target("BenchmarkTest00671", "doGet"),
    new Target("BenchmarkTest00671", "doPost"),
    new Target("BenchmarkTest00672", "doGet"),
    new Target("BenchmarkTest00672", "doPost"),
    new Target("BenchmarkTest00673", "doGet"),
    new Target("BenchmarkTest00673", "doPost"),
    new Target("BenchmarkTest00674", "doGet"),
    new Target("BenchmarkTest00674", "doPost"),
    new Target("BenchmarkTest00675", "doGet"),
    new Target("BenchmarkTest00675", "doPost"),
    new Target("BenchmarkTest00676", "doGet"),
    new Target("BenchmarkTest00676", "doPost"),
    new Target("BenchmarkTest00677", "doGet"),
    new Target("BenchmarkTest00677", "doPost"),
    new Target("BenchmarkTest00678", "doGet"),
    new Target("BenchmarkTest00678", "doPost"),
    new Target("BenchmarkTest00679", "doGet"),
    new Target("BenchmarkTest00679", "doPost"),
    new Target("BenchmarkTest00680", "doGet"),
    new Target("BenchmarkTest00680", "doPost"),
    new Target("BenchmarkTest00681", "doGet"),
    new Target("BenchmarkTest00681", "doPost"),
    new Target("BenchmarkTest00682", "doGet"),
    new Target("BenchmarkTest00682", "doPost"),
    new Target("BenchmarkTest00683", "doGet"),
    new Target("BenchmarkTest00683", "doPost"),
    new Target("BenchmarkTest00684", "doGet"),
    new Target("BenchmarkTest00684", "doPost"),
    new Target("BenchmarkTest00685", "doGet"),
    new Target("BenchmarkTest00685", "doPost"),
    new Target("BenchmarkTest00686", "doGet"),
    new Target("BenchmarkTest00686", "doPost"),
    new Target("BenchmarkTest00687", "doGet"),
    new Target("BenchmarkTest00687", "doPost"),
    new Target("BenchmarkTest00688", "doGet"),
    new Target("BenchmarkTest00688", "doPost"),
    new Target("BenchmarkTest00689", "doGet"),
    new Target("BenchmarkTest00689", "doPost"),
    new Target("BenchmarkTest00690", "doGet"),
    new Target("BenchmarkTest00690", "doPost"),
    new Target("BenchmarkTest00691", "doGet"),
    new Target("BenchmarkTest00691", "doPost"),
    new Target("BenchmarkTest00692", "doGet"),
    new Target("BenchmarkTest00692", "doPost"),
    new Target("BenchmarkTest00693", "doGet"),
    new Target("BenchmarkTest00693", "doPost"),
    new Target("BenchmarkTest00694", "doGet"),
    new Target("BenchmarkTest00694", "doPost"),
    new Target("BenchmarkTest00695", "doGet"),
    new Target("BenchmarkTest00695", "doPost"),
    new Target("BenchmarkTest00696", "doGet"),
    new Target("BenchmarkTest00696", "doPost"),
    new Target("BenchmarkTest00697", "doGet"),
    new Target("BenchmarkTest00697", "doPost"),
    new Target("BenchmarkTest00698", "doGet"),
    new Target("BenchmarkTest00698", "doPost"),
    new Target("BenchmarkTest00699", "doGet"),
    new Target("BenchmarkTest00699", "doPost"),
    new Target("BenchmarkTest00700", "doGet"),
    new Target("BenchmarkTest00700", "doPost"),
    new Target("BenchmarkTest00701", "doGet"),
    new Target("BenchmarkTest00701", "doPost"),
    new Target("BenchmarkTest00702", "doGet"),
    new Target("BenchmarkTest00702", "doPost"),
    new Target("BenchmarkTest00703", "doGet"),
    new Target("BenchmarkTest00703", "doPost"),
    new Target("BenchmarkTest00704", "doGet"),
    new Target("BenchmarkTest00704", "doPost"),
    new Target("BenchmarkTest00705", "doGet"),
    new Target("BenchmarkTest00705", "doPost"),
    new Target("BenchmarkTest00706", "doGet"),
    new Target("BenchmarkTest00706", "doPost"),
    new Target("BenchmarkTest00707", "doGet"),
    new Target("BenchmarkTest00707", "doPost"),
    new Target("BenchmarkTest00708", "doGet"),
    new Target("BenchmarkTest00708", "doPost"),
    new Target("BenchmarkTest00709", "doGet"),
    new Target("BenchmarkTest00709", "doPost"),
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
