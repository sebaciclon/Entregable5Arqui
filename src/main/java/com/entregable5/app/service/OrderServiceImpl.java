package com.entregable5.app.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.entregable5.app.model.Order;
import com.entregable5.app.model.DTOSalesReport;
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

	@Override
	public Long getProdCantByClientByDate(Long id_client, Long id_product, Date date_compra) {
		return or.getProdCantByClientByDate(id_client, id_product, date_compra);
	}

	@Override
	public List<DTOSalesReport> reportSalesByDate() {
		return or.reportSalesByDate();
	}
}
