package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Entity
@Table(name = "repositories")
public class Repository {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private boolean isTemplate;
    private boolean isActive;
    private LocalDateTime created_at;

    @ManyToOne
    @JoinColumn(name = "assigment_id")
    @JsonIgnore
    private Assignment assignmentId;

    @OneToMany(mappedBy = "repositoryId")
    @JsonIgnore
    private List<Commit> commitRepositoryId;

    @OneToMany(mappedBy = "repositoryId")
    @JsonIgnore
    private List<PullRequest> PullRepositoryId;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    @JsonIgnore
    private User ownerId;

}
