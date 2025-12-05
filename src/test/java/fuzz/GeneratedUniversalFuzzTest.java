package fuzz;
import com.code_intelligence.jazzer.api.*;
import org.springframework.mock.web.*;
import registry.MethodInfoRegistry;
import scanner.MethodInfo;
import java.lang.reflect.*;

public class GeneratedUniversalFuzzTest {

 public static void fuzzerTestOneInput(FuzzedDataProvider data) {
   try {
     String inputStr = data.consumeString(200);
     int inputInt = data.consumeInt();
     MockHttpServletRequest req = new MockHttpServletRequest();
     MockHttpServletResponse res = new MockHttpServletResponse();
     req.setParameter("input", inputStr);

     for (MethodInfo mi : MethodInfoRegistry.methods) {
       try {
         Class<?> cls = Class.forName(mi.className);
         Object instance = cls.getDeclaredConstructor().newInstance();
         Class<?>[] params = new Class<?>[mi.paramTypes.size()];
         for (int i = 0; i < mi.paramTypes.size(); i++) {
             params[i] = Class.forName(mi.paramTypes.get(i));
         }
         Method m = cls.getDeclaredMethod(mi.methodName, params);
         m.setAccessible(true);

         Object[] args = new Object[params.length];
         for (int i = 0; i < params.length; i++) {
             String p = params[i].getName();
             if (p.equals("java.lang.String")) args[i] = inputStr;
             else if (p.equals("int")) args[i] = inputInt;
             else if (p.contains("HttpServletRequest")) args[i] = req;
             else if (p.contains("HttpServletResponse")) args[i] = res;
             else args[i] = null;
         }
         m.invoke(instance, args);
       } catch (Throwable ignored) {}
     }
   } catch (Exception ignored) {}
 }
}
