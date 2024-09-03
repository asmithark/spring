package com.example.sb1.entity;
 
import org.springframework.data.annotation.Id;
 
public record Person(@Id Long id, String name, String email) {
}
 
