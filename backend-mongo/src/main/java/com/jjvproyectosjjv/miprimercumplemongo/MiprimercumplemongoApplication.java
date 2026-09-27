package com.jjvproyectosjjv.miprimercumplemongo;

import com.jjvproyectosjjv.miprimercumplemongo.model.persona.usuario.invitado.Invitado;
import com.jjvproyectosjjv.miprimercumplemongo.services.usuario.invitado.InvitadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MiprimercumplemongoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MiprimercumplemongoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
