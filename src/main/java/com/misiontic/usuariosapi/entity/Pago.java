package com.misiontic.usuariosapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name="pago")
public class Pago {
	
	@Id
	@Column(name="codFactura")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codFactura;
	
	@Column(name="nombre", nullable = false, length = 100)
	private String nombre;
	
	@Column(name="apellidos", nullable = false, length = 100)
	private String apellidos;
	
	@Column(name="documento", nullable = false, length = 100)
	private Long documento;
	
	@Column(name="direccion", nullable = false, length = 100)
	private String direccion;
	
	@Column(name="pagoFinal", nullable = false, length = 100)
	private Long pagoFinal;
}
