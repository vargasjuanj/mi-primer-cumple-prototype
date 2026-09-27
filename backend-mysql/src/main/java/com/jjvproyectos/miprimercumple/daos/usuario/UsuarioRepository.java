package com.jjvproyectos.miprimercumple.daos.usuario;

import com.jjvproyectos.miprimercumple.model.persona.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}