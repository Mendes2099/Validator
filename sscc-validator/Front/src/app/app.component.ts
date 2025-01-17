import { Component } from '@angular/core';
import { RouterModule } from '@angular/router'; // router module
import { SsccFormComponent } from './sscc-form/sscc-form.component'; // form component
import { HttpClient } from '@angular/common/http'; // Import HttpClient


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterModule, SsccFormComponent], // Inclusion of RouterModule + SsccFormComponent
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'sscc-validator';  ssccNumber: string = '';
  validationResult: string = '';

  constructor(private http: HttpClient) {}

  // Method for submitting the SSCC form
  onSubmit() {
    if (this.ssccNumber.length === 18) {
      this.validateSSCC();
    }
  }

  // Method to call the backend for SSCC validation
  validateSSCC() {
    const apiUrl = 'http://localhost:8080/api/sscc/validate';
    this.http.post(apiUrl, this.ssccNumber, { responseType: 'json' })
      .subscribe(
        (response: any) => {
          this.validationResult = response.isValid ? 'Valid SSCC' : 'Invalid SSCC';
        },
        (error) => {
          console.error('Error validating SSCC', error);
          this.validationResult = 'Error validating SSCC';
        }
      );
  }
}