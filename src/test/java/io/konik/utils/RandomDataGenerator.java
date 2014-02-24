package io.konik.utils;

import static org.apache.commons.lang3.ClassUtils.isAssignable;
import static org.apache.commons.lang3.ClassUtils.isPrimitiveOrWrapper;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;
import static org.apache.commons.lang3.reflect.MethodUtils.getAccessibleMethod;
import static org.apache.commons.lang3.reflect.MethodUtils.invokeMethod;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

import net._01001111.text.LoremIpsum;

public class RandomDataGenerator {
   LoremIpsum jlorem = new LoremIpsum();

   
   public void populteDataQuite(Object obj) {
      try {
         populteData(obj);
      } catch (InstantiationException e) {
         e.printStackTrace();
      } catch (IllegalAccessException e) {
         e.printStackTrace();
      } catch (NoSuchMethodException e) {
         e.printStackTrace();
      } catch (InvocationTargetException e) {
         e.printStackTrace();
      }
      
   }
   public void populteData(Object obj) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
      
      Method[] declaredMethods = obj.getClass().getDeclaredMethods();
      for (Method method : declaredMethods) {
         
         Class<?> methodMemberTypes;
         if (method.getName().startsWith("add")) 
            methodMemberTypes = method.getParameterTypes()[0];
         else if (method.getName().startsWith("get") && !Collection.class.isAssignableFrom(method.getReturnType())) {
            methodMemberTypes = method.getReturnType();
         }else continue;// next on setter
            
         if (isLeafType(methodMemberTypes)) {//final type
            Object val = generatePrimitveValue(methodMemberTypes,method.getName());
            setValue(obj,method,val);
         }else{// set or add dive 
            Object newInstance = methodMemberTypes.newInstance();
            populteData(newInstance);
            setValue(obj, method, newInstance);
         }
      }
   }

   private void setValue(Object objToSetOn, Method method, Object value) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException  {
      String invokeMethodName = method.getName().replace("get", "set");
      if (method.getName().startsWith("add")) invokeMethodName = method.getName();
      Method setterM = getAccessibleMethod(objToSetOn.getClass(), invokeMethodName, value.getClass());
      invokeMethod(objToSetOn, setterM.getName(), value);
   }

   private boolean isLeafType(Class<?> type) {
     if (isAssignable(Date.class,type)) return true;
     if (isAssignable(String.class,type)) return true;
     if (BigDecimal.class.isAssignableFrom(type)) return true;
     if (type.isEnum()) return true;
     return isPrimitiveOrWrapper(type);
   }

   private Object generatePrimitveValue(Class<?> type, String methodName) {
      if (String.class.isAssignableFrom(type)) return generateStringBasedOnName(methodName);
      if (BigDecimal.class.isAssignableFrom(type)) return new BigDecimal(randomNumeric(6));
      if (isAssignable(type,Boolean.class,true)) return true;
      if (isAssignable(type,Integer.class,true)) return randomNumeric(6);
      if (isAssignable(type,Integer.class,true)) return randomNumeric(6);
      if (type.isEnum()) return type.getClass().getEnumConstants()[0];
      if (isAssignable(type,Date.class,true)) return new Date();
      throw new IllegalArgumentException("Type " + type + " was not found");
   }

   private String generateStringBasedOnName(String methodName) {
      String name = jlorem.randomWord();
      
      if (methodName.contains("UnitCode")) {
         name = name.substring(0, 2);
      }
      
      return name;
   }

}