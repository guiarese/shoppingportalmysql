package br.com.shoppingportal.service;

import java.util.List;

import br.com.shoppingportal.dto.ProductDTO;
import br.com.shoppingportal.entity.Product;

public interface ProductService {
	
	List<Product> findAll();
	Product findById(int idproducts);
	Product create(ProductDTO productsDTO);
	Product update(Integer idproduct, ProductDTO productsDTO);
	void delete(int idproducts);

}
