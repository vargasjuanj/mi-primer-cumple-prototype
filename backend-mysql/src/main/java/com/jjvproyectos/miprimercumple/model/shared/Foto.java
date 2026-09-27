package com.jjvproyectos.miprimercumple.model.shared;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity (name = "fotos")
public class Foto extends BaseEntity {

	@Lob
	@JsonIgnore
	private byte[] archivo;

	private String mime;

	private String nombre;

public Integer getArchivoHashCode(){
	return (this.archivo != null)? archivo.hashCode(): null;
}

}