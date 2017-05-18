package com.net.lnk.spring.jdbc;

import java.io.RandomAccessFile;

import org.apache.commons.io.IOUtils;

/**
 * @author Ben
 * @memo 2017年4月14日
 */
public class RandomAccessFileReader {

	private RandomAccessFile accessFile;
	private int arraySize = Short.MAX_VALUE;
	private long fileSize;
	private long startPosition = 0;
	private byte[] byteArray;

	public RandomAccessFileReader(String path, int arraySize) {
		try {
			accessFile = new RandomAccessFile(path, "r");
			fileSize = accessFile.length();
			this.arraySize = arraySize;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public byte[] read() {
		if (startPosition > fileSize) {
			return new byte[0];
		}

		try {
			if (fileSize - startPosition < arraySize) {
				// 最后一次读取
				int lastSize = (int) (fileSize - startPosition);
				byteArray = new byte[lastSize];
				accessFile.seek(startPosition);
				accessFile.read(byteArray, 0, lastSize);
				startPosition += lastSize;
			} else {
				byteArray = new byte[arraySize];
				accessFile.seek(startPosition);
				accessFile.read(byteArray, 0, arraySize);
				startPosition = startPosition + arraySize;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return byteArray;
	}

	public void close() {
		IOUtils.closeQuietly(accessFile);
		byteArray = null;
	}

}
