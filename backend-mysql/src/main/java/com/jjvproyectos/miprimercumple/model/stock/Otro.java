package com.jjvproyectos.miprimercumple.model.stock;

import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@NoArgsConstructor
@Entity(name = "otros")
@DiscriminatorValue("OTRO")
public class Otro extends Articulo {

}