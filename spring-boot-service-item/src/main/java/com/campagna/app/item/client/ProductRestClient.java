package com.campagna.app.item.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.campagna.app.item.models.Product;

@FeignClient(name = "product-service")
public interface ProductRestClient {
	
	@GetMapping(value = "/product/list")
	public List<Product> list(); 
	
	@GetMapping(value = "/product/{id}")
	public Product findById(@PathVariable("id") Long id);
}
