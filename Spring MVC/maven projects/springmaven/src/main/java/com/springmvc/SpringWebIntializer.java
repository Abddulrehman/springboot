 package com.springmvc;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;

public class SpringWebIntializer implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigApplicationContext container=	new AnnotationConfigApplicationContext();
		container.register(SpringwebConfigClass.class);
	}

}
