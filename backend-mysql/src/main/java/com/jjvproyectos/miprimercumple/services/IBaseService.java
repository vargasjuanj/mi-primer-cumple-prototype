package com.jjvproyectos.miprimercumple.services;

import java.util.List;

public interface IBaseService <Entidad> {
	
	public Entidad findById(long id) throws Exception;
	
	public Entidad save(Entidad entidadForm) throws Exception;
	
	public Entidad update(long id, Entidad entidadForm) throws Exception;
	
	public int countPages(int size) throws Exception;
	
	public List<Entidad> findAll(int page, int size) throws Exception;
	
	public boolean delete(long id) throws Exception;

	public long contarObjetos() throws Exception;
}
