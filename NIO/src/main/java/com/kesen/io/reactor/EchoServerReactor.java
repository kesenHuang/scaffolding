package com.kesen.io.reactor;

import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @Auther: kesen
 * @Date: 2020/8/6 22:28
 * @Description:
 **/
public class Reactor implements Runnable {

	Selector selector;
	ServerSocketChannel serverSocketChannel;

	public Reactor() throws Exception {
		selector= Selector.open();
		serverSocketChannel = ServerSocketChannel.open();
		serverSocketChannel.configureBlocking(false);
		serverSocketChannel.socket().bind(new InetSocketAddress("127.0.0.1", 80));
		SelectionKey sk = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
		sk.attach(new AcceptorHandler());

	}

	@Override
	public void run() {

		while (!Thread.interrupted()) {
			try
			{
			while (selector.select() > 0) {
				Set<SelectionKey> selectionKeys =  selector.selectedKeys();
				Iterator <SelectionKey> iterator = selectionKeys.iterator();
				while (iterator.hasNext()) {
					SelectionKey selectionKey = iterator.next();
					dispatch(selectionKey);
				}
			}
			} catch (Exception e) {

			}
		}

	}

	void dispatch(SelectionKey selectionKey) {
		Runnable handler = (Runnable) selectionKey.attachment();
		if (null != handler) {
			handler.run();
		}
	}

	class  AcceptorHandler implements  Runnable {
		@Override
		public void run() {
			SocketChannel socketChannel = serverSocketChannel.accept();
			if (null != socketChannel) {
				
			}
		}
	}
}
