package com.jjvproyectosjjv.miprimercumplemongo.model.persona.usuario;

import com.jjvproyectosjjv.miprimercumplemongo.model.persona.Persona;
import com.jjvproyectosjjv.miprimercumplemongo.model.shared.Foto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

public abstract class Usuario extends Persona {

	protected String email;

	@DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME)

	protected Date fechaDeAlta = new Date();

	@DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME)
	protected Date fechaDeBaja;

	protected String password;

	protected Foto foto;

	protected String mensaje;

	protected String rol;

}
