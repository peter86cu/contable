package com.shopping.contable.service;

import org.springframework.http.ResponseEntity;



public interface ContableService {	
	
	ResponseEntity<String> listadoTipoGasto();
	
	ResponseEntity<String> addGasto(String gasto);
	
	ResponseEntity<String> addCentroCosto(String gasto);
	
	ResponseEntity<String> obtenerCostosDirectos(int mes, int anio);
	
	ResponseEntity<String> guardarCalculoCosto(String gasto);
	
	ResponseEntity<String> listadoCentroCosto();
}
