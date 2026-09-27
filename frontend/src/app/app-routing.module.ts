import { ErrorPageComponent } from '@shared/components/error-page/error-page.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    loadChildren: () => import('./home/home.module').then(m => m.HomeModule)
  }
  ,
  {
    path: 'invitado',
    loadChildren: () => import('./invitado/invitado.module').then(m => m.InvitadoModule)
  }
  ,
  {
    path: 'anfitrion',
    loadChildren: () => import('./anfitrion/anfitrion.module').then(m => m.AnfitrionModule)
  },
 
  {
     path: '**',
     component: ErrorPageComponent
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes,{ useHash: true })],
  exports: [RouterModule]
})
export class AppRoutingModule { }