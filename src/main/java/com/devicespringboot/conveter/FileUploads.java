package com.devicespringboot.conveter;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class FileUploads {
	String uploadFile(MultipartFile file) {
		String name ="";
		//check file is ready
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				String rootPath = System.getProperty("catalina.home");
				System.out.println("String rootPath "+rootPath);
				
				// get or create folder at server
				File dir = new File(rootPath + File.separator + "uploads/image");
				if (!dir.exists()) {
					dir.mkdir();
				}
				// Create file
				name = String.valueOf(new Date().getTime() + ".jpg");
				File serverFile = new File(dir.getAbsoluteFile() + File.separator + name);
				//
				System.out.println("Path of image" + serverFile.getPath());

				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				
			} catch (IOException e) {
				System.out.println("Error upload file" + e.getMessage());
			}

		} else {
			System.out.println("File not found");
		}
		
		return name;

	}
}
