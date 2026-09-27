import { Component, ElementRef, OnInit, Renderer2, ViewChild } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Invitado } from '@shared/model/persona/usuario/invitado/invitado.model';
import { Articulo } from '@shared/model/stock/articulo.model';
import { ArticuloCategoria } from '@shared/model/stock/articuloCategoria.model';
import { ArticuloService } from '@shared/services/articulo.service';
import { CategoriaService } from '@shared/services/categoria.service';
import { DatosService } from '@shared/services/datos.service';
import { InvitadoService } from '@shared/services/invitado.service';

@Component({
  selector: 'app-principal',
  templateUrl: './principal.component.html',
  styleUrls: ['./principal.component.css']
})
export class PrincipalComponent implements OnInit {

  textoBoton = 'Quiero Colaborar'
  icono = 'volunteer_activism'

  @ViewChild('contenedor') contenedorPrincipal: ElementRef | any

  @ViewChild('botonColaborar') referenciaBotonColaborar: ElementRef | any
  @ViewChild('textoBotonColaborar') referenciaTextoBotonColaborar: ElementRef | any

  @ViewChild('colaboracion') colaboracion: ElementRef | any

  nombreDeCategoria = ''
  categoria: ArticuloCategoria | any
  marcaAuxiliar = ''
  nombreAuxiliar = ''
  archivoAuxiliar: File | any

  articulo: Articulo = {
    nombre: '', foto: {}, categoria: {}
  }
  articulos: Articulo[] = []

  tipoDeBebida = '';
  tipoDeAlcoholica = '';
  marcaONombreAuxiliar = '';

  elevarBoton = true;
  verFormulario = false;

  categorias: ArticuloCategoria[] | any

  bloquearBotonDeMensaje = false

  invitado: Invitado = { articulos: [], nombre: '', apellido: '' }

  textoBotonMensaje = ''

  copiaDelMensaje = ''

  constructor(private rendered: Renderer2, public servicioDeDatos: DatosService,
    private servicioDeArticulo: ArticuloService,
    private servicioDeCategoria: CategoriaService,
    private snackBar: MatSnackBar,
    private servicioDeInvitado: InvitadoService
  ) { }

  ngOnInit(): void {
    this.articulo.categoria = { nombre: "General" }
    this.scrollearAlInicio()

    this.cargarCategorias()

    this.obtenerInvitado()

  }

  cargarArticulos() {

    let id = this.servicioDeInvitado.recuperarIdDelLocalStorage()

    this.servicioDeInvitado.getOne(id!).subscribe(invitado => {
      this.articulos = invitado.articulos
      console.log('Articulos del invitado', this.articulos)
    })
  }
  guardarCategoria() {
    let indexDeCategoria = this.servicioDeDatos.categorias.indexOf(this.nombreDeCategoria)
    this.categoria = this.categorias[indexDeCategoria]

  }
  cargarCategorias() {
    this.servicioDeCategoria.getAll(0, 10).subscribe(categorias => {
      this.categorias = categorias
      this.cargarArticulos()
    },
      err => console.error('Error al obtener las categorias', err)

    )

  }

  aparecerFormulario() {
    this.elevarBoton = false;
    if (this.textoBoton === 'Quiero Colaborar') {
      this.mostrarBotonCancelar()
      this.vaciarVariables()

    } else {

      this.mostrarBotonColaborar()

    }

  }

  mostrarBotonCancelar() {
    this.textoBoton = 'Cancelar'
    this.icono = 'close'
    this.elevarBoton = false
    this.rendered.setStyle(this.referenciaTextoBotonColaborar.nativeElement, 'color', 'black')
    this.verFormulario = true

  }

  mostrarBotonColaborar() {
    this.textoBoton = 'Quiero Colaborar'
    this.icono = 'volunteer_activism'
    this.elevarBoton = true
    this.rendered.setStyle(this.referenciaTextoBotonColaborar.nativeElement, 'color', 'white')
    this.verFormulario = false;
  }

  desaparecerFormulario() {
    this.elevarBoton = true
    this.mostrarBotonColaborar()
  }

  guardarArticulo(articulo: Articulo) {

    this.articulo = articulo

    if (this.articulo.foto.archivo) {
      this.crearArticuloConFoto()
    } else {
      this.crearArticulo()
    }

  }

