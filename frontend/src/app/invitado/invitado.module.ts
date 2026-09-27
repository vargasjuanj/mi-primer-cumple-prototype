import { NgModule } from '@angular/core';
import { InvitadoRoutingModule } from './invitado.routing.module';

import {SharedModule} from "@shared/shared.module";
import { AnfitrionComponent } from './home-invitado/anfitrion/anfitrion.component';
import { HomeInvitadoComponent } from './home-invitado/home-invitado.component';
import { PrincipalComponent } from './home-invitado/principal/principal.component';

@NgModule({
  declarations: [
    AnfitrionComponent,
    HomeInvitadoComponent,
    PrincipalComponent
  ],
  imports: [
    InvitadoRoutingModule,
    SharedModule
  ]
})
export class InvitadoModule { }