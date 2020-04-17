package br.com.shoppingportal.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

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

	
	
}
