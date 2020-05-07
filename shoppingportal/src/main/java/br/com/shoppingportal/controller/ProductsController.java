package br.com.shoppingportal.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.shoppingportal.dto.products.CreateProductsDTO;
import br.com.shoppingportal.dto.products.UpdateProductsDTO;
import br.com.shoppingportal.entity.Products;
import br.com.shoppingportal.service.ProductsService;

@RestController
@RequestMapping({"/products"})
public class ProductsController {
	
	private ProductsService service;
	
	public ProductsController(ProductsService service) {
		this.service = service;
	}
			
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Products> findAll(){
	   return service.findAll();
	}
	
	@GetMapping("{idproducts}")
	@ResponseStatus(HttpStatus.OK)
	public Products findByID(@PathVariable int idproducts){
		return service.findById(idproducts);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Products create(@RequestBody CreateProductsDTO products) {
		return service.create(products);
	}
	
	@PatchMapping
	@ResponseStatus(HttpStatus.OK)
	public Products update(@RequestBody UpdateProductsDTO products) {
		return service.update(products);
	}
	
	@DeleteMapping("{idproducts}")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable int idproducts) {
		service.delete(idproducts);
	}
	
}
