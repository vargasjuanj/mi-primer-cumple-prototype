import { NgModule } from '@angular/core';
import {SharedModule} from "@shared/shared.module";
import { AnfitrionRoutingModule } from './anfitrion.routing.module';
import { HomeAnfitrionComponent } from './home-anfitrion/home-anfitrion.component';
import { InvitadosComponent } from './home-anfitrion/invitados/invitados.component';
import { ArticulosDeInvitadoComponent } from './home-anfitrion/articulos-de-invitado/articulos-de-invitado.component';
import { LugarAnfitrionComponent } from './home-anfitrion/lugar-anfitrion/lugar-anfitrion.component';

@NgModule({
  declarations: [
HomeAnfitrionComponent,
InvitadosComponent,
ArticulosDeInvitadoComponent,
LugarAnfitrionComponent
  ],
  imports: [
    AnfitrionRoutingModule,
    SharedModule
  ]
})
export class AnfitrionModule { }