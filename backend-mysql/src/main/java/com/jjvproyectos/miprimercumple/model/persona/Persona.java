package com.jjvproyectos.miprimercumple.model.persona;

import java.util.Date;

import com.jjvproyectos.miprimercumple.model.enumeraciones.Sexo;
import com.jjvproyectos.miprimercumple.model.shared.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class Persona extends BaseEntity {

	protected String nombre;

	protected String segundoNombre;

	protected String apellido;

	protected int edad;

	@Temporal(TemporalType.TIMESTAMP)
	protected Date fechaDeNacimiento;

	@Enumerated
	protected Sexo sexo;

}