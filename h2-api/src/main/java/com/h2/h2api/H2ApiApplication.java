package com.h2.h2api;

import org.hibernate.annotations.Cache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class H2ApiApplication {

	public static void main(String[] args){
		SpringApplication.run(H2ApiApplication.class, args);
	}
}
