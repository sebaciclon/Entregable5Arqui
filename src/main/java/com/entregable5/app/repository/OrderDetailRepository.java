package com.entregable5.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entregable5.app.model.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long>{
	
}
