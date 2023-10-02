package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.json.Greeting;
import com.example.demo.json.GreetingRecord;

@RestController
public class HelloRestController {

    @GetMapping("/rest")
    public Greeting greet(@RequestParam(defaultValue = "World") String name) {
        return new Greeting("Hello " + name);
    }

    @GetMapping("/record")
    public GreetingRecord greetWithRecord(@RequestParam(defaultValue = "World") String name) {
        return new GreetingRecord("Hello " + name);
    }
}
