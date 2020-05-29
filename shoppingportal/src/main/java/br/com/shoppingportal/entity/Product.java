package br.com.shoppingportal.entity;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.shoppingportal.dto.ProductDTO;

@Entity
@Table(name = "product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idproduct;
	private String name;
	private int amount;
	private BigDecimal price;
	
	@JsonIgnore
	@OneToMany(mappedBy = "id.order")
	private Set<ProductOrder> products = new HashSet<>();
	
	public int getIdproduct() {
		return idproduct;
	}
	public void setIdproduct(int idproduct) {
		this.idproduct = idproduct;
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
	public Set<ProductOrder> getProducts() {
		return products;
	}
	public void setProducts(Set<ProductOrder> products) {
		this.products = products;
	}
	public Product(){
		
	}
	public Product(ProductDTO productsDTO){
		this.name = productsDTO.getName();
		this.amount = productsDTO.getAmount();
		this.price = productsDTO.getPrice();
	}

}
