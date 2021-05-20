package com.emanuel.relacionamento.controller;


import com.emanuel.relacionamento.domain.Student;
import com.emanuel.relacionamento.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/entity/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping //ex api/entity/student?page=1&size=2
    public Slice<Student> getAll(Pageable pageable){
        return studentService.getAll(pageable);
    }

    @RequestMapping("/pagination") //ex api/entity/student?page=1&size=2&sort=name,id
    public Page<Student> getAllWIthSorting(Pageable pageable){

        return studentService.getAll2(pageable);
    }

    @RequestMapping("/filter") //ex api/entity/student?name=emanuel&email=emanuel@gmail.com&page=1&size=2
    public Slice<Student> getByFilters(@RequestParam(name = "name") String name, @RequestParam(required = false) String email, Pageable pageable){
        return studentService.getByFilters(name, email,pageable);
    }



}
