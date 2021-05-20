package com.emanuel.relacionamento.service;

import com.emanuel.relacionamento.domain.Subject;
import com.emanuel.relacionamento.domain.dto.SubjectAssociationCourse;
import com.emanuel.relacionamento.domain.dto.SubjectDTO;
import com.emanuel.relacionamento.repository.CourseRepository;
import com.emanuel.relacionamento.repository.DepartmentRepository;
import com.emanuel.relacionamento.repository.SubjectRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private CourseRepository courseRepository;


    public Subject create(SubjectDTO subjectDTO) {

        var department = departmentRepository.getOne(subjectDTO.getDepartmentId());
        var subjectToSave = subjectDTO.toEntity();
        subjectToSave.setDepartment(department);

        if(Objects.nonNull(subjectDTO.getSubjectDependId())){
            subjectToSave.setSubjectDepend(subjectRepository.getOne(subjectDTO.getSubjectDependId()));
        }

        return subjectRepository.save(subjectToSave);
    }


    public void createAssociationCourse(SubjectAssociationCourse subjectAssociationCourse) {

        var subject = subjectRepository.getOne(subjectAssociationCourse.getSubjectId());
        var courses=  subjectAssociationCourse
                .getCoursesId()
                .stream()
                .map(id -> courseRepository.findById(id).orElseThrow())
                .collect(Collectors.toSet());

        Hibernate.initialize(subject.getCourses());
        subject.getCourses().addAll(courses);

        subjectRepository.save(subject);
    }

    @Transactional
    public void removeAssociationCourse(SubjectAssociationCourse subjectAssociationCourse) {

        var subject = subjectRepository.getOne(subjectAssociationCourse.getSubjectId());
        var courses=  subjectAssociationCourse
                .getCoursesId()
                .stream()
                .map(id -> courseRepository.findById(id).orElseThrow())
                .collect(Collectors.toSet());

        Hibernate.initialize(subject.getCourses());
        subject.getCourses().removeAll(courses);
        subjectRepository.save(subject);

        // TODO caminho para remoção sem carregar a collection
        //subjectAssociationCourse.getCoursesId().forEach(id -> {
            //subjectRepository.deleteAssociateCourse(id, subjectAssociationCourse.getSubjectId());
        //});
    }

    @Transactional
    public Set<Subject> findAllSubjectByCourse(Long courseId) {

        var course = courseRepository.getOne(courseId);
        return subjectRepository.findByCoursesIn(Set.of(course));
    }


}
