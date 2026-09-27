package com.jjvproyectosjjv.miprimercumplemongo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor

public abstract class BaseEntity implements Serializable {

    @Id
    protected String id;

}
