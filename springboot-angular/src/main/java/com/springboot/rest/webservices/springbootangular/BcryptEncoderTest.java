package com.springboot.rest.webservices.springbootangular;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptEncoderTest {

	public static void main(String arg[]) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		
		
		for(int i =1; i<=10; i++) {
			String encoded = encoder.encode("welcome");
			System.out.println("encoded:::"+encoded);
		}
	}
}

