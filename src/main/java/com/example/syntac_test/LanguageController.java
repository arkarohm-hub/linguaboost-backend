package com.example.syntac_test;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LanguageController {
    private final LanguageService languageService;

    // Constructor Injection
    //Spring sees this and automatically plugs in the LanguageService
    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping("/languages")
    public List<Language> getLanguages() {
        return languageService.getAllLanguages();
        }
    
}
