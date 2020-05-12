package br.com.shoppingportal.service;

import java.util.List;

import br.com.shoppingportal.entity.Client;

public interface ClientService {
	
	List<Client> findAll();
	//Product findById(int idproducts);
	//Product create(CreateProductDTO productsDTO);
	//Product update(UpdateProductDTO productsDTO);
	//void delete(int idproducts);

}
