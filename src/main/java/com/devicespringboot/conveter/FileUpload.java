package com.devicespringboot.conveter;

import java.io.File;
import java.nio.file.Path;

import javax.servlet.ServletContext;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUpload {
	@Autowired
	private ServletContext application;
	
	public String uploadImage(MultipartFile file) {
		String fileName = file.getOriginalFilename();
		String path = application.getRealPath("/")+"assets";
		try {
			File dir = new File(path+ File.separator + "imageUpload");
			if(!dir.exists()) {
				dir.mkdirs();
			}
			
			String filePath = dir.getPath() + "/" + fileName;
			file.transferTo(Path.of(filePath));
			
			return fileName;
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

}
