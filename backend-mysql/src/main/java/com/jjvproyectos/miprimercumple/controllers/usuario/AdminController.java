package com.jjvproyectos.miprimercumple.controllers.usuario;

import com.jjvproyectos.miprimercumple.controllers.BaseController;
import com.jjvproyectos.miprimercumple.model.persona.Admin;
import com.jjvproyectos.miprimercumple.services.usuario.AdminService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/admin")
public class AdminController extends BaseController<Admin, AdminService> {

}