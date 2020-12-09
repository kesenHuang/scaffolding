package com.kesen.io.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/**
 * @Auther: kesen
 * @Date: 2020/8/6 06:52
 * @Description:
 **/
public class UDPClient {

	void sendFile() {
		ByteBuffer buffer = ByteBuffer.allocate(4096);
		buffer.clear();
		buffer.put("String from client".getBytes());

		try (DatagramChannel channel = DatagramChannel.open();) {
			channel.configureBlocking(false);
			buffer.flip();
			int length = channel.send(buffer, new InetSocketAddress("127.0.0.1", 80));
			System.out.println("senSuccess,send length " + length);
		} catch (IOException e) {

		}
	}
}
