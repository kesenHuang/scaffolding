package com.kesen.design.patten.Template;

/**
 * @Auther: kesen
 * @Date: 2020/5/10 22:42
 * @Description:
 **/
public abstract class AbstractClass {

	/**
	 * *
	 *
	 * @Description: 模板方法模式可以让子类在不改变算法整体结构的情况下，重新定义算法中的某些步骤。
	 * @Param: []
	 * @return: void
	 * @Author: kesen
	 * @Date: 2020/5/10 22:44
	 */
	public final void templateMethod() {
		//...模板逻辑
		// method1();
		// ...模板逻辑
		// method2();
		// ...模板逻辑
	}

	protected abstract void method1();

	protected abstract void method2();
}
