package com.entregable5.app.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrdersDateDTO {
	
	private Date fecha;
	private List<SaleDTO> ventas;
	
	public OrdersDateDTO() {
		this.fecha = null;
		this.ventas = new ArrayList<SaleDTO>();
	}

	public Date getDateCreated() {
		return fecha;
	}
	
	public void setDateCreated(Date dateCreated) {
		this.fecha = dateCreated;
	}

	public List<SaleDTO> getOrders() {
		return ventas;
	}

	public void setOrders(List<SaleDTO> orders) {
		this.ventas = orders;
	}
	
	public void addPurchase(SaleDTO p) {
		this.ventas.add(p);
	}
	
	
}
