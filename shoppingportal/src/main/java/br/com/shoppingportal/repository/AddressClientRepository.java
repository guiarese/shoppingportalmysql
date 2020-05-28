package br.com.shoppingportal.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.shoppingportal.entity.AddressClient;

public interface AddressClientRepository extends JpaRepository<AddressClient, Integer>{
	
	@Transactional
	void deleteByClientIdclient(Integer idclient);

}
