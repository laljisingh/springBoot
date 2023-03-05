package com.laljisingh.test0533.service;

import com.laljisingh.test0533.model.Student;
import com.laljisingh.test0533.repository.StudentRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public Integer addStudent(Student student) {
        Student save = studentRepository.save(student);
        return save.getStudent_Id();
    }

    public List<Student> getStudentByFirstName(String firstName) {
        return studentRepository.findStudentByfirstName(firstName);
    }

    public List<Student> getActiveStudent() {
        return studentRepository.getActiveStudent();
    }


    public void deleteStudent(Integer valueOf) {
        studentRepository.deleteById(valueOf);
    }


}
