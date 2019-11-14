package com.kesen.interfaces.impl;

/**
 * * 需求：say方法被调用的时候，记录方法被调用的时间
 * 最直接的就是修改Man的say方法，但是这样做的弊端就是如果有很多实现了IPerson接口的类，那就需要修改多处代码，
 * 而且这样的修改可能会导致其他的代码出问题(可能并不是所有的say都需要记录调用时间)。怎么办呢，这时候代理就要登场了！
 *
 */

/**
 * 静态代理：
 * * 新建一个ManProxy类同样实现IPerson接口，将要代理的对象传递进来，
 * 这样就可以在不修改Man的say方法的情况下实现了我们的需求。这其实就是静态代理。
 *
 */

import com.kesen.interfaces.IPerson;

public class ManProxy implements IPerson {
	//需要被代理的类
	private IPerson target;

	public IPerson getTarget() {
		return target;
	}

	public ManProxy setTarget(IPerson target) {
		this.target = target;
		return this;
	}

	@Override
	public void say() {
		if (target != null) {
			System.out.println("man say invoked at : " + System.currentTimeMillis());
			target.say();
		}
	}
}
