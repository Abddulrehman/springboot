package com.springbootdocker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@GetMapping("/dockerTest")
	public String showTest()
	{
		System.out.println(" THis is spring boot apploication running");
		
	return "THis is spring boot apploication running";	
	}

}
