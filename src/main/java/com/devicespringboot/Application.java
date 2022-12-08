package com.devicespringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class Application {
	/*
	 * admin 
	 * $2a$10$jT/7P74B02HL.hs23bf.VezuBOWiSA5/nfgdFxjVleQ50YCGnHolK
	 */

	
	public static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println(encoder.encode("admin"));
	}

}
