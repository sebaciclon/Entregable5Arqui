package com.entregable5.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.entregable5.app.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
	
	

}
