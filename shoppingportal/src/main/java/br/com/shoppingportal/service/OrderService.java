package br.com.shoppingportal.service;

import java.util.List;

import br.com.shoppingportal.dto.OrderDTO;
import br.com.shoppingportal.entity.Order;

public interface OrderService {
	
	List<Order> findAll();
	Order findById(int idorder);
	Order create(OrderDTO orderDTO);
	//Client update(Integer idclient, ClientDTO clientDTO);
	//void delete(int idclient);

}
