package com.jjvproyectos.miprimercumple.model.stock;

import com.jjvproyectos.miprimercumple.model.shared.BaseEntity;
import com.jjvproyectos.miprimercumple.model.shared.Foto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity (name = "articulos")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="tipo_de_articulo")
public class Articulo extends BaseEntity {

	protected float cantidad;

	protected String marca;

	protected String nombre;

	@OneToOne()
	protected ArticuloCategoria categoria;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	protected Foto foto;

}