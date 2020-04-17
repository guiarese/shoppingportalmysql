package br.com.shoppingportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.shoppingportal.entity.Products;

public interface ProductsRepository extends JpaRepository<Products, Integer>{

}
