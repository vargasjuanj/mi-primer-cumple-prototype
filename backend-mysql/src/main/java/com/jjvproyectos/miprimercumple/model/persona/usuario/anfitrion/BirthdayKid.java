package com.jjvproyectos.miprimercumple.model.persona.usuario.anfitrion;

import com.jjvproyectos.miprimercumple.model.shared.Foto;
import com.jjvproyectos.miprimercumple.model.persona.Persona;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "birthdaykid")
public class BirthdayKid extends Persona{

	@OneToMany(cascade = CascadeType.ALL)
	private List<Foto> fotos = new ArrayList();

}