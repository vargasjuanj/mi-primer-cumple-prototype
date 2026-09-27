package com.jjvproyectosjjv.miprimercumplemongo.model.salon;

import com.jjvproyectosjjv.miprimercumplemongo.model.BaseEntity;
import com.jjvproyectosjjv.miprimercumplemongo.model.persona.usuario.anfitrion.Anfitrion;
import com.jjvproyectosjjv.miprimercumplemongo.model.persona.usuario.invitado.Invitado;
import com.jjvproyectosjjv.miprimercumplemongo.model.shared.Foto;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class Salon extends BaseEntity {

	private String nombre;

	@DBRef

	@Singular
	private List<Invitado> invitados = new ArrayList();

	@DBRef
	private Anfitrion anfitrion;

	private Ubicacion ubicacion;

	@Singular
	private List<Foto> fotos = new ArrayList();

}
