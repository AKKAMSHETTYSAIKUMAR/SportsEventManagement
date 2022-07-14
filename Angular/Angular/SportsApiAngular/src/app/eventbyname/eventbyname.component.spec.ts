import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EventbynameComponent } from './eventbyname.component';

describe('EventbynameComponent', () => {
  let component: EventbynameComponent;
  let fixture: ComponentFixture<EventbynameComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EventbynameComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EventbynameComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
