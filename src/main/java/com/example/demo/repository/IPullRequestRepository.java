package com.example.demo.repository;

import com.example.demo.model.PullRequest;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPullRequestRepository extends JpaRepository<PullRequest, Integer> {

    List<PullRequest> findByAuthorIdAndStatusOrderByCreatedAtDesc(String title, String status);

}
