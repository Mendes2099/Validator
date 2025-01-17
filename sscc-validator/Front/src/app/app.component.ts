import { Component } from '@angular/core';
import { RouterModule } from '@angular/router'; // router module
import { SsccFormComponent } from './sscc-form/sscc-form.component'; // form component

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterModule, SsccFormComponent], // Inclusion of RouterModule + SsccFormComponent
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'sscc-validator';
}