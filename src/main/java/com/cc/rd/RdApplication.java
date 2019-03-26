package com.cc.rd;

import org.springframework.beans.BeanUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RdApplication {

	public static void main(String[] args) {
		SpringApplication.run(RdApplication.class, args);
	}

}
