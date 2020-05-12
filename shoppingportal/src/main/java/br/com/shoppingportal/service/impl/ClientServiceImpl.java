package br.com.shoppingportal.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
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

	/*@Override
	public Product create(CreateProductDTO productDTO) {
		Product product = new Product(productDTO);
		return repository.save(product);
	}

	@Override
	public Product findById(int idproduct) {
		return repository.findById(idproduct)
						 .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	@Override
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
