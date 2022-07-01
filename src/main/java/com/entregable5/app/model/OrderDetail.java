package com.entregable5.app.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "orderDetails")
public class OrderDetail {
	
//	@Id
//	@GeneratedValue
//	@Column(name = "order_detail_id")
//	private long id;
	
	@EmbeddedId
	private OrderDetailId id = new OrderDetailId();
	
	@ManyToOne
	@MapsId("orderId")
	@JsonManagedReference
	private Order orden;
	
	@ManyToOne
	@MapsId("productId")
	private Product product;
	
	@Column(nullable = false)
	private int cantidad;

	public OrderDetailId getId() {
		return id;
	}

	public void setId(OrderDetailId id) {
		this.id = id;
	}

	public Order getOrden() {
		return orden;
	}

	public void setOrden(Order orden) {
		this.orden = orden;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", orden=" + orden + ", product=" + product + ", cantidad=" + cantidad + "]";
	}
}
