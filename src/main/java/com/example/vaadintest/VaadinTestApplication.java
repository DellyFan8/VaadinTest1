package com.example.vaadintest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class VaadinTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(VaadinTestApplication.class, args);
    }

    @GetMapping(path = "/penis")
    public String test(){
        return "69";
    }
    @GetMapping(path = "/69")
    public String test1(){
        return "nice!";
    }

}
