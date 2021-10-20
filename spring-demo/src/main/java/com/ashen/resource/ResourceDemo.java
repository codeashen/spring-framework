package com.ashen.resource;

import org.springframework.core.io.FileSystemResource;

import java.io.*;

public class ResourceDemo {
	public static void main(String[] args) throws IOException {
		String filePath = "D:\\Github\\spring-framework\\spring-demo\\src\\main\\resources\\resource\\test.txt";
		FileSystemResource resource = new FileSystemResource(filePath);
		File file = resource.getFile();
		System.out.println(filePath.length());
		
		OutputStream outputStream = resource.getOutputStream();
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
		bufferedWriter.write("Hello World!");
		bufferedWriter.flush();
		bufferedWriter.close();
		outputStream.close();
	}
}
