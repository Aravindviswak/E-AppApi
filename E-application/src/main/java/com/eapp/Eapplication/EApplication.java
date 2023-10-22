package com.eapp.Eapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

public class EApplication {

	public static void main(String[] args) {
		SpringApplication.run(EApplication.class, args);
		System.out.println("The project is started==>");
		System.out.println("This is a dummy message");
		System.out.println("This is my first code");
	}

}
