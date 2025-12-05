package fuzz;
import com.code_intelligence.jazzer.api.*;
import java.lang.reflect.*;
import java.util.*;

public class GeneratedFuzzTest_40 {
  static class Target { final String c, m; Target(String c, String m) { this.c=c; this.m=m; }}
  static Target[] targets = new Target[] {
    new Target("BenchmarkTest01890", "doGet"),
    new Target("BenchmarkTest01890", "doPost"),
    new Target("BenchmarkTest01891", "doGet"),
    new Target("BenchmarkTest01891", "doPost"),
    new Target("BenchmarkTest01892", "doGet"),
    new Target("BenchmarkTest01892", "doPost"),
    new Target("BenchmarkTest01893", "doGet"),
    new Target("BenchmarkTest01893", "doPost"),
    new Target("BenchmarkTest01894", "doGet"),
    new Target("BenchmarkTest01894", "doPost"),
    new Target("BenchmarkTest01895", "doGet"),
    new Target("BenchmarkTest01895", "doPost"),
    new Target("BenchmarkTest01896", "doGet"),
    new Target("BenchmarkTest01896", "doPost"),
    new Target("BenchmarkTest01897", "doGet"),
    new Target("BenchmarkTest01897", "doPost"),
    new Target("BenchmarkTest01898", "doGet"),
    new Target("BenchmarkTest01898", "doPost"),
    new Target("BenchmarkTest01899", "doGet"),
    new Target("BenchmarkTest01899", "doPost"),
    new Target("BenchmarkTest01900", "doGet"),
    new Target("BenchmarkTest01900", "doPost"),
    new Target("BenchmarkTest01901", "doGet"),
    new Target("BenchmarkTest01901", "doPost"),
    new Target("BenchmarkTest01902", "doGet"),
    new Target("BenchmarkTest01902", "doPost"),
    new Target("BenchmarkTest01903", "doGet"),
    new Target("BenchmarkTest01903", "doPost"),
    new Target("BenchmarkTest01904", "doGet"),
    new Target("BenchmarkTest01904", "doPost"),
    new Target("BenchmarkTest01905", "doGet"),
    new Target("BenchmarkTest01905", "doPost"),
    new Target("BenchmarkTest01906", "doGet"),
    new Target("BenchmarkTest01906", "doPost"),
    new Target("BenchmarkTest01907", "doGet"),
    new Target("BenchmarkTest01907", "doPost"),
    new Target("BenchmarkTest01908", "doGet"),
    new Target("BenchmarkTest01908", "doPost"),
    new Target("BenchmarkTest01909", "doGet"),
    new Target("BenchmarkTest01909", "doPost"),
    new Target("BenchmarkTest01910", "doGet"),
    new Target("BenchmarkTest01910", "doPost"),
    new Target("BenchmarkTest01911", "doGet"),
    new Target("BenchmarkTest01911", "doPost"),
    new Target("BenchmarkTest01912", "doGet"),
    new Target("BenchmarkTest01912", "doPost"),
    new Target("BenchmarkTest01913", "doGet"),
    new Target("BenchmarkTest01913", "doPost"),
    new Target("BenchmarkTest01914", "doGet"),
    new Target("BenchmarkTest01914", "doPost"),
    new Target("BenchmarkTest01915", "doGet"),
    new Target("BenchmarkTest01915", "doPost"),
    new Target("BenchmarkTest01916", "doGet"),
    new Target("BenchmarkTest01916", "doPost"),
    new Target("BenchmarkTest01917", "doGet"),
    new Target("BenchmarkTest01917", "doPost"),
    new Target("BenchmarkTest01918", "doGet"),
    new Target("BenchmarkTest01918", "doPost"),
    new Target("BenchmarkTest01919", "doGet"),
    new Target("BenchmarkTest01919", "doPost"),
    new Target("BenchmarkTest01920", "doGet"),
    new Target("BenchmarkTest01920", "doPost"),
    new Target("BenchmarkTest01921", "doGet"),
    new Target("BenchmarkTest01921", "doPost"),
    new Target("BenchmarkTest01922", "doGet"),
    new Target("BenchmarkTest01922", "doPost"),
    new Target("BenchmarkTest01923", "doGet"),
    new Target("BenchmarkTest01923", "doPost"),
    new Target("BenchmarkTest01924", "doGet"),
    new Target("BenchmarkTest01924", "doPost"),
    new Target("BenchmarkTest01925", "doGet"),
    new Target("BenchmarkTest01925", "doPost"),
    new Target("BenchmarkTest01926", "doGet"),
    new Target("BenchmarkTest01926", "doPost"),
    new Target("BenchmarkTest01927", "doGet"),
    new Target("BenchmarkTest01927", "doPost"),
    new Target("BenchmarkTest01928", "doGet"),
    new Target("BenchmarkTest01928", "doPost"),
    new Target("BenchmarkTest01929", "doGet"),
    new Target("BenchmarkTest01929", "doPost"),
    new Target("BenchmarkTest01930", "doGet"),
    new Target("BenchmarkTest01930", "doPost"),
    new Target("BenchmarkTest01931", "doGet"),
    new Target("BenchmarkTest01931", "doPost"),
    new Target("BenchmarkTest01932", "doGet"),
    new Target("BenchmarkTest01932", "doPost"),
    new Target("BenchmarkTest01933", "doGet"),
    new Target("BenchmarkTest01933", "doPost"),
    new Target("BenchmarkTest01934", "doGet"),
    new Target("BenchmarkTest01934", "doPost"),
    new Target("BenchmarkTest01935", "doGet"),
    new Target("BenchmarkTest01935", "doPost"),
    new Target("BenchmarkTest01936", "doGet"),
    new Target("BenchmarkTest01936", "doPost"),
    new Target("BenchmarkTest01937", "doGet"),
    new Target("BenchmarkTest01937", "doPost"),
    new Target("BenchmarkTest01938", "doGet"),
    new Target("BenchmarkTest01938", "doPost"),
    new Target("BenchmarkTest01939", "doGet"),
    new Target("BenchmarkTest01939", "doPost"),
    new Target("BenchmarkTest01940", "doGet"),
    new Target("BenchmarkTest01940", "doPost"),
    new Target("BenchmarkTest01941", "doGet"),
    new Target("BenchmarkTest01941", "doPost"),
    new Target("BenchmarkTest01942", "doGet"),
    new Target("BenchmarkTest01942", "doPost"),
    new Target("BenchmarkTest01943", "doGet"),
    new Target("BenchmarkTest01943", "doPost"),
    new Target("BenchmarkTest01944", "doGet"),
    new Target("BenchmarkTest01944", "doPost"),
    new Target("BenchmarkTest01945", "doGet"),
    new Target("BenchmarkTest01945", "doPost"),
    new Target("BenchmarkTest01946", "doGet"),
    new Target("BenchmarkTest01946", "doPost"),
    new Target("BenchmarkTest01947", "doGet"),
    new Target("BenchmarkTest01947", "doPost"),
    new Target("BenchmarkTest01948", "doGet"),
    new Target("BenchmarkTest01948", "doPost"),
    new Target("BenchmarkTest01949", "doGet"),
    new Target("BenchmarkTest01949", "doPost"),
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
