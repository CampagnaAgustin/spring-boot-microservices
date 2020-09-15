package com.campagna.app.product.models.service;

import java.util.List;

import com.campagna.app.product.models.entity.Product;

public interface ProductService {

	List<Product> findAll();
	
	Product findById(Long id);
}
