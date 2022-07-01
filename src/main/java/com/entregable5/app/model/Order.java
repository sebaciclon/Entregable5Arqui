package com.entregable5.app.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "orders")
@NamedQuery(name="Order.getProdCantByClientByDate", 
query = "SELECT SUM(od.cantidad) FROM Order o,  OrderDetail od WHERE o.id = od.orden.id AND o.cliente.id = :id_client AND od.product.id = :id_product "
		+ "AND o.fechaCompra = :date_compra")
public class Order implements Serializable {

	private static final long serialVersionUID = 7453838558734604648L;

	@Id
	@Column(name = "order_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date fechaCompra;
	
	@ManyToOne
	@JoinColumn(name = "fk_client", nullable = false)
	private Client cliente;
	
	/*@OneToMany(mappedBy = "orden")
	@JsonBackReference
	private List<OrderDetail> orderDetails = new ArrayList<>();*/
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public Client getCliente() {
		return cliente;
	}

	public void setCliente(Client cliente) {
		this.cliente = cliente;
	}
	
	/*public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}*/

	@Override
	public String toString() {
		return "Order [id=" + id + ", fechaCompra=" + fechaCompra + ", cliente=" + cliente + "]";
	}
}
