package com.entregable5.app.repository;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entregable5.app.model.Order;
import com.entregable5.app.model.DTOSalesReport;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
	
	@Query(value =""
			+ "SELECT SUM(od.cantidad) FROM Order o, OrderDetail od WHERE o.id = od.orden.id "
			+ "AND o.cliente.id = :id_client AND od.product.id = :id_product "
			+ "AND o.fechaCompra = :date_compra ")
		
	public Long getProdCantByClientByDate(@Param("id_client") Long id_client, @Param("id_product") Long id_product, 
			@Param("date_compra") Date date_compra);
	
	@Query(value =""
			+ "SELECT new com.entregable5.app.model.DTOSalesReport( od.orden.fechaCompra, od.product.name, SUM(od.cantidad)) "
			+ "FROM OrderDetail od GROUP BY od.orden.fechaCompra, od.product.name "
			+ "ORDER BY od.orden.fechaCompra DESC ")

	
	public List<DTOSalesReport> reportSalesByDate();
}
