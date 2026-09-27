package com.jjvproyectos.miprimercumple.controllers.stock;

import com.jjvproyectos.miprimercumple.controllers.BaseController;
import com.jjvproyectos.miprimercumple.model.stock.MedidaCategoria;
import com.jjvproyectos.miprimercumple.services.stock.MedidaCategoriaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/medidas")
public class MedidaCategoriaController extends BaseController<MedidaCategoria, MedidaCategoriaService> {
}