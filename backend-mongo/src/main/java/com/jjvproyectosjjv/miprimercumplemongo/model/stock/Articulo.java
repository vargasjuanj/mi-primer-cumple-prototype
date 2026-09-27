package com.jjvproyectosjjv.miprimercumplemongo.model.stock;

import com.jjvproyectosjjv.miprimercumplemongo.model.BaseEntity;
import com.jjvproyectosjjv.miprimercumplemongo.model.shared.Foto;
import lombok.AllArgsConstructor;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "articulos")

public class Articulo extends BaseEntity {

	private float cantidad;

	private String marca;

	private String nombre;

	@DBRef
	private ArticuloCategoria categoria;

	private Foto foto;

	private String medida;

	private String descripcion;

}
