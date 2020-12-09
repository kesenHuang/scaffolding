package com.kesen.io.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;

/**
 * @Auther: kesen
 * @Date: 2020/8/6 06:57
 * @Description:
 **/
public class UDPServer {

	void receive() {
		ByteBuffer buffer = ByteBuffer.allocate(4096);
		try(DatagramChannel datagramChannel = DatagramChannel.open()) {
			datagramChannel.socket().bind(new InetSocketAddress("127.0.0.1",80));
			datagramChannel.configureBlocking(false);
			Selector selector = Selector.open();
			datagramChannel.register(selector, SelectionKey.OP_READ);
			while (selector.select() > 0) {
				Iterator<SelectionKey>  iterator =  selector.selectedKeys().iterator();
				while (iterator.hasNext()) {
					SelectionKey selectionKey = iterator.next();
					if (selectionKey.isReadable()) {
						buffer.clear();
						datagramChannel.receive(buffer);
						buffer.flip();
						System.out.println(new String(buffer.array(),0, buffer.limit()));
						buffer.clear();
					}
				}
				iterator.remove();
			}
			selector.close();
			datagramChannel.close();

		}catch ( IOException e) {

		}
	}
}
