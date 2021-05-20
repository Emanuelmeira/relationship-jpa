package com.emanuel.relacionamento.controller;


import com.emanuel.relacionamento.domain.Department;
import com.emanuel.relacionamento.repository.CourseRepository;
import com.emanuel.relacionamento.repository.SubjectRepository;
import com.emanuel.relacionamento.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/entity/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private CourseRepository courseRepository;

    @PostMapping
    public ResponseEntity<Department> create(@RequestBody Department department){
        return ResponseEntity.ok(departmentService.create(department));
    }

}
