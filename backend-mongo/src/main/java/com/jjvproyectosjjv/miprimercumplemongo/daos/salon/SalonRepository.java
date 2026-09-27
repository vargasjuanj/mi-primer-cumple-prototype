package com.jjvproyectosjjv.miprimercumplemongo.daos.salon;

import com.jjvproyectosjjv.miprimercumplemongo.model.salon.Salon;;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SalonRepository extends MongoRepository<Salon,String> {

}

