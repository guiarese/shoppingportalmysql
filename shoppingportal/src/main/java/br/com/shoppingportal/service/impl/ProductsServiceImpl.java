package br.com.shoppingportal.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.shoppingportal.dto.products.CreateProductsDTO;
import br.com.shoppingportal.dto.products.UpdateProductsDTO;
import br.com.shoppingportal.entity.Products;
import br.com.shoppingportal.repository.ProductsRepository;
import br.com.shoppingportal.service.ProductsService;

@Service
public class ProductsServiceImpl implements ProductsService {

	private ProductsRepository repository;

	public ProductsServiceImpl(ProductsRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Products> findAll() {
		return repository.findAll().stream().collect(Collectors.toList());
	}

	@Override
	public Products create(CreateProductsDTO productsDTO) {
		Products products = new Products(productsDTO);
		return repository.save(products);
	}

	@Override
	public Products findById(int idproducts) {
		return repository.findById(idproducts)
						 .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	@Override
	public void delete(int idproducts) {
		Products products = findById(idproducts);
		repository.delete(products);
	}

	@Override
	public Products update(UpdateProductsDTO productsDTO) {
		Products products = findById(productsDTO.getIdproducts());
		products.setName(productsDTO.getName());
		products.setAmount(productsDTO.getAmount());
		products.setPrice(productsDTO.getPrice());
		return repository.save(products);
	}
	
	

}
