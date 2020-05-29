package br.com.shoppingportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.shoppingportal.entity.ProductOrder;
import br.com.shoppingportal.entity.ProductOrderPK;

public interface ProductOrderRepository extends JpaRepository<ProductOrder, ProductOrderPK>{

}
