package com.udemy.udemy;

import com.udemy.udemy.model.Alien;
import com.udemy.udemy.model.Laptop;
import com.udemy.udemy.service.LaptopService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class UdemyApplication {

	public static void main(String[] args) {
		ApplicationContext c = SpringApplication.run(UdemyApplication.class, args);
		//c.getBean(Alien.class).code();

		LaptopService service = c.getBean( LaptopService.class);

		Laptop lap = c.getBean(Laptop.class);
		service.addLaptop(lap);

	}

}
