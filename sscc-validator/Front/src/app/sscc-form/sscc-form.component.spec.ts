import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SsccFormComponent } from './sscc-form.component';

describe('SsccFormComponent', () => {
  let component: SsccFormComponent;
  let fixture: ComponentFixture<SsccFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SsccFormComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SsccFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
