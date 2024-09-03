package com.example.sb1.entity;
 
import org.springframework.data.annotation.Id;
 
public record Person(@Id int id, String name, String email) {

  
}
 
