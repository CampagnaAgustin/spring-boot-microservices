package com.campagna.app.product.endpoints;

import java.util.List;

import com.campagna.app.product.models.entity.Product;

public interface ProductEndpoint {

	String PRODUCT = "/product";
	String LIST = "/list";
	String ID = "/{id}";
	
	public List<Product> list();
	
	public Product findById(Long id);
	
}
