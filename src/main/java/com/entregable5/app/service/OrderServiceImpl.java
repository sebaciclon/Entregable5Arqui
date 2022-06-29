package com.entregable5.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.entregable5.app.model.Order;
import com.entregable5.app.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderRepository or;

	@Override
	public List<Order> findAll() {
		return or.findAll();
	}

	@Override
	public Optional<Order> findById(Long id) {
		return or.findById(id);
	}

	@Override
	public Order save(Order o) {
		return or.save(o);
	}

	@Override
	public void deleteById(Long id) {
		or.deleteById(id);
		
	}

}
