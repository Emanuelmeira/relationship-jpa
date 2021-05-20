package com.emanuel.relacionamento.service;

import com.emanuel.relacionamento.domain.ClassRoom;
import com.emanuel.relacionamento.domain.dto.ClassRoomDTO;
import com.emanuel.relacionamento.repository.ClassRoomRepository;
import com.emanuel.relacionamento.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ClassService {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private ClassRoomRepository classRoomRepository;


    public ClassRoom create(ClassRoomDTO courseDTO) {

        var course = courseRepository.getOne(courseDTO.getCourseId());
        var clazz = courseDTO.toEntity();
        clazz.setCourse(course);
        classRoomRepository.save(clazz);
        return clazz;
    }
}
