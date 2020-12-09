package com.kesen.io.channel;

/**
 * @Auther: kesen
 * @Date: 2020/8/5 21:35
 * @Description:
 **/
public class ServerTest {
	public static void main(String[] args) {
		NioServer server = new NioServer();
		server.acceptFile();
	}
}
