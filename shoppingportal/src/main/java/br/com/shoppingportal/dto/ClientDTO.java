package br.com.shoppingportal.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import br.com.shoppingportal.entity.AddressClient;

public class ClientDTO {
	
	private String name;
	private String cpf;
	private String phonenumber;
	private Date birthdate;
	private Set<AddressClient> addresses = new HashSet<>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public Set<AddressClient> getAddresses() {
		return addresses;
	}
	public void setAddresses(Set<AddressClient> addresses) {
		this.addresses = addresses;
	}

}
