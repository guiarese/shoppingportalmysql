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

import br.com.shoppingportal.dto.client.CreateClientDTO;
import br.com.shoppingportal.dto.client.UpdateClientDTO;
import br.com.shoppingportal.entity.Client;
import br.com.shoppingportal.service.ClientService;

@RestController
@RequestMapping({"/client"})
public class ClientController {
	
	private ClientService service;
	
	public ClientController(ClientService service) {
		this.service = service;
	}
			
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Client> findAll(){
	   return service.findAll();
	}
	
	@GetMapping("{idclient}")
	@ResponseStatus(HttpStatus.OK)
	public Client findByID(@PathVariable int idclient){
		return service.findById(idclient);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Client create(@RequestBody CreateClientDTO client) {
		return service.create(client);
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public Client update(@RequestBody UpdateClientDTO client) {
		return service.update(client);
	}
	
	@DeleteMapping("{idclient}")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable int idclient) {
		service.delete(idclient);
	}
	
}
