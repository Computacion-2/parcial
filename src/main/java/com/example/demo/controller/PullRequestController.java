package com.example.demo.controller;

import com.example.demo.model.PullRequest;
import com.example.demo.model.User;
import com.example.demo.repository.IPullRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pull-requests")
@RequiredArgsConstructor
public class PullRequestController {

    @Autowired
    private IPullRequestRepository pullRequestRepository;

    @GetMapping("/consulta1")
    public List<PullRequest> findPullRequestsByNameCourseAndStatus(String title, String status) {

        return pullRequestRepository.findByAuthorIdAndStatusOrderByCreatedAtDesc("Computacion en Internet II - Grupo 1", "OPEN");
    }
}
