package com.entregable5.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entregable5.app.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

	public Long getProdCantByClientByDate(@Param("id_client") Long id_client, @Param("id_product") Long id_product, @Param("date_compra") Date date_compra);

	public List<Date> getAllDates();

	public List<Order> getOrdersByDate(@Param("date") Date date);
}
