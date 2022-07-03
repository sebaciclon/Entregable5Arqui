package com.entregable5.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "orderDetails")
public class OrderDetail implements Serializable{
	
	private static final long serialVersionUID = 7297139416803964460L;

	@EmbeddedId
	private OrderDetailId id = new OrderDetailId();
	
	@ManyToOne
	@MapsId("orderId")
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
