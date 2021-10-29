package com.misiontic.usuariosapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.misiontic.usuariosapi.entity.Pago;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Long> {

	
}
