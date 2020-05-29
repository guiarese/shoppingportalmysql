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
import br.com.shoppingportal.repository.ProductRepository;
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
	private ProductRepository repositoryProduct;
	
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
		
		if (orderDTO.getProducts().isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Ao menos um produto deve ser informado");
		}

		Set<ProductOrder> productsSet = new HashSet<>();
		for(ProductOrderDTO x : orderDTO.getProducts()) {
			
			ProductOrder productMake = new ProductOrder();
			
			productMake.setOrder(order);
			
			Product product = new Product();
			product = productService.findById(x.getIdproduct());
			if (product.getAmount() < x.getAmount()) {
				throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Quantidade solicitada maior que a quantidade do estoque");
			}
			if (product.getAmount() == 0) {
				throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Produto com quantidade 0 em estoque");
			}
			if (x.getAmount() <= 0) {
				throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Quantidade do produto deve ser maior do que zero");
			}
			productMake.setProduct(product);
			
			productMake.setAmount(x.getAmount());
			productMake.setValue(product.getPrice());
			
			BigDecimal sum1 = new BigDecimal(x.getAmount());
			BigDecimal sum2 = new BigDecimal(0).add(product.getPrice());
			sum1 = sum1.multiply(sum2);
			sumValues = sumValues.add(sum1);
			
			productsSet.add(productMake);
			
		}
		
		order.setProducts(productsSet);
		order.setValue(sumValues);
		
		repositoryOrder.save(order);
		repositoryProductOrder.saveAll(productsSet);
		
		for (ProductOrder w : order.getProducts()) {
			
			Product product = new Product();
			product = productService.findById(w.getIdproduct());
			product.setAmount(product.getAmount() - w.getAmount());
			repositoryProduct.save(product);
			
		}
		
		return order;
	}
	
}
