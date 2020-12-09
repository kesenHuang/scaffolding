package com.kesen.io;

import java.nio.IntBuffer;

/**
 * @Auther: kesen
 * @Date: 2020/8/3 22:14
 * @Description:
 **/
public class BufferTest {
	static IntBuffer intBuffer = null;
	public static void main(String[] args) {
		intBuffer = IntBuffer.allocate(20);

		System.out.println("position:" + intBuffer.position());
		System.out.println("limit:" + intBuffer.limit());
		System.out.println("capacity:" +intBuffer.capacity());

		for (int i = 0; i<= 4; i++) {
			intBuffer.put(i);
		}

		System.out.println("position:" + intBuffer.position());
		System.out.println("limit:" + intBuffer.limit());
		System.out.println("capacity:" +intBuffer.capacity());

		intBuffer.flip();

		System.out.println("position:" + intBuffer.position());
		System.out.println("limit:" + intBuffer.limit());
		System.out.println("capacity:" +intBuffer.capacity());

	}
}
