package com.shopping.contable.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;



import com.shopping.contable.modelo.TipoGastos;


public interface TipoGastoJpa extends JpaRepository<TipoGastos, Integer>{

}
