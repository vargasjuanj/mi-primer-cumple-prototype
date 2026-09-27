import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeAnfitrionComponent } from './home-anfitrion.component';

describe('HomeAnfitrionComponent', () => {
  let component: HomeAnfitrionComponent;
  let fixture: ComponentFixture<HomeAnfitrionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HomeAnfitrionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HomeAnfitrionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});