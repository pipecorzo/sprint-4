package com.misiontic.usuariosapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.misiontic.usuariosapi.entity.Pago;
import com.misiontic.usuariosapi.services.PagoService;

@RestController
public class PagoController {

	@Autowired
	private PagoService pagoService;

	@GetMapping(value ="/pago/{pagoCodFactura}")
	public ResponseEntity<Pago> findById(@PathVariable("pagoCodFactura") Long pagoCodFactura) {
		Pago pago = pagoService.findById(pagoCodFactura);
		return new ResponseEntity<Pago>(pago, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/pago/{pagoCodFactura}")
	public ResponseEntity<Void> delete(@PathVariable("pagoCodFactura")Long pagoCodFactura) {
		pagoService.delete(pagoCodFactura);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
		
	@GetMapping(value = "/pago")
	public ResponseEntity<List<Pago>> findAll() {
		List<Pago> pago = pagoService.findAll();
		return new ResponseEntity<List<Pago>>(pago, HttpStatus.OK);
	}
	
	@PostMapping(value = "/pago")
	public ResponseEntity<Pago> create(@RequestBody Pago pago) {
		Pago nuevoPago = pagoService.create(pago);
		return new ResponseEntity<Pago>(nuevoPago, HttpStatus.CREATED);
	}
	
		
	@PutMapping(value = "/pago")
	public ResponseEntity<Pago> update(@RequestBody Pago pago) {
		Pago existePago = pagoService.update(pago);
		return new ResponseEntity<Pago>(existePago, HttpStatus.OK);
	}
			
}
