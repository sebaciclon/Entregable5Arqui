package com.entregable5.app.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entregable5.app.model.Order;


@RestController
@RequestMapping("/api/products")
public class OrderController implements Controller<Order> {

	@Override
	public ResponseEntity<?> create(Order t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> update(Order t, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
