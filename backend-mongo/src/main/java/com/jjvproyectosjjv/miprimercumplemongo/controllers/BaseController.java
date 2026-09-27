package com.jjvproyectosjjv.miprimercumplemongo.controllers;

import com.jjvproyectosjjv.miprimercumplemongo.services.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin(origins = "*", methods = { RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST,
		RequestMethod.PUT })
public class BaseController<Entidad, Servicio extends IBaseService<Entidad>> {
	@Autowired
	protected Servicio service;

	@GetMapping("")
	@Transactional

	public ResponseEntity<?> getAll(@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "size", defaultValue = "10") int size) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.findAll(page, size));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("{\"Error al obtener con getAll!\": \"" + e.getMessage() + "\"}");
		}
	}

	@GetMapping("/{id}")

	@Transactional
	public ResponseEntity getOne(@PathVariable String id) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Error al buscar por id!\": \"" + e.getMessage() + "\"}");
		}
	}

	@PostMapping("")
	@Transactional
	public ResponseEntity<?> post(@RequestBody Entidad entidadForm) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(service.save(entidadForm));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Error al crear!\": \"" + e.getMessage() + "\"}");
		}
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<?> put(@PathVariable String id, @RequestBody Entidad entidadForm) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.update(id, entidadForm));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Error al actualizar!\": \"" + e.getMessage() + "\"}");
		}
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> delete(@PathVariable String id) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.delete(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("{\"No se encontró el recurso a eliminar!\": \"" + e.getMessage() + "\"}");
		}

	}

	@GetMapping("/cantidad-de-paginas")
	@Transactional
	public ResponseEntity<?> getCount(@RequestParam(value = "size", defaultValue = "10") int size) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body("{\"paginas\": " + service.countPages(size) + "}");
		} catch (Exception e) {
			return null;
		}

	}
	@GetMapping("/cantidad-de-objetos")
	@Transactional
	public ResponseEntity<?> getTotal() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body("{\"objetos\": " + service.contarObjetos() + "}");
		} catch (Exception e) {
			return null;
		}

	}
}
