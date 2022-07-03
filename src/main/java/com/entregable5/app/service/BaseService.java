package com.entregable5.app.service;

import java.util.List;
import java.util.Optional;



public interface BaseService<E> {
	
public List<E> findAll();
	
	public Optional<E> findById(Long id);
	
	public E save(E e);	// Alta/modificacion
	
	public void deleteById(Long id);	// Baja

}
