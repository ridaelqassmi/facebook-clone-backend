package com.facebook.facebookclone;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.facebook.facebookclone.CommunService.CommenFunctions;

@SpringBootApplication
public class FacebookCloneApplication {

	public static void main(String[] args) {
		new File(CommenFunctions.dir).mkdir();
		SpringApplication.run(FacebookCloneApplication.class, args);
	}

}
