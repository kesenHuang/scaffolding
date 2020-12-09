package com.kesen.primary.entity;

import com.kesen.primary.interfaces.AP;

/**
 * @Auther: kesen
 * @Date: 2020/4/21 08:04
 * @Description:
 **/
public class ApHero extends  Hero implements AP {
	@Override
	public void magicAttack() {
		System.out.println("进行魔法攻击");
	}

	public ApHero(String name, float hp, float armor, int moveSpeed) {
		super(name, hp, armor, moveSpeed);
	}
}
