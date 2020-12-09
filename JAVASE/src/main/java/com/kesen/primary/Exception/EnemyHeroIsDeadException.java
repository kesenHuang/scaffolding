package com.kesen.primary.Exception;

/**
 * @Auther: kesen
 * @Date: 2020/4/26 21:04
 * @Description:
 **/
public class EnemyHeroIsDeadException extends Exception {
	public EnemyHeroIsDeadException() {
	}

	public EnemyHeroIsDeadException(String message) {
		super(message);
	}
}
