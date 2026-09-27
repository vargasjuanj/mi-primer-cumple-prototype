package com.jjvproyectosjjv.miprimercumplemongo.model.stock;

import com.jjvproyectosjjv.miprimercumplemongo.model.BaseEntity;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document (collection = "categorias")
public class ArticuloCategoria extends BaseEntity {

	private String nombre;

	@Singular
	private List<ArticuloCategoria> categoriashijas = new ArrayList<ArticuloCategoria>();

}
