package com.kesen.design.patten.Observer;

import com.google.common.eventbus.Subscribe;

/**
 * @Auther: kesen
 * @Date: 2020/5/9 08:14
 * @Description:
 **/
public class RegNotificationObserver {
	private NotificationService notificationService;

	@Subscribe
	public void handleRegSuccess(long userId) {
		notificationService.sendInboxMessage(userId, "...");
	}
}