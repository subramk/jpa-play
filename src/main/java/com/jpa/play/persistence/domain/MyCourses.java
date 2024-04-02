package com.jpa.play.persistence.domain;


import jakarta.persistence.*;
import lombok.*;

/**
 * MyCourses has A ONE TO ONE Relationship with MyCoursesDetails.
 **/

@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "MYCOURSES")
@Entity

public class MyCourses {
    @Id
    @SequenceGenerator(name = "mycourses_id_seq", sequenceName = "mycourses_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mycourses_id_seq")


    private Long id;

    @Column(name = "title")
    private String title;

    @OneToOne(mappedBy = "myCourses", optional = false ,cascade = CascadeType.ALL)
    private MyCoursesDetails myCoursesDetails;
}
