package fuzz;
import com.code_intelligence.jazzer.api.*;
import java.lang.reflect.*;
import java.util.*;

public class GeneratedFuzzTest_8 {
  static class Target { final String c, m; Target(String c, String m) { this.c=c; this.m=m; }}
  static Target[] targets = new Target[] {
    new Target("BenchmarkTest00410", "doGet"),
    new Target("BenchmarkTest00410", "doPost"),
    new Target("BenchmarkTest00411", "doGet"),
    new Target("BenchmarkTest00411", "doPost"),
    new Target("BenchmarkTest00412", "doGet"),
    new Target("BenchmarkTest00412", "doPost"),
    new Target("BenchmarkTest00413", "doGet"),
    new Target("BenchmarkTest00413", "doPost"),
    new Target("BenchmarkTest00414", "doGet"),
    new Target("BenchmarkTest00414", "doPost"),
    new Target("BenchmarkTest00415", "doGet"),
    new Target("BenchmarkTest00415", "doPost"),
    new Target("BenchmarkTest00416", "doGet"),
    new Target("BenchmarkTest00416", "doPost"),
    new Target("BenchmarkTest00417", "doGet"),
    new Target("BenchmarkTest00417", "doPost"),
    new Target("BenchmarkTest00418", "doGet"),
    new Target("BenchmarkTest00418", "doPost"),
    new Target("BenchmarkTest00419", "doGet"),
    new Target("BenchmarkTest00419", "doPost"),
    new Target("BenchmarkTest00420", "doGet"),
    new Target("BenchmarkTest00420", "doPost"),
    new Target("BenchmarkTest00421", "doGet"),
    new Target("BenchmarkTest00421", "doPost"),
    new Target("BenchmarkTest00422", "doGet"),
    new Target("BenchmarkTest00422", "doPost"),
    new Target("BenchmarkTest00423", "doGet"),
    new Target("BenchmarkTest00423", "doPost"),
    new Target("BenchmarkTest00424", "doGet"),
    new Target("BenchmarkTest00424", "doPost"),
    new Target("BenchmarkTest00425", "doGet"),
    new Target("BenchmarkTest00425", "doPost"),
    new Target("BenchmarkTest00426", "doGet"),
    new Target("BenchmarkTest00426", "doPost"),
    new Target("BenchmarkTest00427", "doGet"),
    new Target("BenchmarkTest00427", "doPost"),
    new Target("BenchmarkTest00428", "doGet"),
    new Target("BenchmarkTest00428", "doPost"),
    new Target("BenchmarkTest00429", "doGet"),
    new Target("BenchmarkTest00429", "doPost"),
    new Target("BenchmarkTest00430", "doGet"),
    new Target("BenchmarkTest00430", "doPost"),
    new Target("BenchmarkTest00431", "doGet"),
    new Target("BenchmarkTest00431", "doPost"),
    new Target("BenchmarkTest00432", "doGet"),
    new Target("BenchmarkTest00432", "doPost"),
    new Target("BenchmarkTest00433", "doGet"),
    new Target("BenchmarkTest00433", "doPost"),
    new Target("BenchmarkTest00434", "doGet"),
    new Target("BenchmarkTest00434", "doPost"),
    new Target("BenchmarkTest00435", "doGet"),
    new Target("BenchmarkTest00435", "doPost"),
    new Target("BenchmarkTest00436", "doGet"),
    new Target("BenchmarkTest00436", "doPost"),
    new Target("BenchmarkTest00437", "doGet"),
    new Target("BenchmarkTest00437", "doPost"),
    new Target("BenchmarkTest00438", "doGet"),
    new Target("BenchmarkTest00438", "doPost"),
    new Target("BenchmarkTest00439", "doGet"),
    new Target("BenchmarkTest00439", "doPost"),
    new Target("BenchmarkTest00440", "doGet"),
    new Target("BenchmarkTest00440", "doPost"),
    new Target("BenchmarkTest00441", "doGet"),
    new Target("BenchmarkTest00441", "doPost"),
    new Target("BenchmarkTest00442", "doGet"),
    new Target("BenchmarkTest00442", "doPost"),
    new Target("BenchmarkTest00443", "doGet"),
    new Target("BenchmarkTest00443", "doPost"),
    new Target("BenchmarkTest00444", "doGet"),
    new Target("BenchmarkTest00444", "doPost"),
    new Target("BenchmarkTest00445", "doGet"),
    new Target("BenchmarkTest00445", "doPost"),
    new Target("BenchmarkTest00446", "doGet"),
    new Target("BenchmarkTest00446", "doPost"),
    new Target("BenchmarkTest00447", "doGet"),
    new Target("BenchmarkTest00447", "doPost"),
    new Target("BenchmarkTest00448", "doGet"),
    new Target("BenchmarkTest00448", "doPost"),
    new Target("BenchmarkTest00449", "doGet"),
    new Target("BenchmarkTest00449", "doPost"),
    new Target("BenchmarkTest00450", "doGet"),
    new Target("BenchmarkTest00450", "doPost"),
    new Target("BenchmarkTest00451", "doGet"),
    new Target("BenchmarkTest00451", "doPost"),
    new Target("BenchmarkTest00452", "doGet"),
    new Target("BenchmarkTest00452", "doPost"),
    new Target("BenchmarkTest00453", "doGet"),
    new Target("BenchmarkTest00453", "doPost"),
    new Target("BenchmarkTest00454", "doGet"),
    new Target("BenchmarkTest00454", "doPost"),
    new Target("BenchmarkTest00455", "doGet"),
    new Target("BenchmarkTest00455", "doPost"),
    new Target("BenchmarkTest00456", "doGet"),
    new Target("BenchmarkTest00456", "doPost"),
    new Target("BenchmarkTest00457", "doGet"),
    new Target("BenchmarkTest00457", "doPost"),
    new Target("BenchmarkTest00458", "doGet"),
    new Target("BenchmarkTest00458", "doPost"),
    new Target("BenchmarkTest00459", "doGet"),
    new Target("BenchmarkTest00459", "doPost"),
    new Target("BenchmarkTest00460", "doGet"),
    new Target("BenchmarkTest00460", "doPost"),
    new Target("BenchmarkTest00461", "doGet"),
    new Target("BenchmarkTest00461", "doPost"),
    new Target("BenchmarkTest00462", "doGet"),
    new Target("BenchmarkTest00462", "doPost"),
    new Target("BenchmarkTest00463", "doGet"),
    new Target("BenchmarkTest00463", "doPost"),
    new Target("BenchmarkTest00464", "doGet"),
    new Target("BenchmarkTest00464", "doPost"),
    new Target("BenchmarkTest00465", "doGet"),
    new Target("BenchmarkTest00465", "doPost"),
    new Target("BenchmarkTest00466", "doGet"),
    new Target("BenchmarkTest00466", "doPost"),
    new Target("BenchmarkTest00467", "doGet"),
    new Target("BenchmarkTest00467", "doPost"),
    new Target("BenchmarkTest00468", "doGet"),
    new Target("BenchmarkTest00468", "doPost"),
    new Target("BenchmarkTest00469", "doGet"),
    new Target("BenchmarkTest00469", "doPost"),
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
