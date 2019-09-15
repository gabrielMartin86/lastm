package com.lastm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 * Spring Application Starter
 * 
 * @author Gabriel Martin
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.lastm"})
@EnableAutoConfiguration
public class ApplicationBootStarter {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationBootStarter.class, args);
	}
}
