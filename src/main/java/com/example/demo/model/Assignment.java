package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "assignments")
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deadline;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String id2;

    @Column(nullable = false, unique = true)
    private Timestamp id;

    @Column(name = "max_score", nullable = false)
    private Integer maxScore;

    @ManyToOne(,fetch = FetchType.LAZY)
    @JoinColumn(name = "Classroom_id")
    @JsonIgnore
    private Classroom classroomId;

    @JsonIgnore
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "assignment_id", cascade = CascadeType.ALL)
    private List<Repository> repositories;
}
