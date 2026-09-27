import { AnfitrionComponent } from './home-invitado/anfitrion/anfitrion.component';
import { HomeInvitadoComponent } from './home-invitado/home-invitado.component';
import { LugarComponent } from '@shared/components/lugar/lugar.component';
import { MiPerfilComponent } from '@shared/components/mi-perfil/mi-perfil.component';
import { NgModule } from '@angular/core';
import { PrincipalComponent } from './home-invitado/principal/principal.component';
import { RouterModule, Routes } from '@angular/router';
import { UsuarioGuard } from '@shared/guards/usuario.guard';

const routes: Routes = [
  {
    path: '',
    component: HomeInvitadoComponent  ,canActivateChild: [UsuarioGuard],
     children: [
      { path: '', component: PrincipalComponent },
      { path: 'lugar', component: LugarComponent },
      { path: 'anfitrion', component: AnfitrionComponent },
      { path: 'mi-perfil', component: MiPerfilComponent }

    ]
  }
]

@NgModule({
  imports: [
    RouterModule.forChild(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class InvitadoRoutingModule { }