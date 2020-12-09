package com.kesen.io.channel;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * @Auther: kesen
 * @Date: 2020/8/5 20:49
 * @Description:
 **/
public class NioClient {

	void  sendFile(String ip, int port, String srcFile) {
		try (SocketChannel socketChannel = SocketChannel.open();
		     RandomAccessFile infile = new RandomAccessFile(srcFile, "rw");) {
			socketChannel.configureBlocking(false);

			socketChannel.connect(new InetSocketAddress(ip, port));
			while (!socketChannel.finishConnect()) {
				// do other things
			}
			System.out.println("client connected server success");
			ByteBuffer buffer = ByteBuffer.allocate(4096);

			FileChannel fin = infile.getChannel();
			ByteBuffer fileName = Charset.forName("UTF-8").encode(srcFile);
			// 发送文件名
			socketChannel.write(fileName);
			buffer.putLong(fin.size());
			// 发送文件长度
			buffer.flip();
			socketChannel.write(buffer);
			buffer.clear();
			//发送文件内容
			while (fin.read(buffer) != -1) {
				buffer.flip();
				socketChannel.write(buffer);
				buffer.clear();
			}
			socketChannel.shutdownOutput();
			fin.close();

		} catch (IOException e) {

		}
	}
}
