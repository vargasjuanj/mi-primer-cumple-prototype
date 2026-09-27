package com.jjvproyectos.miprimercumple.daos.usuario.invitado;

import com.jjvproyectos.miprimercumple.model.persona.usuario.invitado.Invitado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvitadoRepository extends JpaRepository<Invitado,Long> {
}