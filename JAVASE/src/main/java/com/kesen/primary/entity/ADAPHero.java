package com.kesen.primary.entity;

import com.kesen.primary.interfaces.AD;
import com.kesen.primary.interfaces.AP;

/**
 * @Auther: kesen
 * @Date: 2020/4/21 08:05
 * @Description:
 **/
public class ADAPHero extends Hero implements AD, AP {
	@Override
	public void physicAttack() {
		System.out.println("进行物理攻击");
	}

	@Override
	public void magicAttack() {
		System.out.println("进行魔法攻击");
	}

	public ADAPHero(String name, float hp, float armor, int moveSpeed) {
		super(name, hp, armor, moveSpeed);
	}
}
