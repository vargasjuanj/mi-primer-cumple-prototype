package com.jjvproyectosjjv.miprimercumplemongo.controllers.salon;

import com.jjvproyectosjjv.miprimercumplemongo.controllers.BaseController;
import com.jjvproyectosjjv.miprimercumplemongo.model.salon.Salon;
import com.jjvproyectosjjv.miprimercumplemongo.services.salon.SalonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1/salon")
public class SalonController extends BaseController<Salon, SalonService> {

    @PostMapping("/foto")
    @Transactional
    public ResponseEntity<?> postConFoto(Salon entidadForm, @RequestParam MultipartFile archivo)  {

        try {

            return ResponseEntity.status(HttpStatus.CREATED).body(service.saveConFoto(entidadForm,archivo));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Error al crear la foto del salón!\": \"" + e.getMessage() + "\"}");
        }
    }

    @PutMapping("/{id}/foto")
    @Transactional
    public ResponseEntity<?> putConFoto(@PathVariable String id,Salon entidadForm, @RequestParam MultipartFile archivo) {
        try {

            return ResponseEntity.status(HttpStatus.OK).body(service.updateConFoto(id, entidadForm,archivo));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Error al actualizar la primer foto del salón!\": \"" + e.getMessage() + "\"}");
        }
    }

    @GetMapping("/{id}/foto")
    @Transactional
    public ResponseEntity<?> verFoto(@PathVariable String id){
        try {
            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(service.verFoto(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Error al mostrar la primer foto del salón!!\": \"" + e.getMessage() + "\"}");
        }
    }

    @PostMapping("/{id}/foto")
    @Transactional
    public ResponseEntity<?> agregarFoto(@PathVariable String id, @RequestParam MultipartFile archivo){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.agregarFoto(id,archivo));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Error al agregar foto al salon!\": \"" + e.getMessage() + "\"}");
        }
    }

    @PutMapping("/{id}/{indexDeFoto}/foto")
    @Transactional
    public ResponseEntity<?> editarFoto(@PathVariable String id,@PathVariable int indexDeFoto, @RequestParam MultipartFile archivo){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.editarFoto(id,indexDeFoto,archivo));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Error al editar foto del salon!\": \"" + e.getMessage() + "\"}");
        }
    }

    @DeleteMapping("/{id}/{indexDeFoto}/foto")
    @Transactional
    public ResponseEntity<?> eliminarFoto(@PathVariable String id,@PathVariable int indexDeFoto){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.eliminarFoto(id, indexDeFoto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"No se encontró el recurso al eliminar una foto del salón!\": \"" + e.getMessage() + "\"}");
        }
    }

    @DeleteMapping("/{id}/fotos")
    @Transactional
    public ResponseEntity<?> eliminarFotos(@PathVariable String id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.eliminarFotos(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"No se encontraron los recursos al eliminar todas las fotos del salón!\": \"" + e.getMessage() + "\"}");
        }
    }

}
