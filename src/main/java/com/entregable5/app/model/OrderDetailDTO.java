package com.entregable5.app.model;

import lombok.Data;

@Data
public class OrderDetailDTO {

	private Long order_id;
	private Long product_id;
	private int cantidad;
	
}
