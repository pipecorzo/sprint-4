package com.misiontic.usuariosapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.misiontic.usuariosapi.entity.Pago;
import com.misiontic.usuariosapi.repository.PagoRepository;
import com.misiontic.usuariosapi.validators.PagoValidator;

@Service
public class PagoService {
	@Autowired
	private PagoRepository pagoRepo;
	
	public Pago findById(Long perfilId) {
		Pago pago = pagoRepo.findById(perfilId)
				.orElseThrow(() -> new RuntimeException("No Existe la Factura."));
		return pago;
	}
	
	@Transactional
	public void delete(Long perfilId) {
		Pago perfil = pagoRepo.findById(perfilId)
				.orElseThrow(() -> new RuntimeException("No Existe la Factura."));
		pagoRepo.delete(perfil);	
		}
	
	
	public List<Pago> findAll() {
		List<Pago> perfiles = pagoRepo.findAll();
		return perfiles;
	}
	
	@Transactional
	public Pago create(Pago perfil) {
		PagoValidator.save(perfil);
		Pago nuevoPago = pagoRepo.save(perfil);
		return nuevoPago;
	}
		
	@Transactional
	public Pago update(Pago pago) {
		PagoValidator.save(pago);
		Pago existePago = pagoRepo.findById(pago.getCodFactura())
				.orElseThrow(() -> new RuntimeException("No Existe la Factura."));
		
		existePago.setNombre(pago.getNombre());
		existePago.setApellidos(pago.getApellidos());
		existePago.setDocumento(pago.getDocumento());
		existePago.setDireccion(pago.getDireccion());
		existePago.setPagoFinal(pago.getPagoFinal());
		pagoRepo.save(existePago);
		return existePago;
	}
			
}