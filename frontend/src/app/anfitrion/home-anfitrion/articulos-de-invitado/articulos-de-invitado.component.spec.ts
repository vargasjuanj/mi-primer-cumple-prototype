import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ArticulosDeInvitadoComponent } from './articulos-de-invitado.component';

describe('ArticulosDeInvitadoComponent', () => {
  let component: ArticulosDeInvitadoComponent;
  let fixture: ComponentFixture<ArticulosDeInvitadoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ArticulosDeInvitadoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ArticulosDeInvitadoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});