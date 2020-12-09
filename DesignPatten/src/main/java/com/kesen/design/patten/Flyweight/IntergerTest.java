package com.kesen.design.patten.Flyweight;

/**
 * @Auther: kesen
 * @Date: 2020/5/8 21:17
 * @Description:
 **/
public class IntergerTest {
	public static void main(String[] args) {

		Integer i1 = 56;
		Integer i2 = 56;
		Integer i3 = 129;
		Integer i4 = 129;
		// IntegerCache存储了-128 ~ 127的整型
		System.out.println(i1 == i2);
		System.out.println(i3 == i4);
	}
}
