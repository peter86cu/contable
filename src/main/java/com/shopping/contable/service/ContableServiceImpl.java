package com.shopping.contable.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ayalait.utils.ErrorState;
import com.google.gson.Gson;
import com.shopping.contable.modelo.ContableGastos;
import com.shopping.contable.modelo.TipoGastos;
import com.shopping.contable.repositorio.ContableGastoJpa;
import com.shopping.contable.repositorio.TipoGastoJpa;



@Service
public class ContableServiceImpl implements ContableService {

	ErrorState error= new ErrorState();
	
	@Autowired
	TipoGastoJpa daoTipoGasto;
	
	@Autowired
	ContableGastoJpa daoGasto;
	
	@Override
	public ResponseEntity<String> listadoTipoGasto() {
		try {
			List<TipoGastos> tipo= daoTipoGasto.findAll();
			if(!tipo.isEmpty()) {
				return new ResponseEntity<String>(new Gson().toJson(tipo), HttpStatus.OK);
			}else {
				error.setCode(40001);
				return new ResponseEntity<String>(new Gson().toJson(error), HttpStatus.BAD_REQUEST);

			}
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@Override
	public ResponseEntity<String> addGasto(String gasto) {
		try {
			ContableGastos request = new Gson().fromJson(gasto, ContableGastos.class);
			
				
				daoGasto.save(request);
			
				return new ResponseEntity<String>("Gastos registrado correctamente.",HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getMessage(),HttpStatus.NOT_ACCEPTABLE);
		}
	}

	

}
