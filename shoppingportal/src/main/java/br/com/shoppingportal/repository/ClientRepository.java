package br.com.shoppingportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.shoppingportal.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Integer>{

}
