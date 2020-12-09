package com.kesen.primary.innerClass;

/**
 * @Auther: kesen
 * @Date: 2020/4/26 20:49
 * @Description:
 **/
public  abstract  class Demo {
	abstract void show();
}

class Outer1 {
	int num = 4;
	// 内部类
	class Inner extends Demo{
		@Override
		void show() {
			System.out.println("show ..."+num);

		}
	}

	public void method() {
		// 匿名内部类
		new Demo(){
			@Override
			void show() {

			}
		}.show();
	}

}


