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

import br.com.shoppingportal.dto.products.CreateProductDTO;
import br.com.shoppingportal.dto.products.UpdateProductDTO;
import br.com.shoppingportal.entity.Product;
import br.com.shoppingportal.service.ProductService;

@RestController
@RequestMapping({"/product"})
public class ProductController {
	
	private ProductService service;
	
	public ProductController(ProductService service) {
		this.service = service;
	}
			
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Product> findAll(){
	   return service.findAll();
	}
	
	@GetMapping("{idproducts}")
	@ResponseStatus(HttpStatus.OK)
	public Product findByID(@PathVariable int idproducts){
		return service.findById(idproducts);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Product create(@RequestBody CreateProductDTO products) {
		return service.create(products);
	}
	
	@PatchMapping
	@ResponseStatus(HttpStatus.OK)
	public Product update(@RequestBody UpdateProductDTO products) {
		return service.update(products);
	}
	
	@DeleteMapping("{idproducts}")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable int idproducts) {
		service.delete(idproducts);
	}
	
}
