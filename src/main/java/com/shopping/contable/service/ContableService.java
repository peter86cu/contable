package com.shopping.contable.service;

import org.springframework.http.ResponseEntity;



public interface ContableService {	
	
	ResponseEntity<String> listadoTipoGasto();
	
	ResponseEntity<String> addGasto(String gasto);
	
}
