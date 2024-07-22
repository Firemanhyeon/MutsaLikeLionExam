package org.example.githubclientasync.controller;

import org.example.githubclientasync.dto.Repository;
import org.example.githubclientasync.dto.User;
import org.example.githubclientasync.service.GitHubApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
public class GithubController {

    @Autowired
    private GitHubApiService gitHubApiService;

    @GetMapping("/github/{username}/repos")
    public CompletableFuture<List<Repository>> getUserRepos(@PathVariable(name = "username") String username){
        return gitHubApiService.getUserRepos(username);
    }
    @GetMapping("/github/{username}/followers")
    public CompletableFuture<List<User>> getUserFollowers(@PathVariable(name = "username") String username){
        return gitHubApiService.getUserFollowers(username);
    }
    @GetMapping("/github/{username}/followings")
    public CompletableFuture<List<User>> getUserFollowings(@PathVariable(name = "username") String username){
        return gitHubApiService.getUserFollowings(username);
    }

    @GetMapping("/github/{username}/all")
    public CompletableFuture<String> getUserDetails(@PathVariable(name = "username") String username){
        CompletableFuture<List<Repository>> repoFuture =gitHubApiService.getUserRepos(username);
        CompletableFuture<List<User>> followersFuture =gitHubApiService.getUserFollowers(username);
        CompletableFuture<List<User>> followingsFuture =gitHubApiService.getUserFollowings(username);
        System.out.println("준비");
        return CompletableFuture.allOf(repoFuture,followersFuture,followingsFuture)
                .thenApply(v->{
                    List<Repository> repos = repoFuture.join();
                    List<User> followers = followersFuture.join();
                    List<User> following = followingsFuture.join();
                    return formatResult(repos,followers.size(),following.size());
                });

    }
    private String formatResult(List<Repository> repos, int followersCount, int followingCount) {
        StringBuilder result = new StringBuilder();
        result.append("<ul>");
        for (Repository repo : repos) {
            result.append("<li>");
            result.append("<strong>").append(repo.getName()).append("</strong><br>");
            result.append("Followers: ").append(followersCount).append("<br>");
            result.append("Following: ").append(followingCount).append("<br>");
            result.append("</li>");
        }
        result.append("</ul>");
        return result.toString();
    }

}
