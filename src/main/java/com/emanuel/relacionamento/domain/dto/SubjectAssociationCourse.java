package com.emanuel.relacionamento.domain.dto;

import java.util.List;

public class SubjectAssociationCourse {

    private Long subjectId;
    private List<Long> coursesId;

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public List<Long> getCoursesId() {
        return coursesId;
    }

    public void setCoursesId(List<Long> coursesId) {
        this.coursesId = coursesId;
    }
}
