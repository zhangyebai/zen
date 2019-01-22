package com.boot.zen;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication
@EnableAutoConfiguration //(exclude = DataSourceAutoConfiguration.class)
@MapperScan(value = "com.boot.zen.mapper")
public class ApplicationZen {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationZen.class, args);
	}

}

