package com.jjvproyectosjjv.miprimercumplemongo.model.shared;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jjvproyectosjjv.miprimercumplemongo.model.BaseEntity;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Foto {

	@JsonIgnore
	private byte[] archivo;

	private String mime;

	private String nombre;

public Integer getArchivoHashCode(){

	return (this.archivo != null)? archivo.hashCode(): null;
}

}
