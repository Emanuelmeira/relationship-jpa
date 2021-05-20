package com.emanuel.relacionamento.domain.dto;

import com.emanuel.relacionamento.domain.Subject;

public class SubjectDTO {

    private Long departmentId;
    private int numberStudents;
    private String name;
    private Integer workload;
    private String description;
    private Long subjectDependId;

    public Long getSubjectDependId() {
        return subjectDependId;
    }

    public void setSubjectDependId(Long subjectDependId) {
        this.subjectDependId = subjectDependId;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public int getNumberStudents() {
        return numberStudents;
    }

    public void setNumberStudents(int numberStudents) {
        this.numberStudents = numberStudents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWorkload() {
        return workload;
    }

    public void setWorkload(Integer workload) {
        this.workload = workload;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Subject toEntity() {
        Subject subject = new Subject();
        subject.setWorkload(getWorkload());
        subject.setNumberStudents(getNumberStudents());
        subject.setDescription(getDescription());
        subject.setName(getName());
        return subject;
    }
}
