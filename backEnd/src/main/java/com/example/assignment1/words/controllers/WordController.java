package com.example.assignment1.words.controllers;

import java.util.Optional;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.assignment1.words.entities.Word;
import com.example.assignment1.words.repositories.WordRepository;
@RestController
/**
 *  WordController
 */
public class WordController {
    private final WordRepository wordRepository;

    public WordController(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }
    
    @GetMapping("/words")
    public ResponseEntity<Iterable<Word>> getWords() {
        return ResponseEntity.ok(this.wordRepository.findAll());
    }

    @GetMapping("/words/{id}")
    public ResponseEntity<?> getWord(@PathVariable("id") Integer id) {
        Optional<Word> optionalWord = this.wordRepository.findById(id);
        if (!optionalWord.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("id is not correct");
        }
        return ResponseEntity.ok(optionalWord.get());
    }
   
    @GetMapping("/words/search")
    public ResponseEntity<Iterable<Word>> searchWords(@RequestParam(name="word", required=false) String word, @RequestParam(name="frequency", required = false) Integer frequency, @RequestParam(name="mastered", required = false) Boolean mastered) {
        if (word != null && frequency != null && mastered != null) {
            if (mastered) {
                return ResponseEntity.ok(this.wordRepository.findByWordAndFrequencyAndMasteredTrue(word, frequency));
            } else {
                return ResponseEntity.ok(this.wordRepository.findByWordAndFrequencyAndMasteredFalse(word, frequency));
            }
        } else if (word != null) {
            return ResponseEntity.ok(this.wordRepository.findByWord(word));
        } else if (frequency != null) {
            return ResponseEntity.ok(this.wordRepository.findByFrequency(frequency));
        } else if (mastered != null) {
            if (mastered) {
                return ResponseEntity.ok(this.wordRepository.findByMasteredTrue());
            } else {
                return ResponseEntity.ok(this.wordRepository.findByMasteredFalse());
            }
        }
        else {
            return ResponseEntity.ok(this.wordRepository.findAll());
        }
    }

    @PostMapping("/words")
    public ResponseEntity<Word> createWord(@RequestBody Word word) {
        Word savedWord = this.wordRepository.save(word);
        return new ResponseEntity<Word>(savedWord, HttpStatus.CREATED);
    }
    
    @PutMapping("/words/{id}")
    public Word updateWord(@PathVariable("id") Integer id, @RequestBody Word word) {
        Optional<Word> optionalWord = this.wordRepository.findById(id);
        if (!optionalWord.isPresent()) {
            throw new RuntimeException("word not found");
        }
        Word wordToUpdate = optionalWord.get();
        if (word.getWord() != null) {
            wordToUpdate.setWord(word.getWord());
        }
        if (word.getInterpretation() != null) {
            wordToUpdate.setInterpretation(word.getInterpretation());
        }
        if (word.getFrequency() != null) {
            wordToUpdate.setFrequency(word.getFrequency());
        }
        if (word.getMastered() != null) {
            wordToUpdate.setMastered(word.getMastered());
        }

        Word updatedWord = this.wordRepository.save(wordToUpdate);
        return updatedWord;
    }

    @DeleteMapping("/words/{id}")
    public Word deleteWord(@PathVariable("id") Integer id) {
        Optional<Word> optionalWord = this.wordRepository.findById(id);
        if (!optionalWord.isPresent()) {
            throw new RuntimeException("word not found");
        }
        Word wordToDelete = optionalWord.get();
        this.wordRepository.delete(wordToDelete);
        return wordToDelete;
    }
}
