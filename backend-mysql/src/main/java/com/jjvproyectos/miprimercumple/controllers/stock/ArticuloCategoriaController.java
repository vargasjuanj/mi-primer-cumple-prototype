package com.jjvproyectos.miprimercumple.controllers.stock;

import com.jjvproyectos.miprimercumple.controllers.BaseController;
import com.jjvproyectos.miprimercumple.model.stock.ArticuloCategoria;
import com.jjvproyectos.miprimercumple.services.stock.ArticuloCategoriaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/categorias")
public class ArticuloCategoriaController extends BaseController<ArticuloCategoria, ArticuloCategoriaService> {
}