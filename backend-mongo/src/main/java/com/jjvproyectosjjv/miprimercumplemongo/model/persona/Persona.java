package com.jjvproyectosjjv.miprimercumplemongo.model.persona;

import java.util.Date;

import com.jjvproyectosjjv.miprimercumplemongo.model.BaseEntity;
import com.jjvproyectosjjv.miprimercumplemongo.model.enumeraciones.Sexo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Persona extends BaseEntity {

	protected String nombre;

	protected String segundoNombre;

	protected String apellido;

	protected int edad;

	@DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME)

	protected Date fechaDeNacimiento;

	protected Sexo sexo;

}
