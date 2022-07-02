package com.entregable5.app.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.entregable5.app.model.Order;

public interface OrderService {

	public List<Order> findAll();
	
	public Optional<Order> findById(Long id);
	
	public Order save(Order o);	// Alta/modificacion
	
	public void deleteById(Long id);	// Baja
	
	public Long getProdCantByClientByDate(Long id_client, Long id_product, Date date_compra);
	
	public List<Date> getAllDates();
	
	public List <Order> getOrdersByDate(Date date);
}
