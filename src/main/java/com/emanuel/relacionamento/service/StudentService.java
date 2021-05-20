package com.emanuel.relacionamento.service;

import com.emanuel.relacionamento.domain.Student;
import com.emanuel.relacionamento.repository.StudentRepository;
import com.emanuel.relacionamento.repository.spec.StudentSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    //TODO Slice não realiza count na base para buscar o getTotalElements, economizando tempo para a resposta
    public Slice<Student> getAll(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    public Page<Student> getAll2(Pageable pageable) {

        //obtem lista para conversão em response, caso necessario
        var pageStudents =  studentRepository.findAll(pageable);

        //remotando page com nova lista de elementos
        Page<Student> pages = new PageImpl<>(pageStudents.getContent(), pageable, pageStudents.getTotalElements());

        return pages;
    }

    public Slice<Student> getByFilters(String name, String email, Pageable pageable) {

        return studentRepository.findAll(StudentSpecification.likeName(name)
                .or(StudentSpecification.equalEmail(email)), pageable);
    }
}
