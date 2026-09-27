package com.jjvproyectosjjv.miprimercumplemongo.services.usuario.invitado;

import com.jjvproyectosjjv.miprimercumplemongo.daos.usuario.invitado.InvitadoRepository;
import com.jjvproyectosjjv.miprimercumplemongo.model.persona.usuario.invitado.Invitado;
import com.jjvproyectosjjv.miprimercumplemongo.model.shared.Foto;
import com.jjvproyectosjjv.miprimercumplemongo.services.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.Optional;

@Service
public class InvitadoService extends BaseService<Invitado, InvitadoRepository> {

    @Autowired
    private InvitadoRepository invitadoRepository;

    private Invitado  procesarLaBajaOAlta(String id, Date date) throws Exception {
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

    public Invitado darDeBaja(String id) throws Exception {
        return procesarLaBajaOAlta(id, new Date());
    }

    public Invitado darDeAlta(String id) throws Exception {
        return procesarLaBajaOAlta(id,null);
    }

    private Foto armarFoto(MultipartFile archivo) throws IOException {
        Foto foto = new Foto();
        foto.setArchivo(archivo.getBytes());
        foto.setNombre(archivo.getOriginalFilename());
        foto.setMime(archivo.getContentType());
        return foto;
    }

    private Invitado obtenerInvitado(String id) {
        Optional<Invitado> entidadOpcional = repository.findById(id);
        Invitado entidad = entidadOpcional.get();
        return entidad;
    }
    public Invitado saveConFoto(Invitado entidadForm, MultipartFile archivo) throws Exception {
        try {
            if(!archivo.isEmpty()){
                Foto foto = armarFoto(archivo);
                entidadForm.setFoto(foto);
            }
            entidadForm = repository.save(entidadForm);
            return entidadForm;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public Invitado updateConFoto(String id, Invitado entidadForm, MultipartFile archivo) throws Exception {
        try {
            if(!archivo.isEmpty()){
                Foto foto = armarFoto(archivo);
                entidadForm.setFoto(foto);
            }
            Optional<Invitado> entidadOpcional = repository.findById(id);
            entidadForm.setId(entidadOpcional.get().getId());
            entidadForm = repository.save(entidadForm);
            return entidadForm;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    public Resource verFoto(String id) throws Exception {

        try {
            Invitado entidad = obtenerInvitado(id);
            Resource imagen = new ByteArrayResource(entidad.getFoto().getArchivo());
            return imagen;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

  public Invitado buscarPorNombreYSegundoNombre(String nombre,String segundoNombre) throws Exception {

        try {
            return  invitadoRepository.findByNombreAndSegundoNombre(nombre,segundoNombre);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public Invitado buscarPorNombreYApellido(String nombre,String apellido) throws Exception {

        try {
            return  invitadoRepository.findByNombreAndApellido(nombre,apellido);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
