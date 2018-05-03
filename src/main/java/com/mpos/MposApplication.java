package com.mpos;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableTransactionManagement
@SpringBootApplication
@EnableSwagger2
@EnableCaching
@MapperScan("com.mpos.*.mapper")
public class MposApplication {

	public static void main(String[] args) {
		SpringApplication.run(MposApplication.class, args);
	}
}
