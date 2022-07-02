package com.entregable5.app.service;

import java.util.List;
import java.util.Optional;
import com.entregable5.app.model.DTOProductMoreSelling;
import com.entregable5.app.model.Product;

public interface ProductService {
	
	public List<Product> findAll();
	
	public Optional<Product> findById(Long id);
	
	public Product save(Product p);	// Alta/modificacion
	
	public void deleteById(Long id);	// Baja
	
	public List<DTOProductMoreSelling> getMoreSelling();

}
