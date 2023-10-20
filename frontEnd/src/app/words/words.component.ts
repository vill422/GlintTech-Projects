import { Component } from '@angular/core';
import { Word } from '../word';

@Component({
  selector: 'app-words',
  templateUrl: './words.component.html',
  styleUrls: ['./words.component.css'],
})
export class WordsComponent {
  word: Word = {
    id: 1,
    word: 'abacus',
    definition: 'a frame with balls for calculating',
    frequency: 1,
    mastered: false,
  };
  onSubmit() {
    console.log('submitted');
  }
}
