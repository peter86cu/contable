package com.shopping.contable.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.contable.service.ContableService;


@RestController
public class ContableController {
	
	@Autowired
	ContableService service;
	
	


	@PostMapping({ "contable/tipo-gastos" })
	@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> tiposGastos(HttpServletResponse responseHttp) throws IOException {
		return service.listadoTipoGasto();
		
	}
	
	
	@PostMapping(value = "contable/gastos/add", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> guardarGastos(@RequestBody String datos) {
		return service.addGasto(datos);

	}
	
}
