package com.entregable5.app.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orderDetails")
public class OrderDetail {
	
	@Id
	private Long id;
	
	@Column(nullable = false)
	private Timestamp fechaCompra;
	
	@ManyToOne
	private Client cliente;

	public Long getId() {
		return id;
	}

}
