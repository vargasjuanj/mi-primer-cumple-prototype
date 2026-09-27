package com.jjvproyectos.miprimercumple.daos.shared;

import com.jjvproyectos.miprimercumple.model.shared.Foto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FotoRepository extends JpaRepository<Foto,Long> {
}