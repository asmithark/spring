package com.example.sb1.controller;
 
import java.util.List;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.sb1.entity.Person;
import com.example.sb1.repository.PersonRepository;
 
@RestController
@RequestMapping("/persons")
public class PersonController {
 
    @Autowired
    private PersonRepository personRepository;
 
    // GET all persons
    @GetMapping
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }
 
    // GET person by ID
    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
        Optional<Person> person = personRepository.findById(id);
        return person.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }
 
    // POST to create a new person
    @PostMapping("/{id}/{name}/{email}")
    public void addData(
        @PathVariable int id,
        @PathVariable String name,
        @PathVariable String email){
            personRepository.addData(id, name, email);  
        }
   
 
    // PUT to update an existing person
    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Long id, @RequestBody Person updatedPerson) {
        return personRepository.findById(id)
                .map(person -> {
                    // Update the fields as necessary
                    Person savedPerson = personRepository.save(new Person(id, updatedPerson.name(), updatedPerson.email()));
                    return ResponseEntity.ok(savedPerson);
                })
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }
 
    // DELETE to remove a person by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        try {
            personRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
 