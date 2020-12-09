package com.kesen.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @Auther: kesen
 * @Date: 2020/11/29 20:23
 * @Description:
 **/
public class ReflectFieldDemo {

	public static void main(String[] args) throws Exception {
		Person person = new Person(1, "kesen", 20, "male");
		person.setId(1);
		Class<Person> personClass = Person.class;

		//返回所有的public字段，包括其父类的，如果没有字段，返回空数组
		Field[] fields = personClass.getFields();

		for (Field f : fields) {
			System.out.println(f.getName());
		}
         //返回本类声明的所有字段，包括非public的，但不包括父类的
		Field[] fields1 = personClass.getDeclaredFields();

		for (Field f : fields1) {
			System.out.println(f.getName());
			f.setAccessible(true);
			if ("id".equals(f.getName())) {
				try {
					// 重新设置对象p的id
					f.set(person, new Integer(2));
					System.out.println(f.get(person));
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
			// 字段的修饰符
			System.out.println(Modifier.toString(f.getModifiers()));
			//字段的类型
			System.out.println(f.getType());

		}

		try {
			Field fieldId = personClass.getField("id");
		} catch (NoSuchFieldException e) {
			System.out.println(e.getMessage());
		}

		try {
			Field fieldId = personClass.getDeclaredField("id");
		} catch (NoSuchFieldException e) {
			System.out.println(e.getMessage());
		}



	}
}
