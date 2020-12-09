package com.kesen.design.patten.strategy;

import com.google.common.collect.Maps;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @Auther: kesen
 * @Date: 2020/5/11 21:37
 * @Description:
 **/
public class StrategyFactory2 {

	private static final Map<String, Class<?>> strategies = Maps.newConcurrentMap();
	static {
		/*strategies.put("A", ConcreteStrategyA.class);
		strategies.put("A", ConcreteStrategyB.class);*/

		// 反射方式
		Class<StrategyAnno> clz = StrategyAnno.class;
	}

	public static Strategy getStrategy(String type) {
		if (null ==  type  || type.isEmpty()) {
			throw new IllegalArgumentException("type should not be empty");
		}
		Class<?> clazz =  strategies.get(type);

		// 获取类的三种方式：
		/*Class.forName("com.kesen.design.patten.strategy.ConcreteStrategyA");
		new ConcreteStrategyA().getClass();
		ConcreteStrategyA.class;*/

		try {
			try {
				return  (Strategy) clazz.getConstructor().newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return null;
	}
}
