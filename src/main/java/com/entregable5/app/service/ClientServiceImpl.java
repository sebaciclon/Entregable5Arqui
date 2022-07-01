package com.entregable5.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.entregable5.app.model.Client;
import com.entregable5.app.model.DTOClientAmountSpend;
import com.entregable5.app.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService{
	
	@Autowired
	private ClientRepository cr;

	@Override
	public List<Client> findAll() {
		return cr.findAll();
	}

	@Override
	public Optional<Client> findById(Long id) {
		return cr.findById(id);
	}

	@Override
	public Client save(Client c) {
		return cr.save(c);
	}

	@Override
	public void deleteById(Long id) {
		cr.deleteById(id);
		
	}

	/*@Override
	public List<DTOClientAmountSpend> getAmountSpendByClientReport() {
		return cr.getAmountSpendByClientReport();
	}*/

	

	

}
