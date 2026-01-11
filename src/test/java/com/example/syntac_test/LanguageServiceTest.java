package com.example.syntac_test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class) // 1. Enable Mockito in this test class
public class LanguageServiceTest {
    @Mock
    private LanguageRepository languageRepository; // 2. Mock the LanguageRepository
    @InjectMocks
    private LanguageService languageService; // 3. Inject the mock into LanguageService

    @Test
    void shouldBlockDuplicateLanguages(){
        Language existingLanguage = new Language("Burmese", "Myanamar Language");
        when(languageRepository.findByName("Burmese"))
            .thenReturn(List.of(existingLanguage));

            //--- When & THEN (The Action & Check) ---
            // We try to add 'Burmese' again. We expect an Error (Exception).
            RuntimeException exception = assertThrows(RuntimeException.class, ()->{
                languageService.addLanguage("Burmese", "Another Description");
            });

            // Verify the error message is correct
            assertEquals("Language Burmese already exists!", exception.getMessage());

            // Verify the Stunt Double was actually called(The Manager did his job)
            verify(languageRepository).findByName("Burmese");

 // Verify we never tried to save to the database (Crisis averted!)
            verify(languageRepository,never()).save(any());

    }
}
