package com.laljisingh.hibernateMapping.controller;


import com.laljisingh.hibernateMapping.model.*;
import com.laljisingh.hibernateMapping.repository.BookRepository;
import com.laljisingh.hibernateMapping.repository.CourseRepository;
import com.laljisingh.hibernateMapping.repository.HostelRepository;
import com.laljisingh.hibernateMapping.service.StudentService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;
    @Autowired
    HostelRepository hostelRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    CourseRepository courseRepository;

    @PostMapping("/add-student")
    public String addStudent(@RequestBody String newStudent){
        JSONObject json = new JSONObject(newStudent);
        Student student = setStudent(json);
        studentService.addStudent(student);
        return "Student Added";
    }
    @GetMapping("/getAll-Student")
    public List<Student> getAllStudent(){
        return studentService.getAlStudent();
    }
    @DeleteMapping("/delete-student/{id}")
    public String deleteStudent(@PathVariable String id){
        return studentService.deleteStudent(Integer.valueOf(id));
    }


    private Student setStudent(JSONObject json) {
        Student std=new Student();
        std.setName(json.getString("name"));
        std.setAge(json.getString("age"));
        std.setPhoneNumber(json.getString("phone"));
        std.setBranch(json.getString("branch"));
        std.setDepartment(json.getString("department"));

        Address add=new Address();

        add.setCountry(json.getString("country"));
        add.setLandmark(json.getString("landmark"));
        add.setDistrict(json.getString("district"));
        add.setState(json.getString("state"));
        add.setZipcode(json.getString("zipcode"));
        std.setAddress(add);

        String hid = json.getString("hostel_id");

        Hostel hstl=null;
        for (Hostel hostel : hostelRepository.findAll()) {
            if(hostel.getHostel_id()==(Integer.valueOf(hid))){
                hstl = hostel;
                break;
            }
        }
        std.setHostel(hstl);

        List<Book> BookList=new ArrayList<>();
        String bid = json.getString("book_id");
        for (Book book : bookRepository.findAll()) {
            if(book.getBook_Id()==(Integer.valueOf(bid))){
                BookList.add(book);
            }
        }
        std.setBookList(BookList);

        List<Course> CourseList=new ArrayList<>();
        String cid = json.getString("course_id");
        for (Course course : courseRepository.findAll()) {
            if(course.getCourse_Id()==(Integer.valueOf(cid))){
                CourseList.add(course);
            }
        }
        std.setCourseList(CourseList);

        return std;
    }
}
