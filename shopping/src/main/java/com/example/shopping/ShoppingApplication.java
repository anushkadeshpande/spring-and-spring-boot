package com.example.shopping;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.shopping.dao.ProductRepository;
import com.example.shopping.entities.Product;

@SpringBootApplication
public class ShoppingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingApplication.class, args);
	}

	@Bean
	public CommandLineRunner appInit(@Autowired ProductRepository repository) {
		return args -> {
			List<Product> products = List.of(
					new Product("Football", BigDecimal.valueOf(25.00)),
					new Product("Football", BigDecimal.valueOf(25.00)),
					new Product("Football", BigDecimal.valueOf(25.00))

			);
			repository.saveAll(products).forEach(System.out::println);
			;
		};
	}

}
