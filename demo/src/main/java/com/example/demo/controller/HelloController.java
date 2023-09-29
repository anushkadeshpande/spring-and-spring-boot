package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
    
    @GetMapping("/hello")
    public String sayHello(@RequestParam(defaultValue = "world") String name, Model model) {

        // spring uses RequestMappingHandlerMapping to map requests to methods
        // spring uses ThymeleafViewResolver to map the returned string to view

        // Spring takes all attriburtes from the Model object
        // those are added to the current HttpRequest and forwarded to view
        model.addAttribute("user", name);
        return "hello"; // this string will be mapped by spring to src/main/resources/templates/hello.html (thymeleaf)
                        // spring uses view resolver, which resolves strings to views, done by thymeleaf
    }
}
