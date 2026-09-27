package com.jjvproyectosjjv.miprimercumplemongo.model.persona.usuario.invitado;

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
@Document(collection = "invitados")
public class Invitado extends Usuario {

	@Singular
	private List<Articulo> articulos= new ArrayList();

}
