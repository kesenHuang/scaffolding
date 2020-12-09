package com.kesen.primary.object;

/**
 * @Auther: kesen
 * @Date: 2020/4/21 07:36
 * @Description:Java 中的每一个枚举都继承自 java.lang.Enum 类。当定义一个枚举类型时，
 * 每一个枚举类型成员都可以看作是 Enum 类的实例，
 * 这些枚举成员默认都被 final、public, static 修饰，当使用枚举类型成员时，直接使用枚举名称调用成员即可
 **/
public enum HeroType {

	TANK("坦克"),
	WIZARD("法师"),

	ASSASSIN("刺客"),

	ASSIST("辅助"),

	WARRIOR("近战"),

	RANGED("远程"),

	PUSH("推进"),

	FARMING("打野");

	private final String name;


	private HeroType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}


}
