package com.entregable5.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.entregable5.app.model.Client;
import com.entregable5.app.model.DTOClientAmountSpend;

import com.entregable5.app.service.ClientServiceImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/clients")
public class ClientController implements Controller<Client>{
	
	@Autowired
	//private ClientService clientService;
	private ClientServiceImpl clientService;
	
	// create a new client
	//@RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@Override
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Client c) {
		return ResponseEntity.status(HttpStatus.CREATED).body(clientService.save(c));
	}
	
	// List of clients
	@Override
	@GetMapping
	public List<Client> findAll(){
		return clientService.findAll();
	}
	
	// read an client
	@Override
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id) {
		Optional<Client> o = clientService.findById(id);
		
		if(!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(o);
	}
	
	// update an client
	@Override
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Client c, @PathVariable Long id) {
		Optional<Client> oClient = clientService.findById(id);
		
		if(!oClient.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		oClient.get().setName(c.getName());
		oClient.get().setSurname(c.getSurname());
		oClient.get().setEmail(c.getEmail());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(clientService.save(oClient.get()));
	}
	
	// delete an client
	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Optional<Client> oClient = clientService.findById(id);
		
		if(!oClient.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		clientService.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping(value = "/report")
	public List<DTOClientAmountSpend> getReportAmountSpend() {
		//System.out.println(clientService.getAmountSpendByClientReport());
		return clientService.getAmountSpendByClientReport();
	}
			
			
			

}
