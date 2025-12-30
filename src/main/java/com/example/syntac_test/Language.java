package com.example.syntac_test;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
@Entity
public class Language {
   @Id // 2. Primary Key
   @GeneratedValue // 3. Auto Increment
   private Long id;

   private String name;
   private String description;

   // Standard Getters, Setters, and Empty Constructor are needed here!
   public Language() {
   }
   public Language(String name, String description) {
       this.name = name;
       this.description = description;
   }
   // Imagine Getter and Setter here
   public String getName(){
    return name;
   }
}
