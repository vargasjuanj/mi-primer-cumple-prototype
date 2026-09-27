package com.jjvproyectos.miprimercumple.model.stock;

import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@NoArgsConstructor
@Entity(name = "postres")
@DiscriminatorValue("POSTRE")
public class Postre extends Articulo {

}