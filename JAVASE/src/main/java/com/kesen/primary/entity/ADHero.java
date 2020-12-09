package com.kesen.primary.entity;

import com.kesen.primary.interfaces.AD;

/**
 * @Auther: kesen
 * @Date: 2020/4/21 08:03
 * @Description:
 **/
public class ADHero extends Hero implements AD {
	@Override
	public void physicAttack() {
		System.out.println("进行物理攻击");
	}

	//父类定义了显示有参构造函数，则父类不存在默认的无参构造函数，子类必须supper(xx,y)
	public ADHero(String name, float hp, float armor, int moveSpeed) {
		super(name, hp, armor, moveSpeed);
	}
}
