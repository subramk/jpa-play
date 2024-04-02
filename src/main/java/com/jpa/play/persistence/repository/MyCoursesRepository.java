package com.jpa.play.persistence.repository;

import com.jpa.play.persistence.domain.MyBook;
import com.jpa.play.persistence.domain.MyCourses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyCoursesRepository extends JpaRepository<MyCourses, Long> {

    public String  deleteByTitle(String  title);

    public Long deleteCourseById(Long id);

}
