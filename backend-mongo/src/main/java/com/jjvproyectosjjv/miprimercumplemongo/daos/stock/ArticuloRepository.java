package com.jjvproyectosjjv.miprimercumplemongo.daos.stock;

import com.jjvproyectosjjv.miprimercumplemongo.model.stock.Articulo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArticuloRepository extends MongoRepository<Articulo,String> {
}
