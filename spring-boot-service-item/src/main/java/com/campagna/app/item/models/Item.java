package com.campagna.app.item.models;

public class Item {
	
	Product product;
	Integer units;
	
	public Item() {}
	
	public Item(Product product, Integer units) {
		this.product = product;
		this.units = units;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public Integer getUnits() {
		return units;
	}
	
	public void setUnits(Integer units) {
		this.units = units;
	}

	public Double getTotal() {
		return product.getPrice() * this.units.doubleValue();
	}
	
}
