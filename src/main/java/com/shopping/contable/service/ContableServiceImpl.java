package com.shopping.contable.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ayalait.utils.ErrorState;
import com.google.gson.Gson;
import com.shopping.contable.modelo.CalculoCosto;
import com.shopping.contable.modelo.CentroCosto;
import com.shopping.contable.modelo.ContableLibroDiario;
import com.shopping.contable.modelo.TipoGastos;
import com.shopping.contable.repositorio.CalculoCostoJpa;
import com.shopping.contable.repositorio.CentroCostoJpa;
import com.shopping.contable.repositorio.ContableGastoJpa;
import com.shopping.contable.repositorio.TipoGastoJpa;



@Service
public class ContableServiceImpl implements ContableService {

	ErrorState error= new ErrorState();
	
	@Autowired
	TipoGastoJpa daoTipoGasto;
	
	@Autowired
	ContableGastoJpa daoGasto;
	
	@Autowired
	CalculoCostoJpa daoCalculo;
	
	@Autowired
	CentroCostoJpa daoCentroCosto;
	
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
			ContableLibroDiario request = new Gson().fromJson(gasto, ContableLibroDiario.class);
			
				
				daoGasto.save(request);
			
				return new ResponseEntity<String>("Registrado guardado correctamente.",HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getMessage(),HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@Override
	public ResponseEntity<String> obtenerCostosDirectos(int mes, int anio) {
		try {
			List<ContableLibroDiario> costos= daoGasto.findCosotosDirectos(mes, anio);
			if(!costos.isEmpty()) {
				return new ResponseEntity<String>(new Gson().toJson(costos), HttpStatus.OK);
			}else {
				error.setCode(40001);
				error.setMenssage("No se encontraron datos para el filtro solicitado.");
				return new ResponseEntity<String>(new Gson().toJson(error), HttpStatus.BAD_REQUEST);

			}
		} catch (Exception e) {
			error.setCode(4000);
			error.setMenssage(e.getCause().getMessage());
			return new ResponseEntity<String>(new Gson().toJson(error), HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@Override
	public ResponseEntity<String> guardarCalculoCosto(String gasto) {
		try {
			CalculoCosto request = new Gson().fromJson(gasto, CalculoCosto.class);
			
				daoCalculo.save(request);
			
				return new ResponseEntity<String>("Registrado guardado correctamente.",HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@Override
	public ResponseEntity<String> addCentroCosto(String datos) {
		try {
			CentroCosto request = new Gson().fromJson(datos, CentroCosto.class);
			
				daoCentroCosto.save(request);
			
				return new ResponseEntity<String>("Registrado guardado correctamente.",HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getMessage(),HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@Override
	public ResponseEntity<String> listadoCentroCosto() {
		try {
			List<CentroCosto> tipo= daoCentroCosto.findAll();
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

	

}
