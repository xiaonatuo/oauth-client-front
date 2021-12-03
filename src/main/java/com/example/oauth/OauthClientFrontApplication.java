package com.example.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class OauthClientFrontApplication {

    public static void main(String[] args) {
        SpringApplication.run(OauthClientFrontApplication.class, args);
    }

    @Controller
    static class IndexController{

        @GetMapping("/")
        public String index(){
            return "index";
        }

        @GetMapping("/login")
        public String login(){
            return "login";
        }
    }
}
