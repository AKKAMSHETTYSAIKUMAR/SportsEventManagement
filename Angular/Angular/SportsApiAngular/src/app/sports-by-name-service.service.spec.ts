import { TestBed } from '@angular/core/testing';

import { SportsByNameServiceService } from './sports-by-name-service.service';

describe('SportsByNameServiceService', () => {
  let service: SportsByNameServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SportsByNameServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
