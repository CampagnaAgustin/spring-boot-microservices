package com.campagna.app.item.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campagna.app.item.endpoint.ItemEndpoint;
import com.campagna.app.item.models.Item;
import com.campagna.app.item.models.service.ItemService;

@RestController
@RequestMapping(value = ItemEndpoint.ITEM)
public class ItemResource implements ItemEndpoint {
	
	@Autowired
	@Qualifier("itemServiceFeign")
	private ItemService itemService;

	@GetMapping(value = LIST)
	public List<Item> list(){
		return itemService.findAll();
	}
	
	@GetMapping(value = DETAIL)
	public Item detail(@PathVariable("id") Long id, @PathVariable("quantity") Integer quantity) {
		return itemService.findById(id, quantity);
	}
	
}
