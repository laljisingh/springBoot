package com.laljisingh.hibernateMapping.controller;


import com.laljisingh.hibernateMapping.model.Course;
import com.laljisingh.hibernateMapping.model.Student;
import com.laljisingh.hibernateMapping.repository.StudentRepository;
import com.laljisingh.hibernateMapping.service.CourseService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CourseController {
    @Autowired
    CourseService courseService;
    @Autowired
    StudentRepository studentRepository;

    @PostMapping("/add-course")
    public Course addCourse(@RequestBody String newCourse) {
        JSONObject json = new JSONObject(newCourse);
        Course course = setCourse(json);
        Course cs = courseService.addCourse(course);
        return cs;
    }
    @GetMapping("/get-allCourse")
    public List<Course> getAllCourse(){
        return courseService.getAllCourse();
    }

    @DeleteMapping("/delete-course/{id}")
    public String deleteStudent(@PathVariable String id){
        return courseService.deleteCourse(Integer.valueOf(id));
    }

    private Course setCourse(JSONObject json) {
        Course course=new Course();
        course.setDescription(json.getString("description"));
        course.setDuration(json.getString("duration"));
        course.setTitle(json.getString("title"));
        List<Student> sList=new ArrayList<>();
        String sid = json.getString("student_id");
        for (Student student : studentRepository.findAll()) {
            if(student.getStudent_Id()==(Integer.valueOf(sid))){
                sList.add(student);
            }
        }
        course.setStudentList(sList);
        return course;
    }


}
