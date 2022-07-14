import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SportsbynameComponent } from './sportsbyname.component';

describe('SportsbynameComponent', () => {
  let component: SportsbynameComponent;
  let fixture: ComponentFixture<SportsbynameComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SportsbynameComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SportsbynameComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
