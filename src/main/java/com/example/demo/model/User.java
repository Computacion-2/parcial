package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "role", nullable = false)
    private String role;

    @OneToMany(mappedBy = "teacherId", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Classroom> ownedRepositories;

    @OneToMany(mappedBy = "ownerId", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Repository> taughtRepositories;

    @OneToMany(mappedBy = "authorId", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<PullRequest> authoredPullRequests;

    @OneToMany(mappedBy = "reviewerId", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<PullRequest> reviewedPullRequests;

    @OneToMany(mappedBy = "authorId", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Commit> author_id;
}
