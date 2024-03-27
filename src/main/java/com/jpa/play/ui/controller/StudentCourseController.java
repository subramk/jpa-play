package com.jpa.play.ui.controller;

import com.jpa.play.persistence.domain.Course;
import com.jpa.play.persistence.domain.Student;
import com.jpa.play.persistence.repository.CourseRepository;
import com.jpa.play.persistence.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/course")
public class StudentCourseController {

    // not ideal to wire Repository here,
    private final StudentRepository studentRepository;

    private final CourseRepository courseRepository;

    public StudentCourseController(final StudentRepository studentRepository, final CourseRepository courseRepository){
        this.studentRepository =  studentRepository;
        this.courseRepository = courseRepository;
    }


    @PostMapping
    public Student saveStudentWithCourse(@RequestBody final Student student){
        return   studentRepository.save(student);
    }

    @GetMapping
    public List<Student> findALlStudents(){
        return studentRepository.findAll();
    }

    @GetMapping("/{studentId}")
    public Student findStudent(@PathVariable final Long studentId){
        return studentRepository.findById(studentId).orElse(null);
    }
    @GetMapping("/find/{name}")
    public List<Student> findStudentsContainingByName(@PathVariable final String name){
        return studentRepository.findByNameContaining(name);
    }

    @GetMapping("/search/{price}")
    public List<Course> findCourseLessThanPrice(@PathVariable final double price){
        return courseRepository.findByFeeLessThan(price);
    }

}
