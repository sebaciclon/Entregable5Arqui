package com.entregable5.app.model;

import java.util.Date;

public class DTOSalesReport{
	
	Date fecha;
	String producto;
	long cantidad;
	
	public DTOSalesReport(Date fecha, String producto, long cantidad) {
		this.fecha = fecha;
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public long getCantidad() {
		return cantidad;
	}

	public void setCantidad(long cantidad) {
		this.cantidad = cantidad;
	}
	

}
