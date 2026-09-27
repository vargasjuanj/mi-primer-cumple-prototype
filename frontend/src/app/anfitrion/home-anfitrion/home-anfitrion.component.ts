import { Component, OnInit  } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { DatosService } from '@shared/services/datos.service';
import { InvitadoService } from '@shared/services/invitado.service';
@Component({
  selector: 'app-home-anfitrion',
  templateUrl: './home-anfitrion.component.html',
  styleUrls: ['./home-anfitrion.component.css']
})
export class HomeAnfitrionComponent implements OnInit {

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