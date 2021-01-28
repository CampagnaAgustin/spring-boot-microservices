package com.campagna.app.item.models.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.campagna.app.item.models.Item;
import com.campagna.app.item.models.Product;
import com.campagna.app.item.models.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private RestTemplate restClient;
	
	@Override
	public List<Item> findAll() {
		List<Product> products = Arrays.asList(restClient.getForObject("http://localhost:8080/product/list", Product[].class));
		return products.stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer quantity) {
		Map<String, String> pathVariables = new HashMap<String, String>();
		pathVariables.put("id",  id.toString());
		Product product = restClient.getForObject("http://localhost:8080/product/{id}", Product.class, pathVariables);
		return new Item(product, quantity);
	}

}