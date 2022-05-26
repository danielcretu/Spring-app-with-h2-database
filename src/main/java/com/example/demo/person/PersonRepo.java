package com.example.demo.person;

import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonRepo extends JpaRepository<Person, Integer> {
    Person getPersonById(int id);
}
