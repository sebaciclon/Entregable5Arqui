package com.entregable5.app.service;

import java.util.List;
import java.util.Optional;

import com.entregable5.app.model.OrderDetail;

public interface OrderDetailService {

public List<OrderDetail> findAll();
	
	public Optional<OrderDetail> findById(Long id);
	
	public OrderDetail save(OrderDetail od);	// Alta/modificacion
	
	public void deleteById(Long id);	// Baja
	
	public List<OrderDetail> getOrderDetailsByOrder(Long id_order);
}
