package com.emanuel.relacionamento.repository.spec;

import com.emanuel.relacionamento.domain.ClassRoom;
import com.emanuel.relacionamento.domain.Course;
import com.emanuel.relacionamento.domain.Student;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Student.class)
public abstract class Student_ {


    public static volatile SingularAttribute<Student, ClassRoom> classRoom;
    public static final String CLASSROOM = "classRoom";

    public static volatile SingularAttribute<Student, Course> course;
    public static final String COURSE = "course";

    public static volatile SingularAttribute<Student, String> name;
    public static final String NAME = "name";

    public static volatile SingularAttribute<Student, String> id;
    public static final String ID = "id";

    public static volatile SingularAttribute<Student, String> email;
    public static final String EMAIL = "email";




}
