package com.entregable5.app.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.entregable5.app.model.OrderDetail;
import com.entregable5.app.repository.OrderDetailRepository;

@Service
public class OrderDetailServiceImpl implements OrderDetailService{

	@Autowired
	private OrderDetailRepository odr;

	@Override
	public List<OrderDetail> findAll() {
		return odr.findAll();
	}

	@Override
	public Optional<OrderDetail> findById(Long id) {
		return odr.findById(id);
	}

	@Override
	public OrderDetail save(OrderDetail od) {
		return odr.save(od);
	}

	@Override
	public void deleteById(Long id) {
		odr.deleteById(id);
		
	}
}
