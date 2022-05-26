package com.example.demo.person;
import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Table(name = "PERSON")
@Getter
@Setter
@NoArgsConstructor

public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "FULLNAME")
    private String fullName;

    @Column
    private int age;

    public Person(int id, String fullName, int age) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
    }
    public Person(String fullName, int age) {
        this.fullName = fullName;
        this.age = age;
    }
}
