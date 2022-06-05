package com.xtream.controller;

import com.xtream.domain.Person;
import com.xtream.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @PostMapping
    public ResponseEntity<Void> add(@RequestBody Person person) {
        personRepository.Add(person);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getById(@PathVariable int id) {
        return new ResponseEntity<>(personRepository.getById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Person>> getAll() {
        return  new ResponseEntity<>(personRepository.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        personRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
