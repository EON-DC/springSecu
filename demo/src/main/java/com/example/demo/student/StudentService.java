package com.example.demo.student;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentService {

    private final StudentRepository studentRepository;

    public Student findById(Long studentId) {
        return studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException("그런 아이디 학생 없음"));
    }

    public void saveStudent(Student student) {
        studentRepository.save(student);
        log.info("저장되었습니다. 학새 이름 : ",student.getName());
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

}
