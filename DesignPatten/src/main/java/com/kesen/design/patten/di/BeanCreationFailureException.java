package com.kesen.design.patten.di;

/**
 * @Auther: kesen
 * @Date: 2020/3/22 16:42
 * @Description:
 **/
public class BeanCreationFailureException extends  RuntimeException  {

	public BeanCreationFailureException(String message) {
		super(message);
	}

	public BeanCreationFailureException(String message, Throwable cause) {
		super(message, cause);
	}
}
