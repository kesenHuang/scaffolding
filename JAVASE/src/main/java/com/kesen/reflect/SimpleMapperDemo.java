package com.kesen.reflect;

import java.lang.reflect.Field;

/**
 * @Auther: kesen
 * @Date: 2020/11/29 21:22
 * @Description:
 **/
public class SimpleMapperDemo {
	public static void main(String[] args) throws Exception {
		Person person = new Person(1, "kesen", 20, "male");

		System.out.println(SimpleMapperDemo.toString(person));
	}

	public static String toString(Object obj) throws Exception {
		Class<?> clas = obj.getClass();

		StringBuilder sb = new StringBuilder();
		sb.append(clas.getSimpleName() + "[");
		for (Field f : clas.getDeclaredFields()) {
			if (!f.isAccessible()) {
				f.setAccessible(true);
			}
			sb.append(f.getName() + "=" + f.get(obj).toString());
			sb.append(",");
		}
		sb.deleteCharAt(sb.length() - 1);
		sb.append("]");
		return sb.toString();
	}
}
