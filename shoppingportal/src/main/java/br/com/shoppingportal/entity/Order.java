package br.com.shoppingportal.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.shoppingportal.dto.OrderDTO;

@Entity
@Table(name = "orders")
public class Order implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idorder;
	
	@ManyToOne
    @JoinColumn(name = "idclient")
	private Client client;
	
	@ManyToOne
    @JoinColumn(name = "idaddress")
	private AddressClient deliveryAddress;
	
	@OneToMany(mappedBy = "id.order")
	private Set<ProductOrder> products = new HashSet<>();
	
	private Date orderdate;
	private BigDecimal value;
	
	public int getIdorder() {
		return idorder;
	}
	public void setIdorder(int idorder) {
		this.idorder = idorder;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public AddressClient getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(AddressClient deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	public Date getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}
	public BigDecimal getValue() {
		return value;
	}
	public void setValue(BigDecimal value) {
		this.value = value;
	}
	public Set<ProductOrder> getProducts() {
		return products;
	}
	public void setProducts(Set<ProductOrder> products) {
		this.products = products;
	}
	public Order() {
		
	}
	public Order(OrderDTO orderDTO, Client client, AddressClient deliveryAddress) {
		this.client = client;
		this.deliveryAddress = deliveryAddress;
		this.orderdate = orderDTO.getOrderdate();
	}

}
