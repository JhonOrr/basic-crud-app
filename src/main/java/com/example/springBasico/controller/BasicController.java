package com.example.springBasico.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {
    //localhost: 8080
    @GetMapping("/hola")
    public String hola(){
        return "Hola a todos desde Spring Boot";
    }
    @GetMapping("/adios")
    public String decirAdios(){
        return "Adios desde Spring Boot";
    }
}
