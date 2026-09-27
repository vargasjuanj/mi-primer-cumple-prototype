package com.jjvproyectosjjv.miprimercumplemongo.model.persona;

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
@Document(collection = "admin")
public class Admin extends BaseEntity {

	private String email;

	private String password;

	private String mensaje;

}
