package com.jjvproyectosjjv.miprimercumplemongo.controllers.usuario.invitado;

import com.jjvproyectosjjv.miprimercumplemongo.controllers.BaseController;
import com.jjvproyectosjjv.miprimercumplemongo.model.persona.usuario.invitado.Invitado;
import com.jjvproyectosjjv.miprimercumplemongo.services.usuario.invitado.InvitadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@RestController
@RequestMapping("api/v1/invitados")
public class InvitadoController extends BaseController<Invitado, InvitadoService> {

    @Autowired
    private InvitadoService invitadoService;

    @PostMapping("/foto")
    @Transactional

    public ResponseEntity<?> postConFoto(Invitado entidadForm, @RequestParam MultipartFile archivo)  {

        try {

            return ResponseEntity.status(HttpStatus.CREATED).body(invitadoService.saveConFoto(entidadForm,archivo));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Error al crear la foto del invitado!\": \"" + e.getMessage() + "\"}");
        }
    }

    @PutMapping("/{id}/foto")
    @Transactional
    public ResponseEntity<?> putConFoto(@PathVariable String id,Invitado entidadForm, @RequestParam MultipartFile archivo) {
        try {

            return ResponseEntity.status(HttpStatus.OK).body(invitadoService.updateConFoto(id, entidadForm,archivo));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Error al actualizar la foto del invitado!\": \"" + e.getMessage() + "\"}");
        }
    }

    @GetMapping("/{id}/foto")
    @Transactional
    public ResponseEntity<?> verFoto(@PathVariable String id){
        try {

            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(invitadoService.verFoto(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Error al mostrar la foto del invitado!\": \"" + e.getMessage() + "\"}");
        }
    }

    @PutMapping("/{id}/baja")
    @Transactional
    public ResponseEntity<?> darDeBaja(@PathVariable String id) {
        try {

            return ResponseEntity.status(HttpStatus.OK).body(service.darDeBaja(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Error al dar de baja al invitado!\": \"" + e.getMessage() + "\"}");
        }
    }

    @PutMapping("/{id}/alta")
    @Transactional
    public ResponseEntity<?> darDeAlta(@PathVariable String id) {
        try {

            return ResponseEntity.status(HttpStatus.OK).body(service.darDeAlta(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Error al dar de alta al invitado!\": \"" + e.getMessage() + "\"}");
        }
    }

	@GetMapping("/por-nombres")
	@Transactional
	public ResponseEntity<?> buscarPorNombreYSegundoNombre(@RequestParam(value = "nombre", defaultValue = "") String nombre, @RequestParam(value = "segundoNombre", defaultValue = "") String segundoNombre) {
		try {
			 return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorNombreYSegundoNombre(nombre,segundoNombre));
		} catch (Exception e) {
	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"No se encuentra el invitado con esos nombres!\": \"" + e.getMessage() + "\"}");

		}

	}

    @GetMapping("/por-nombre-apellido")
    @Transactional
    public ResponseEntity<?> buscarPorNombreYApellido(@RequestParam(value = "nombre", defaultValue = "") String nombre, @RequestParam(value = "apellido", defaultValue = "") String apellido
                                                                     ) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorNombreYApellido(nombre,apellido));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"No se encuentra el invitado con ese nombre y/o apellido!\": \"" + e.getMessage() + "\"}");

        }

    }
}
