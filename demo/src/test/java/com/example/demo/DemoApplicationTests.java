package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private ApplicationContext context;

	@Test
	void contextLoads() {
		System.out.println("No of beans: " + context.getBeanDefinitionCount());

		for(String name: context.getBeanDefinitionNames())
			System.out.println(name);
	}

}
