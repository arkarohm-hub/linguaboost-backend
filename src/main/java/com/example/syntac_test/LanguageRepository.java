package com.example.syntac_test;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long>{
    // We write NOTHING here.
    // Spring automatically gives us: .save(), .findAll(), .findById(), .deleteById(), etc.
}
