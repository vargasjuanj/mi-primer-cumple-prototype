import { Component, OnInit } from '@angular/core';
import { Invitado } from '@shared/model/persona/usuario/invitado/invitado.model';
import { InvitadoService } from '@shared/services/invitado.service';

@Component({
  selector: 'app-invitados',
  templateUrl: './invitados.component.html',
  styleUrls: ['./invitados.component.css']
})
export class InvitadosComponent implements OnInit {

  invitados: Invitado[] = []

  constructor(private servicioDeInvitado: InvitadoService){}

  ngOnInit(): void {
this.scrollearAlInicio()

this.cargarInvitados()
  }

  scrollearAlInicio() {
    window.scroll(0, 0)

  }

  cargarInvitados(){
    this.servicioDeInvitado.getAll(0,100).subscribe(invitados=>{
      this.invitados = invitados
    }, err=> console.error('Error al cargar los invitados en Modulo Anfitrion, componente Invitados', err))
  }

}