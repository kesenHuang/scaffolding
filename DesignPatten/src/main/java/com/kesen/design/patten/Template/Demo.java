package com.kesen.design.patten.Template;

/**
 * @Auther: kesen
 * @Date: 2020/5/10 22:45
 * @Description:
 **/
public class Demo {
	public static void main(String[] args) {
		AbstractClass abstractClass = new ConcreteClass1();
		abstractClass.templateMethod();
	}
}
