package com.example.demo.student;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class Student {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String subject;

    public Student() {
    }

    public Student(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }
}
