package com.jjvproyectosjjv.miprimercumplemongo.daos.usuario.invitado;

import com.jjvproyectosjjv.miprimercumplemongo.model.persona.usuario.invitado.Invitado;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;

public interface InvitadoRepository extends MongoRepository<Invitado,String> {

	Invitado findByNombreAndSegundoNombre(String nombre, String segundoNombre);
	Invitado findByNombreAndApellido(String nombre, String apellido);

}
