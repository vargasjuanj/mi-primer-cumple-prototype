package com.jjvproyectosjjv.miprimercumplemongo.model.salon;

import com.jjvproyectosjjv.miprimercumplemongo.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Ubicacion {

	private int latitud;

	private int longitud;

}
