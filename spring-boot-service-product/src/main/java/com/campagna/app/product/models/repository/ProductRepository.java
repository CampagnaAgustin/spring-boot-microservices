package com.campagna.app.product.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campagna.app.product.models.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
