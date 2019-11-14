package com.kesen.examples;

import com.kesen.interfaces.UserManager;
import com.kesen.interfaces.impl.LogHandler;
import com.kesen.interfaces.impl.UserManagerImpl;
import com.kesen.interfaces.impl.UserManagerImplProxy;

public class Client {

	public static void main(String[] args){
		//UserManager userManager=new UserManagerImpl();
	/*	UserManager userManager=new UserManagerImplProxy(new UserManagerImpl());
		userManager.addUser("1111", "张三");*/

		LogHandler logHandler=new LogHandler();
		UserManager userManager=(UserManager)logHandler.newProxyInstance(new UserManagerImpl());
		//UserManager userManager=new UserManagerImpl();
		userManager.addUser("1111", "张三");
		userManager.delUser("1111");

	}
}

