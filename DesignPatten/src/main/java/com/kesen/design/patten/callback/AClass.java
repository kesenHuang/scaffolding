package com.kesen.design.patten.callback;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @Auther: kesen
 * @Date: 2020/5/11 20:42
 * @Description:
 **/
public class AClass {
	public static void main(String[] args) {
		BClass b = new BClass();
		b.process(new ICallback() {
			@Override
			public void methodToCallback() {
				System.out.println("Call back me.");
			}
		});

		// 例如排序:同步回调
		Collections.sort(new ArrayList<String>(), new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return 0;
			}
		});


	}
}
