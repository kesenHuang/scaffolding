package com.kesen.primary.entity;

/**
 * @Auther: kesen
 * @Date: 2020/4/20 21:09
 * @Description:
 **/
public class Hero {
	String name; //姓名

	float hp; //血量

	float armor; //护甲

	int moveSpeed; //移动速度

	public Hero(String name, float hp, float armor, int moveSpeed) {
		this.name = name;
		this.hp = hp;
		this.armor = armor;
		this.moveSpeed = moveSpeed;
	}

	public static void main(String[] args) {
		/*Hero garen =  new Hero();
		garen.name = "盖伦";
		garen.hp = 616.28f;
		garen.armor = 27.536f;
		garen.moveSpeed = 350;

		Hero teemo =  new Hero();
		teemo.name = "提莫";
		teemo.hp = 383f;
		teemo.armor = 14f;
		teemo.moveSpeed = 330;*/
	}
}
