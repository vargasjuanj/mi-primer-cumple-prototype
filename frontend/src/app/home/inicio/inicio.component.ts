import { Component, OnInit } from '@angular/core';
import { trigger, style, state, transition, animate, keyframes } from '@angular/animations'
import { InvitadoService } from '@shared/services/invitado.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-inicio',
  templateUrl: './inicio.component.html',
  styleUrls: ['./inicio.component.css'],
  animations: [
    trigger('animarNombre', [
      state('inactivo', style({
        transform: 'scale(1)'
      })),

      state('activo', style({
        transform: 'scale(1.3)'
      })),

      transition('inactivo => activo', [
        animate(2000, keyframes([
          style({ transform: 'scale(1)', color: 'black', offset: 0 }),
          style({ transform: 'scale(1.1)', color: 'pink', offset: 0.4 }),
          style({ transform: 'scale(1.3)', color: 'pink', offset: 0.8 }),
          style({ transform: 'scale(1.5)', color: 'pink', offset: 1 })
        ]))
      ]),
      transition('activo => inactivo', [
        animate(2000, keyframes([
          style({ transform: 'scale(1.5)', color: 'pink', offset: 0 }),
          style({ transform: 'scale(1.3)', color: 'pink', offset: 0.4 }),
          style({ transform: 'scale(1.1)', color: 'pink', offset: 0.8 }),
          style({ transform: 'scale(1)', color: 'black', offset: 1 })
        ]))
      ])

    ])
  ]
})
export class InicioComponent implements OnInit {

  estadoDelNombre = 'inactivo'

  constructor(private servicioDeInvitado: InvitadoService, private router: Router) { }

  ngOnInit(): void {
    this.comprobarSiEstaLogueado()
    this.cambiarEstadoDelNombre()
 
  }
  comprobarSiEstaLogueado(){

    if(this.servicioDeInvitado.esSesionDeAnfitrion()){
      this.router.navigate(['./anfitrion'])
    }
    else if(this.servicioDeInvitado.recuperarSesionDelLocalStorage('invitado')){
      this.router.navigate(['./invitado'])
    }
  }

  cambiarEstadoDelNombre() {
    setInterval(() => {
      this.estadoDelNombre = this.estadoDelNombre === 'inactivo' ? 'activo' : 'inactivo'
    }, 4000)
  }
}
