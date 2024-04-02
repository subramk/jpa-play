package com.jpa.play.persistence.repository;

import com.jpa.play.persistence.domain.MyCoursesDetails;
import com.jpa.play.persistence.domain.MyCourses;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.Assert.assertEquals;

/*
*********************************************************************************
        MyCourses has a ONE-TO-ONE relationship with MyCoursesDetails
*********************************************************************************
*/


@DataJpaTest
public class MyCoursesOneToOneRepositoryTest extends  AbstractBaseTestContainer {

    @Autowired
    private MyCoursesRepository myCoursesRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @BeforeEach
    public void setupData() {

    }

    @Test
    public void saveMyCourseWithCourseDetails() {

        MyCourses myCourses = new MyCourses();
        myCourses.setTitle("Statistics");
        // myCourses.setId(); will be done by the Sequence_Generator.

        MyCoursesDetails myCoursesDetails = new MyCoursesDetails();
        myCoursesDetails.setDescription("stats for beginners");
        myCoursesDetails.linkCourseDetailsWith(myCourses);

        myCourses.setMyCoursesDetails(myCoursesDetails);

        MyCourses postSave = myCoursesRepository.saveAndFlush(myCourses);
        assertEquals("Statistics", postSave.getTitle());
        assertEquals("stats for beginners", postSave.getMyCoursesDetails().getDescription());

        String query1   = "select count(*) as count from MYCOURSES";
        int  rowsFound1 = jdbcTemplate.queryForObject(query1,Integer.class);
        assertEquals( rowsFound1, 1) ;

        String query2   = "select count(*) as count from MYCOURSEDETAILS";
        int  rowsFound2 = jdbcTemplate.queryForObject(query2,Integer.class);
        assertEquals( rowsFound2, 1) ;

    }


    @Test
    @Transactional // Required @Transactional for all tests where we need to flush the delete() within the transaction
    // and then do an assert on row Count.
    public void deleteCourseShouldCascadeDeleteCourseDetails() {

        MyCourses myCourses = new MyCourses();
        myCourses.setTitle("Mathematics");

        MyCoursesDetails myCoursesDetails = new MyCoursesDetails();
        myCoursesDetails.setDescription("Mathematics for beginners");
        myCoursesDetails.linkCourseDetailsWith(myCourses);
        myCourses.setMyCoursesDetails(myCoursesDetails);

        MyCourses postSave = myCoursesRepository.saveAndFlush(myCourses);
        assertEquals("Mathematics", postSave.getTitle());
        assertEquals("Mathematics for beginners", postSave.getMyCoursesDetails().getDescription());

        long rowsCount = myCoursesRepository.deleteCourseById(postSave.getId());
    }
}
