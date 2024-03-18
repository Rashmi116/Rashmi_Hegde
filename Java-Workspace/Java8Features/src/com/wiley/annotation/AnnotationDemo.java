/*package com.wiley.annotation;

import java.lang.annotation.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Target(ElementType.METHOD)

@Retention(RetentionPolicy.RUNTIME)

 @interface Test{
	 String info() default "";
 }
class Annotated{
	@Test(info="AWESOME")
	public void foo(String myParam) {
        System.out.println("This is " + myParam);
    }
	@Test(info="GOOD")
	public void zoo(String myParam) {
    	System.out.println("This is " + myParam);
    }
	
}

class TestAnnoationParser{
	public void parse(Class cls) throws Exception {
		Method[] methods=cls.getMethods();
		for(Method m:methods) {
			if (m.isAnnotationPresent(Test.class)) {
				m.getAnnotation(Test.class);
				Test test = m.getAnnotation(Test.class);
				String info = test.info();
				if ("AWESOME".equals(info)) {
					m.invoke(Annotated.class.newInstance(), "cool");
				}
			}
		}
	}
}

public class AnnotationDemo {

	public static void main(String[] args) throws Exception {
		TestAnnoationParser parser=new TestAnnoationParser();
		parser.parse(Annotated.class);
     
	}

}*/
