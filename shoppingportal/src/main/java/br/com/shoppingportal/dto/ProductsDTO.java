package br.com.shoppingportal.dto;

import java.math.BigDecimal;

public class ProductsDTO {
	
	private int idproducts;
	private String name;
	private int amount;
	private BigDecimal price;
	
	public int getIdproducts() {
		return idproducts;
	}
	public void setIdproducts(int idproducts) {
		this.idproducts = idproducts;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
