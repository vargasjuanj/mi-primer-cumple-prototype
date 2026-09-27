package com.jjvproyectos.miprimercumple.daos.stock;

import com.jjvproyectos.miprimercumple.model.stock.Postre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostreRepository extends JpaRepository<Postre,Long> {
}