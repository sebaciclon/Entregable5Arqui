package com.entregable5.app.model;

import java.util.ArrayList;
import java.util.List;

public class SaleDTO {
	
	private String cliente;
	private List<PurchaseDetailDTO> detalle;
	
	
	
	public SaleDTO() {
		this.cliente = null;
		this.detalle = new ArrayList<PurchaseDetailDTO>();
	}

	public String getCliente() {
		return cliente;
	}
	
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	
	public List<PurchaseDetailDTO> getDetalle() {
		return detalle;
	}
	
	public void setDetalle(List<PurchaseDetailDTO> detalle) {
		this.detalle = detalle;
	}
	
	public void addDetalle(PurchaseDetailDTO detalle) {
		this.detalle.add(detalle);
	}
}
