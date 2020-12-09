package com.kesen.design.patten.Observer;

/**
 * @Auther: kesen
 * @Date: 2020/5/9 08:11
 * @Description:
 **/
public interface NotificationService {
	void  sendInboxMessage(long userId, String msg);
}
