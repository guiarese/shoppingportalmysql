package br.com.shoppingportal.dto;

public class ProductOrderDTO {
	
	private int idproduct;
	private int amount;
	
	public ProductOrderDTO() {
		
	}
	
	public int getIdproduct() {
		return idproduct;
	}
	public void setIdproduct(int idproduct) {
		this.idproduct = idproduct;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}	

}
