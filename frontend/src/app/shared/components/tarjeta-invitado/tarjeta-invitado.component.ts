import { Component, EventEmitter, HostBinding, Input, OnInit, Output } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { Invitado } from '@shared/model/persona/usuario/invitado/invitado.model';
import { Articulo } from '@shared/model/stock/articulo.model';
import { DatosService } from '@shared/services/datos.service';
import { InvitadoService } from '@shared/services/invitado.service';
import { DialogoEliminarComponent } from '../dialogo-eliminar/dialogo-eliminar.component';

@Component({
  selector: 'app-tarjeta-invitado',
  templateUrl: './tarjeta-invitado.component.html',
  styleUrls: ['./tarjeta-invitado.component.css']
})
export class TarjetaInvitadoComponent implements OnInit {

  @Input() invitado!: Invitado
  @Input() index: any
  @Output() emitirIndex = new EventEmitter<number>()
  constructor(private router: Router, private servicioDeDatos: DatosService, private servicioDeInvitado: InvitadoService, private dialog: MatDialog) { }

  ngOnInit(): void {
  }

  eliminar(idInvitado: string) {

    this.abrirDialogo(idInvitado);

  }

  abrirDialogo(idInvitado: string) {
    const dialog = this.dialog.open(DialogoEliminarComponent, {
      width: "300px",
      disableClose: true
    })

    dialog.afterClosed().subscribe(
      result => {
        if (result) {
          this.eliminarInvitado(idInvitado)
        } 
      }
    )
  }

  eliminarInvitado(idInvitado: any){
    this.servicioDeInvitado.delete(idInvitado).subscribe(invitado=>{
      console.log('Se eliminó el invitado', invitado)
      this.emitirIdAlPadre(this.index)
    }, err => console.error('Error en Listado Invitados al intentar eliminar invitado', err))
 }
 
 emitirIdAlPadre(idInvitado: number) {
  this.emitirIndex.emit(idInvitado)
}

  mostrarArticulos(articulos: Articulo[]){
    this.servicioDeDatos.articulos = articulos
    let nombreYApellido = this.invitado.nombre + '-' + this.invitado.apellido
    this.router.navigate(['./anfitrion/articulos',nombreYApellido])
  }

}