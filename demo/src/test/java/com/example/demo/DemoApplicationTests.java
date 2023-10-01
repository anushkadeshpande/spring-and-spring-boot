package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import com.example.demo.json.Greeting;

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

	@Test @Disabled("Bean exists")
	void noGreetingInAppCtx() {
		System.out.println("NO BEAN FOUND!");
		assertThrows(NoSuchBeanDefinitionException.class, () -> context.getBean(Greeting.class));
	}

	@Test
	void testDefaultGreeting() {
		Greeting greeting = context.getBean(Greeting.class);
		assertEquals("Hiee!", greeting.getMessage());
	}
}
