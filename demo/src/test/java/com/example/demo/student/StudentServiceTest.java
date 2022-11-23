package com.example.demo.student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    private StudentService underTest;
    //    private AutoCloseable autoCloseable;
    @Mock
    private StudentRepository studentRepository;

    @BeforeEach
    public void beforeEach() {
        underTest = new StudentService(studentRepository);
    }

//    @AfterEach
//    void afterAll()  throws Exception{
//        autoCloseable.close();
//    }

    @Test
    void saveStudent() {
        Student sampleStudent = new Student("park", "math");

        underTest.saveStudent(sampleStudent);

        ArgumentCaptor<Student> studentArgumentCaptor = ArgumentCaptor.forClass(Student.class);

        verify(studentRepository).save(studentArgumentCaptor.capture());

        Student capturedStudent = studentArgumentCaptor.getValue();
        assertThat("park").isEqualTo(sampleStudent.getName());

    }

    @Test
    void getAllStudents() {
        // when
        underTest.getAllStudents();
        // then
        verify(studentRepository).findAll();
    }

    @Test
    void findById() {
        // when
        Student sample = new Student("park", "math");
        underTest.saveStudent(sample);
        Long id = sample.getId();
        //then
        Student byId = underTest.findById(id);

    }
}