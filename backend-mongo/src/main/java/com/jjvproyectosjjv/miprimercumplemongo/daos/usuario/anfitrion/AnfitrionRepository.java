package com.jjvproyectosjjv.miprimercumplemongo.daos.usuario.anfitrion;

import com.jjvproyectosjjv.miprimercumplemongo.model.persona.usuario.anfitrion.Anfitrion;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AnfitrionRepository extends MongoRepository<Anfitrion,String> {
}
