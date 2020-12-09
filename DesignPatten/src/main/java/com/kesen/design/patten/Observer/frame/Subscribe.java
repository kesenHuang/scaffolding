package com.kesen.design.patten.Observer.frame;


import com.google.common.annotations.Beta;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用于标明观察者中的哪个函数可以接收消息
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.METHOD)
@Beta
public @interface Subscribe {
}
