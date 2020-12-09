package com.kesen.primary.innerClass;

/**
 * @Auther: kesen
 * @Date: 2020/4/26 20:45
 * @Description:
 **/
public class Outer {
	private static  int num = 31;

	static  class Inner {
		void show()
		{
			System.out.println("show run..."+num);
		}
		// 如果内部类中定义了静态成员，该内部类也必须是静态的。
		static  void function() {
			System.out.println("function run ...."+num);
		}

		public void method()
		{
			Inner in = new Inner();
			in.show();
		}

	}
	public void method()
	{
		Inner in = new Inner();
		in.show();
	}
}
