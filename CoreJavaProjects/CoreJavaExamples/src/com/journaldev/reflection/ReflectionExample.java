package com.journaldev.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ReflectionExample {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, InstantiationException {
		
		// Get Class using reflection
		Class<?> concreteClass = ConcreteClass.class;
		concreteClass = new ConcreteClass(5).getClass();
		try {
			// below method is used most of the times in frameworks like JUnit
			//Spring dependency injection, Tomcat web container
			//Eclipse auto completion of method names, hibernate, Struts2 etc.
			//because ConcreteClass is not available at compile time
			concreteClass = Class.forName("com.journaldev.reflection.ConcreteClass");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(concreteClass.getCanonicalName()); // prints com.journaldev.reflection.ConcreteClass
		
		//for primitive types, wrapper classes and arrays
		Class<?> booleanClass = boolean.class;
		System.out.println(booleanClass.getCanonicalName()); // prints boolean
		
		Class<?> cDouble = Double.TYPE;
		System.out.println(cDouble.getCanonicalName()); // prints double
		
		Class<?> cDoubleArray = Class.forName("[D");
		System.out.println(cDoubleArray.getCanonicalName()); //prints double[]
		
		Class<?> twoDStringArray = String[][].class;
		System.out.println(twoDStringArray.getCanonicalName()); // prints java.lang.String[][]
		
		//getting public inner classes, enums, interface information including inherited class
		Class<?> superClass = Class.forName("com.journaldev.reflection.ConcreteClass").getSuperclass();
		System.out.println(superClass); // prints "class com.journaldev.reflection.BaseClass"
		System.out.println(Object.class.getSuperclass()); // prints "null"
		System.out.println(String[][].class.getSuperclass());// prints "class java.lang.Object"
		
		Class<?>[] classes = concreteClass.getClasses();
		//[class com.journaldev.reflection.ConcreteClass$ConcreteClassPublicClass, 
		//class com.journaldev.reflection.ConcreteClass$ConcreteClassPublicEnum, 
		//interface com.journaldev.reflection.ConcreteClass$ConcreteClassPublicInterface,
		//class com.journaldev.reflection.BaseClass$BaseClassInnerClass, 
		//class com.journaldev.reflection.BaseClass$BaseClassMemberEnum]
		System.out.println(Arrays.toString(classes));
		
		//getting all of the classes, interfaces, and enums that are explicitly declared in ConcreteClass
		Class<?>[] explicitClasses = Class.forName("com.journaldev.reflection.ConcreteClass").getDeclaredClasses();
		//[class com.journaldev.reflection.ConcreteClass$ConcreteClassDefaultClass, 
		//class com.journaldev.reflection.ConcreteClass$ConcreteClassDefaultEnum, 
		//class com.journaldev.reflection.ConcreteClass$ConcreteClassPrivateClass, 
		//class com.journaldev.reflection.ConcreteClass$ConcreteClassProtectedClass, 
		//class com.journaldev.reflection.ConcreteClass$ConcreteClassPublicClass, 
		//class com.journaldev.reflection.ConcreteClass$ConcreteClassPublicEnum, 
		//interface com.journaldev.reflection.ConcreteClass$ConcreteClassPublicInterface]
		System.out.println(Arrays.toString(explicitClasses));
		
		Class<?> innerClass = Class.forName("com.journaldev.reflection.ConcreteClass$ConcreteClassDefaultClass");
		//prints com.journaldev.reflection.ConcreteClass
		System.out.println(innerClass.getDeclaringClass().getCanonicalName());
		System.out.println(innerClass.getEnclosingClass().getCanonicalName()); //prints class com.journaldev.reflection.ConcreteClass
		
		//Get class modifiers, concreteClass.getModifiers() returns int representation of Modifiers, Modifier class can be used to return it in normal string format
		System.out.println(Modifier.toString(concreteClass.getModifiers())); //prints "public"
		//prints "public abstract interface"
		System.out.println(Modifier.toString(Class.forName("com.journaldev.reflection.BaseInterface").getModifiers())); 
		
		//Getting package name
		//prints "com.journaldev.reflection"
		System.out.println(Class.forName("com.journaldev.reflection.BaseInterface").getPackage().getName());
		//Get Type parameters (generics)
		TypeVariable<?>[] typeParameters = Class.forName("java.util.HashMap").getTypeParameters();
		for(TypeVariable<?> t : typeParameters)
		System.out.print(t.getName()+",");
		
		
		System.out.println("\n");
		
		Type[] interfaces = Class.forName("java.util.HashMap").getGenericInterfaces();
		//prints "[java.util.Map<K, V>, interface java.lang.Cloneable, interface java.io.Serializable]"
		System.out.println(Arrays.toString(interfaces));
		//prints "[interface java.util.Map, interface java.lang.Cloneable, interface java.io.Serializable]"
		System.out.println(Arrays.toString(Class.forName("java.util.HashMap").getInterfaces()));
		
		//Get All annotations
		java.lang.annotation.Annotation[] annotations = Class.forName("com.journaldev.reflection.ConcreteClass").getAnnotations();
		System.out.println(Arrays.toString(annotations));
		
		
		try {
			Field field = Class.forName("com.journaldev.reflection.ConcreteClass").getField("publicInt");
			Class<?> fieldType = field.getType();
			System.out.println(fieldType.getCanonicalName()); //prints int
			ConcreteClass obj = new ConcreteClass(5);
			System.out.println(field.get(obj)); //prints 5
			field.setInt(obj, 10); //setting field value to 10 in object
			System.out.println(field.get(obj)); //prints 10
			Class<?> fieldClass = field.getDeclaringClass();
			System.out.println(fieldClass.getCanonicalName()); //prints com.journaldev.reflection.BaseInterface
			
			Field privateField = Class.forName("com.journaldev.reflection.ConcreteClass").getDeclaredField("privateString");
			//turning off access check with below method call
			privateField.setAccessible(true);
			ConcreteClass objTest = new ConcreteClass(1);
			System.out.println(privateField.get(objTest)); // prints "private string"
			privateField.set(objTest, "private string updated");
			System.out.println(privateField.get(objTest)); //prints "private string updated"
		} catch (NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
		
		try {
			Method method = Class.forName("com.journaldev.reflection.ConcreteClass").getMethod("method4", null);
			System.out.println(method.getDeclaringClass()); //prints class com.journaldev.reflection.ConcreteClass
			method = Class.forName("com.journaldev.reflection.ConcreteClass").getMethod("method5", int.class);
			System.out.println(method.getDeclaringClass()); //prints class com.journaldev.reflection.ConcreteClass
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		
		Method method = Class.forName("java.util.HashMap").getMethod("put", Object.class, Object.class);
		//get method parameter types, prints "[class java.lang.Object, class java.lang.Object]"
		System.out.println(Arrays.toString(method.getParameterTypes()));
		//get method return type, return "class java.lang.Object", class reference for void
		System.out.println(method.getReturnType());
		//get method modifiers
		System.out.println(Modifier.toString(method.getModifiers()));
		
		//invoking method
		Map<String, String> hm = new HashMap<>();
		method.invoke(hm, "key", "value");
		System.out.println(hm); // prints {key=value}
		
		//invoking private method
		method = Class.forName("com.journaldev.reflection.BaseClass").getDeclaredMethod("method3", null);
		method.setAccessible(true);
		method.invoke(null, null); //prints "Method3"
		
		//constructors
		Constructor<?> constructor = Class.forName("com.journaldev.reflection.ConcreteClass").getConstructor(int.class);
		//getting constructor parameters
		System.out.println(Arrays.toString(constructor.getParameterTypes())); // prints "[int]"
		
		Object myObj = constructor.newInstance(10);
		
		Method myObjMethod = myObj.getClass().getMethod("method1", null);
		myObjMethod.invoke(myObj, null); //prints "Method1 impl."
		
		Constructor<?> hashMapConstructor = Class.forName("java.util.HashMap").getConstructor(null);
		System.out.println(Arrays.toString(hashMapConstructor.getParameterTypes())); // prints "[]"
		HashMap<String,String> myMap = (HashMap<String,String>) hashMapConstructor.newInstance(null);
	}

}
