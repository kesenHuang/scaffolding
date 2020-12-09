package com.kesen.reflect;

import java.util.Calendar;

/**
 * @Auther: kesen
 * @Date: 2020/11/29 20:09
 * @Description:
 **/
public class ReflectDemo {

	public static void main(String[] args) {

		// 获取Class对象的三种方式
		Class<Student> studentClass = Student.class;
		//Class是一个泛型类，有一个类型参数，getClass（）并不知道具
		//体的类型，所以返回Class<？>
		Class<?> studentClass1 = new Student().getClass();
		try {
			Class<?> studentClass2 = Class.forName("com.kesen.reflect.Person");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		//getName返回的是Java内
		//部使用的真正的名称

		System.out.println(studentClass.getName());
		//getSimpleName返回的名称不带包信息
		System.out.println(studentClass.getSimpleName());
		//getCanonicalName返回的名称更为友好
		System.out.println(studentClass.getCanonicalName());
		//getPackage返回的是包信息
		System.out.println(studentClass.getPackage());

	}

	static class Student {
		private Integer id;

		private String name;

		private Integer age;

		private String sex;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}

		public String getSex() {
			return sex;
		}

		public void setSex(String sex) {
			this.sex = sex;
		}
	}
}
