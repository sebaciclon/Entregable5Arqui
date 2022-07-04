package com.entregable5.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.entregable5.app.model.DTOProductMoreSelling;
import com.entregable5.app.model.Product;
import com.entregable5.app.repository.ProductRepository;

@Service
public class ProductServiceImpl implements BaseService<Product> {
	
	@Autowired
	private ProductRepository pr;

	@Override
	@Transactional(readOnly = true)		// en una transaccion de solo lectura, no va a cambiar nada en la db
	public List<Product> findAll() {
		return pr.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Product> findById(Long id) {
		return pr.findById(id);
	}

	@Override
	@Transactional		// guarda la entidad en la db, por ende va a cambiar la db
	public Product save(Product p) {
		return pr.save(p);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		pr.deleteById(id);
		
	}

	
	public List<DTOProductMoreSelling> getAllMoreSelling() {
		return pr.getAllMoreSelling();
	}

	public DTOProductMoreSelling getMoreSelling() {
		return this.getAllMoreSelling().get(0);
	}

}
