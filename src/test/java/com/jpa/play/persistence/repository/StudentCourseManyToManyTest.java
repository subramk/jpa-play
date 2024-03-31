package com.jpa.play.persistence.repository;


import com.jpa.play.persistence.domain.Course;
import com.jpa.play.persistence.domain.Student;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

@DataJpaTest
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class StudentCourseManyToManyTest {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Container
    static PostgreSQLContainer database =
            new PostgreSQLContainer("postgres:12")
                    .withDatabaseName("postgres")
                    .withPassword("springboot")
                    .withUsername("springboot");

    @DynamicPropertySource
    static void setDatasourceProperties(DynamicPropertyRegistry propertyRegistry) {
        propertyRegistry.add("spring.datasource.url", database::getJdbcUrl);
        propertyRegistry.add("spring.datasource.password", database::getPassword);
        propertyRegistry.add("spring.datasource.username", database::getUsername);
    }

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
        courseRepository.saveAndFlush(course);
        courseRepository.saveAndFlush(course2);


        Student student = Student.builder().id(1L).name("Kasi").age(52).dept("Commerce").build();
        Set<Course> myCourses = new HashSet();
        myCourses.add(course);
        myCourses.add(course2);

        student.setCourses(myCourses);
        studentRepository.saveAndFlush(student);

        String linkTableSelect = "select count(*) from STUDENT_COURSE_LINK_TABLE";
        Integer rowsFound = jdbcTemplate.queryForObject(linkTableSelect,Integer.class);

        Assert.assertTrue( rowsFound == 2  );
    }

}
