import { Component } from '@angular/core';

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.css'],
})
export class AboutComponent {
  head = '2023 My First Angular Project';
  discription =
    'This is my first Angular project. I will add more features to this project in the future.';
  features = {
    1: 'Connect front-end to back-end',
    2: 'Handle wrong inputs',
    3: 'Handle user authentication',
  };
}
