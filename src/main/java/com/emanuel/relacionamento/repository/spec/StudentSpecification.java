package com.emanuel.relacionamento.repository.spec;


import com.emanuel.relacionamento.domain.Student;
import org.springframework.data.jpa.domain.Specification;

public class StudentSpecification {

    public static Specification<Student> likeName(String name){
        if(name == null){
            return null;
        }
        return (root, criteriaQuery, criteriaBuilder) -> {
            return criteriaBuilder.like( root.get(Student_.NAME), "%" + name + "%" );
        };
    }

    public static Specification<Student> equalEmail(String email){
        if(email == null){
            return null;
        }
        return (root, criteriaQuery, criteriaBuilder) -> {
            return criteriaBuilder.equal( root.get(Student_.EMAIL), email );
        };
    }
}
