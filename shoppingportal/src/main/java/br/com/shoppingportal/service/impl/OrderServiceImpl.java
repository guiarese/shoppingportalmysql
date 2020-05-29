package br.com.shoppingportal.service.impl;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.shoppingportal.dto.OrderDTO;
import br.com.shoppingportal.dto.ProductOrderDTO;
import br.com.shoppingportal.entity.AddressClient;
import br.com.shoppingportal.entity.Client;
import br.com.shoppingportal.entity.Order;
import br.com.shoppingportal.entity.Product;
import br.com.shoppingportal.entity.ProductOrder;
import br.com.shoppingportal.repository.OrderRepository;
import br.com.shoppingportal.repository.ProductOrderRepository;
import br.com.shoppingportal.service.ClientService;
import br.com.shoppingportal.service.OrderService;
import br.com.shoppingportal.service.ProductService;

@Service
public class OrderServiceImpl implements OrderService {
    
	@Autowired
	private OrderRepository repositoryOrder;
	
	@Autowired
	private ProductOrderRepository repositoryProductOrder;
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private ProductService productService;

	@Override
	public List<Order> findAll() {
		return repositoryOrder.findAll().stream().collect(Collectors.toList());
	}
	
	@Override
	public Order findById(int idorder) {
		return repositoryOrder.findById(idorder)
						 .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	@Override
	public Order create(OrderDTO orderDTO) {
		
		Client client = new Client();
		client = clientService.findById(orderDTO.getIdclient());
		
		AddressClient addressClient = new AddressClient();
		addressClient = clientService.findAddressById(orderDTO.getIdaddress());
		
		Order order = new Order(orderDTO,client,addressClient);
		
		BigDecimal sumValues = new BigDecimal(0);

		Set<ProductOrder> productsSet = new HashSet<>();
		for(ProductOrderDTO x : orderDTO.getProducts()) {
			
			ProductOrder productMake = new ProductOrder();
			
			productMake.setOrder(order);
			
			Product product = new Product();
			product = productService.findById(x.getIdproduct());
			productMake.setProduct(product);
			
			productMake.setAmount(x.getAmount());
			productMake.setValue(product.getPrice());
			
			//BigDecimal sum1 = new BigDecimal(product.getPrice());
			
			productsSet.add(productMake);
			
		}
		
		order.setProducts(productsSet);
		//order.setValue(s);
		
		repositoryOrder.save(order);
		repositoryProductOrder.saveAll(productsSet);
		
		return order;
	}
	
}
