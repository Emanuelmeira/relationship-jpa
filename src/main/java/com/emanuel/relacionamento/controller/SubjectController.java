package com.emanuel.relacionamento.controller;


import com.emanuel.relacionamento.domain.Course;
import com.emanuel.relacionamento.domain.Subject;
import com.emanuel.relacionamento.domain.dto.SubjectAssociationCourse;
import com.emanuel.relacionamento.domain.dto.SubjectDTO;
import com.emanuel.relacionamento.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/entity/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @PostMapping
    public ResponseEntity<Subject> create(@RequestBody SubjectDTO subjectDTO){
        return ResponseEntity.ok(subjectService.create(subjectDTO));
    }

    @PostMapping("/associationCourse")
    public ResponseEntity.BodyBuilder createCourseAssociation(@RequestBody SubjectAssociationCourse subjectAssociationCourse ){
        subjectService.createAssociationCourse(subjectAssociationCourse);
        return ResponseEntity.ok();
    }

    @PostMapping("/removeAssociationCourse")
    public ResponseEntity removeCourseAssociation(@RequestBody SubjectAssociationCourse subjectAssociationCourse ){
        subjectService.removeAssociationCourse(subjectAssociationCourse);
        return ResponseEntity.ok(ResponseEntity.noContent());
    }


    //TODO quero todos os courses relacionados com o ID desse subject
//    @GetMapping("/{subjectId}/course")
//    public ResponseEntity<Set<Course>> removeCourseAssociation(@PathVariable("subjectId") Long subjectId){
//        return ResponseEntity.ok(subjectService.findAllSubjectByCourses(subjectId));
//    }


}
