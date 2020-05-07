package br.com.shoppingportal.service;

import java.util.List;

import br.com.shoppingportal.dto.products.CreateProductsDTO;
import br.com.shoppingportal.dto.products.UpdateProductsDTO;
import br.com.shoppingportal.entity.Products;

public interface ProductsService {
	
	List<Products> findAll();
	Products findById(int idproducts);
	Products create(CreateProductsDTO productsDTO);
	Products update(UpdateProductsDTO productsDTO);
	void delete(int idproducts);

}
