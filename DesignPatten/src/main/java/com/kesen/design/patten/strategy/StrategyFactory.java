package com.kesen.design.patten.strategy;

import com.google.common.collect.Maps;
import org.junit.Assert;

import java.util.Map;

/**
 * @Auther: kesen
 * @Date: 2020/5/11 21:25
 * @Description:策略工厂类（简单工厂） 策略的生成
 **/
public class StrategyFactory {

	private static final Map<String, Strategy> strategies = Maps.newConcurrentMap();

	static {
		strategies.put("A", new ConcreteStrategyA());
		strategies.put("B", new ConcreteStrategyB());
	}

	public static Strategy getStrategy(String type) {
		if (null ==  type  || type.isEmpty()) {
			throw new IllegalArgumentException("type should not be empty");
		}
		return strategies.get(type);

	}
}
