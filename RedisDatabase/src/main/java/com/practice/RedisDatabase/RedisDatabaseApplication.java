package com.practice.RedisDatabase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RedisDatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisDatabaseApplication.class, args);
	}

}
