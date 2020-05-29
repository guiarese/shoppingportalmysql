package br.com.shoppingportal.service;

import java.util.List;

import br.com.shoppingportal.dto.ClientDTO;
import br.com.shoppingportal.entity.AddressClient;
import br.com.shoppingportal.entity.Client;

public interface ClientService {
	
	List<Client> findAll();
	Client findById(int idclient);
	AddressClient findAddressById(int idaddress);
	Client create(ClientDTO client);
	Client update(Integer idclient, ClientDTO clientDTO);
	void delete(int idclient);

}
