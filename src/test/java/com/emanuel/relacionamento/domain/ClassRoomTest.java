package com.emanuel.relacionamento.domain;


import com.emanuel.relacionamento.repository.ClassRoomRepository;
import com.emanuel.relacionamento.repository.CourseRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClassRoomTest {

    @Autowired
    ClassRoomRepository classRoomRepository;

    @Autowired
    CourseRepository courseRepository;

    @Test
    public void getAllClazz() {

        List<ClassRoom> list = classRoomRepository.findAll();
        list.forEach(x -> System.out.println(x.getId() +"_"+ x.getDateOfStartCourse()));
    }

    @Test
    public void getAllClazzFromCourse() {

        //Relacionamento 1:N: caso se precisa buscar a lista completa, usar spring data pra isso é uma boa opção

        var course = courseRepository.getOne(1l);
        classRoomRepository.findByCourse(course)
                .forEach(c -> System.out.println(c.getId()));
    }

}
