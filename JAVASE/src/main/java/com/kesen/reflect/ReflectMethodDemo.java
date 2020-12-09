package com.kesen.reflect;

import java.lang.reflect.Method;

/**
 * @Auther: kesen
 * @Date: 2020/11/29 20:59
 * @Description:
 **/
public class ReflectMethodDemo {
	public static void main(String[] args)  throws Exception {

		Class<Person> personClass = Person.class;
		Person p = new Person();
		//返回所有的public方法，包括其父类的，如果没有方法，返回空数组
		Method[] methods = personClass.getMethods();
		for (Method method : methods) {
			System.out.println(method.getName());

			if ("setAge".equals(method.getName())) {
				method.setAccessible(true);
				method.invoke(p, new Integer[]{12});
			}

			//Method还有很多方法，可以获取其修饰符、参数、返回值、注解等信息
			Class<?> [] paramsType = method.getParameterTypes();
		}
		System.out.println(p.getAge());
		//返回本类声明的所有方法，包括非public的，但不包括父类的
		Method[] methodsDeclared = personClass.getDeclaredMethods();


		Method method = personClass.getDeclaredMethod("setAge", Integer.class);
	}
}
