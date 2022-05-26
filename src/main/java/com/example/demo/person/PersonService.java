package com.example.demo.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepo personRepo;

    public List<Person> getAllPersons() {
        return personRepo.findAll();
    }

    public Person getPersonDetails(int id) {
        return personRepo.getPersonById(id);
    }

    public Person addPerson(Person person) {
        return personRepo.save(person);
    }

    public Person deletePerson(int id) {
        Person person = personRepo.getPersonById(id);
        personRepo.delete(person);
        return person;
    }
}
