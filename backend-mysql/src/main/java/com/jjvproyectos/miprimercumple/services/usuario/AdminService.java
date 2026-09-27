package com.jjvproyectos.miprimercumple.services.usuario;

import com.jjvproyectos.miprimercumple.daos.usuario.AdminRepository;
import com.jjvproyectos.miprimercumple.model.persona.Admin;
import com.jjvproyectos.miprimercumple.services.BaseService;
import org.springframework.stereotype.Service;

@Service
public class AdminService extends BaseService<Admin, AdminRepository> {
}