package com.scotcro.songsapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class SongsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SongsApiApplication.class, args);
	}

}
