package com.campagna.app.item.models.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.campagna.app.item.client.ProductRestClient;
import com.campagna.app.item.models.Item;
import com.campagna.app.item.models.service.ItemService;

@Service("itemServiceFeign")
public class ItemServiceFeign implements ItemService {

	private final ProductRestClient feignClient;
	
	@Autowired	
	public ItemServiceFeign(ProductRestClient feignClient) {
		this.feignClient = feignClient;
	}

	@Override
	public List<Item> findAll() {
		return feignClient.list().stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer quantity) {
		return new Item(feignClient.findById(id),quantity);
	}

}
