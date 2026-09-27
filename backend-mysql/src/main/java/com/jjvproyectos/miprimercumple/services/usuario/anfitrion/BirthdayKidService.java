package com.jjvproyectos.miprimercumple.services.usuario.anfitrion;

import com.jjvproyectos.miprimercumple.daos.shared.FotoRepository;
import com.jjvproyectos.miprimercumple.daos.usuario.anfitrion.BirthdayKidRepository;
import com.jjvproyectos.miprimercumple.model.persona.usuario.anfitrion.BirthdayKid;
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
public class BirthdayKidService extends BaseService<BirthdayKid, BirthdayKidRepository> {

    @Autowired
    private FotoRepository fotoRepository;

    private Foto armarFoto(MultipartFile archivo) throws IOException {
        Foto foto = new Foto();
        foto.setArchivo(archivo.getBytes());
        foto.setNombre(archivo.getOriginalFilename());
        foto.setMime(archivo.getContentType());
        return foto;
    }

    private int obtenerIndexDeFoto(long fotoId, BirthdayKid entidadForm) {
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

    private BirthdayKid obtenerBirthdayKid(long id) {
        Optional<BirthdayKid> entidadOpcional = repository.findById(id);
        BirthdayKid entidad = entidadOpcional.get();
        return entidad;
    }

    public BirthdayKid saveConFoto(BirthdayKid entidadForm, MultipartFile archivo) throws Exception {
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

    public BirthdayKid updateConFoto(long id, BirthdayKid entidadForm, MultipartFile archivo) throws Exception {
        try {
            if (!archivo.isEmpty()) {
                Foto foto = armarFoto(archivo);
                entidadForm.getFotos().add(foto);
            }
            Optional<BirthdayKid> entidadOpcional = repository.findById(id);
            entidadForm.setId(entidadOpcional.get().getId());
            entidadForm = repository.save(entidadForm);
            return entidadForm;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public Resource verFoto(long id) throws Exception {

        try {
            BirthdayKid entidad = obtenerBirthdayKid(id);
            Resource imagen = new ByteArrayResource(entidad.getFotos().get(0).getArchivo());
            return imagen;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<Resource> verFotos(long id) throws Exception {

        try {

            BirthdayKid entidad = obtenerBirthdayKid(id);
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

    public BirthdayKid agregarFoto(long id, MultipartFile archivo) throws Exception {
        try {
            Foto foto = armarFoto(archivo);

            BirthdayKid entidad = obtenerBirthdayKid(id);
            entidad.getFotos().add(foto);
            entidad = repository.save(entidad);
            return entidad;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public BirthdayKid editarFoto(long id, long fotoId, MultipartFile archivo) throws Exception {
        try {
            Foto foto = armarFoto(archivo);
            BirthdayKid entidad = obtenerBirthdayKid(id);

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

            BirthdayKid entidad = obtenerBirthdayKid(id);

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

            BirthdayKid entidad = obtenerBirthdayKid(id);
            entidad.setFotos(null);
            repository.save(entidad);
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}