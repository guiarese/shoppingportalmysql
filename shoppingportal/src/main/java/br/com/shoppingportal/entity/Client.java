package br.com.shoppingportal.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.br.CPF;

import br.com.shoppingportal.dto.ClientDTO;

@Entity
@Table(name = "client")
public class Client implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idclient;
	
	private String name;
	@CPF
	private String cpf;
	private String phonenumber;
	private Date birthdate;
	
	@OneToMany(mappedBy = "client")
	private Set<AddressClient> addresses = new HashSet<>();
	
	public int getIdclient() {
		return idclient;
	}
	public void setIdclient(int idclient) {
		this.idclient = idclient;
	}
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
	public Client() {
		
	}
	public Client(ClientDTO createClientDTO) {
		this.name = createClientDTO.getName();
		this.cpf = createClientDTO.getCpf();
		this.phonenumber = createClientDTO.getPhonenumber();
		this.birthdate = createClientDTO.getBirthdate();
		this.addresses = createClientDTO.getAddresses();
	}

}
