package com.emanuel.relacionamento.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "CURSO", schema = "public")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_curso")
    private Long id;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_departamento")
    private Department department;

    @Column(name = "nome_curso")
    private String name;

//    @ManyToMany(mappedBy = "courses")
//    private Set<Subject> subjects;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(id, course.id) &&
                Objects.equals(department, course.department) &&
                Objects.equals(name, course.name); //&&
//                Objects.equals(subjects, course.subjects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, department, name);
    }

//    public Set<Subject> getSubjects() {
//        return subjects;
//    }
//
//    public void setSubjects(Set<Subject> subjects) {
//        this.subjects = subjects;
//    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Quando se tenta usar a propria entidade para retorno como JSON, e a mesma possui um atributo mapeado como LAZY..
    // é necessario usar o @JsonIgnoreProperties para ignorar algumas class internas do JPA, não mapeando assim a classe para o retorno

}
