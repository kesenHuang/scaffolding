package com.kesen.io.channel;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @Auther: kesen
 * @Date: 2020/8/5 20:54
 * @Description:
 **/
public class NioServer {

	void acceptFile() {
		try (ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		     RandomAccessFile accessFile = new RandomAccessFile("C://Users//kesen//Desktop//dst2.sql", "rw");
		     FileChannel out = accessFile.getChannel()) {
			serverSocketChannel.configureBlocking(false);
			ServerSocket socket = serverSocketChannel.socket();
			socket.bind(new InetSocketAddress("127.0.0.1", 80));
			ByteBuffer buffer = ByteBuffer.allocate(4096);
			while (true) {
				SocketChannel socketChannel = serverSocketChannel.accept();
				if (null != socketChannel) {
					int length = 0;
					while ((length = socketChannel.read(buffer)) > -1) {
						buffer.flip();
						out.write(buffer);
						out.force(true);
						buffer.clear();
					}
					out.close();
					socketChannel.shutdownInput();
					serverSocketChannel.close();
					break;
				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
