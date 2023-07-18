package com.springmvc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "com.springmvc")
@EnableWebMvc
public class SpringwebConfigClass {
	
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver viewReslover=new InternalResourceViewResolver("/pages/",".jsp");
		return viewReslover;
	}

}
