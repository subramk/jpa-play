package com.jpa.play.persistence.domain;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "MYCOURSEDETAILS")
@Entity
public class MyCoursesDetails {

    // Id here is FK to the MyCourses entity
    @Id
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")

    private MyCourses myCourses;

    @Column(name = "description")
    private String description;

    public void linkCourseDetailsWith(MyCourses myCourses){
        this.myCourses = myCourses;
    }




}
