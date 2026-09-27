package com.jjvproyectos.miprimercumple.daos.stock;

import com.jjvproyectos.miprimercumple.model.stock.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticuloRepository extends JpaRepository<Articulo,Long> {
}