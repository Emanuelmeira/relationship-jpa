package com.emanuel.relacionamento.repository;

import com.emanuel.relacionamento.domain.ClassRoom;
import com.emanuel.relacionamento.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ClassRoomRepository extends JpaRepository<ClassRoom, Long> {

    Set<ClassRoom> findByCourse(Course course);
}
