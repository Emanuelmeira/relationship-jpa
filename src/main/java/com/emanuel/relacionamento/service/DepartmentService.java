package com.emanuel.relacionamento.service;

import com.emanuel.relacionamento.domain.Department;
import com.emanuel.relacionamento.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;


    public Department create(Department department){

        return departmentRepository.save(department);
    }
}
