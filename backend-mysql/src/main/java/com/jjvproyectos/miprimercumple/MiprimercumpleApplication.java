package com.jjvproyectos.miprimercumple;

import com.jjvproyectos.miprimercumple.daos.stock.ArticuloCategoriaRepository;
import com.jjvproyectos.miprimercumple.daos.usuario.invitado.InvitadoRepository;
import com.jjvproyectos.miprimercumple.model.persona.usuario.invitado.Invitado;
import com.jjvproyectos.miprimercumple.model.stock.ArticuloCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MiprimercumpleApplication implements CommandLineRunner {

	@Autowired
	private InvitadoRepository invitadoRepository;

	public static void main(String[] args) {
		SpringApplication.run(MiprimercumpleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		cargarInvitados();

	}

	public void cargarCategorias() throws Exception {

		List<ArticuloCategoria> categorias= new ArrayList<>();

	}

	private void cargarInvitados() throws Exception {
		if(invitadoRepository.count() != 0){
			return;
		}
		Invitado invitado = new Invitado();
		invitado.setNombre("Juan");
		invitadoRepository.save(invitado);
	}
}