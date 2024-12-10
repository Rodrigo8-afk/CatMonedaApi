import { TestBed } from '@angular/core/testing';

import { WsCatMonedaService } from './ws-cat-moneda.service';

describe('WsCatMonedaService', () => {
  let service: WsCatMonedaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(WsCatMonedaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
