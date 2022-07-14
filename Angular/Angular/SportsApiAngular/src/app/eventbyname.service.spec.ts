import { TestBed } from '@angular/core/testing';

import { EventbynameService } from './eventbyname.service';

describe('EventbynameService', () => {
  let service: EventbynameService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EventbynameService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
