package com.net.lnk.spring.jdbc;

import java.io.FileInputStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

import org.apache.commons.io.IOUtils;

/**
 * @author Ben
 * @memo 2017年4月13日
 */
public class MappedBiggerFileReader {

	private FileInputStream fileIn = null;
	private int arraySize;
	private MappedByteBuffer[] mappedBufferArray;
	private byte[] byteArray;
	private long regionSize = (long) Integer.MAX_VALUE;
	private int mappedByteBufferIndex = 0;

	public MappedBiggerFileReader(String path, int arraySize) {
		try {
			fileIn = new FileInputStream(path);
			FileChannel fileChannel = fileIn.getChannel();
			long fileSize = fileChannel.size();
			int mappedBufferArrayLength = (int) Math.ceil((double) fileSize / (double) regionSize);
			// 内存文件映射数组
			mappedBufferArray = new MappedByteBuffer[mappedBufferArrayLength];
			long prePosition = 0;
			for (int i = 0; i < mappedBufferArray.length; i++) {
				if (fileSize - prePosition < regionSize) {
					regionSize = fileSize - prePosition;
				}

				mappedBufferArray[i] = fileChannel.map(FileChannel.MapMode.READ_ONLY, prePosition, regionSize);
				prePosition += regionSize;
			}

			this.arraySize = arraySize;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public byte[] read() {
		if (mappedByteBufferIndex >= mappedBufferArray.length) {
			return new byte[0];
		}

		MappedByteBuffer mappedBuffer = mappedBufferArray[mappedByteBufferIndex];
		int limit = mappedBuffer.limit();
		int position = mappedBuffer.position();
		if (limit - position >= arraySize) {
			byteArray = new byte[arraySize];
			mappedBuffer.get(byteArray);
		} else {
			// 本内存文件映射最后一次读取数据
			byteArray = new byte[limit - position];
			mappedBuffer.get(byteArray);
			if (mappedByteBufferIndex < mappedBufferArray.length) {
				// 转换到下一个内存文件映射
				mappedByteBufferIndex++;
			}
		}

		return byteArray;
	}

	public void close() {
		IOUtils.closeQuietly(fileIn);
		byteArray = null;
	}

}
