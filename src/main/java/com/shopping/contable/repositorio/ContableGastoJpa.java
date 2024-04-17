package com.shopping.contable.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.contable.modelo.ContableGastos;


public interface ContableGastoJpa extends JpaRepository<ContableGastos, String>{

}
