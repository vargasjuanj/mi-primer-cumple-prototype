package com.jjvproyectos.miprimercumple.daos.usuario;

import com.jjvproyectos.miprimercumple.model.persona.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,Long> {
}