package com.socialmediablogapi.JavaLinMediaApi;

import org.springframework.boot.SpringApplication;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.javalin.Javalin;
import com.onlineapp.onlineapp.controller.LoginController;

import io.javalin.Javalin;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		SpringApplication.run(OnlineappApplication.class, args);
		Javalin app = Javalin.create().start(7000);
		LoginController loginController = new LoginController();
		app.post("/login", loginController::login);
	}
}
