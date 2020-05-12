package br.com.shoppingportal.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.shoppingportal.dto.client.CreateClientDTO;

@Entity
@Table(name = "client")
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idclient;
	private String name;
	private String cpf;
	private String phonenumber;
	private Date birthdate;
	
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
	
	public Client() {
		
	}
	
	public Client(CreateClientDTO createClientDTO) {
		this.name = createClientDTO.getName();
		this.cpf = createClientDTO.getCpf();
		this.phonenumber = createClientDTO.getPhonenumber();
		this.birthdate = createClientDTO.getBirthdate();
	}

}
