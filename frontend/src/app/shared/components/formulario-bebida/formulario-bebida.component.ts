import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Articulo } from '@shared/model/stock/articulo.model';
import { ArticuloCategoria } from '@shared/model/stock/articuloCategoria.model';
import { DatosService } from '@shared/services/datos.service';

@Component({
  selector: 'app-formulario-bebida',
  templateUrl: './formulario-bebida.component.html',
  styleUrls: ['./formulario-bebida.component.css']
})
export class FormularioBebidaComponent implements OnInit {
  
  @Input()nombreDeCategoria: any
  @Input() categoria : ArticuloCategoria | any
  @Input() articulo: Articulo | any

  @Input() marcaAuxiliar : string | any
  @Input() archivoAuxiliar: File | any

  @Input() tipoDeBebida = '';
  @Input() tipoDeAlcoholica = '';
  @Input() marcaONombreAuxiliar = '';
  
  @Output() desaparecerFormularioDelPadre = new EventEmitter<any>()
  @Output() enviarArticuloAlPadre = new EventEmitter<Articulo>()

  constructor(public servicioDeDatos: DatosService) { }

  ngOnInit(): void {
  
  }

  bloquearBoton() {
    if ( this.hayCantidadYMedida() &&  this.hayMarca()&& this.tipoDeBebida ) {
      return false;
    }
    return true;
  }

  hayCantidadYMedida(){
    return this.articulo.cantidad && this.articulo.medida
  }
  hayMarca(){
    return (this.articulo.marca && this.articulo.marca !== 'Otra') || this.marcaONombreAuxiliar
  }

  hayFoto(){
    return this.articulo.foto.archivo
  }

vaciarMarcaNombreYMarcaAuxiliar() {
  this.articulo.nombre = ''
  this.articulo.marca = ''
  this.marcaONombreAuxiliar = ''
}

desaparecerFormulario() {
  this.desaparecerFormularioDelPadre.emit()
}

  enviarArticulo() {
this.guardarCategoria()
this.articulo.foto.archivo = this.archivoAuxiliar
    if (this.marcaONombreAuxiliar) {
      this.articulo.marca = this.marcaONombreAuxiliar
    }
    this.enviarArticuloAlPadre.emit(this.articulo)
    this.desaparecerFormulario()
  }

  guardarCategoria(){

let indexDeTipoDeBebida = this.servicioDeDatos.tiposDeBebidas.indexOf(this.tipoDeBebida)

    if(this.tipoDeBebida === 'Alcohol'){
  let indexDeTipoDeAlcohol = this.servicioDeDatos.tiposDeAlcoholicas.indexOf(this.tipoDeAlcoholica)
 this.articulo.categoria = this.categoria.categoriashijas[0].categoriashijas[indexDeTipoDeAlcohol] 
 }else{

      this.articulo.categoria = this.categoria.categoriashijas[indexDeTipoDeBebida]

    }

  }

  seleccionarFoto(event: any){
    this.archivoAuxiliar = event.target.files[0]
  }

}
