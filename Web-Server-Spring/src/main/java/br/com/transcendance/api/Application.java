package br.com.transcendance.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "br.com.transcendance.api.controller", "br.com.transcendance.api.log",
		"br.com.transcendance.api.exception", "br.com.transcendance.api.security",
		"br.com.transcendance.api.models", "br.com.transcendance.api.repository",
		"br.com.transcendance.api.services", "br.com.transcendance.api.util" })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
