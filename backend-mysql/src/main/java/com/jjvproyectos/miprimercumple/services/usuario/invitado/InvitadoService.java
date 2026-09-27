package com.jjvproyectos.miprimercumple.services.usuario.invitado;

import com.jjvproyectos.miprimercumple.daos.usuario.invitado.InvitadoRepository;
import com.jjvproyectos.miprimercumple.model.persona.usuario.invitado.Invitado;
import com.jjvproyectos.miprimercumple.services.BaseService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class InvitadoService extends BaseService<Invitado, InvitadoRepository> {

    private Invitado  procesarLaBajaOAlta(long id, Date date) throws Exception {
        try {
            Optional<Invitado> entidadOpcional = repository.findById(id);
            Invitado entidad = entidadOpcional.get();
            entidad.setFechaDeBaja(date);
            entidad = repository.save(entidad);
            return entidad;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }

    public Invitado darDeBaja(long id) throws Exception {
        return procesarLaBajaOAlta(id, new Date());
    }

    public Invitado darDeAlta(long id) throws Exception {
        return procesarLaBajaOAlta(id,null);
    }

}