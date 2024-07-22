package org.example.githubclient.controller;

import lombok.RequiredArgsConstructor;
import org.example.githubclient.service.GItHubApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
public class GithubController {

    @Autowired
    private GItHubApiService gItHubApiService;

    @GetMapping("/github/{username}/repos")
    public CompletableFuture<String> getUserRepos(@PathVariable(name = "username") String username){
        return gItHubApiService.getUserRepos(username);
    }

}
