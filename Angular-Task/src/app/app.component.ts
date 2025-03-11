import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Task';
  
  serviceslist = [
    { title: 'Product Design and Development' },
    { title: 'Automation and Control Systems' },
    { title: 'Structural Engineering Solutions' },
    { title: 'Electrical and Electronics Engineering' },
    { title: 'Systems Integration' },
    { title: 'Research and Development (R&D)' }
  ];
}
