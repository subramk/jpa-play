package com.jpa.play.persistence.repository;


import com.jpa.play.persistence.domain.Course;
import com.jpa.play.persistence.domain.Student;
import org.junit.Assert;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertNotNull;

@DataJpaTest
public class StudentCourseManyToManyTest extends AbstractBaseTestContainer {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void contextLoads(){
        assertNotNull(database.getJdbcUrl());
        assertNotNull(database.getDriverClassName());
        assertNotNull(jdbcTemplate);
    }

    @Test
    @DisplayName("Save A Student with One Course")
    public void saveStudentWithCourse(){

        Course course =  Course.builder()
                                .id(200L)
                                .title("maths")
                                .fee(250.22)
                                .modules(2)
                                .abbreviation("Maths").build();

        Course course2 =  Course.builder()
                .id(300L)
                .title("statistics")
                .fee(400.22)
                .modules(3)
                .abbreviation("Statistics").build();

        // .saveAll() - not working
        courseRepository.save(course);
        courseRepository.save(course2);


        Student student = Student.builder().id(1L).name("Kasi").age(52).dept("Commerce").build();
        Set<Course> myCourses = new HashSet();
        myCourses.add(course);
        myCourses.add(course2);

        student.setCourses(myCourses);
        studentRepository.saveAndFlush(student); //saveAndFlush() before we assert.ss

        // ensure link table is updated.
        String linkTableSelect = "select count(*) from STUDENT_COURSE_LINK_TABLE";
        Integer rowsFound = jdbcTemplate.queryForObject(linkTableSelect,Integer.class);

        Assert.assertTrue( rowsFound == 2  );
    }

    @Test
    @Disabled
    @DisplayName(" Delete Student and check that course REMAINS ,but the LINK Table should NOT have any rows")
    public void deleteStudent(){
        // TODO
        // throw new UnsupportedOperationException();
    }
}
