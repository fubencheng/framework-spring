package com.net.lnk.spring.jdbc;

/**
 * @author Ben
 * @memo 2017年4月14日
 */
public class RandomAccessFileReaderTest {

	public static void main(String[] args) {
		// 可以读取超过2GB大小的文件
		RandomAccessFileReader reader = new RandomAccessFileReader("file/id.txt", Short.MAX_VALUE);
		long totalNum = 0;
		int readNum = 0;
		while ((readNum = reader.read().length) > 0) {
			totalNum += readNum;
		}

		reader.close();

		System.out.println("total bytes " + totalNum);
	}

}
