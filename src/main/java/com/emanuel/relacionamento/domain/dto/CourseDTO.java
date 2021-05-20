package com.emanuel.relacionamento.domain.dto;


import com.emanuel.relacionamento.domain.Course;

public class CourseDTO {

    private Long departmentId;
    private String name;

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Course toEntity() {
        Course course = new Course();
        course.setName(this.name);
        return course;
    }
}
