import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminProductsDetailComponent } from './admin-products-detail.component';

describe('AdminProductsDetailComponent', () => {
  let component: AdminProductsDetailComponent;
  let fixture: ComponentFixture<AdminProductsDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminProductsDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminProductsDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
