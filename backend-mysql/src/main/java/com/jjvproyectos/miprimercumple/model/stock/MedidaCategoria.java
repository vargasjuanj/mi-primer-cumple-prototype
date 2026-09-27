package com.jjvproyectos.miprimercumple.model.stock;

import com.jjvproyectos.miprimercumple.model.enumeraciones.Simbolo;
import com.jjvproyectos.miprimercumple.model.shared.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "medidas")
public class MedidaCategoria extends BaseEntity {

    private float cantidad;

    private Simbolo simbolo;
}