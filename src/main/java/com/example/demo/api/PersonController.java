package com.example.demo.api;

import com.example.demo.person.Person;
import com.example.demo.person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping("/persons")
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @GetMapping("/person/{id}")
    public Person getPersonById(@PathVariable int id) {
        return personService.getPersonDetails(id);
    }

    @PostMapping("/addPerson")
    public Person addPerson(@RequestBody Person person) {
        return personService.addPerson(person);
    }

    @PutMapping("/updatePerson/{id}")
    public Person updatePerson(@PathVariable int id, @RequestBody Person person) {
        person.setId(id);
        return personService.addPerson(person);
    }

    @DeleteMapping("/deletePerson/{id}")
    public Person deletePerson(@PathVariable int id) {
        return personService.deletePerson(id);
    }
}
