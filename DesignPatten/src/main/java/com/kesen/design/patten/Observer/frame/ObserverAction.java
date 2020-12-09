package com.kesen.design.patten.Observer.frame;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Auther: kesen
 * @Date: 2020/5/10 20:30
 * @Description: ObserverAction 类用来表示 @Subscribe 注解的方法，其中，target 表示观察者类，method 表示方法
 **/
public class ObserverAction {
	private Object target;
	private Method method;

	public ObserverAction(Object target, Method method) {
		this.target = target;
		this.method = method;
		this.method.setAccessible(true);
	}

	public void execute(Object event) {
		/*try {
			method.invoke(targer, method);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}*/

		// 第二种写法
		try {
			method.invoke(target, event);
		} catch (InvocationTargetException | IllegalAccessException e) {
			e.printStackTrace();
		}

	}
}
