package fuzz;
import com.code_intelligence.jazzer.api.*;
import java.lang.reflect.*;
import java.util.*;

public class GeneratedFuzzTest_13 {
  static class Target { final String c, m; Target(String c, String m) { this.c=c; this.m=m; }}
  static Target[] targets = new Target[] {
    new Target("BenchmarkTest00710", "doGet"),
    new Target("BenchmarkTest00710", "doPost"),
    new Target("BenchmarkTest00711", "doGet"),
    new Target("BenchmarkTest00711", "doPost"),
    new Target("BenchmarkTest00712", "doGet"),
    new Target("BenchmarkTest00712", "doPost"),
    new Target("BenchmarkTest00713", "doGet"),
    new Target("BenchmarkTest00713", "doPost"),
    new Target("BenchmarkTest00714", "doGet"),
    new Target("BenchmarkTest00714", "doPost"),
    new Target("BenchmarkTest00715", "doGet"),
    new Target("BenchmarkTest00715", "doPost"),
    new Target("BenchmarkTest00716", "doGet"),
    new Target("BenchmarkTest00716", "doPost"),
    new Target("BenchmarkTest00717", "doGet"),
    new Target("BenchmarkTest00717", "doPost"),
    new Target("BenchmarkTest00718", "doGet"),
    new Target("BenchmarkTest00718", "doPost"),
    new Target("BenchmarkTest00719", "doGet"),
    new Target("BenchmarkTest00719", "doPost"),
    new Target("BenchmarkTest00720", "doGet"),
    new Target("BenchmarkTest00720", "doPost"),
    new Target("BenchmarkTest00721", "doGet"),
    new Target("BenchmarkTest00721", "doPost"),
    new Target("BenchmarkTest00722", "doGet"),
    new Target("BenchmarkTest00722", "doPost"),
    new Target("BenchmarkTest00723", "doGet"),
    new Target("BenchmarkTest00723", "doPost"),
    new Target("BenchmarkTest00724", "doGet"),
    new Target("BenchmarkTest00724", "doPost"),
    new Target("BenchmarkTest00725", "doGet"),
    new Target("BenchmarkTest00725", "doPost"),
    new Target("BenchmarkTest00726", "doGet"),
    new Target("BenchmarkTest00726", "doPost"),
    new Target("BenchmarkTest00727", "doGet"),
    new Target("BenchmarkTest00727", "doPost"),
    new Target("BenchmarkTest00728", "doGet"),
    new Target("BenchmarkTest00728", "doPost"),
    new Target("BenchmarkTest00729", "doGet"),
    new Target("BenchmarkTest00729", "doPost"),
    new Target("BenchmarkTest00730", "doGet"),
    new Target("BenchmarkTest00730", "doPost"),
    new Target("BenchmarkTest00731", "doGet"),
    new Target("BenchmarkTest00731", "doPost"),
    new Target("BenchmarkTest00732", "doGet"),
    new Target("BenchmarkTest00732", "doPost"),
    new Target("BenchmarkTest00733", "doGet"),
    new Target("BenchmarkTest00733", "doPost"),
    new Target("BenchmarkTest00734", "doGet"),
    new Target("BenchmarkTest00734", "doPost"),
    new Target("BenchmarkTest00735", "doGet"),
    new Target("BenchmarkTest00735", "doPost"),
    new Target("BenchmarkTest00736", "doGet"),
    new Target("BenchmarkTest00736", "doPost"),
    new Target("BenchmarkTest00737", "doGet"),
    new Target("BenchmarkTest00737", "doPost"),
    new Target("BenchmarkTest00738", "doGet"),
    new Target("BenchmarkTest00738", "doPost"),
    new Target("BenchmarkTest00739", "doGet"),
    new Target("BenchmarkTest00739", "doPost"),
    new Target("BenchmarkTest00740", "doGet"),
    new Target("BenchmarkTest00740", "doPost"),
    new Target("BenchmarkTest00741", "doGet"),
    new Target("BenchmarkTest00741", "doPost"),
    new Target("BenchmarkTest00742", "doGet"),
    new Target("BenchmarkTest00742", "doPost"),
    new Target("BenchmarkTest00743", "doGet"),
    new Target("BenchmarkTest00743", "doPost"),
    new Target("BenchmarkTest00744", "doGet"),
    new Target("BenchmarkTest00744", "doPost"),
    new Target("BenchmarkTest00745", "doGet"),
    new Target("BenchmarkTest00745", "doPost"),
    new Target("BenchmarkTest00746", "doGet"),
    new Target("BenchmarkTest00746", "doPost"),
    new Target("BenchmarkTest00747", "doGet"),
    new Target("BenchmarkTest00747", "doPost"),
    new Target("BenchmarkTest00748", "doGet"),
    new Target("BenchmarkTest00748", "doPost"),
    new Target("BenchmarkTest00749", "doGet"),
    new Target("BenchmarkTest00749", "doPost"),
    new Target("BenchmarkTest00750", "doGet"),
    new Target("BenchmarkTest00750", "doPost"),
    new Target("BenchmarkTest00751", "doGet"),
    new Target("BenchmarkTest00751", "doPost"),
    new Target("BenchmarkTest00752", "doGet"),
    new Target("BenchmarkTest00752", "doPost"),
    new Target("BenchmarkTest00753", "doGet"),
    new Target("BenchmarkTest00753", "doPost"),
    new Target("BenchmarkTest00754", "doGet"),
    new Target("BenchmarkTest00754", "doPost"),
    new Target("BenchmarkTest00755", "doGet"),
    new Target("BenchmarkTest00755", "doPost"),
    new Target("BenchmarkTest00756", "doGet"),
    new Target("BenchmarkTest00756", "doPost"),
    new Target("BenchmarkTest00757", "doGet"),
    new Target("BenchmarkTest00757", "doPost"),
    new Target("BenchmarkTest00758", "doGet"),
    new Target("BenchmarkTest00758", "doPost"),
    new Target("BenchmarkTest00759", "doGet"),
    new Target("BenchmarkTest00759", "doPost"),
    new Target("BenchmarkTest00760", "doGet"),
    new Target("BenchmarkTest00760", "doPost"),
    new Target("BenchmarkTest00761", "doGet"),
    new Target("BenchmarkTest00761", "doPost"),
    new Target("BenchmarkTest00762", "doGet"),
    new Target("BenchmarkTest00762", "doPost"),
    new Target("BenchmarkTest00763", "doGet"),
    new Target("BenchmarkTest00763", "doPost"),
    new Target("BenchmarkTest00764", "doGet"),
    new Target("BenchmarkTest00764", "doPost"),
    new Target("BenchmarkTest00765", "doGet"),
    new Target("BenchmarkTest00765", "doPost"),
    new Target("BenchmarkTest00766", "doGet"),
    new Target("BenchmarkTest00766", "doPost"),
    new Target("BenchmarkTest00767", "doGet"),
    new Target("BenchmarkTest00767", "doPost"),
    new Target("BenchmarkTest00768", "doGet"),
    new Target("BenchmarkTest00768", "doPost"),
    new Target("BenchmarkTest00769", "doGet"),
    new Target("BenchmarkTest00769", "doPost"),
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
