package com.emanuel.relacionamento.repository;


import com.emanuel.relacionamento.domain.Course;
import com.emanuel.relacionamento.domain.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Set;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

    @Modifying // TODO necessario para SQL de 'delete e update'
    @Query(value = "delete from curso_disciplina cd where cd.cod_curso = :courseId and cd.cod_disciplina = :subjectId", nativeQuery = true)
    Integer deleteAssociateCourse(Long courseId, Long subjectId);

    //TODO pesquisar entidades relacionadas num N:M
    Set<Subject> findByCoursesIn(Set<Course> courses);

}
