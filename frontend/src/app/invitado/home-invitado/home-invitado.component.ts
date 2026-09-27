import { Component, HostBinding, HostListener, OnInit, Output, ViewChild } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { DatosService } from '@shared/services/datos.service';
import { InvitadoService } from '@shared/services/invitado.service';
@Component({
  selector: 'app-home-invitado',
  templateUrl: './home-invitado.component.html',
  styleUrls: ['./home-invitado.component.css']
})

export class HomeInvitadoComponent implements OnInit {

  mensaje = 'Registrado Exitosamente!'

  constructor(private servicioDeInvitado: InvitadoService,private snackBar: MatSnackBar, private router: Router, public servicioDeDatos: DatosService) { }

  ngOnInit(): void {
  this.comprobarSiEsUsuarioNuevo()
  }

  comprobarSiEsUsuarioNuevo(){
    if(this.servicioDeInvitado.esNuevoUsuario()){
      this.mostrarSnackBar(this.mensaje)
      this.servicioDeInvitado.eliminarSesionOCondicionDeNuevoDelLocalStorage('nuevo')
    }
  }
  
  ngAfterViewInit() {
  }

  abrirDialogo(){

  }
  cerrarSesion() {

  this.abrirDialogo()

  }
 
  mostrarSnackBar(mensaje: string) {

    this.snackBar.open(mensaje, 'ok!', {
      duration: 5000, panelClass: ['green-light']
    })
  }

}