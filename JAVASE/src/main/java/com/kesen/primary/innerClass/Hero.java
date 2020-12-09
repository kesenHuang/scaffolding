package com.kesen.primary.innerClass;

/**
 * @Auther: kesen
 * @Date: 2020/4/21 21:49
 * @Description:
 **/
public class Hero {

	private String name; // 姓名

	float hp; // 血量

	float armor; // 护甲

	int moveSpeed; // 移动速度


	// 非静态内部类，只有一个外部类对象存在的时候，才有意义
	// 战斗成绩只有在一个英雄对象存在的时候才有意义

	class BattleScore {
		private int kill;
		private int die;
		private int assit;

		public void legendary() {
			if (kill >= 8)
				System.out.println(name + "超神！");
			else
				System.out.println(name + "尚未超神！");
		}

	}
}
