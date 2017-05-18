package com.net.lnk.spring.jdbc;

/**
 * @author Ben
 * @memo 2017年4月13日
 */
public class MappedFileReaderTest {

	public static void main(String[] args) {
		// 最大只能Map文件大小为2的31次减1字节大小的文件，即2GB大小
		MappedFileReader reader = new MappedFileReader("file/ids.txt", Integer.MAX_VALUE);
		long totalNum = 0;
		int readNum = 0;
		while ((readNum = reader.read().length) > 0) {
			totalNum += readNum;
		}

		reader.close();

		System.out.println("total bytes " + totalNum);
	}

}
