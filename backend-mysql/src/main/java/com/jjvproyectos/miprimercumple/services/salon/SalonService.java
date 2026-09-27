package com.jjvproyectos.miprimercumple.services.salon;

import com.jjvproyectos.miprimercumple.daos.salon.SalonRepository;
import com.jjvproyectos.miprimercumple.daos.shared.FotoRepository;
import com.jjvproyectos.miprimercumple.model.salon.Salon;
import com.jjvproyectos.miprimercumple.model.shared.Foto;
import com.jjvproyectos.miprimercumple.services.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SalonService extends BaseService<Salon, SalonRepository> {

    @Autowired
    private FotoRepository fotoRepository;

    private Foto armarFoto(MultipartFile archivo) throws IOException {
        Foto foto = new Foto();
        foto.setArchivo(archivo.getBytes());
        foto.setNombre(archivo.getOriginalFilename());
        foto.setMime(archivo.getContentType());
        return foto;
    }

    private int obtenerIndexDeFoto(long fotoId, Salon entidadForm) {
        Optional<Foto> entidadOpcionalFoto = fotoRepository.findById(fotoId);
        Foto entidadFoto = entidadOpcionalFoto.get();
        int index = entidadForm.getFotos().indexOf(entidadFoto);
        return index;
    }

    private Foto obtenerFoto(long fotoId) {
        Optional<Foto> entidadOpcionalFoto = fotoRepository.findById(fotoId);
        Foto foto = entidadOpcionalFoto.get();
        return foto;
    }

    private Salon obtenerSalon(long id) {
        Optional<Salon> entidadOpcional = repository.findById(id);
        Salon entidad = entidadOpcional.get();
        return entidad;
    }

    public Salon saveConFoto(Salon entidadForm, MultipartFile archivo) throws Exception {
        try {
            if (!archivo.isEmpty()) {
                Foto foto = armarFoto(archivo);
                entidadForm.getFotos().add(foto);
            }
            entidadForm = repository.save(entidadForm);
            return entidadForm;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public Salon updateConFoto(long id, Salon entidadForm, MultipartFile archivo) throws Exception {
        try {
            if (!archivo.isEmpty()) {
                Foto foto = armarFoto(archivo);
                entidadForm.getFotos().add(foto);
            }
            Optional<Salon> entidadOpcional = repository.findById(id);
            entidadForm.setId(entidadOpcional.get().getId());
            entidadForm = repository.save(entidadForm);
            return entidadForm;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public Resource verFoto(long id) throws Exception {

        try {
            Salon entidad = obtenerSalon(id);
            Resource imagen = new ByteArrayResource(entidad.getFotos().get(0).getArchivo());
            return imagen;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<Resource> verFotos(long id) throws Exception {

        try {

            Salon entidad = obtenerSalon(id);
            List<Resource> imagenes = new ArrayList();

            for (Foto foto : entidad.getFotos()) {
                Resource imagen = new ByteArrayResource(foto.getArchivo());
                imagenes.add(imagen);
            }
            return imagenes;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public Salon agregarFoto(long id, MultipartFile archivo) throws Exception {
        try {
            Foto foto = armarFoto(archivo);

            Salon entidad = obtenerSalon(id);
            entidad.getFotos().add(foto);
            entidad = repository.save(entidad);
            return entidad;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public Salon editarFoto(long id, long fotoId, MultipartFile archivo) throws Exception {
        try {
            Foto foto = armarFoto(archivo);
            Salon entidad = obtenerSalon(id);

            Foto fotoEntidad = obtenerFoto(fotoId);
            fotoEntidad.setNombre(foto.getNombre());
            fotoEntidad.setMime(foto.getMime());
            fotoEntidad.setArchivo(foto.getArchivo());
            fotoRepository.save(fotoEntidad);

            return entidad;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public boolean eliminarFoto(long id, long fotoId) throws Exception {
        try {

            Salon entidad = obtenerSalon(id);

            int index = obtenerIndexDeFoto(fotoId, entidad);
            entidad.getFotos().remove(index);

            repository.save(entidad);

            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public boolean eliminarFotos(long id) throws Exception {
        try {

            Salon entidad = obtenerSalon(id);
            entidad.setFotos(null);
            repository.save(entidad);
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}