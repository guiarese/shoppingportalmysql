package br.com.shoppingportal.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class OrderDTO {
	
	private int idclient;
	private int idaddress;
	private Date orderdate;
	private Set<ProductOrderDTO> products = new HashSet<>();
	
	public int getIdclient() {
		return idclient;
	}
	public void setIdclient(int idclient) {
		this.idclient = idclient;
	}
	public int getIdaddress() {
		return idaddress;
	}
	public void setIdaddress(int idaddress) {
		this.idaddress = idaddress;
	}
	public Date getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}
	public Set<ProductOrderDTO> getProducts() {
		return products;
	}
	public void setProducts(Set<ProductOrderDTO> products) {
		this.products = products;
	}
}
