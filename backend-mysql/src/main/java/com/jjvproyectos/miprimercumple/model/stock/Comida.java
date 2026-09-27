package com.jjvproyectos.miprimercumple.model.stock;

import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@NoArgsConstructor
@Entity(name = "comidas")
@DiscriminatorValue("COMIDA")
public class Comida extends Articulo {

}