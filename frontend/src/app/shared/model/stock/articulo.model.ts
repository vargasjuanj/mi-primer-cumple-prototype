import { BaseEntity } from "../baseEntity";
import { Foto } from "../shared/foto.model";
import { ArticuloCategoria } from "./articuloCategoria.model";
import { MedidaGeneralEnum } from "./medida.enum";

export interface Articulo extends BaseEntity{
    cantidad?: number
    marca?: string
    medida?: string
    nombre?: string
    categoria: ArticuloCategoria
    foto: Foto
    descripcion?: string   
}