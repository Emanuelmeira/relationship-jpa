package com.emanuel.relacionamento.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "TURMA", schema = "public")
public class ClassRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_turma")
    private Long id;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_curso")
    private Course course;

    @Column(name = "num_alunos_sala")
    private int numberOfStudent;

    @Column(name = "periodo")
    private String timeCourse;

    @Column(name = "data_inicio")
    private LocalDate dateOfStartCourse;

    @Column(name = "data_fim")
    private LocalDate dateOfEndCourse;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumberOfStudent() {
        return numberOfStudent;
    }

    public void setNumberOfStudent(int numberOfStudent) {
        this.numberOfStudent = numberOfStudent;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getTimeCourse() {
        return timeCourse;
    }

    public void setTimeCourse(String timeCourse) {
        this.timeCourse = timeCourse;
    }

    public LocalDate getDateOfStartCourse() {
        return dateOfStartCourse;
    }

    public void setDateOfStartCourse(LocalDate dateOfStartCourse) {
        this.dateOfStartCourse = dateOfStartCourse;
    }

    public LocalDate getDateOfEndCourse() {
        return dateOfEndCourse;
    }

    public void setDateOfEndCourse(LocalDate dateOfEndCourse) {
        this.dateOfEndCourse = dateOfEndCourse;
    }
}
