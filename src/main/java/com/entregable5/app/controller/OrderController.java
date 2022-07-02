package com.entregable5.app.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entregable5.app.model.Client;
import com.entregable5.app.model.Order;
import com.entregable5.app.model.OrdersDateDTO;
import com.entregable5.app.model.OrderDetail;
import com.entregable5.app.model.OrderDto;
import com.entregable5.app.model.PurchaseDetailDTO;
import com.entregable5.app.model.SaleDTO;
import com.entregable5.app.service.ClientService;
import com.entregable5.app.service.OrderDetailService;
import com.entregable5.app.service.OrderService;


@RestController
@RequestMapping("/api/orders")
public class OrderController implements Controller<Order> {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private OrderDetailService orderDetailService;
	
	// create a new order
	//@RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")

	@PostMapping
	public ResponseEntity<?> create(@RequestBody OrderDto o) {
		
		Optional<Client> c = clientService.findById(o.getFk_client());
		
		Order order = new Order();
		order.setCliente(c.get());
		order.setFechaCompra(new Date(System.currentTimeMillis()));
		
		System.out.println(o);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(orderService.save(order));
	}
	
	// List of orders
	@Override
	@GetMapping
	public List<Order> findAll(){
		return orderService.findAll();
	}
	
	// read an order
	@Override
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id) {
		Optional<Order> oOrder = orderService.findById(id);
		
		if(!oOrder.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oOrder);
	}
	
	// update an order
	@Override
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Order o, @PathVariable Long id) {
		Optional<Order> oOrder = orderService.findById(id);
		
		if(!oOrder.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		oOrder.get().setFechaCompra(o.getFechaCompra());
		oOrder.get().setCliente(o.getCliente());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(orderService.save(oOrder.get()));
	}
	
	// delete an client
	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Optional<Order> oOrder = orderService.findById(id);
		
		if(!oOrder.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		orderService.deleteById(id);
		return ResponseEntity.ok().build();
	}

	@Override
	public ResponseEntity<?> create(@RequestBody Order o) {
		return ResponseEntity.status(HttpStatus.CREATED).body(orderService.save(o));
	}
	
	@GetMapping("/report")
	public ResponseEntity<?> getOrderReport() {
		
		List<OrdersDateDTO> report = new ArrayList<OrdersDateDTO>();
		List<Date> salesDate = orderService.getAllDates();
		
		for(Date dateCreated : salesDate) {
			OrdersDateDTO record = new OrdersDateDTO();
			record.setDateCreated(dateCreated);
			
			List<Order> dailySales = orderService.getOrdersByDate(dateCreated);
			
			for(Order actual : dailySales) {
				SaleDTO sale = new SaleDTO();
				sale.setCliente(actual.getCliente().getName() + " " +actual.getCliente().getSurname());
				
				List<OrderDetail> details = orderDetailService.getOrderDetailsByOrder(actual.getId());
				for(OrderDetail detail: details) {
					PurchaseDetailDTO purchase = new PurchaseDetailDTO();
					purchase.setCantidad(detail.getCantidad());
					purchase.setProduct(detail.getProduct().getName());
					sale.addDetalle(purchase);
				}
				record.addPurchase(sale);
			}
			report.add(record);
		}
		return ResponseEntity.status(HttpStatus.OK).body(report);
	}
}
