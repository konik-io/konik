/*
 * Copyright (C) 2014 konik.io
 *
 * This file is part of Konik library.
 *
 * Konik library is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Konik library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with Konik library.  If not, see <http://www.gnu.org/licenses/>.
 */
package io.konik.utils;

import static java.lang.Boolean.TRUE;
import static java.lang.reflect.Modifier.isAbstract;
import static org.apache.commons.lang3.ClassUtils.isAssignable;
import static org.apache.commons.lang3.ClassUtils.isPrimitiveOrWrapper;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;
import static org.apache.commons.lang3.reflect.MethodUtils.getAccessibleMethod;
import static org.apache.commons.lang3.reflect.MethodUtils.invokeMethod;
import io.konik.zugferd.entity.CommonTax;
import io.konik.zugferd.unqualified.ZfDate;
import io.konik.zugferd.unqualified.ZfDateFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.Random;

import net._01001111.text.LoremIpsum;

import org.apache.commons.lang3.RandomStringUtils;
@SuppressWarnings("javadoc")
public class RandomInvoiceGenerator {
   LoremIpsum jlorem = new LoremIpsum();
   Random random = new Random();
   String[] supportedDateFormatts = new String[] {"102","610","616"};
   

   @SuppressWarnings({ "unchecked" })
   public <T> T generate(Class<T> root) {
      try {
         return (T) populteData(root, null);
      } catch (InstantiationException e) {
         e.printStackTrace();
      } catch (IllegalAccessException e) {
         e.printStackTrace();
      } catch (NoSuchMethodException e) {
         e.printStackTrace();
      } catch (InvocationTargetException e) {
         e.printStackTrace();
      }
      return null;
   }
   
   public Object populteData(Class<?> root, String name) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
      Object rootObj;
      if (isLeafType(root)) {//final type
          return generatePrimitveValue(root,name);
      }
      rootObj = createNewInstance(root);

