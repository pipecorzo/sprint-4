package com.misiontic.usuariosapi.validators;

import com.misiontic.usuariosapi.entity.Pago;

public class PagoValidator {
	
	public static void save(Pago pago) {
		if(pago.getNombre() == null || pago.getNombre().trim().isEmpty()) {
			throw new RuntimeException("El nombre del perfil es obligatorio. ");
		}
		
		if(pago.getNombre().length() > 100) {
			throw new RuntimeException("El nombre del perfil es muy largo maximo 100 caracteres");
		}
	}
	
}
