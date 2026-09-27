package com.jjvproyectos.miprimercumple.model.stock;

import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@NoArgsConstructor
@Entity(name = "golosinas")
@DiscriminatorValue("GOLOSINA")
public class Golosina extends Articulo {

}