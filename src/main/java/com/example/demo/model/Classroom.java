package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "classrooms")
public class Classroom {

    @Id
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "course_code")
    private String courseCode;

    @Column(name = "semester")
    private String semester;

    @OneToMany(mappedBy = "classroomId")
    @JsonIgnore
    List<Assignment> assignments;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    @JsonIgnore
    private User teacherId;

}
