package com.jjvproyectos.miprimercumple.model.persona.usuario;

import java.util.Date;

import com.jjvproyectos.miprimercumple.model.persona.Persona;
import com.jjvproyectos.miprimercumple.model.shared.Foto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "usuarios")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="tipo_de_usuario")
public  class Usuario extends Persona {

	protected String email;

	@Temporal(TemporalType.TIMESTAMP)
	protected Date fechaDeAlta = new Date();

	protected Date fechaDeBaja;

	protected String password;

	@OneToOne (cascade = CascadeType.ALL, orphanRemoval = true)
	protected Foto foto;

}