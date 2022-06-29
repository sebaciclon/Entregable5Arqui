package com.entregable5.app.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;

public interface Controller<T> {
	
	public ResponseEntity<?> create(T t); 
	
	public List<T> findAll();
	
	public ResponseEntity<?> getById(Long id); 
	
	public ResponseEntity<?> update(T t, Long id);

	public ResponseEntity<?> delete(Long id); 


}
