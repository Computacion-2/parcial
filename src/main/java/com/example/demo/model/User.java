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

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(name = "full_name", nullable = false)
    private String role;

    @Column(nullable = false)
    private String fullName;

    @OneToMany(mappedBy = "teacherId", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Classroom> ownedRepositories;

    @OneToMany(mappedBy = "owner_id", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<PullRequest> taughtRepositories;

    @OneToMany(mappedBy = "author_id", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<PullRequest> authoredPullRequests;

    @OneToMany(mappedBy = "reviewerId", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<PullRequest> reviewedPullRequests;

    @OneToMany(mappedBy = "authorId", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Commit> author_id;

    @OneToMany(mappedBy = "owner_id", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Repository> owner_id;
}
