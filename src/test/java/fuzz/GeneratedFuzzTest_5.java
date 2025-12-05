package fuzz;
import com.code_intelligence.jazzer.api.*;
import java.lang.reflect.*;
import java.util.*;

public class GeneratedFuzzTest_5 {
  static class Target { final String c, m; Target(String c, String m) { this.c=c; this.m=m; }}
  static Target[] targets = new Target[] {
    new Target("BenchmarkTest00230", "doGet"),
    new Target("BenchmarkTest00230", "doPost"),
    new Target("BenchmarkTest00231", "doGet"),
    new Target("BenchmarkTest00231", "doPost"),
    new Target("BenchmarkTest00232", "doGet"),
    new Target("BenchmarkTest00232", "doPost"),
    new Target("BenchmarkTest00233", "doGet"),
    new Target("BenchmarkTest00233", "doPost"),
    new Target("BenchmarkTest00234", "doGet"),
    new Target("BenchmarkTest00234", "doPost"),
    new Target("BenchmarkTest00235", "doGet"),
    new Target("BenchmarkTest00235", "doPost"),
    new Target("BenchmarkTest00236", "doGet"),
    new Target("BenchmarkTest00236", "doPost"),
    new Target("BenchmarkTest00237", "doGet"),
    new Target("BenchmarkTest00237", "doPost"),
    new Target("BenchmarkTest00238", "doGet"),
    new Target("BenchmarkTest00238", "doPost"),
    new Target("BenchmarkTest00239", "doGet"),
    new Target("BenchmarkTest00239", "doPost"),
    new Target("BenchmarkTest00240", "doGet"),
    new Target("BenchmarkTest00240", "doPost"),
    new Target("BenchmarkTest00241", "doGet"),
    new Target("BenchmarkTest00241", "doPost"),
    new Target("BenchmarkTest00242", "doGet"),
    new Target("BenchmarkTest00242", "doPost"),
    new Target("BenchmarkTest00243", "doGet"),
    new Target("BenchmarkTest00243", "doPost"),
    new Target("BenchmarkTest00244", "doGet"),
    new Target("BenchmarkTest00244", "doPost"),
    new Target("BenchmarkTest00245", "doGet"),
    new Target("BenchmarkTest00245", "doPost"),
    new Target("BenchmarkTest00246", "doGet"),
    new Target("BenchmarkTest00246", "doPost"),
    new Target("BenchmarkTest00247", "doGet"),
    new Target("BenchmarkTest00247", "doPost"),
    new Target("BenchmarkTest00248", "doGet"),
    new Target("BenchmarkTest00248", "doPost"),
    new Target("BenchmarkTest00249", "doGet"),
    new Target("BenchmarkTest00249", "doPost"),
    new Target("BenchmarkTest00250", "doGet"),
    new Target("BenchmarkTest00250", "doPost"),
    new Target("BenchmarkTest00251", "doGet"),
    new Target("BenchmarkTest00251", "doPost"),
    new Target("BenchmarkTest00252", "doGet"),
    new Target("BenchmarkTest00252", "doPost"),
    new Target("BenchmarkTest00253", "doGet"),
    new Target("BenchmarkTest00253", "doPost"),
    new Target("BenchmarkTest00254", "doGet"),
    new Target("BenchmarkTest00254", "doPost"),
    new Target("BenchmarkTest00255", "doGet"),
    new Target("BenchmarkTest00255", "doPost"),
    new Target("BenchmarkTest00256", "doGet"),
    new Target("BenchmarkTest00256", "doPost"),
    new Target("BenchmarkTest00257", "doGet"),
    new Target("BenchmarkTest00257", "doPost"),
    new Target("BenchmarkTest00258", "doGet"),
    new Target("BenchmarkTest00258", "doPost"),
    new Target("BenchmarkTest00259", "doGet"),
    new Target("BenchmarkTest00259", "doPost"),
    new Target("BenchmarkTest00260", "doGet"),
    new Target("BenchmarkTest00260", "doPost"),
    new Target("BenchmarkTest00261", "doGet"),
    new Target("BenchmarkTest00261", "doPost"),
    new Target("BenchmarkTest00262", "doGet"),
    new Target("BenchmarkTest00262", "doPost"),
    new Target("BenchmarkTest00263", "doGet"),
    new Target("BenchmarkTest00263", "doPost"),
    new Target("BenchmarkTest00264", "doGet"),
    new Target("BenchmarkTest00264", "doPost"),
    new Target("BenchmarkTest00265", "doGet"),
    new Target("BenchmarkTest00265", "doPost"),
    new Target("BenchmarkTest00266", "doGet"),
    new Target("BenchmarkTest00266", "doPost"),
    new Target("BenchmarkTest00267", "doGet"),
    new Target("BenchmarkTest00267", "doPost"),
    new Target("BenchmarkTest00268", "doGet"),
    new Target("BenchmarkTest00268", "doPost"),
    new Target("BenchmarkTest00269", "doGet"),
    new Target("BenchmarkTest00269", "doPost"),
    new Target("BenchmarkTest00270", "doGet"),
    new Target("BenchmarkTest00270", "doPost"),
    new Target("BenchmarkTest00271", "doGet"),
    new Target("BenchmarkTest00271", "doPost"),
    new Target("BenchmarkTest00272", "doGet"),
    new Target("BenchmarkTest00272", "doPost"),
    new Target("BenchmarkTest00273", "doGet"),
    new Target("BenchmarkTest00273", "doPost"),
    new Target("BenchmarkTest00274", "doGet"),
    new Target("BenchmarkTest00274", "doPost"),
    new Target("BenchmarkTest00275", "doGet"),
    new Target("BenchmarkTest00275", "doPost"),
    new Target("BenchmarkTest00276", "doGet"),
    new Target("BenchmarkTest00276", "doPost"),
    new Target("BenchmarkTest00277", "doGet"),
    new Target("BenchmarkTest00277", "doPost"),
    new Target("BenchmarkTest00278", "doGet"),
    new Target("BenchmarkTest00278", "doPost"),
    new Target("BenchmarkTest00279", "doGet"),
    new Target("BenchmarkTest00279", "doPost"),
    new Target("BenchmarkTest00280", "doGet"),
    new Target("BenchmarkTest00280", "doPost"),
    new Target("BenchmarkTest00281", "doGet"),
    new Target("BenchmarkTest00281", "doPost"),
    new Target("BenchmarkTest00282", "doGet"),
    new Target("BenchmarkTest00282", "doPost"),
    new Target("BenchmarkTest00283", "doGet"),
    new Target("BenchmarkTest00283", "doPost"),
    new Target("BenchmarkTest00284", "doGet"),
    new Target("BenchmarkTest00284", "doPost"),
    new Target("BenchmarkTest00285", "doGet"),
    new Target("BenchmarkTest00285", "doPost"),
    new Target("BenchmarkTest00286", "doGet"),
    new Target("BenchmarkTest00286", "doPost"),
    new Target("BenchmarkTest00287", "doGet"),
    new Target("BenchmarkTest00287", "doPost"),
    new Target("BenchmarkTest00288", "doGet"),
    new Target("BenchmarkTest00288", "doPost"),
    new Target("BenchmarkTest00289", "doGet"),
    new Target("BenchmarkTest00289", "doPost"),
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
