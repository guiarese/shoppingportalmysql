package br.com.shoppingportal.service;

import java.util.List;

import br.com.shoppingportal.dto.client.CreateClientDTO;
import br.com.shoppingportal.entity.Client;

public interface ClientService {
	
	List<Client> findAll();
	Client findById(int idclient);
	Client create(CreateClientDTO clientDTO);
	//Product update(UpdateProductDTO productsDTO);
	//void delete(int idproducts);

}
