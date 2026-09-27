package com.jjvproyectosjjv.miprimercumplemongo.model.persona.usuario.anfitrion;

import com.jjvproyectosjjv.miprimercumplemongo.model.persona.Persona;
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
@Document(collection = "kids")
public class BirthdayKid extends Persona {

	@Singular
	private List<Foto> fotos = new ArrayList();

}
