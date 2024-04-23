package com.shopping.contable.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@PostMapping(value = "contable/calculo/add", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> guardarCalculoCostos(@RequestBody String datos) {
		return service.guardarCalculoCosto(datos);

	}
	
	@PostMapping(value = "contable/centro-costo/add", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> guardarCentroCosto(@RequestBody String datos) {
		return service.addCentroCosto(datos);

	}
	
	@GetMapping(value = "contable/costos-directos", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> obtenerCostosDirectos(@RequestParam("mes") int mes,@RequestParam("anio") int anio, HttpServletRequest request)
			throws Exception {
		return service.obtenerCostosDirectos(mes, anio);

	}
	
	@PostMapping({ "contable/centro-costo/lista" })
	@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> obtenerCentroCosto(HttpServletResponse responseHttp) throws IOException {
		return service.listadoCentroCosto();
		
	}
	
}
