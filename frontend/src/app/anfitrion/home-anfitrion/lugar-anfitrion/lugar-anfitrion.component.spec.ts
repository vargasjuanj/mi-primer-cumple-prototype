import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LugarAnfitrionComponent } from './lugar-anfitrion.component';

describe('LugarAnfitrionComponent', () => {
  let component: LugarAnfitrionComponent;
  let fixture: ComponentFixture<LugarAnfitrionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LugarAnfitrionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LugarAnfitrionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});