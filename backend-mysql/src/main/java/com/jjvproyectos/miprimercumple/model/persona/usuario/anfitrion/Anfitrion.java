package com.jjvproyectos.miprimercumple.model.persona.usuario.anfitrion;

import com.jjvproyectos.miprimercumple.model.enumeraciones.Parentesco;
import com.jjvproyectos.miprimercumple.model.stock.Articulo;
import com.jjvproyectos.miprimercumple.model.persona.usuario.Usuario;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DiscriminatorValue("ANFITRION")
public class Anfitrion extends Usuario {

	private String urlGrupoDeWhatsApp;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Articulo> articulos = new ArrayList();

	@Enumerated(EnumType.STRING)
	private Parentesco parentescoConBirthDayKid;

}