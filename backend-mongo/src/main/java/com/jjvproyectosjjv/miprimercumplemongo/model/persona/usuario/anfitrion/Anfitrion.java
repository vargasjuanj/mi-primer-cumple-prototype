package com.jjvproyectosjjv.miprimercumplemongo.model.persona.usuario.anfitrion;

import com.jjvproyectosjjv.miprimercumplemongo.model.enumeraciones.Parentesco;
import com.jjvproyectosjjv.miprimercumplemongo.model.persona.usuario.Usuario;
import com.jjvproyectosjjv.miprimercumplemongo.model.stock.Articulo;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class Anfitrion extends Usuario {

	private String urlGrupoDeWhatsApp;

	@Singular
	private List<Articulo> articulos = new ArrayList();

	private Parentesco parentescoConBirthDayKid;

}
