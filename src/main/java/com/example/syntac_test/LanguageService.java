package com.example.syntac_test;

import java.util.List;

import org.springframework.stereotype.Service;

@Service // Tells spring: "Manage this class!"
public class LanguageService {
    private final LanguageRepository languageRepository;

    public LanguageService(LanguageRepository languageRepository){
        this.languageRepository = languageRepository;
    }
    public List<Language> getAllLanguages() {
        return languageRepository.findAll();
    }

    // Let's add a method to save data so we can test it
    public void addLanguage(String name, String desc) {
        languageRepository.save(new Language(name, desc));
    }
}i
