package com.jjvproyectosjjv.miprimercumplemongo.daos.usuario;

import com.jjvproyectosjjv.miprimercumplemongo.model.persona.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AdminRepository extends MongoRepository<Admin,String> {
}
