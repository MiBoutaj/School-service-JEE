package com.school.controller;


import com.school.model.Course;
import com.school.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v3")
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping("/courses")
    public List<Course> getAll(){
        System.out.println("Liste  courses");
        return courseRepository.findAll();
    }
}
