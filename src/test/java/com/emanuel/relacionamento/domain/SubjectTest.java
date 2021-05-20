package com.emanuel.relacionamento.domain;

import com.emanuel.relacionamento.repository.CourseRepository;
import com.emanuel.relacionamento.repository.DepartmentRepository;
import com.emanuel.relacionamento.repository.SubjectRepository;
import org.hibernate.Hibernate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SubjectTest {

    @Autowired
    SubjectRepository subjectRepository;
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    CourseRepository courseRepository;

    @Test
    public void getAll(){
        List<Subject> list = subjectRepository.findAll();
        list.forEach(x -> {
            System.out.println(x.getId() +" "+x.getName() + " Depende de: ");

            if(x.getSubjectDepend() != null){
                System.out.println(x.getSubjectDepend().getName());
            }else {
                System.out.println("Nenhuma");
            }
        });
    }

    @Test
    public void addNew(){

        var course = courseRepository.getOne(4l); // pegar so a referencia para associação
        var subjectDepend = subjectRepository.getOne(3l);  // pegar so a referencia para associação

        departmentRepository.findById(4l).ifPresent(d -> {

            Subject subject  = new Subject();
            subject.setName("Engenharia 1");
            subject.setDescription("Materia que retrata o basico da engenharia");
            subject.setNumberStudents(30);
            subject.setWorkload(120);
            subject.setDepartment(d);

            subject.setSubjectDepend(subjectDepend); //adc diciplina dependente
            subject.getCourses().add(course); // construindo o relacionamento com courso

            subjectRepository.save(subject);
        });
    }

    @Test
    @Transactional
    public void addNewCourseToSubject(){

        var course1 = courseRepository.findById(1l).get();
        var course2 = courseRepository.findById(2l).get();
        var course3 = courseRepository.findById(3l).get();

        var subject = subjectRepository.findById(7l);
        subject.ifPresent(sub -> {

            sub.getCourses().add(course1);
            sub.getCourses().add(course2);
            sub.getCourses().add(course3);
            subjectRepository.save(sub);
        });
    }

    @Test
    @Transactional
    public void getAllCourses(){

        List<Subject> list = subjectRepository.findAll();
        list.forEach(x -> {

            System.out.println("\n "+x.getName() + " - É utilizada no curso: ");
            Hibernate.initialize(x.getCourses());

            Optional.ofNullable(x.getCourses())
                    .orElseGet(HashSet::new)
                    .forEach(c -> System.out.println(c.getName()));
        });
    }

    @Test
    @Transactional
    public void removeSubjectWithCourse(){
        //removendo associação pelo lado dominante

        var course = courseRepository.findById(1l).get();
        var optSubject = subjectRepository.findById(4l);

        optSubject.ifPresent(subj -> {

            Hibernate.initialize(subj.getCourses());
            subj.getCourses().forEach(x -> System.out.println(x.getName()));
            subj.getCourses().clear();//remove(course);

            subjectRepository.save(subj);
        });
    }

}
