package com.kesen.io.channel;

/**
 * @Auther: kesen
 * @Date: 2020/8/5 21:35
 * @Description:
 **/
public class socketTest {
	public static void main(String[] args) {
		NioClient client = new NioClient();
		client.sendFile( "127.0.0.1", 80, "C://Users//kesen//Desktop//dst.sql");
		NioServer server = new NioServer();
		server.acceptFile();
	}
}
