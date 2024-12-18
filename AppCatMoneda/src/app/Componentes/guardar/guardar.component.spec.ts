import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GuardarComponent } from './guardar.component';

describe('GuardarComponent', () => {
  let component: GuardarComponent;
  let fixture: ComponentFixture<GuardarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GuardarComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GuardarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
