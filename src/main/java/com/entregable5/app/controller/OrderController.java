package com.entregable5.app.controller;

import java.util.Date;
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
import com.entregable5.app.model.Order;
import com.entregable5.app.model.OrderDto;

import com.entregable5.app.service.ClientServiceImpl;

import com.entregable5.app.service.OrderServiceImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/orders")
public class OrderController implements Controller<Order> {

	@Autowired
	private OrderServiceImpl orderService;
	
	@Autowired
	private ClientServiceImpl clientService;

	
	// create a new order
	//@RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")

	@PostMapping
	public ResponseEntity<?> create(@RequestBody OrderDto o) {
		
		Optional<Client> c = clientService.findById(o.getFk_client());
		
		Order order = new Order();
		order.setCliente(c.get());
		order.setFechaCompra(new Date(System.currentTimeMillis()));
		
		System.out.println(o);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(orderService.save(order));
	}
	
	// List of orders
	@Override
	@GetMapping
	public List<Order> findAll(){
		return orderService.findAll();
	}
	
	// read an order
	@Override
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id) {
		Optional<Order> oOrder = orderService.findById(id);
		
		if(!oOrder.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oOrder);
	}
	
	// update an order
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody OrderDto o, @PathVariable Long id) {
		Optional<Order> oOrder = orderService.findById(id);
		
		Optional<Client> clienteNuevo = clientService.findById(o.getFk_client());
		if(!oOrder.isPresent()) {
			return ResponseEntity.notFound().build();
		}
	
		oOrder.get().setCliente(clienteNuevo.get());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(orderService.save(oOrder.get()));
	}
	
	// delete an client
	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Optional<Order> oOrder = orderService.findById(id);
		
		if(!oOrder.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		orderService.deleteById(id);
		return ResponseEntity.ok().build();
	}

	
	@Override
	public ResponseEntity<?> create(@RequestBody Order o) {
		return ResponseEntity.status(HttpStatus.CREATED).body(orderService.save(o));
	}
	
	@Override
	public ResponseEntity<?> update(Order o, Long id) {
		return ResponseEntity.status(HttpStatus.CREATED).body(orderService.save(o));
	}
	
	@GetMapping("/report")
	public ResponseEntity<?> getOrderReport() {
		return ResponseEntity.status(HttpStatus.OK).body(orderService.reportSalesByDate());
	}

	
}
