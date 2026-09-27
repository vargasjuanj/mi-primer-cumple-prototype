package com.jjvproyectosjjv.miprimercumplemongo.services.usuario.anfitrion;

import com.jjvproyectosjjv.miprimercumplemongo.daos.usuario.anfitrion.BirthdayKidRepository;
import com.jjvproyectosjjv.miprimercumplemongo.model.persona.usuario.anfitrion.BirthdayKid;
import com.jjvproyectosjjv.miprimercumplemongo.model.shared.Foto;
import com.jjvproyectosjjv.miprimercumplemongo.services.BaseService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class BirthdayKidService extends BaseService<BirthdayKid, BirthdayKidRepository> {

    private Foto armarFoto(MultipartFile archivo) throws IOException {
        Foto foto = new Foto();
        foto.setArchivo(archivo.getBytes());
        foto.setNombre(archivo.getOriginalFilename());
        foto.setMime(archivo.getContentType());
        return foto;
    }

    private BirthdayKid obtenerBirthdayKid(String id) {
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

    public BirthdayKid updateConFoto(String id, BirthdayKid entidadForm, MultipartFile archivo) throws Exception {
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

    public Resource verFoto(String id) throws Exception {

        try {
            BirthdayKid entidad = obtenerBirthdayKid(id);
            Resource imagen = new ByteArrayResource(entidad.getFotos().get(0).getArchivo());
            return imagen;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public BirthdayKid agregarFoto(String id, MultipartFile archivo) throws Exception {
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

    public BirthdayKid editarFoto(String id, int indexDeFoto, MultipartFile archivo) throws Exception {
        try {
            Foto foto = armarFoto(archivo);
            BirthdayKid entidad = obtenerBirthdayKid(id);

            Foto fotoDeEntidad = entidad.getFotos().get(indexDeFoto);
            fotoDeEntidad.setNombre(foto.getNombre());
            fotoDeEntidad.setMime(foto.getMime());
            fotoDeEntidad.setArchivo(foto.getArchivo());
            entidad.getFotos().remove(indexDeFoto);
            entidad.getFotos().add(indexDeFoto,fotoDeEntidad);
            entidad = repository.save(entidad);

            return entidad;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public boolean eliminarFoto(String id, int indexDeFoto) throws Exception {
        try {

            BirthdayKid entidad = obtenerBirthdayKid(id);

            entidad.getFotos().remove(indexDeFoto);

            repository.save(entidad);

            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public boolean eliminarFotos(String id) throws Exception {
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
