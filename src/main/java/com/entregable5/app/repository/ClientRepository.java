package com.entregable5.app.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.entregable5.app.model.Client;
import com.entregable5.app.model.DTOClientAmountSpend;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
	
	/*@Query(value =""
			+ "SELECT new com.entregable5.app.model.DTOClientAmountSpend(c, SUM(od.cantidad * p.price) AS int) "
			+ "FROM Client c, Order o, OrderDetail od, Product p"
			+ "WHERE c.client_id = o.cliente_client_id AND o.order_id = od.order_id AND od.product_id = p.product_id"
			+ "GROUP BY o.cliente_client_id")
			
	public List<DTOClientAmountSpend> getAmountSpendByClientReport();*/

	
}


