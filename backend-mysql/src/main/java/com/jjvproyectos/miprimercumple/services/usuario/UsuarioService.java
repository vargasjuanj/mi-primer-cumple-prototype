package com.jjvproyectos.miprimercumple.services.usuario;

import com.jjvproyectos.miprimercumple.daos.shared.FotoRepository;
import com.jjvproyectos.miprimercumple.daos.usuario.UsuarioRepository;
import com.jjvproyectos.miprimercumple.model.persona.usuario.Usuario;
import com.jjvproyectos.miprimercumple.model.shared.Foto;
import com.jjvproyectos.miprimercumple.services.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class UsuarioService extends BaseService<Usuario, UsuarioRepository> {
    @Autowired
    private FotoRepository fotoRepository;

    private Foto armarFoto(MultipartFile archivo) throws IOException {
        Foto foto = new Foto();
        foto.setArchivo(archivo.getBytes());
        foto.setNombre(archivo.getOriginalFilename());
        foto.setMime(archivo.getContentType());
        return foto;
    }

    private Usuario obtenerUsuario(long id) {
        Optional<Usuario> entidadOpcional = repository.findById(id);
        Usuario entidad = entidadOpcional.get();
        return entidad;
    }
    public Usuario saveConFoto(Usuario entidadForm, MultipartFile archivo) throws Exception {
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

    public Usuario updateConFoto(long id, Usuario entidadForm, MultipartFile archivo) throws Exception {
        try {
            if(!archivo.isEmpty()){
                Foto foto = armarFoto(archivo);
                entidadForm.setFoto(foto);
            }
            Optional<Usuario> entidadOpcional = repository.findById(id);
            entidadForm.setId(entidadOpcional.get().getId());
            entidadForm = repository.save(entidadForm);
            return entidadForm;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    public Resource verFoto(long id) throws Exception {

        try {
            Usuario entidad = obtenerUsuario(id);
            Resource imagen = new ByteArrayResource(entidad.getFoto().getArchivo());
            return imagen;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}