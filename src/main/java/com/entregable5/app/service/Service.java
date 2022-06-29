package com.entregable5.app.service;

import java.util.List;
import java.util.Optional;

public interface Service<T> {

	public List<T> findAll();
	
	public Optional<T> findById(Long id);
	
	public T save(T t);	// Alta/modificacion
	
	public void deleteById(Long id);	// Baja
}
