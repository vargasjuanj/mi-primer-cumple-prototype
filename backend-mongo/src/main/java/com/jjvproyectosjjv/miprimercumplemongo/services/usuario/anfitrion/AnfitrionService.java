package com.jjvproyectosjjv.miprimercumplemongo.services.usuario.anfitrion;

import com.jjvproyectosjjv.miprimercumplemongo.daos.usuario.anfitrion.AnfitrionRepository;
import com.jjvproyectosjjv.miprimercumplemongo.model.persona.usuario.anfitrion.Anfitrion;
import com.jjvproyectosjjv.miprimercumplemongo.model.shared.Foto;
import com.jjvproyectosjjv.miprimercumplemongo.services.BaseService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class AnfitrionService extends BaseService<Anfitrion, AnfitrionRepository> {

    private Foto armarFoto(MultipartFile archivo) throws IOException {
        Foto foto = new Foto();
        foto.setArchivo(archivo.getBytes());
        foto.setNombre(archivo.getOriginalFilename());
        foto.setMime(archivo.getContentType());
        return foto;
    }

    private Anfitrion obtenerAnfitrion(String id) {
        Optional<Anfitrion> entidadOpcional = repository.findById(id);
        Anfitrion entidad = entidadOpcional.get();
        return entidad;
    }
    public Anfitrion saveConFoto(Anfitrion entidadForm, MultipartFile archivo) throws Exception {
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

    public Anfitrion updateConFoto(String id, Anfitrion entidadForm, MultipartFile archivo) throws Exception {
        try {
            if(!archivo.isEmpty()){
                Foto foto = armarFoto(archivo);
                entidadForm.setFoto(foto);
            }
            Optional<Anfitrion> entidadOpcional = repository.findById(id);
            entidadForm.setId(entidadOpcional.get().getId());
            entidadForm = repository.save(entidadForm);
            return entidadForm;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    public Resource verFoto(String id) throws Exception {

        try {
            Anfitrion entidad = obtenerAnfitrion(id);
            Resource imagen = new ByteArrayResource(entidad.getFoto().getArchivo());
            return imagen;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
