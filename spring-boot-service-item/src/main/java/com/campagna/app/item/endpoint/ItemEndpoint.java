package com.campagna.app.item.endpoint;

import java.util.List;

import com.campagna.app.item.models.Item;

public interface ItemEndpoint {
	
	String ID_PARAM = "id";
	String QUANTITY_PARAM = "quantity";
	
	String ITEM = "/item";
	String LIST = "/list";
	String DETAIL = "/{" + ID_PARAM + "}/quantity/{" + QUANTITY_PARAM + "}";
	
	List<Item> list();
	
	Item detail(Long id, Integer quantity);

}
