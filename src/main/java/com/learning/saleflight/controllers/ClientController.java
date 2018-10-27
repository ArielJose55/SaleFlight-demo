package com.learning.saleflight.controllers;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.learning.saleflight.entities.Client;
import com.learning.saleflight.repositories.ClientRepository;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

	@Autowired
	private ClientRepository clientRepository;
	
	@GetMapping
	public Iterable<Client> findAll(){
		return clientRepository.findAll();
	}
	
	@GetMapping("/{uername}")
	public List<Client> findByUsername(@PathVariable String username){
		return clientRepository.findByUsername(username);
	}
	
	@GetMapping("/{id}")
	public Client findById(@PathVariable long id) {
		return clientRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}
	
	@PostMapping
	@ResponseStatus(org.springframework.http.HttpStatus.CREATED)
	public Client create(@RequestBody Client client) {
		return clientRepository.save(client);
	}
	
	@DeleteMapping("/{id}")
	public void deleteClient(@PathVariable long id) {
		Client client = clientRepository.findById(id).orElseThrow(EntityNotFoundException::new);
		clientRepository.delete(client);
	}
	
	@PutMapping("/{id}")
	public Client updateClient(@RequestBody Client client, @PathVariable long id) {
		if(client.getId() != id)
			throw new EntityNotFoundException("Cliente no existe");
		clientRepository.findById(id).orElseThrow(EntityNotFoundException::new);
		return clientRepository.save(client);
	}
	
}
