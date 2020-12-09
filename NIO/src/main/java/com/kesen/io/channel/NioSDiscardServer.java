package com.kesen.io.channel;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @Auther: kesen
 * @Date: 2020/8/6 21:31
 * @Description:
 **/
public class NioSDiscardServer {

	public static void startServer() throws Exception {
		// 获取通道
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		// 设置为阻塞
		serverSocketChannel.configureBlocking(false);
		// 绑定连接
		serverSocketChannel.socket().bind(new InetSocketAddress("127.0.0.1", 80));
		// 获取选择器
		Selector selector = Selector.open();
		// 将通道注册到选择器中
		serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
		// 轮循
		while (selector.select() > 0) {
			Set<SelectionKey> selectionKeys = selector.selectedKeys();
			Iterator<SelectionKey> iterator = selectionKeys.iterator();
			while (iterator.hasNext()) {
				SelectionKey selectionKey = iterator.next();
				if (selectionKey.isAcceptable()) {
					SocketChannel socketChannel = serverSocketChannel.accept();
					socketChannel.configureBlocking(false);

					// 将新连接的通道的可读事件注册到选择器上
					socketChannel.register(selector, SelectionKey.OP_READ);
				} else if(selectionKey.isReadable()) {
					SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
					ByteBuffer buffer = ByteBuffer.allocate(1024);

					int length = 0;
					while ((length = socketChannel.read(buffer)) > 0) {
						buffer.flip();
						System.out.println(new String(buffer.array(), 0, buffer.limit()));
					}
					socketChannel.close();
				}
				iterator.remove();
			}
		}
		serverSocketChannel.close();

	}

	public static void main(String[] args) throws Exception{
		startServer();
	}
}
