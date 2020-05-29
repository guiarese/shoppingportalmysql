package br.com.shoppingportal.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.shoppingportal.dto.ClientDTO;
import br.com.shoppingportal.entity.AddressClient;
import br.com.shoppingportal.entity.Client;
import br.com.shoppingportal.repository.AddressClientRepository;
import br.com.shoppingportal.repository.ClientRepository;
import br.com.shoppingportal.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {
    
	@Autowired
	private ClientRepository repositoryClient;
	
	@Autowired
	private AddressClientRepository repositoryAddress;

	@Override
	public List<Client> findAll() {
		return repositoryClient.findAll().stream().collect(Collectors.toList());
	}

	@Override
	public Client create(ClientDTO clientDTO) {
		Client client = new Client(clientDTO);
		client = repositoryClient.save(client);
		for(AddressClient a : client.getAddresses()) {
			a.setClient(client);
		}
		repositoryAddress.saveAll(client.getAddresses());
		return client;
	}

	@Override
	public Client findById(int idclient) {
		return repositoryClient.findById(idclient)
						 .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	@Override
	public AddressClient findAddressById(int idaddress) {
		return repositoryAddress.findById(idaddress)
						 .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	@Override
	public void delete(int idclient) {
		Client client = findById(idclient);
		repositoryAddress.deleteByClientIdclient(client.getIdclient());
		repositoryClient.delete(client);
	}
	
	@Override
	public Client update(Integer idclient, ClientDTO clientDTO) {
		
		Client client = findById(idclient);
		
		repositoryAddress.deleteByClientIdclient(client.getIdclient());
		
		client.setName(clientDTO.getName());
		client.setCpf(clientDTO.getCpf());
		client.setPhonenumber(clientDTO.getPhonenumber());
		client.setBirthdate(clientDTO.getBirthdate());
		repositoryClient.save(client);
		
		client.setAddresses(clientDTO.getAddresses());
		for(AddressClient a : client.getAddresses()) {
			a.setClient(client);
		}
		repositoryAddress.saveAll(client.getAddresses());
		
		return client;
	}
	
}
