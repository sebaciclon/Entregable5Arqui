package com.entregable5.app.model;

public class DTOClientAmountSpend {

	private Client client;
	private double amountSpend;

	public DTOClientAmountSpend() {
		
	}

	public DTOClientAmountSpend(Client client, double amountSpend) {
		super();
		this.client = client;
		this.amountSpend = amountSpend;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public double getAmountSpend() {
		return amountSpend;
	}

	public void setAmountSpend(int amountSpend) {
		this.amountSpend = amountSpend;
	}
}
