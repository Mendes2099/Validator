import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms'; // Import FormsModule for two-way binding

@Component({
  selector: 'app-sscc-form',
  standalone: true,
  imports: [FormsModule], // Include FormsModule for template-driven forms
  templateUrl: './sscc-form.component.html',
  styleUrls: ['./sscc-form.component.scss']
})
export class SsccFormComponent {
  ssccNumber: string = '';

  // This method ensures only numeric input is accepted
  validateInput() {
    this.ssccNumber = this.ssccNumber.replace(/[^0-9]/g, '');  // Removal of non-numeric characters
  }

  onSubmit() {
    if (this.ssccNumber.length === 18) {
      console.log('SSCC/NVE Entered:', this.ssccNumber);
      // Call to backend API for validation
    } else {
      console.log('Invalid SSCC/NVE');
    }
  }
}
