package com.jjvproyectos.miprimercumple.daos.stock;

import com.jjvproyectos.miprimercumple.model.stock.Bebida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BebidaRepository extends JpaRepository<Bebida,Long> {
}