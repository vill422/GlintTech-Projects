package com.example.assignment1.words.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Table(name = "WORDS")
public class Word {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "WORD")
    private String word;

    @Column(name = "INTERPRETATION")
    private String interpretation;

    @Column(name = "FREQUENCY")
    private Integer frequency;

    @Column(name = "MASTERED")
    private boolean mastered;

    // id
    public Integer getId() {
        return this.id;
    }

    // Word
    public String getWord(){
        return this.word;
    }
    public void setWord(String word){
        this.word = word;
    }

    // interpretation
    public String getInterpretation(){
        return this.interpretation;
    }
    public void setInterpretation(String interpretation){
        this.interpretation = interpretation;
    }

    // frequency
    public Integer getFrequency() {
        return this.frequency;
    }
    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }
    
    // mastered
    public Boolean getMastered() {
        return this.mastered;
    }
    public void setMastered(Boolean mastered) {
        this.mastered = mastered;
    }
}
