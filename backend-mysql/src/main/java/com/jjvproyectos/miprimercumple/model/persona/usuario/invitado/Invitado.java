package com.jjvproyectos.miprimercumple.model.persona.usuario.invitado;

import com.jjvproyectos.miprimercumple.model.persona.usuario.Usuario;
import com.jjvproyectos.miprimercumple.model.stock.Articulo;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "invitados")
@DiscriminatorValue("INVITADO")

public class Invitado extends Usuario {

	@OneToMany(cascade = CascadeType.ALL)
	private List<Articulo> articulos= new ArrayList();

}