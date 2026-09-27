package com.jjvproyectos.miprimercumple.services.stock;

import com.jjvproyectos.miprimercumple.daos.shared.FotoRepository;
import com.jjvproyectos.miprimercumple.daos.stock.ArticuloRepository;
import com.jjvproyectos.miprimercumple.model.shared.Foto;
import com.jjvproyectos.miprimercumple.model.stock.Articulo;
import com.jjvproyectos.miprimercumple.services.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class ArticuloService extends BaseService<Articulo, ArticuloRepository> {
    @Autowired
    private FotoRepository fotoRepository;

    private Foto armarFoto(MultipartFile archivo) throws IOException {
        Foto foto = new Foto();
        foto.setArchivo(archivo.getBytes());
        foto.setNombre(archivo.getOriginalFilename());
        foto.setMime(archivo.getContentType());
        return foto;
    }

    private Articulo obtenerArticulo(long id) {
        Optional<Articulo> entidadOpcional = repository.findById(id);
        Articulo entidad = entidadOpcional.get();
        return entidad;
    }
    public Articulo saveConFoto(Articulo entidadForm, MultipartFile archivo) throws Exception {
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

    public Articulo updateConFoto(long id, Articulo entidadForm, MultipartFile archivo) throws Exception {
        try {
            if(!archivo.isEmpty()){
                Foto foto = armarFoto(archivo);
                entidadForm.setFoto(foto);
            }
            Optional<Articulo> entidadOpcional = repository.findById(id);
            entidadForm.setId(entidadOpcional.get().getId());
            entidadForm = repository.save(entidadForm);
            return entidadForm;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    public Resource verFoto(long id) throws Exception {

        try {
            Articulo entidad = obtenerArticulo(id);
            Resource imagen = new ByteArrayResource(entidad.getFoto().getArchivo());
            return imagen;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
}