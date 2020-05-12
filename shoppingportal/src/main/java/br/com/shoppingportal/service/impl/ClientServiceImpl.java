package br.com.shoppingportal.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.shoppingportal.dto.client.CreateClientDTO;
import br.com.shoppingportal.entity.Client;
import br.com.shoppingportal.repository.ClientRepository;
import br.com.shoppingportal.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

	private ClientRepository repository;

	public ClientServiceImpl(ClientRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Client> findAll() {
		return repository.findAll().stream().collect(Collectors.toList());
	}

	@Override
	public Client create(CreateClientDTO clientDTO) {
		Client client = new Client(clientDTO);
		return repository.save(client);
	}

	@Override
	public Client findById(int idclient) {
		return repository.findById(idclient)
						 .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	/*@Override
	public void delete(int idproduct) {
		Product product = findById(idproduct);
		repository.delete(product);
	}

	@Override
	public Product update(UpdateProductDTO productsDTO) {
		Product product = findById(productsDTO.getIdproduct());
		product.setName(productsDTO.getName());
		product.setAmount(productsDTO.getAmount());
		product.setPrice(productsDTO.getPrice());
		return repository.save(product);
	}
	*/
	

}
