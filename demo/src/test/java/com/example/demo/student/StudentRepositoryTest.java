package com.example.demo.student;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;
    private CommandLineRunner commandLineRunner;

    @Test
    void itShouldCheckIfStudentExistsEmail() {
        //given
        Student student = new Student(
                "Jamila", "math"
        );
        studentRepository.saveAndFlush(student);
        //when
        List<Student> all = studentRepository.findAll();
        //then
        assertThat(all).contains(student);
    }

}