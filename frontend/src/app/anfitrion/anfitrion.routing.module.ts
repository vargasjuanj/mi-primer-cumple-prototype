import { MiPerfilComponent } from '@shared/components/mi-perfil/mi-perfil.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UsuarioGuard } from '@shared/guards/usuario.guard';
import { HomeAnfitrionComponent } from './home-anfitrion/home-anfitrion.component';
import { InvitadosComponent } from './home-anfitrion/invitados/invitados.component';
import { ArticulosDeInvitadoComponent } from './home-anfitrion/articulos-de-invitado/articulos-de-invitado.component';
import { LugarAnfitrionComponent } from './home-anfitrion/lugar-anfitrion/lugar-anfitrion.component';

const routes: Routes = [
  {
    path: '',
    component: HomeAnfitrionComponent ,
     children: [
      { path: '', component: InvitadosComponent },
      { path: 'articulos', component: ArticulosDeInvitadoComponent  },
      { path: 'articulos/:nombreYApellido', component: ArticulosDeInvitadoComponent  },
      { path: 'lugar', component: LugarAnfitrionComponent },
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
export class AnfitrionRoutingModule { }