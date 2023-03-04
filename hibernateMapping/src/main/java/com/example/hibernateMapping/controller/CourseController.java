package com.example.hibernateMapping.controller;

import com.example.hibernateMapping.model.Course;
import com.example.hibernateMapping.service.CourseService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
    @Autowired
    CourseService courseService;


    public String addCourse(@RequestBody String newCourse) {
        JSONObject json = new JSONObject(newCourse);
        Course course = setCourse(json);
        courseService.addCourse(course);
        return course.toString();
    }

    private Course setCourse(JSONObject json) {
        Course course=new Course();
        course.setDescription(json.getString("description"));
        course.setDuration(json.getString("duration"));
        course.setTitle(json.getString("title"));

        return course;
    }


}
