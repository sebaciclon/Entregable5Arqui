package com.entregable5.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.entregable5.app.model.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long>{

	List<OrderDetail> getOrderDetailsByOrder(@Param("order_id") Long id_order);

}
