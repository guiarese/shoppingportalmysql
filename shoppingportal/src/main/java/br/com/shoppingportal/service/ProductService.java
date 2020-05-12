package br.com.shoppingportal.service;

import java.util.List;

import br.com.shoppingportal.dto.product.CreateProductDTO;
import br.com.shoppingportal.dto.product.UpdateProductDTO;
import br.com.shoppingportal.entity.Product;

public interface ProductService {
	
	List<Product> findAll();
	Product findById(int idproducts);
	Product create(CreateProductDTO productsDTO);
	Product update(UpdateProductDTO productsDTO);
	void delete(int idproducts);

}
