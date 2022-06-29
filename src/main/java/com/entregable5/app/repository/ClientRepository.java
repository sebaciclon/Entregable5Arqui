package com.entregable5.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entregable5.app.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
