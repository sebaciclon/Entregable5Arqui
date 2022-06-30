package com.entregable5.app.controller;

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
import com.entregable5.app.model.OrderDetail;
import com.entregable5.app.service.OrderDetailService;

@RestController
@RequestMapping("/api/orderDetails")
public class OrderDetailController implements Controller<OrderDetail>{
	
	@Autowired
	private OrderDetailService orderDetailService;
	
	// create a new orderDetail
	//@RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@Override
	@PostMapping
	public ResponseEntity<?> create(@RequestBody OrderDetail od) {
		return ResponseEntity.status(HttpStatus.CREATED).body(orderDetailService.save(od));
	}
	
	// List of orderDetails
	@Override
	@GetMapping
	public List<OrderDetail> findAll(){
		return orderDetailService.findAll();
	}
	
	// read an orderDetail
	@Override
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id) {
		Optional<OrderDetail> oOrderDetail = orderDetailService.findById(id);
		
		if(!oOrderDetail.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oOrderDetail);
	}
	
	// update an orderDetail
	@Override
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody OrderDetail od, @PathVariable Long id) {
		Optional<OrderDetail> oOrderDetail = orderDetailService.findById(id);
		
		if(!oOrderDetail.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		oOrderDetail.get().setCantidad(od.getCantidad());
		oOrderDetail.get().setId(od.getId());
		oOrderDetail.get().setOrden(od.getOrden());
		oOrderDetail.get().setProduct(od.getProduct());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(orderDetailService.save(oOrderDetail.get()));
	}
	
	// delete an orderDetail
	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Optional<OrderDetail> oOrderDetail = orderDetailService.findById(id);
		
		if(!oOrderDetail.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		orderDetailService.deleteById(id);
		return ResponseEntity.ok().build();
	}


}