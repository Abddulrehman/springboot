package com.socialmediablogapi.SocialMediaBlogApi;


import io.javalin.Javalin;

public class HomeController {

    public static void main(String[] args) {
        Javalin app = Javalin.create().start(7000);

        app.get("/", ctx -> ctx.result("Hello, Javalin!"));

        // Additional routes and logic can be added here
    }
}
