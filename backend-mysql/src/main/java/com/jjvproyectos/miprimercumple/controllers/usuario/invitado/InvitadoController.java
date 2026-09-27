package com.jjvproyectos.miprimercumple.controllers.usuario.invitado;

import com.jjvproyectos.miprimercumple.controllers.BaseController;
import com.jjvproyectos.miprimercumple.model.persona.usuario.invitado.Invitado;
import com.jjvproyectos.miprimercumple.services.usuario.UsuarioService;
import com.jjvproyectos.miprimercumple.services.usuario.invitado.InvitadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1/invitados")
public class InvitadoController extends BaseController<Invitado, InvitadoService> {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/foto")
    @Transactional

    public ResponseEntity<?> postConFoto(Invitado entidadForm, @RequestParam MultipartFile archivo)  {

        try {

            return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.saveConFoto(entidadForm,archivo));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Error al crear la foto del invitado!\": \"" + e.getMessage() + "\"}");
        }
    }

    @PutMapping("/{id}/foto")
    @Transactional
    public ResponseEntity<?> putConFoto(@PathVariable long id,Invitado entidadForm, @RequestParam MultipartFile archivo) {
        try {

            return ResponseEntity.status(HttpStatus.OK).body(usuarioService.updateConFoto(id, entidadForm,archivo));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Error al actualizar la foto del invitado!\": \"" + e.getMessage() + "\"}");
        }
    }

    @GetMapping("/{id}/foto")
    @Transactional
    public ResponseEntity<?> verFoto(@PathVariable long id){
        try {

            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(usuarioService.verFoto(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Error al mostrar la foto del invitado!\": \"" + e.getMessage() + "\"}");
        }
    }

    @PutMapping("/{id}/baja")
    @Transactional
    public ResponseEntity<?> darDeBaja(@PathVariable long id) {
        try {

            return ResponseEntity.status(HttpStatus.OK).body(service.darDeBaja(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Error al dar de baja al invitado!\": \"" + e.getMessage() + "\"}");
        }
    }

    @PutMapping("/{id}/alta")
    @Transactional
    public ResponseEntity<?> darDeAlta(@PathVariable long id) {
        try {

            return ResponseEntity.status(HttpStatus.OK).body(service.darDeAlta(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Error al dar de alta al invitado!\": \"" + e.getMessage() + "\"}");
        }
    }
}