package com.kesen.design.patten.Decorator;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @Auther: kesen
 * @Date: 2020/5/8 07:55
 * @Description:
 **/
public class Demo {

	public static void main(String[] args) {
		try {
			InputStream in = new FileInputStream("/xxx");
			BufferedInputStream bufferedInputStream = new BufferedInputStream(in);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
