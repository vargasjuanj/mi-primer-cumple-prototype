package com.jjvproyectos.miprimercumple.model.stock;

import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@NoArgsConstructor
@Entity(name = "bebidas")
@DiscriminatorValue("BEBIDA")
public class Bebida extends Articulo {

}