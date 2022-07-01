package com.entregable5.app.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.entregable5.app.model.Client;
import com.entregable5.app.model.DTOClientAmountSpend;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
	
	@Query(value =""
			+ "SELECT new com.entregable5.app.model.DTOClientAmountSpend(c, SUM(od.cantidad * p.price) AS int) "
			+ "FROM Client c, Order o, OrderDetail od, Product p "
			+ "WHERE c.id = o.cliente.id AND o.id = od.id.orderId AND od.id.productId = p.id "
			+ "GROUP BY o.cliente.id")
			
	public List<DTOClientAmountSpend> getAmountSpendByClientReport();
	
}