  crearArticuloConFoto() {
    this.servicioDeArticulo.crearArticuloConFoto(this.articulo).subscribe(articulo => {

      articulo.categoria = this.articulo.categoria

      this.servicioDeArticulo.put(articulo.id!, articulo).subscribe(articuloCompleto => {
        this.articulo = articuloCompleto
        this.articulos.push(articulo)
        this.desaparecerFormulario()
        this.mostrarSnackBar("Articulo Agregado")
      }, err => console.log('Error al crear el Articulo con foto y categoria', err))

    }, err => console.error('Error al crear el Articulo con foto', err))
  }

  crearArticulo() {

    let id = this.servicioDeInvitado.recuperarIdDelLocalStorage()

    this.servicioDeInvitado.getOne(id!).subscribe(invitado => {
      this.articulo.id = invitado.nombre + '-' + invitado.apellido
      invitado.articulos.push(this.articulo)
      this.servicioDeInvitado.put(id!, invitado).subscribe(invitado => {
        this.articulos.push(this.articulo)

        this.articulo = { categoria: {}, foto: {} }
        console.log('articulo agregado al usaurio', invitado)
        this.mostrarSnackBar("Articulo Agregado")
      })
    })

  }

  scrollearAlInicio() {
    window.scroll(0, 0)

  }

  noEsBebida() {
    return (this.nombreDeCategoria && this.nombreDeCategoria !== 'Bebida')
  }
  guardarCategoriaYVaciarTiposGeneralesYVariables() {
    this.guardarCategoria()
    this.servicioDeDatos.tiposGenerales = []
    this.vaciarVariables()
    this.cargarTiposGenerales()

  }
  cargarTiposGenerales() {
    switch (this.nombreDeCategoria) {
      case 'Comida':
        this.servicioDeDatos.tiposGenerales = this.servicioDeDatos.tiposDeComidas
        break
      case 'Golosina':
        this.servicioDeDatos.tiposGenerales = this.servicioDeDatos.tiposDeGolosinas
        break
      case 'Postre':
        this.servicioDeDatos.tiposGenerales = this.servicioDeDatos.tiposDePostres
        break
      case 'Snack':
        this.servicioDeDatos.tiposGenerales = this.servicioDeDatos.tiposDeSnacks
        break
      default:
        this.servicioDeDatos.tiposGenerales = this.servicioDeDatos.tiposDeOtra
    }

  }

  vaciarVariables() {
    this.articulo.nombre = ''
    this.articulo.marca = ''
    this.articulo.medida = ''
    this.articulo.cantidad = undefined
    this.articulo.descripcion = ''
    this.vaciarAuxiliares()

  }

  vaciarAuxiliares() {
    this.marcaAuxiliar = ''
    this.nombreAuxiliar = ''
    this.marcaONombreAuxiliar = ''
    this.archivoAuxiliar = undefined

  }

  mostrarSnackBar(mensaje: string) {

    this.snackBar.open(mensaje, 'ok!', {
      duration: 5000, panelClass: ['yellow-light']
    })
  }

  cambiarEstadoDelBotonDeMensaje() {
    this.bloquearBotonDeMensaje = this.bloquearBotonDeMensaje ? false : true
  }

  guardarMensaje() {

    this.servicioDeInvitado.put(this.invitado.id!, this.invitado).subscribe((invitadoBD) => {
      this.bloquearBotonDeMensaje = false
      if(!invitadoBD.mensaje){
        this.textoBotonMensaje = 'Dejar Mensajito'
      }
    }, err => console.error('Error al actualizar invitado -Principal-', err))

  }

  obtenerInvitado() {
    let id = this.servicioDeInvitado.recuperarIdDelLocalStorage()
    this.servicioDeInvitado.getOne(id!).subscribe(invitado => {
      this.invitado = invitado
      if(!invitado.mensaje  || invitado.mensaje === ''){
        this.textoBotonMensaje = 'Dejar Mensajito'
      }else{
        this.textoBotonMensaje = 'Actualizar Mensaje'
      }
    })

  }

  mostrarContenidoDelMensaje(){
    if(!this.bloquearBotonDeMensaje && this.invitado.mensaje){
      return true
    }
    return false
    
  }
cancelarGuardar(){
  this.cambiarEstadoDelBotonDeMensaje()
  this.invitado.mensaje = this.copiaDelMensaje
}

abrirCajaDeMensaje(){
  this.cambiarEstadoDelBotonDeMensaje()
  this.copiaDelMensaje = this.invitado.mensaje!
}
}