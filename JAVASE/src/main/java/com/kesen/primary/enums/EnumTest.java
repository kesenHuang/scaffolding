package com.kesen.primary.enums;

/**
 * @Auther: kesen
 * @Date: 2020/12/10 07:17
 * @Description:
 **/
public class EnumTest {
	public static void main(String[] args) {
		//System.out.println(PizzaStatus.ORDER.name());//ORDERED
		Pizza testPz = new Pizza();
		testPz.setStatus(Pizza.PizzaStatus.DELIVERED);

		System.out.println(testPz.getStatus().equals(Pizza.PizzaStatus.DELIVERED));
	}
}
