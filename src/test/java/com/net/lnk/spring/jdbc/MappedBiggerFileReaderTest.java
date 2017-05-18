package com.net.lnk.spring.jdbc;

/**
 * @author Ben
 * @memo 2017年4月13日
 */
public class MappedBiggerFileReaderTest {

	public static void main(String[] args) {
		// 可以读取超过2GB大小的文件
		MappedBiggerFileReader reader = new MappedBiggerFileReader("file/id.txt", Short.MAX_VALUE);
		long totalNum = 0;
		int readNum = 0;
		while ((readNum = reader.read().length) > 0) {
			totalNum += readNum;
		}

		reader.close();

		System.out.println("total bytes " + totalNum);
	}

}
