package com.kesen.design.patten.Observer;

import com.google.common.eventbus.Subscribe;

/**
 * @Auther: kesen
 * @Date: 2020/5/9 08:13
 * @Description:
 **/
public class RegPromotionObserver {
	private PromotionService promotionService; // 依赖注入

	@Subscribe
	public void handleRegSuccess(long userId) {
		promotionService.issueNewUserExperienceCash(userId);
	}
}