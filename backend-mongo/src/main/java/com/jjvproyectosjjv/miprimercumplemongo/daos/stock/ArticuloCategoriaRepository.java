package com.jjvproyectosjjv.miprimercumplemongo.daos.stock;

import com.jjvproyectosjjv.miprimercumplemongo.model.stock.ArticuloCategoria;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArticuloCategoriaRepository extends MongoRepository<ArticuloCategoria,String> {
}
