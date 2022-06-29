package com.entregable5.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.entregable5.app.model.Client;
import com.entregable5.app.service.ClientService;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	// create a new client
	@RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	//@PostMapping
	public ResponseEntity<?> create(@RequestBody Client c) {
		return ResponseEntity.status(HttpStatus.CREATED).body(clientService.save(c));
	}
	
	// read an client
	@GetMapping("/{id}")
	public ResponseEntity<?> getClientById(@PathVariable Long id) {
		Optional<Client> o = clientService.findById(id);
		
		if(!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(o);
			
	}
	
}
