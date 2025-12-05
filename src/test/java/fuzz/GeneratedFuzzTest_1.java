package fuzz;
import com.code_intelligence.jazzer.api.*;
import java.lang.reflect.*;
import java.util.*;

public class GeneratedFuzzTest_1 {
  static class Target { final String c, m; Target(String c, String m) { this.c=c; this.m=m; }}
  static Target[] targets = new Target[] {
    new Target("Utils", "printOSCommandResults"),
    new Target("Utils", "getFileFromClasspath"),
    new Target("Utils", "getLinesFromFile"),
    new Target("Utils", "getLinesFromFile"),
    new Target("Utils", "encodeForHTML"),
    new Target("Utils", "writeLineToFile"),
    new Target("Utils", "getCipher"),
    new Target("Utils", "getSSLFactory"),
    new Target("Utils", "getClassImplementationInfo"),
    new Target("KeepAsJsonDeserializer", "deserialize"),
    new Target("SonarReport", "main"),
    new Target("Person", "getId"),
    new Target("Person", "getAddress"),
    new Target("Person", "setId"),
    new Target("Person", "setAddress"),
    new Target("Person", "getFirstName"),
    new Target("Person", "setFirstName"),
    new Target("Person", "getLastName"),
    new Target("Person", "setLastName"),
    new Target("Person", "toString"),
    new Target("XMLMessage", "getMsg"),
    new Target("XMLMessage", "setMsg"),
    new Target("BenchmarkTest00001", "doGet"),
    new Target("BenchmarkTest00001", "doPost"),
    new Target("BenchmarkTest00002", "doGet"),
    new Target("BenchmarkTest00002", "doPost"),
    new Target("BenchmarkTest00003", "doGet"),
    new Target("BenchmarkTest00003", "doPost"),
    new Target("BenchmarkTest00004", "doGet"),
    new Target("BenchmarkTest00004", "doPost"),
    new Target("BenchmarkTest00005", "doGet"),
    new Target("BenchmarkTest00005", "doPost"),
    new Target("BenchmarkTest00006", "doGet"),
    new Target("BenchmarkTest00006", "doPost"),
    new Target("BenchmarkTest00007", "doGet"),
    new Target("BenchmarkTest00007", "doPost"),
    new Target("BenchmarkTest00008", "doGet"),
    new Target("BenchmarkTest00008", "doPost"),
    new Target("BenchmarkTest00009", "doGet"),
    new Target("BenchmarkTest00009", "doPost"),
    new Target("BenchmarkTest00010", "doGet"),
    new Target("BenchmarkTest00010", "doPost"),
    new Target("BenchmarkTest00011", "doGet"),
    new Target("BenchmarkTest00011", "doPost"),
    new Target("BenchmarkTest00012", "doGet"),
    new Target("BenchmarkTest00012", "doPost"),
    new Target("BenchmarkTest00013", "doGet"),
    new Target("BenchmarkTest00013", "doPost"),
    new Target("BenchmarkTest00014", "doGet"),
    new Target("BenchmarkTest00014", "doPost"),
    new Target("BenchmarkTest00015", "doGet"),
    new Target("BenchmarkTest00015", "doPost"),
    new Target("BenchmarkTest00016", "doGet"),
    new Target("BenchmarkTest00016", "doPost"),
    new Target("BenchmarkTest00017", "doGet"),
    new Target("BenchmarkTest00017", "doPost"),
    new Target("BenchmarkTest00018", "doGet"),
    new Target("BenchmarkTest00018", "doPost"),
    new Target("BenchmarkTest00019", "doGet"),
    new Target("BenchmarkTest00019", "doPost"),
    new Target("BenchmarkTest00020", "doGet"),
    new Target("BenchmarkTest00020", "doPost"),
    new Target("BenchmarkTest00021", "doGet"),
    new Target("BenchmarkTest00021", "doPost"),
    new Target("BenchmarkTest00022", "doGet"),
    new Target("BenchmarkTest00022", "doPost"),
    new Target("BenchmarkTest00023", "doGet"),
    new Target("BenchmarkTest00023", "doPost"),
    new Target("BenchmarkTest00024", "doGet"),
    new Target("BenchmarkTest00024", "doPost"),
    new Target("BenchmarkTest00025", "doGet"),
    new Target("BenchmarkTest00025", "doPost"),
    new Target("BenchmarkTest00026", "doGet"),
    new Target("BenchmarkTest00026", "doPost"),
    new Target("BenchmarkTest00027", "doGet"),
    new Target("BenchmarkTest00027", "doPost"),
    new Target("BenchmarkTest00028", "doGet"),
    new Target("BenchmarkTest00028", "doPost"),
    new Target("BenchmarkTest00029", "doGet"),
    new Target("BenchmarkTest00029", "doPost"),
    new Target("BenchmarkTest00030", "doGet"),
    new Target("BenchmarkTest00030", "doPost"),
    new Target("BenchmarkTest00031", "doGet"),
    new Target("BenchmarkTest00031", "doPost"),
    new Target("BenchmarkTest00032", "doGet"),
    new Target("BenchmarkTest00032", "doPost"),
    new Target("BenchmarkTest00033", "doGet"),
    new Target("BenchmarkTest00033", "doPost"),
    new Target("BenchmarkTest00034", "doGet"),
    new Target("BenchmarkTest00034", "doPost"),
    new Target("BenchmarkTest00035", "doGet"),
    new Target("BenchmarkTest00035", "doPost"),
    new Target("BenchmarkTest00036", "doGet"),
    new Target("BenchmarkTest00036", "doPost"),
    new Target("BenchmarkTest00037", "doGet"),
    new Target("BenchmarkTest00037", "doPost"),
    new Target("BenchmarkTest00038", "doGet"),
    new Target("BenchmarkTest00038", "doPost"),
    new Target("BenchmarkTest00039", "doGet"),
    new Target("BenchmarkTest00039", "doPost"),
    new Target("BenchmarkTest00040", "doGet"),
    new Target("BenchmarkTest00040", "doPost"),
    new Target("BenchmarkTest00041", "doGet"),
    new Target("BenchmarkTest00041", "doPost"),
    new Target("BenchmarkTest00042", "doGet"),
    new Target("BenchmarkTest00042", "doPost"),
    new Target("BenchmarkTest00043", "doGet"),
    new Target("BenchmarkTest00043", "doPost"),
    new Target("BenchmarkTest00044", "doGet"),
    new Target("BenchmarkTest00044", "doPost"),
    new Target("BenchmarkTest00045", "doGet"),
    new Target("BenchmarkTest00045", "doPost"),
    new Target("BenchmarkTest00046", "doGet"),
    new Target("BenchmarkTest00046", "doPost"),
    new Target("BenchmarkTest00047", "doGet"),
    new Target("BenchmarkTest00047", "doPost"),
    new Target("BenchmarkTest00048", "doGet"),
    new Target("BenchmarkTest00048", "doPost"),
    new Target("BenchmarkTest00049", "doGet"),
    new Target("BenchmarkTest00049", "doPost"),
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
