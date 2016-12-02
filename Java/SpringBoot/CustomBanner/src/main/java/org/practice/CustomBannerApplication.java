package org.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CustomBannerApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(CustomBannerApplication.class);
		//Uncomment below line to disable Banner completely or 
		//add an entry spring.main.banner-mode=off in application.properties or yml file.
		//app.setBannerMode(Mode.OFF);
		app.run(args);
	}
}
