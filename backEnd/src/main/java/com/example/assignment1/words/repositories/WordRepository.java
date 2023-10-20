package com.example.assignment1.words.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.assignment1.words.entities.Word;


/**
 * PersonRepository
 */
public interface WordRepository extends CrudRepository<Word, Integer>{

    Iterable<Word> findByWord(String word);

    Iterable<Word> findByFrequency(Integer frequency);
    
    Iterable<Word> findByMasteredTrue();
    Iterable<Word> findByMasteredFalse();

    Iterable<Word> findByWordAndFrequencyAndMasteredTrue(String word, Integer frequency);
    Iterable<Word> findByWordAndFrequencyAndMasteredFalse(String word, Integer frequency);


}
