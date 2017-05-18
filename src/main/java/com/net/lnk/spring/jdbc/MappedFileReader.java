package com.net.lnk.spring.jdbc;

import java.io.FileInputStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

import org.apache.commons.io.IOUtils;

/**
 * @author Ben
 * @memo 2017年4月13日
 */
public class MappedFileReader {

	private FileInputStream fileIn = null;
	private int arraySize;
	private MappedByteBuffer mappedBuffer;
	private byte[] byteArray;

	public MappedFileReader(String path, int arraySize) {
		try {
			fileIn = new FileInputStream(path);
			FileChannel fileChannel = fileIn.getChannel();
			long fileSize = fileChannel.size();
			mappedBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileSize);
			this.arraySize = arraySize;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public byte[] read() {
		int limit = mappedBuffer.limit();
		int position = mappedBuffer.position();
		if (position == limit) {
			byteArray = new byte[0];
		}
		if (limit - position > arraySize) {
			// 剩余比数组容量大
			byteArray = new byte[arraySize];
			mappedBuffer.get(byteArray);
		} else {
			// 最后一次读取数据
			byteArray = new byte[limit - position];
			mappedBuffer.get(byteArray);
		}

		return byteArray;
	}

	public void close() {
		IOUtils.closeQuietly(fileIn);
		byteArray = null;
	}

}
