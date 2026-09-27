package com.jjvproyectos.miprimercumple.model.salon;

import com.jjvproyectos.miprimercumple.model.shared.BaseEntity;
import com.jjvproyectos.miprimercumple.model.shared.Foto;
import com.jjvproyectos.miprimercumple.model.persona.usuario.anfitrion.Anfitrion;
import com.jjvproyectos.miprimercumple.model.persona.usuario.invitado.Invitado;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Salon extends BaseEntity {

	private String nombre;

	@OneToMany()
	@JoinColumn(name="salon")
	private List<Invitado> invitados = new ArrayList();

	@OneToOne()
	private Anfitrion anfitrion;

	@OneToOne (cascade = CascadeType.ALL)
	private Ubicacion ubicacion;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Foto> fotos = new ArrayList();

}