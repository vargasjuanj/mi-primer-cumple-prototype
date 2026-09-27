package com.jjvproyectos.miprimercumple.controllers.stock;

import com.jjvproyectos.miprimercumple.controllers.BaseController;
import com.jjvproyectos.miprimercumple.model.stock.Articulo;
import com.jjvproyectos.miprimercumple.services.stock.ArticuloService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1/articulos")
public class ArticuloController extends BaseController<Articulo, ArticuloService> {

    @PostMapping("/foto")
    @Transactional

    public ResponseEntity<?> postConFoto(Articulo entidadForm, @RequestParam MultipartFile archivo)  {

        try {

            return ResponseEntity.status(HttpStatus.CREATED).body(service.saveConFoto(entidadForm,archivo));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Error al crear la foto del articulo!\": \"" + e.getMessage() + "\"}");
        }
    }

    @PutMapping("/{id}/foto")
    @Transactional
    public ResponseEntity<?> putConFoto(@PathVariable long id,Articulo entidadForm, @RequestParam MultipartFile archivo) {
        try {

            return ResponseEntity.status(HttpStatus.OK).body(service.updateConFoto(id, entidadForm,archivo));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Error al actualizar la foto del articulo!\": \"" + e.getMessage() + "\"}");
        }
    }

    @GetMapping("/{id}/foto")
    @Transactional
    public ResponseEntity<?> verFoto(@PathVariable long id){
        try {

            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(service.verFoto(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Error al mostrar la foto del articulo!\": \"" + e.getMessage() + "\"}");
        }
    }
  
}
