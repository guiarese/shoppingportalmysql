package br.com.shoppingportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.shoppingportal.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}
