package com.campagna.app.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@RibbonClient(name = "product-service")
@EnableFeignClients
@SpringBootApplication
public class SpringBootServiceItemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootServiceItemApplication.class, args);
	}

}
