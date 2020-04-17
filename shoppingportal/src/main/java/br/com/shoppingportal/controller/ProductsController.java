package br.com.shoppingportal.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public List<Products> findAll(){
	   return service.findAll();
	}

}
