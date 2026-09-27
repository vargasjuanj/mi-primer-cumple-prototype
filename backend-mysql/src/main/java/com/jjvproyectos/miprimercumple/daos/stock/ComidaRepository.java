package com.jjvproyectos.miprimercumple.daos.stock;

import com.jjvproyectos.miprimercumple.model.stock.Comida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComidaRepository extends JpaRepository<Comida,Long> {
}