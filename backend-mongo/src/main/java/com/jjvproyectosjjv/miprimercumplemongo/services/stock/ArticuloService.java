package com.jjvproyectosjjv.miprimercumplemongo.services.stock;

import com.jjvproyectosjjv.miprimercumplemongo.daos.stock.ArticuloRepository;
import com.jjvproyectosjjv.miprimercumplemongo.model.shared.Foto;
import com.jjvproyectosjjv.miprimercumplemongo.model.stock.Articulo;
import com.jjvproyectosjjv.miprimercumplemongo.services.BaseService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class ArticuloService extends BaseService<Articulo, ArticuloRepository> {

    private Foto armarFoto(MultipartFile archivo) throws IOException {
        Foto foto = new Foto();
        foto.setArchivo(archivo.getBytes());
        foto.setNombre(archivo.getOriginalFilename());
        foto.setMime(archivo.getContentType());
        return foto;
    }

    private Articulo obtenerArticulo(String id) {
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

    public Articulo updateConFoto(String id, Articulo entidadForm, MultipartFile archivo) throws Exception {
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
    public Resource verFoto(String id) throws Exception {

        try {
            Articulo entidad = obtenerArticulo(id);
            Resource imagen = new ByteArrayResource(entidad.getFoto().getArchivo());
            return imagen;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
