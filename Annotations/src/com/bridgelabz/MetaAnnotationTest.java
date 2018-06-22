/********************************************************************************* *
 * Purpose: To make custom Annotation and use built in Meta Annotations within the program
 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 22/06/2018
 *********************************************************************************/
package com.bridgelabz;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
@interface MyAnnotation {
	int value();

	String value2() default "Saurav";
}

/**
 * @author Saurav:
 * Class Hello having Annotation usage
 */

class Hello {
	@MyAnnotation(value = 10)
	public void sayHello() {
		System.out.println("Hello Annotation");
	}
}

/**
 * @author Saurav:
 * Class to show the use of Meta Annotations in java
 */
public class MetaAnnotationTest extends Hello{
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		Hello hello=new Hello();
		Method m1=hello.getClass().getMethod("sayHello");
		MyAnnotation myAnnotation= m1.getAnnotation(MyAnnotation.class);//for using the annotation in Hello class
		System.out.println("tha value is:"+myAnnotation.value()+ " and name is: "+myAnnotation.value2());
		MetaAnnotationTest meta=new MetaAnnotationTest();
		Method m2=meta.getClass().getMethod("sayHello");
		MyAnnotation myAnnotation1=m2.getAnnotation(MyAnnotation.class);
		System.out.println("tha value is:"+myAnnotation1.value()+ " and name is: "+myAnnotation1.value2());
		
	}

}
