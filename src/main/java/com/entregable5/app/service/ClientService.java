package com.entregable5.app.service;

import java.util.List;
import java.util.Optional;

import com.entregable5.app.model.Client;
import com.entregable5.app.model.DTOClientAmountSpend;

public interface ClientService {
	
	public List<Client> findAll();
	
	public Optional<Client> findById(Long id);
	
	public Client save(Client c);	// Alta/modificacion
	
	public void deleteById(Long id);	// Baja
	
	//public List<DTOClientAmountSpend> getAmountSpendByClientReport();
	
	//Pagination<T> findAll(int page, int size);

}
