package com.learning.saleflight.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.learning.saleflight.entities.Client;

public interface ClientRepository extends CrudRepository<Client, Long>{
	List<Client> findByUsername(String username);
}
