package com.ckx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringbootBlogProApplication {
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//
//		// 注意这里要指向原先用main方法执行的Application启动类
//		return builder.sources(SpringbootBlogProApplication.class);
//	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBlogProApplication.class, args);
	}


}
