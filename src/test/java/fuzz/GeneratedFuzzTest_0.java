package fuzz;
import com.code_intelligence.jazzer.api.*;
import java.lang.reflect.*;
import java.util.*;

public class GeneratedFuzzTest_0 {
  static class Target { final String c, m; Target(String c, String m) { this.c=c; this.m=m; }}
  static Target[] targets = new Target[] {
    new Target("DatabaseHelper", "initDataBase"),
    new Target("DatabaseHelper", "getSqlStatement"),
    new Target("DatabaseHelper", "reset"),
    new Target("DatabaseHelper", "getSqlConnection"),
    new Target("DatabaseHelper", "executeSQLCommand"),
    new Target("DatabaseHelper", "outputUpdateComplete"),
    new Target("DatabaseHelper", "outputUpdateComplete"),
    new Target("DatabaseHelper", "printResults"),
    new Target("DatabaseHelper", "printResults"),
    new Target("DatabaseHelper", "printResults"),
    new Target("DatabaseHelper", "printResults"),
    new Target("DatabaseHelper", "printResults"),
    new Target("DatabaseHelper", "printResults"),
    new Target("DatabaseHelper", "printColTypes"),
    new Target("DataBaseServer", "getOtherOrder"),
    new Target("DataBaseServer", "createOrder2"),
    new Target("DataBaseServer", "getAll"),
    new Target("DataBaseServer", "main"),
    new Target("Certificate", "getId"),
    new Target("Certificate", "setId"),
    new Target("Certificate", "getName"),
    new Target("Certificate", "setName"),
    new Target("Certificate", "equals"),
    new Target("Certificate", "hashCode"),
    new Target("Employee", "getId"),
    new Target("Employee", "setId"),
    new Target("Employee", "getFirstName"),
    new Target("Employee", "setFirstName"),
    new Target("Employee", "getLastName"),
    new Target("Employee", "setLastName"),
    new Target("Employee", "getSalary"),
    new Target("Employee", "setSalary"),
    new Target("Employee", "getCertificates"),
    new Target("Employee", "setCertificates"),
    new Target("Hobby", "getHobbyId"),
    new Target("Hobby", "setHobbyId"),
    new Target("Hobby", "getName"),
    new Target("Hobby", "setName"),
    new Target("User", "getUserId"),
    new Target("User", "setUserId"),
    new Target("User", "getHobbyId"),
    new Target("User", "setHobbyId"),
    new Target("User", "getPassword"),
    new Target("User", "setPassword"),
    new Target("User", "getName"),
    new Target("User", "setName"),
    new Target("ExpressionEvaluator", "evaluateEL"),
    new Target("ExpressionEvaluator", "evaluate"),
    new Target("ExpressionEvaluator", "parseExpression"),
    new Target("DataBaseFilter", "init"),
    new Target("DataBaseFilter", "doFilter"),
    new Target("DataBaseFilter", "destroy"),
    new Target("HTTPResponseHeaderFilter", "init"),
    new Target("HTTPResponseHeaderFilter", "doFilter"),
    new Target("HTTPResponseHeaderFilter", "destroy"),
    new Target("HibernateUtil", "getSessionFactory"),
    new Target("HibernateUtil", "getSession"),
    new Target("HibernateUtil", "destroySession"),
    new Target("HibernateUtil", "getClassicSession"),
    new Target("HibernateUtil", "destroyClassicSession"),
    new Target("HibernateUtil", "executeSQLCommand"),
    new Target("HibernateUtil", "initData"),
    new Target("HibernateUtil", "initClassicData"),
    new Target("HibernateUtil", "checkData"),
    new Target("HibernateUtil", "checkClassicData"),
    new Target("LDAPManager", "insert"),
    new Target("LDAPManager", "getDirContext"),
    new Target("LDAPManager", "closeDirContext"),
    new Target("LDAPPerson", "getName"),
    new Target("LDAPPerson", "setName"),
    new Target("LDAPPerson", "getAddress"),
    new Target("LDAPPerson", "setAddress"),
    new Target("LDAPPerson", "getPassword"),
    new Target("LDAPPerson", "setPassword"),
    new Target("LDAPServer", "getBasePartitionName"),
    new Target("LDAPServer", "getBaseStructure"),
    new Target("LDAPServer", "getBaseCacheSize"),
    new Target("LDAPServer", "getLdapServerPort"),
    new Target("LDAPServer", "getAttrNamesToIndex"),
    new Target("LDAPServer", "init"),
    new Target("LDAPServer", "destroy"),
    new Target("LDAPServer", "getDirectoryServiceName"),
    new Target("LDAPServer", "getSystemIndexMap"),
    new Target("LDAPServer", "getUserIndexMap"),
    new Target("LDAPServer", "getPartitionsDirectory"),
    new Target("LDAPServer", "getBasePartitionPath"),
    new Target("LDAPServer", "getGuessedInstanceDirectory"),
    new Target("LDAPServer", "getOidByAttributeName"),
    new Target("LDAPServer", "addSchemaFromPath"),
    new Target("LDAPServer", "addSchemaFromClasspath"),
    new Target("LDAPServer", "getDirectoryService"),
    new Target("LDAPServer", "setDirectoryService"),
    new Target("LDAPServer", "getLdapServer"),
    new Target("LDAPServer", "setLdapServer"),
    new Target("LDAPServer", "getBasePartition"),
    new Target("LDAPServer", "setBasePartition"),
    new Target("LDAPServer", "getDeleteInstanceDirectoryOnStartup"),
    new Target("LDAPServer", "setDeleteInstanceDirectoryOnStartup"),
    new Target("LDAPServer", "getDeleteInstanceDirectoryOnShutdown"),
    new Target("LDAPServer", "setDeleteInstanceDirectoryOnShutdown"),
    new Target("LDAPServer", "main"),
    new Target("PropertiesManager", "displayProperties"),
    new Target("PropertiesManager", "getProperty"),
    new Target("PropertiesManager", "getProperty"),
    new Target("PropertiesManager", "saveProperty"),
    new Target("PropertiesManager", "removeProperty"),
    new Target("SeparateClassRequest", "getTheParameter"),
    new Target("SeparateClassRequest", "getTheCookie"),
    new Target("SeparateClassRequest", "getTheValue"),
    new Target("Startup", "contextInitialized"),
    new Target("Startup", "contextDestroyed"),
    new Target("Thing1", "doSomething"),
    new Target("Thing2", "doSomething"),
    new Target("ThingFactory", "createThing"),
    new Target("ThingInterface", "doSomething"),
    new Target("Utils", "getCookie"),
    new Target("Utils", "getOSCommandString"),
    new Target("Utils", "getInsecureOSCommandString"),
    new Target("Utils", "getOSCommandArray"),
    new Target("Utils", "printOSCommandResults"),
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
