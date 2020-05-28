package br.com.shoppingportal.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.shoppingportal.dto.ProductDTO;
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
	
	@GetMapping("{idproduct}")
	@ResponseStatus(HttpStatus.OK)
	public Product findByID(@PathVariable int idproduct){
		return service.findById(idproduct);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Product create(@RequestBody ProductDTO product) {
		return service.create(product);
	}
	
	@PutMapping("{idproduct}")
	@ResponseStatus(HttpStatus.OK)
	public Product update(@PathVariable Integer idproduct, @RequestBody ProductDTO product) {
		return service.update(idproduct,product);
	}
	
	@DeleteMapping("{idproduct}")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable int idproduct) {
		service.delete(idproduct);
	}
	
}
