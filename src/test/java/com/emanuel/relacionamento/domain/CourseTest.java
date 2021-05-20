package com.emanuel.relacionamento.domain;

import com.emanuel.relacionamento.repository.CourseRepository;
import com.emanuel.relacionamento.repository.DepartmentRepository;
import org.hibernate.Hibernate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseTest {

    @Autowired
    CourseRepository courseRepository;
    @Autowired
    DepartmentRepository departmentRepository;

    @Test
    public void getAll(){

        List<Course> list = courseRepository.findAll();
        list.forEach(x -> {
            System.out.println(x.getId() +"_"+ x.getName());
        });
    }

    @Test
    @Transactional
    public void getAllWithSubjects(){

        List<Course> list = courseRepository.findAll();
        list.forEach(x -> {

            System.out.println(" \n"+ x.getName() + " se relaciona com materias");
//            Hibernate.initialize(x.getSubjects()); // é possivel 'acordar' a coleção usando esse meteodo do JPA dentro de uma transação aberta
//            //x.getSubjects().size(); 2 opcao, tbm pode ser usado
//
//            Optional.ofNullable(x.getSubjects())
//                    .orElseGet(HashSet::new)
//                    .forEach(s -> System.out.println(s.getName()));
        });
    }

    @Test
    public void addNewCourseWithDepartment(){

        //Para casos de busca e associação em cadastros.. é melhor usar o getOne, por que o mesmo
        //busca apenas uma referencia do objeto na base (proxy lazy)
        //então esse objeto é associado e salvo.. gerando apenas uma unica query que é p Insert..

        //usando o findById, o objeto fisico é buscado do banco, gerando 2 sql, um de select e outro de insert
        var department = departmentRepository.getOne(1l);
        Course course = new Course();

        course.setName("Nutrição");
        course.setDepartment(department);
        courseRepository.save(course);
    }


}
