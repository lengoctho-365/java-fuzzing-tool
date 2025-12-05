package fuzz;
import com.code_intelligence.jazzer.api.*;
import java.lang.reflect.*;
import java.util.*;

public class GeneratedFuzzTest_39 {
  static class Target { final String c, m; Target(String c, String m) { this.c=c; this.m=m; }}
  static Target[] targets = new Target[] {
    new Target("BenchmarkTest01830", "doGet"),
    new Target("BenchmarkTest01830", "doPost"),
    new Target("BenchmarkTest01831", "doGet"),
    new Target("BenchmarkTest01831", "doPost"),
    new Target("BenchmarkTest01832", "doGet"),
    new Target("BenchmarkTest01832", "doPost"),
    new Target("BenchmarkTest01833", "doGet"),
    new Target("BenchmarkTest01833", "doPost"),
    new Target("BenchmarkTest01834", "doGet"),
    new Target("BenchmarkTest01834", "doPost"),
    new Target("BenchmarkTest01835", "doGet"),
    new Target("BenchmarkTest01835", "doPost"),
    new Target("BenchmarkTest01836", "doGet"),
    new Target("BenchmarkTest01836", "doPost"),
    new Target("BenchmarkTest01837", "doGet"),
    new Target("BenchmarkTest01837", "doPost"),
    new Target("BenchmarkTest01838", "doGet"),
    new Target("BenchmarkTest01838", "doPost"),
    new Target("BenchmarkTest01839", "doGet"),
    new Target("BenchmarkTest01839", "doPost"),
    new Target("BenchmarkTest01840", "doGet"),
    new Target("BenchmarkTest01840", "doPost"),
    new Target("BenchmarkTest01841", "doGet"),
    new Target("BenchmarkTest01841", "doPost"),
    new Target("BenchmarkTest01842", "doGet"),
    new Target("BenchmarkTest01842", "doPost"),
    new Target("BenchmarkTest01843", "doGet"),
    new Target("BenchmarkTest01843", "doPost"),
    new Target("BenchmarkTest01844", "doGet"),
    new Target("BenchmarkTest01844", "doPost"),
    new Target("BenchmarkTest01845", "doGet"),
    new Target("BenchmarkTest01845", "doPost"),
    new Target("BenchmarkTest01846", "doGet"),
    new Target("BenchmarkTest01846", "doPost"),
    new Target("BenchmarkTest01847", "doGet"),
    new Target("BenchmarkTest01847", "doPost"),
    new Target("BenchmarkTest01848", "doGet"),
    new Target("BenchmarkTest01848", "doPost"),
    new Target("BenchmarkTest01849", "doGet"),
    new Target("BenchmarkTest01849", "doPost"),
    new Target("BenchmarkTest01850", "doGet"),
    new Target("BenchmarkTest01850", "doPost"),
    new Target("BenchmarkTest01851", "doGet"),
    new Target("BenchmarkTest01851", "doPost"),
    new Target("BenchmarkTest01852", "doGet"),
    new Target("BenchmarkTest01852", "doPost"),
    new Target("BenchmarkTest01853", "doGet"),
    new Target("BenchmarkTest01853", "doPost"),
    new Target("BenchmarkTest01854", "doGet"),
    new Target("BenchmarkTest01854", "doPost"),
    new Target("BenchmarkTest01855", "doGet"),
    new Target("BenchmarkTest01855", "doPost"),
    new Target("BenchmarkTest01856", "doGet"),
    new Target("BenchmarkTest01856", "doPost"),
    new Target("BenchmarkTest01857", "doGet"),
    new Target("BenchmarkTest01857", "doPost"),
    new Target("BenchmarkTest01858", "doGet"),
    new Target("BenchmarkTest01858", "doPost"),
    new Target("BenchmarkTest01859", "doGet"),
    new Target("BenchmarkTest01859", "doPost"),
    new Target("BenchmarkTest01860", "doGet"),
    new Target("BenchmarkTest01860", "doPost"),
    new Target("BenchmarkTest01861", "doGet"),
    new Target("BenchmarkTest01861", "doPost"),
    new Target("BenchmarkTest01862", "doGet"),
    new Target("BenchmarkTest01862", "doPost"),
    new Target("BenchmarkTest01863", "doGet"),
    new Target("BenchmarkTest01863", "doPost"),
    new Target("BenchmarkTest01864", "doGet"),
    new Target("BenchmarkTest01864", "doPost"),
    new Target("BenchmarkTest01865", "doGet"),
    new Target("BenchmarkTest01865", "doPost"),
    new Target("BenchmarkTest01866", "doGet"),
    new Target("BenchmarkTest01866", "doPost"),
    new Target("BenchmarkTest01867", "doGet"),
    new Target("BenchmarkTest01867", "doPost"),
    new Target("BenchmarkTest01868", "doGet"),
    new Target("BenchmarkTest01868", "doPost"),
    new Target("BenchmarkTest01869", "doGet"),
    new Target("BenchmarkTest01869", "doPost"),
    new Target("BenchmarkTest01870", "doGet"),
    new Target("BenchmarkTest01870", "doPost"),
    new Target("BenchmarkTest01871", "doGet"),
    new Target("BenchmarkTest01871", "doPost"),
    new Target("BenchmarkTest01872", "doGet"),
    new Target("BenchmarkTest01872", "doPost"),
    new Target("BenchmarkTest01873", "doGet"),
    new Target("BenchmarkTest01873", "doPost"),
    new Target("BenchmarkTest01874", "doGet"),
    new Target("BenchmarkTest01874", "doPost"),
    new Target("BenchmarkTest01875", "doGet"),
    new Target("BenchmarkTest01875", "doPost"),
    new Target("BenchmarkTest01876", "doGet"),
    new Target("BenchmarkTest01876", "doPost"),
    new Target("BenchmarkTest01877", "doGet"),
    new Target("BenchmarkTest01877", "doPost"),
    new Target("BenchmarkTest01878", "doGet"),
    new Target("BenchmarkTest01878", "doPost"),
    new Target("BenchmarkTest01879", "doGet"),
    new Target("BenchmarkTest01879", "doPost"),
    new Target("BenchmarkTest01880", "doGet"),
    new Target("BenchmarkTest01880", "doPost"),
    new Target("BenchmarkTest01881", "doGet"),
    new Target("BenchmarkTest01881", "doPost"),
    new Target("BenchmarkTest01882", "doGet"),
    new Target("BenchmarkTest01882", "doPost"),
    new Target("BenchmarkTest01883", "doGet"),
    new Target("BenchmarkTest01883", "doPost"),
    new Target("BenchmarkTest01884", "doGet"),
    new Target("BenchmarkTest01884", "doPost"),
    new Target("BenchmarkTest01885", "doGet"),
    new Target("BenchmarkTest01885", "doPost"),
    new Target("BenchmarkTest01886", "doGet"),
    new Target("BenchmarkTest01886", "doPost"),
    new Target("BenchmarkTest01887", "doGet"),
    new Target("BenchmarkTest01887", "doPost"),
    new Target("BenchmarkTest01888", "doGet"),
    new Target("BenchmarkTest01888", "doPost"),
    new Target("BenchmarkTest01889", "doGet"),
    new Target("BenchmarkTest01889", "doPost"),
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
