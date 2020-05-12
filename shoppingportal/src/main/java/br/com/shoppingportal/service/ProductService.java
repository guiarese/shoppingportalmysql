package br.com.shoppingportal.service;

import java.util.List;

import br.com.shoppingportal.dto.products.CreateProductDTO;
import br.com.shoppingportal.dto.products.UpdateProductDTO;
import br.com.shoppingportal.entity.Product;

public interface ProductService {
	
	List<Product> findAll();
	Product findById(int idproducts);
	Product create(CreateProductDTO productsDTO);
	Product update(UpdateProductDTO productsDTO);
	void delete(int idproducts);

}
