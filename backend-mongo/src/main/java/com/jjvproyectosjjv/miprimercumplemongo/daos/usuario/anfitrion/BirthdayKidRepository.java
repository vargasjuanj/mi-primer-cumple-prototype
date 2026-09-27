package com.jjvproyectosjjv.miprimercumplemongo.daos.usuario.anfitrion;

import com.jjvproyectosjjv.miprimercumplemongo.model.persona.usuario.anfitrion.BirthdayKid;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BirthdayKidRepository extends MongoRepository<BirthdayKid,String> {
}
