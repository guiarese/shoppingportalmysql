package br.com.shoppingportal.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "address_client")
public class AddressClient implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idaddress;
	
	private String address;
	private String numberaddress;
	private String reference;
	private String district;
	private String postalcode;
	private String city;
	private String stateabbreviation;
	
	@ManyToOne
	@JoinColumn(name = "idclient")
	private Client client;
	
	@JsonIgnore
	public int getIdaddress() {
		return idaddress;
	}
	public void setIdaddress(int idaddress) {
		this.idaddress = idaddress;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNumberaddress() {
		return numberaddress;
	}
	public void setNumberaddress(String numberaddress) {
		this.numberaddress = numberaddress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStateabbreviation() {
		return stateabbreviation;
	}
	public void setStateabbreviation(String stateabbreviation) {
		this.stateabbreviation = stateabbreviation;
	}
	public String getPostalcode() {
		return postalcode;
	}
	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	@JsonIgnore
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}

}
