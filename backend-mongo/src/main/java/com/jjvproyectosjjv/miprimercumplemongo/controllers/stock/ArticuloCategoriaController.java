package com.jjvproyectosjjv.miprimercumplemongo.controllers.stock;

import com.jjvproyectosjjv.miprimercumplemongo.controllers.BaseController;
import com.jjvproyectosjjv.miprimercumplemongo.model.stock.ArticuloCategoria;
import com.jjvproyectosjjv.miprimercumplemongo.services.stock.ArticuloCategoriaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/categorias")
public class ArticuloCategoriaController extends BaseController<ArticuloCategoria, ArticuloCategoriaService> {
}
