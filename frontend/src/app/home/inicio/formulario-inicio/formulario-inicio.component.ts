import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Invitado } from '@shared/model/persona/usuario/invitado/invitado.model';
import { DatosService } from '@shared/services/datos.service';
import { InvitadoService } from '@shared/services/invitado.service';

@Component({
  selector: 'app-formulario-inicio',
  templateUrl: './formulario-inicio.component.html',
  styleUrls: ['./formulario-inicio.component.css']

})
export class FormularioInicioComponent implements OnInit {
 
  invitado: Invitado = {nombre:'',apellido:'',articulos:[]}

  constructor(private router: Router, private servicioInvitado: InvitadoService, private servicioDeDatos: DatosService) { }

  ngOnInit(): void {

  }

  iniciarORegistrarUsuario(){
    this.invitado.nombre = this.invitado.nombre.toLowerCase().trim()
    this.invitado.apellido = this.invitado.apellido!.toLowerCase().trim()
  this.servicioInvitado.buscarPorNombreYApellido(this.invitado.nombre, this.invitado.apellido!).subscribe(invitado=>{
    if(invitado){
      this.iniciarSesion(invitado)
    }else{
      this.registrarse()
    }  })
  }

  iniciarSesion(invitado: Invitado){

    console.log('Iniciando sesión de invitado', invitado)
    this.servicioInvitado.guardarSesionEnElLocalStorage(invitado)
    this.servicioInvitado.guardarIdEnElLocalStorage(invitado.id!)

    this.esAnfitrion(invitado)
  }

  registrarse(){
  
    this.servicioInvitado.post(this.invitado).subscribe(invitado=>{
      console.log('invitado registrado',invitado)
      this.servicioInvitado.guardarSesionEnElLocalStorage(invitado)
      this.servicioInvitado.nuevoUsuario()
      this.servicioInvitado.guardarIdEnElLocalStorage(invitado.id!)
      this.esAnfitrion(invitado)

    })
  }

  bloquearBoton(){
    if(this.invitado.apellido.trim() && this.invitado.nombre.trim()){
      return false
    }
    return true

  }
 esAnfitrion(invitado: Invitado){

  if(invitado.nombre === 'host4033' && invitado.apellido === 'host4033'){
    this.servicioInvitado.crearSesionDeAnfitrion()
    this.router.navigate(['./anfitrion'])
  }else{
    this.router.navigate(['./invitado'])
  }
 }

}