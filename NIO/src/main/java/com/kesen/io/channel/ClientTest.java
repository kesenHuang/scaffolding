package com.kesen.io.channel;

/**
 * @Auther: kesen
 * @Date: 2020/8/5 21:45
 * @Description:
 **/
public class ClientTest {
	public static void main(String[] args) {
		NioClient client = new NioClient();
		client.sendFile( "127.0.0.1", 80, "C://Users//kesen//Desktop//dst.sql");
	}
}