      // get method and populate each of them
      Method[] rootDeclaredMethods = root.getMethods();
      for (Method method : rootDeclaredMethods) {
         int modifiers = method.getModifiers();
         Class<?> methodType;
         if (method.getName().startsWith("add") && !isAbstract(modifiers)) 
            methodType = method.getParameterTypes()[0];
         else if (method.getName().startsWith("get") && !Collection.class.isAssignableFrom(method.getReturnType()) && !method.getName().startsWith("getClass") && !isAbstract(modifiers)) {
            methodType = method.getReturnType();
         }else continue;// next on setter
         //
         Object popultedData = populteData(methodType,method.getName());
         setValue(rootObj,method,popultedData);
      }
      return rootObj;
   }
   
   private Object createNewInstance(Class<?> root) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
      try {
         return root.newInstance();
      }catch(IllegalAccessException e) {
         Constructor<?> biggestConstructor = findBiggestConstructor(root);
         //for each parameter populate data
         Class<?>[] constructorParameters = biggestConstructor.getParameterTypes();
         Object[] constructorParameterObjects = new Object[constructorParameters.length];
         for (int i = 0; i < constructorParameters.length; i++) {
            Class<?> cp = constructorParameters[i];
            constructorParameterObjects[i] = populteData(cp,biggestConstructor.getName());
         }
         return biggestConstructor.newInstance(constructorParameterObjects);
      }
      catch (InstantiationException e) {
         if(root.equals(CommonTax.class)){
//            return ZfDateFactory.create(supportedDateFormatts[random.nextInt(3)]);
         }
//         throw e;
         return null;
      }
   }

   private Constructor<?> findBiggestConstructor(Class<?> root) {
      Constructor<?>[] constructors = root.getConstructors();
      Constructor<?> biggestConstructor = null;
      for (Constructor<?> constructor : constructors) {
         if (biggestConstructor == null) {
            biggestConstructor = constructor;
            continue;
         }
         if(constructor.getTypeParameters().length > biggestConstructor.getParameterTypes().length) {
            biggestConstructor = constructor;
         }
      }
      return biggestConstructor;
   }
   
   
   private void setValue(Object entity, Method entityMethod, Object paramValue) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException  {
      if(paramValue == null || entity == null)return;
      String methodToCall = entityMethod.getName().replace("get", "set");
//      int repeadAdder = 1;
      if (entityMethod.getName().startsWith("add")) { 
         Collection.class.isAssignableFrom(entityMethod.getReturnType());
         methodToCall = entityMethod.getName();//overwrite
//         repeadAdder += random.nextInt(5);//repeat call for adder
      }
      Method setterOrAdder = getAccessibleMethod(entity.getClass(), methodToCall, paramValue.getClass());
      if (setterOrAdder == null) {
         setterOrAdder = getAccessibleMethod(entity.getClass(), methodToCall, paramValue.getClass().getSuperclass());
      }
      if (setterOrAdder == null) {
         System.out.println("Could not find setter on Class Instnace :"+entity.getClass().getSimpleName() + " Getter :" + entityMethod.getName() + " has no setter. Ignoring value:" + paramValue.toString());
         return; 
      }
      //repeat a 2 times for adder
      for (int i = 0; i < 2; i++) {
         invokeMethod(entity, setterOrAdder.getName(), paramValue);   
      }
   }

   private boolean isLeafType(Class<?> type) {
     if (type.equals(Class.class))return true;
     if (isAssignable(ZfDate.class,type)) return true;
     if (isAssignable(Date.class,type)) return true;
     if (isAssignable(String.class,type)) return true;
     if (BigDecimal.class.isAssignableFrom(type)) return true;
     if (type.isEnum()) return true;
     return isPrimitiveOrWrapper(type);
   }

   private Object generatePrimitveValue(Class<?> type, String methodName) {
      if (methodName.equals("getClass")) return type;
      if (String.class.isAssignableFrom(type)) return generateStringBasedOnName(methodName);
      if (BigDecimal.class.isAssignableFrom(type)) return new BigDecimal(randomNumeric(3)+"."+randomNumeric(6));
      if (isAssignable(type,Boolean.class,true)) return TRUE;
      if (isAssignable(type,Integer.class,true)) return Integer.valueOf(random.nextInt(100));
      if (type.isEnum()) return getEnum(type);
      if (isAssignable(type,ZfDate.class,true)) return ZfDateFactory.create(supportedDateFormatts[random.nextInt(3)]);
      if (isAssignable(type,Date.class,true)) return new Date();
      if (isAssignable(type,Long.class,true)) return Long.valueOf(random.nextInt(100));
      throw new IllegalArgumentException("Type " + type + " was not found");
   }
   private Object getEnum(Class<?> type) {
      Object[] enumConstants = type.getEnumConstants();
      return enumConstants[random.nextInt(enumConstants.length)];
   }

   private String generateStringBasedOnName(String methodName) {
      String name = jlorem.randomWord();
      
      if (methodName.contains("UnitCode")) {
         return name.substring(0, name.length()<2?name.length():2);
      }
      
      if (methodName.contains("currencyId") ) {
         return RandomStringUtils.randomAlphabetic(3).toUpperCase();
      }
      
      if (methodName.contains("Number") ) {
         return String.valueOf(new Random().nextInt(1000));
      }
      
      if (methodName.contains("Telephone") || methodName.contains("Fax") ) {
         return "+4178906011";
      }
      
      if (methodName.contains("Description")) {
         return jlorem.sentences(2);
      }
      
      if (methodName.contains("Email")) {
         return "hello@konik.io";
      }
      
      if (methodName.contains("Id") ) {
         if(random.nextBoolean()) {
            return String.valueOf(random.nextInt(999));
         }
         return RandomStringUtils.randomAlphabetic(3).toUpperCase();
      }
      return name;
   }



}