package com.jjvproyectos.miprimercumple.model.stock;

import com.jjvproyectos.miprimercumple.model.shared.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "categorias")
public class ArticuloCategoria extends BaseEntity {

	private String nombre;

	@OneToMany()
	@JoinColumn(name = "categoria")
	@Singular List<MedidaCategoria> medidas = new ArrayList();

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "categoriahija")
	@Singular private List<ArticuloCategoria> categoriashijas = new ArrayList<ArticuloCategoria>();

}