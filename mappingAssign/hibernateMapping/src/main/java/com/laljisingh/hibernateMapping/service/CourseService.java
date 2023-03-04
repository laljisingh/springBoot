package com.laljisingh.hibernateMapping.service;


import com.laljisingh.hibernateMapping.model.Course;
import com.laljisingh.hibernateMapping.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;
    public Course addCourse(Course course) {
        Course cs =  courseRepository.save(course);
        return cs;
    }

    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }

    public String deleteCourse(Integer valueOf) {
        courseRepository.deleteById(valueOf);
        return "Deleted";
    }
}
