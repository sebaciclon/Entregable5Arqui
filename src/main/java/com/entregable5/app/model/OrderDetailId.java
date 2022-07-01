package com.entregable5.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailId implements Serializable{
	
	@Column(name = "order_id")
	private Long orderId;
	
	@Column(name = "product_id")
	private Long productId;

}
