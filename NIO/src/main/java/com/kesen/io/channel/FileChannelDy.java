package com.kesen.io.channel;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Auther: kesen
 * @Date: 2020/8/5 19:42
 * @Description:
 **/
public class FileChannelDy {
	static String srcFile = "C://Users//kesen//Desktop//ca_log_audit_event_mysql_20200725.sql";
	static String dstFile = "C://Users//kesen//Desktop//dst.sql";

	public static void main(String[] args) {

		//copyFile(srcFile, dstFile);
		fastCopy(srcFile, dstFile);
	}

	/**
	 * 使用通道复制文件
	 * @param srcFile
	 * @param dstFile
	 */
	static void copyFile(String srcFile, String dstFile) {
		try {
			RandomAccessFile in = new RandomAccessFile(srcFile, "rw");
			FileChannel inChannel = in.getChannel();

			RandomAccessFile out = new RandomAccessFile(dstFile, "rw");
			FileChannel outChannel = out.getChannel();

			ByteBuffer byteBuffer = ByteBuffer.allocate(4096);
			while (inChannel.read(byteBuffer) != -1) {
				byteBuffer.flip();
				outChannel.write(byteBuffer);
				byteBuffer.clear();
				outChannel.force(true);
			}
			inChannel.close();
			outChannel.close();

		} catch (Exception e) {

		}
	}
	
	/**
	** 
	* @Description: 使用transferFrom 高效复制文件
	* @Param: [srcFile, dstFile] 
	* @return: void 
	* @Author: kesen
	* @Date: 2020/8/5 20:16 
	*/ 
	static  void fastCopy(String srcFile, String dstFile) {
		try {
			RandomAccessFile in = new RandomAccessFile(srcFile, "rw");
			FileChannel inChannel = in.getChannel();

			RandomAccessFile out = new RandomAccessFile(dstFile, "rw");
			FileChannel outChannel = out.getChannel();

			inChannel.transferTo(0, inChannel.size(),outChannel);

		} catch (Exception e) {

		}
	}
}
