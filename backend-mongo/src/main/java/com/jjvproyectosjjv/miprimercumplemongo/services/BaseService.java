package com.jjvproyectosjjv.miprimercumplemongo.services;

import java.util.List;
import java.util.Optional;

import com.jjvproyectosjjv.miprimercumplemongo.model.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public abstract class BaseService<Entidad extends BaseEntity, Repositorio extends MongoRepository<Entidad, String>> implements IBaseService<Entidad> {

	@Autowired
	protected Repositorio repository;

	@Override
	public List<Entidad> findAll(int page, int size) throws Exception {
		if(page == 0 && size == 0) return repository.findAll();

		try {

			Pageable pageable = PageRequest.of(page, size);
			return repository.findAll(pageable).getContent();

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

	}
	@Override
	public Entidad findById(String id) throws Exception {
		try {

			Optional<Entidad> entidadOpcional = repository.findById(id);
			Entidad entidad = entidadOpcional.get();
			return entidad;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public Entidad save(Entidad entidadForm) throws Exception {
		try {
			entidadForm = repository.save(entidadForm);
			return entidadForm;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public Entidad update(String id, Entidad entidadForm) throws Exception {
		try {
			Optional<Entidad> entidadOpcional = repository.findById(id);
			entidadForm.setId(entidadOpcional.get().getId());
			entidadForm = repository.save(entidadForm);
			return entidadForm;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public boolean delete(String id) throws Exception{
		try {
		Optional<Entidad> entidadOpcional = repository.findById(id);
			Entidad entidad = entidadOpcional.get();

			repository.delete(entidad);
		} catch (Exception e) {

			throw new Exception(e.getMessage());
		}
		return true;
	}

	@Override
	public int countPages(int size) throws Exception {

		try {
			Pageable pageable = PageRequest.of(0, size);
			return repository.findAll(pageable).getTotalPages();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public long contarObjetos() throws Exception {

		try {
			return repository.count();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
