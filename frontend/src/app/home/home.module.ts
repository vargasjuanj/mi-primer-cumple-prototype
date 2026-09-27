import { NgModule } from '@angular/core';
import { HomeRoutingModule } from './home.routing.module';
import {SharedModule} from "@shared/shared.module";
import {FormularioInicioComponent} from "./inicio/formulario-inicio/formulario-inicio.component";
import { InicioComponent } from './inicio/inicio.component';

@NgModule({
  declarations: [
    FormularioInicioComponent,
    InicioComponent
  ],
  imports: [
    HomeRoutingModule,
    SharedModule
  ]
})
export class HomeModule { }