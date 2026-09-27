package com.jjvproyectosjjv.miprimercumplemongo.controllers.usuario;

import com.jjvproyectosjjv.miprimercumplemongo.controllers.BaseController;
import com.jjvproyectosjjv.miprimercumplemongo.model.persona.Admin;
import com.jjvproyectosjjv.miprimercumplemongo.services.usuario.AdminService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/admin")
public class AdminController extends BaseController<Admin, AdminService> {

}
