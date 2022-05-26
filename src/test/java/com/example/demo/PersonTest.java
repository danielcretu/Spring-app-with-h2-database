package com.example.demo;

import com.example.demo.person.Person;
import com.example.demo.person.PersonRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;


@DataJpaTest
@Rollback(value = false)
public class PersonTest {

    @Autowired
    private PersonRepo personRepo;

    Person person = new Person("Daniel", 17);
    Person person1 = new Person("Ionut", 32);
    Person person2 = new Person("Marian", 20);

    @Test
    public void addAndGetPersonTest() {
        personRepo.save(person);
        personRepo.save(person1);
        personRepo.save(person2);
        int size = personRepo.findAll().size();
        Assertions.assertEquals(3, size);
    }

    @Test
    public void getPersonByIdTest() {

        Person personById = personRepo.getPersonById(1);
        Person personById2 = personRepo.getPersonById(2);
        Person personById3 = personRepo.getPersonById(4);
        Assertions.assertEquals("Daniel", personById.getFullName());
        Assertions.assertEquals("Ionut", personById2.getFullName());
        Assertions.assertEquals("Marian", personById3.getFullName());
        Assertions.assertEquals(17, personById.getAge());
        Assertions.assertEquals(32, personById2.getAge());
        Assertions.assertEquals(20, personById3.getAge());
    }

    @Test
    public void updatePersonTest() {
        Person updatedPerson = new Person(1, "George", 32);
        personRepo.save(updatedPerson);
        Person pers = personRepo.getPersonById(1);
        Assertions.assertEquals("George", pers.getFullName());
        Person pers1 = person;
        pers1.setId(1);
        personRepo.save(pers1);
        personRepo.findAll().forEach(System.out::println);
    }

    @Test
    public void deletePersonTest() {
        Assertions.assertEquals(3, personRepo.findAll().size());
        Person pers = person2;
        pers.setId(3);
        personRepo.delete(pers);
        Assertions.assertEquals(2, personRepo.findAll().size());
        personRepo.save(pers);
    }
}

