package com.kesen.interfaces.impl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 接口与代理类是1对1的，有多个接口需要代理，就需要新建多个代理类，繁琐，类爆炸
 */

/**
 * 动态代理：
 *
 */
public class NormalHandler implements InvocationHandler {
	private Object target;

	public NormalHandler(Object target) {
		this.target = target;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//记录时间
		System.out.println("man say invoked at : " + System.currentTimeMillis());
		method.invoke(target, args);
		return  null;
	}
}
