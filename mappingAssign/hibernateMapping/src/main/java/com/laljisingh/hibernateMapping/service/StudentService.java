package com.laljisingh.hibernateMapping.service;

import com.laljisingh.hibernateMapping.model.Student;
import com.laljisingh.hibernateMapping.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public List<Student> getAlStudent() {
        return studentRepository.findAll();
    }

    public String deleteStudent(Integer valueOf) {
        studentRepository.deleteById(valueOf);
        return "user deleted";
    }
}
