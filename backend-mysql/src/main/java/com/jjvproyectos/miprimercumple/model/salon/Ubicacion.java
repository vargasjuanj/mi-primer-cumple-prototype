package com.jjvproyectos.miprimercumple.model.salon;

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
@Entity
public class Ubicacion extends BaseEntity {

	private int latitud;

	private int longitud;

}