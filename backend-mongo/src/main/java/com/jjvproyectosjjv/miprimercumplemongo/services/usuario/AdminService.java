package com.jjvproyectosjjv.miprimercumplemongo.services.usuario;

import com.jjvproyectosjjv.miprimercumplemongo.daos.usuario.AdminRepository;
import com.jjvproyectosjjv.miprimercumplemongo.model.persona.Admin;
import com.jjvproyectosjjv.miprimercumplemongo.services.BaseService;
import org.springframework.stereotype.Service;

@Service
public class AdminService extends BaseService<Admin, AdminRepository> {
}
