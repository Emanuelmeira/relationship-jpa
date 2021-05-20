package com.emanuel.relacionamento.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "DISCIPLINA", schema = "public")
public class Subject {

    public Subject() {
        this.courses = new HashSet<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_disciplina")
    private Long id;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_departamento")
    private Department department;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)   //Disciplina depende de uma unica disciplina.. caso precise depender de mais de uma, precisa de outra tabela...
    @JoinColumn(name = "cod_disciplina_depende", referencedColumnName = "cod_disciplina", nullable = true)
    private Subject subjectDepend;

    @Column(name = "num_alunos")
    private Integer numberStudents;

    @Column(name = "nome_disciplina")
    private String name;

    @Column(name = "carga_horaria")
    private Integer workload;

    @Column(name = "descricao")
    private String description;

    @ManyToMany
    @JoinTable(name = "curso_disciplina", // nome da tabela de relacionamento
            joinColumns = @JoinColumn(name = "cod_disciplina"), // referencia ao id da tabela dominante
            inverseJoinColumns = @JoinColumn(name = "cod_curso")) // referencia ao id da tabela dominada
    private Set<Course> courses;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return id.equals(subject.id) &&
                Objects.equals(department, subject.department) &&
                Objects.equals(subjectDepend, subject.subjectDepend) &&
                Objects.equals(numberStudents, subject.numberStudents) &&
                Objects.equals(name, subject.name) &&
                Objects.equals(workload, subject.workload) &&
                Objects.equals(description, subject.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, department, subjectDepend, numberStudents, name, workload, description);
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Subject getSubjectDepend() {
        return subjectDepend;
    }

    public void setSubjectDepend(Subject subjectDepend) {
        this.subjectDepend = subjectDepend;
    }

    public Integer getNumberStudents() {
        return numberStudents;
    }

    public void setNumberStudents(Integer numberStudents) {
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
}
