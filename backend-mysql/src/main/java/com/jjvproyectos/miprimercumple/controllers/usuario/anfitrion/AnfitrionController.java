package com.jjvproyectos.miprimercumple.controllers.usuario.anfitrion;

import com.jjvproyectos.miprimercumple.controllers.BaseController;
import com.jjvproyectos.miprimercumple.model.persona.usuario.anfitrion.Anfitrion;
import com.jjvproyectos.miprimercumple.services.usuario.UsuarioService;
import com.jjvproyectos.miprimercumple.services.usuario.anfitrion.AnfitrionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1/anfitrion")
public class AnfitrionController extends BaseController<Anfitrion, AnfitrionService> {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/foto")
    @Transactional

    public ResponseEntity<?> postConFoto(Anfitrion entidadForm, @RequestParam MultipartFile archivo)  {

        try {

            return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.saveConFoto(entidadForm,archivo));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Error al crear la foto de anfitrion!\": \"" + e.getMessage() + "\"}");
        }
    }

    @PutMapping("/{id}/foto")
    @Transactional
    public ResponseEntity<?> putConFoto(@PathVariable long id,Anfitrion entidadForm, @RequestParam MultipartFile archivo) {
        try {

            return ResponseEntity.status(HttpStatus.OK).body(usuarioService.updateConFoto(id, entidadForm,archivo));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Error al actualizar la foto de anfitrion!\": \"" + e.getMessage() + "\"}");
        }
    }

    @GetMapping("/{id}/foto")
    @Transactional
    public ResponseEntity<?> verFoto(@PathVariable long id){
        try {

            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(usuarioService.verFoto(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Error al mostrar la foto de anfitrion!\": \"" + e.getMessage() + "\"}");
        }
    }
}