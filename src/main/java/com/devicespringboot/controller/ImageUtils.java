package com.devicespringboot.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class ImageUtils {
	@RequestMapping(value = "/getImage/{imageId}")
	@ResponseBody
	public byte[] getImage(@PathVariable long imageId, HttpServletRequest request) throws IOException  {
	    String rpath = request.getRealPath("/");
	    rpath = rpath + "/" + imageId; // whatever path you used for storing the file
	    Path path = Paths.get(rpath);
	    byte[] data = Files.readAllBytes(path); 
	    return data;
	}
}
