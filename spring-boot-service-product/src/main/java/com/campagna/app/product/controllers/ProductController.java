package com.campagna.app.product.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campagna.app.product.endpoints.ProductEndpoint;
import com.campagna.app.product.models.entity.Product;
import com.campagna.app.product.models.service.ProductService;

@RestController
@RequestMapping(value = ProductEndpoint.PRODUCT)
public class ProductController implements ProductEndpoint {

	private ProductService productService;
	
	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@Override
	@GetMapping(value = LIST)
	public List<Product> list() {
		return productService.findAll();
	}

	@Override
	@GetMapping(value = ID)
	public Product findById(@PathVariable("id") Long id) {
		return productService.findById(id);
	}

	
	
}
