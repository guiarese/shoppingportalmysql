package br.com.shoppingportal.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.shoppingportal.dto.OrderDTO;
import br.com.shoppingportal.entity.Order;
import br.com.shoppingportal.service.OrderService;

@RestController
@RequestMapping({"/order"})
public class OrderController {
	
	private OrderService service;
	
	public OrderController(OrderService service) {
		this.service = service;
	}
			
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Order> findAll(){
	   return service.findAll();
	}
	
	@GetMapping("{idorder}")
	@ResponseStatus(HttpStatus.OK)
	public Order findByID(@PathVariable int idorder){
		return service.findById(idorder);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Order create(@RequestBody OrderDTO orderDTO) {
		return service.create(orderDTO);
	}
	
}
