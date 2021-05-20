package com.emanuel.relacionamento.repository;

import com.emanuel.relacionamento.domain.Course;
import com.emanuel.relacionamento.domain.Department;
import com.emanuel.relacionamento.domain.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    Set<Course> findByDepartment(Department department);

}
