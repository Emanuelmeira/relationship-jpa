package com.emanuel.relacionamento.domain.dto;

import com.emanuel.relacionamento.domain.ClassRoom;


import java.time.LocalDate;

public class ClassRoomDTO {
    private Long courseId;
    private int numberOfStudent;
    private String timeCourse;
    private LocalDate dateStart;
    private LocalDate dateEnd;

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public int getNumberOfStudent() {
        return numberOfStudent;
    }

    public void setNumberOfStudent(int numberOfStudent) {
        this.numberOfStudent = numberOfStudent;
    }

    public String getTimeCourse() {
        return timeCourse;
    }

    public void setTimeCourse(String timeCourse) {
        this.timeCourse = timeCourse;
    }

    public LocalDate getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDate dateStart) {
        this.dateStart = dateStart;
    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(LocalDate dateEnd) {
        this.dateEnd = dateEnd;
    }

    public ClassRoom toEntity() {
        ClassRoom classRoom = new ClassRoom();
        classRoom.setDateOfStartCourse(getDateStart());
        classRoom.setDateOfEndCourse(getDateEnd());
        classRoom.setTimeCourse(getTimeCourse());
        classRoom.setNumberOfStudent(getNumberOfStudent());
        return classRoom;
    }
}
