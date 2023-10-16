import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent {
  welcome = 'Welcom to THe Lexi Memory App';
  description =
    "This is a simple app to help you rememeber English words more easily. You can add words to your list and then test yourself on them. You can also add a definition and mark whether you've learned the word or not.";
}
