package com.kesen.design.patten.di;

/**
 * @Auther: kesen
 * @Date: 2020/3/22 16:38
 * @Description:
 **/
public class NoSuchBeanDefinitionException extends RuntimeException  {

	public NoSuchBeanDefinitionException() {
	}

	public NoSuchBeanDefinitionException(String message) {
		super(message);
	}
}
