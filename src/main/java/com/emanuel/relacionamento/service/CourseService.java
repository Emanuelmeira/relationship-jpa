package com.emanuel.relacionamento.service;

import com.emanuel.relacionamento.domain.Course;
import com.emanuel.relacionamento.domain.dto.CourseDTO;
import com.emanuel.relacionamento.repository.CourseRepository;
import com.emanuel.relacionamento.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CourseService {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private CourseRepository courseRepository;


    public Course create(CourseDTO courseDTO) {

        var department = departmentRepository.getOne(courseDTO.getDepartmentId());
        var courseToSave = courseDTO.toEntity();
        courseToSave.setDepartment(department);
        return courseRepository.save(courseToSave);
    }
}
