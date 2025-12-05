package fuzz;
import com.code_intelligence.jazzer.api.*;
import java.lang.reflect.*;
import java.util.*;

public class GeneratedFuzzTest_51 {
  static class Target { final String c, m; Target(String c, String m) { this.c=c; this.m=m; }}
  static Target[] targets = new Target[] {
    new Target("BenchmarkTest02550", "doGet"),
    new Target("BenchmarkTest02550", "doPost"),
    new Target("BenchmarkTest02551", "doGet"),
    new Target("BenchmarkTest02551", "doPost"),
    new Target("BenchmarkTest02552", "doGet"),
    new Target("BenchmarkTest02552", "doPost"),
    new Target("BenchmarkTest02553", "doGet"),
    new Target("BenchmarkTest02553", "doPost"),
    new Target("BenchmarkTest02554", "doGet"),
    new Target("BenchmarkTest02554", "doPost"),
    new Target("BenchmarkTest02555", "doGet"),
    new Target("BenchmarkTest02555", "doPost"),
    new Target("BenchmarkTest02556", "doGet"),
    new Target("BenchmarkTest02556", "doPost"),
    new Target("BenchmarkTest02557", "doGet"),
    new Target("BenchmarkTest02557", "doPost"),
    new Target("BenchmarkTest02558", "doGet"),
    new Target("BenchmarkTest02558", "doPost"),
    new Target("BenchmarkTest02559", "doGet"),
    new Target("BenchmarkTest02559", "doPost"),
    new Target("BenchmarkTest02560", "doGet"),
    new Target("BenchmarkTest02560", "doPost"),
    new Target("BenchmarkTest02561", "doGet"),
    new Target("BenchmarkTest02561", "doPost"),
    new Target("BenchmarkTest02562", "doGet"),
    new Target("BenchmarkTest02562", "doPost"),
    new Target("BenchmarkTest02563", "doGet"),
    new Target("BenchmarkTest02563", "doPost"),
    new Target("BenchmarkTest02564", "doGet"),
    new Target("BenchmarkTest02564", "doPost"),
    new Target("BenchmarkTest02565", "doGet"),
    new Target("BenchmarkTest02565", "doPost"),
    new Target("BenchmarkTest02566", "doGet"),
    new Target("BenchmarkTest02566", "doPost"),
    new Target("BenchmarkTest02567", "doGet"),
    new Target("BenchmarkTest02567", "doPost"),
    new Target("BenchmarkTest02568", "doGet"),
    new Target("BenchmarkTest02568", "doPost"),
    new Target("BenchmarkTest02569", "doGet"),
    new Target("BenchmarkTest02569", "doPost"),
    new Target("BenchmarkTest02570", "doGet"),
    new Target("BenchmarkTest02570", "doPost"),
    new Target("BenchmarkTest02571", "doGet"),
    new Target("BenchmarkTest02571", "doPost"),
    new Target("BenchmarkTest02572", "doGet"),
    new Target("BenchmarkTest02572", "doPost"),
    new Target("BenchmarkTest02573", "doGet"),
    new Target("BenchmarkTest02573", "doPost"),
    new Target("BenchmarkTest02574", "doGet"),
    new Target("BenchmarkTest02574", "doPost"),
    new Target("BenchmarkTest02575", "doGet"),
    new Target("BenchmarkTest02575", "doPost"),
    new Target("BenchmarkTest02576", "doGet"),
    new Target("BenchmarkTest02576", "doPost"),
    new Target("BenchmarkTest02577", "doGet"),
    new Target("BenchmarkTest02577", "doPost"),
    new Target("BenchmarkTest02578", "doGet"),
    new Target("BenchmarkTest02578", "doPost"),
    new Target("BenchmarkTest02579", "doGet"),
    new Target("BenchmarkTest02579", "doPost"),
    new Target("BenchmarkTest02580", "doGet"),
    new Target("BenchmarkTest02580", "doPost"),
    new Target("BenchmarkTest02581", "doGet"),
    new Target("BenchmarkTest02581", "doPost"),
    new Target("BenchmarkTest02582", "doGet"),
    new Target("BenchmarkTest02582", "doPost"),
    new Target("BenchmarkTest02583", "doGet"),
    new Target("BenchmarkTest02583", "doPost"),
    new Target("BenchmarkTest02584", "doGet"),
    new Target("BenchmarkTest02584", "doPost"),
    new Target("BenchmarkTest02585", "doGet"),
    new Target("BenchmarkTest02585", "doPost"),
    new Target("BenchmarkTest02586", "doGet"),
    new Target("BenchmarkTest02586", "doPost"),
    new Target("BenchmarkTest02587", "doGet"),
    new Target("BenchmarkTest02587", "doPost"),
    new Target("BenchmarkTest02588", "doGet"),
    new Target("BenchmarkTest02588", "doPost"),
    new Target("BenchmarkTest02589", "doGet"),
    new Target("BenchmarkTest02589", "doPost"),
    new Target("BenchmarkTest02590", "doGet"),
    new Target("BenchmarkTest02590", "doPost"),
    new Target("BenchmarkTest02591", "doGet"),
    new Target("BenchmarkTest02591", "doPost"),
    new Target("BenchmarkTest02592", "doGet"),
    new Target("BenchmarkTest02592", "doPost"),
    new Target("BenchmarkTest02593", "doGet"),
    new Target("BenchmarkTest02593", "doPost"),
    new Target("BenchmarkTest02594", "doGet"),
    new Target("BenchmarkTest02594", "doPost"),
    new Target("BenchmarkTest02595", "doGet"),
    new Target("BenchmarkTest02595", "doPost"),
    new Target("BenchmarkTest02596", "doGet"),
    new Target("BenchmarkTest02596", "doPost"),
    new Target("BenchmarkTest02597", "doGet"),
    new Target("BenchmarkTest02597", "doPost"),
    new Target("BenchmarkTest02598", "doGet"),
    new Target("BenchmarkTest02598", "doPost"),
    new Target("BenchmarkTest02599", "doGet"),
    new Target("BenchmarkTest02599", "doPost"),
    new Target("BenchmarkTest02600", "doGet"),
    new Target("BenchmarkTest02600", "doPost"),
    new Target("BenchmarkTest02601", "doGet"),
    new Target("BenchmarkTest02601", "doPost"),
    new Target("BenchmarkTest02602", "doGet"),
    new Target("BenchmarkTest02602", "doPost"),
    new Target("BenchmarkTest02603", "doGet"),
    new Target("BenchmarkTest02603", "doPost"),
    new Target("BenchmarkTest02604", "doGet"),
    new Target("BenchmarkTest02604", "doPost"),
    new Target("BenchmarkTest02605", "doGet"),
    new Target("BenchmarkTest02605", "doPost"),
    new Target("BenchmarkTest02606", "doGet"),
    new Target("BenchmarkTest02606", "doPost"),
    new Target("BenchmarkTest02607", "doGet"),
    new Target("BenchmarkTest02607", "doPost"),
    new Target("BenchmarkTest02608", "doGet"),
    new Target("BenchmarkTest02608", "doPost"),
    new Target("BenchmarkTest02609", "doGet"),
    new Target("BenchmarkTest02609", "doPost"),
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
