package com.entregable5.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orderDetails")
public class OrderDetail {
	
	@Id
	@GeneratedValue
	private long id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private Order orden;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private Product product;
	
	@Column(nullable = false)
	private int cantidad;

	public long getId() {
		return id;
	}

	public void setId(long id) {
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
	
	

	

}
