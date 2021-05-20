package com.emanuel.relacionamento.controller;


import com.emanuel.relacionamento.domain.Course;
import com.emanuel.relacionamento.domain.dto.CourseDTO;
import com.emanuel.relacionamento.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/entity/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public ResponseEntity<Course> create(@RequestBody CourseDTO courseDTO){
        return ResponseEntity.ok(courseService.create(courseDTO));
    }

    //TODO quero todos os subjects relacionados com o ID desse course
}
