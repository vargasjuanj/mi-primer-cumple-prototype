package com.jjvproyectos.miprimercumple.controllers.usuario.anfitrion;

import com.jjvproyectos.miprimercumple.controllers.BaseController;
import com.jjvproyectos.miprimercumple.model.persona.usuario.anfitrion.BirthdayKid;
import com.jjvproyectos.miprimercumple.services.usuario.anfitrion.BirthdayKidService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1/kid")
public class BirthdayKidController extends BaseController<BirthdayKid, BirthdayKidService> {

    @PostMapping("/foto")
    @Transactional
    public ResponseEntity<?> postConFoto(BirthdayKid entidadForm, @RequestParam MultipartFile archivo)  {

        try {

            return ResponseEntity.status(HttpStatus.CREATED).body(service.saveConFoto(entidadForm,archivo));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Error al crear la foto del kid!\": \"" + e.getMessage() + "\"}");
        }
    }

    @PutMapping("/{id}/foto")
    @Transactional
    public ResponseEntity<?> putConFoto(@PathVariable long id,BirthdayKid entidadForm, @RequestParam MultipartFile archivo) {
        try {

            return ResponseEntity.status(HttpStatus.OK).body(service.updateConFoto(id, entidadForm,archivo));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Error al actualizar la primer foto del kid!\": \"" + e.getMessage() + "\"}");
        }
    }

    @GetMapping("/{id}/foto")
    @Transactional
    public ResponseEntity<?> verFoto(@PathVariable long id){
        try {
            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(service.verFoto(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Error al mostrar la primer foto del kid!!\": \"" + e.getMessage() + "\"}");
        }
    }
    
    @PostMapping("/{id}/foto")
    @Transactional
    public ResponseEntity<?> agregarFoto(@PathVariable long id, @RequestParam MultipartFile archivo){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.agregarFoto(id,archivo));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Error al agregar foto al kid!\": \"" + e.getMessage() + "\"}");
        }
    }
    @PutMapping("/{id}/{fotoId}/foto")
    @Transactional
    public ResponseEntity<?> editarFoto(@PathVariable long id,@PathVariable long fotoId, @RequestParam MultipartFile archivo){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.editarFoto(id,fotoId,archivo));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Error al editar foto del kid!\": \"" + e.getMessage() + "\"}");
        }
    }
    @DeleteMapping("/{id}/{fotoId}/foto")
    @Transactional
    public ResponseEntity<?> eliminarFoto(@PathVariable long id,@PathVariable long fotoId){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.eliminarFoto(id, fotoId));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"No se encontró el recurso al eliminar una foto del kid!\": \"" + e.getMessage() + "\"}");
        }
    }
    @DeleteMapping("/{id}/fotos")
    @Transactional
    public ResponseEntity<?> eliminarFotos(@PathVariable long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.eliminarFotos(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"No se encontraron los recursos al eliminar todas las fotos del kid!\": \"" + e.getMessage() + "\"}");
        }
    }

}