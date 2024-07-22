package org.example.githubclientasync.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.githubclientasync.dto.Repository;
import org.example.githubclientasync.dto.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class GitHubApiService {

    @Value("${github.api.url}")
    private String githubApiUrl;

    @Value("${github.api.token}")
    private String githubApiToken;

    private final RestTemplate restTemplate;//api요청보낼때 담는 객체
    private final ObjectMapper objectMapper;//json객체변환

    public GitHubApiService() {
        this.restTemplate=new RestTemplate();
        this.objectMapper = new ObjectMapper();
    }

    //레파지토리 목록
    @Async("taskExecutor")//AsyncConfig에서 선언해둔 스레드 풀을 사용하겠다
    public CompletableFuture<List<Repository>> getUserRepos(String username){

        return CompletableFuture.supplyAsync(()->{//리턴값이 있으면 supplyAsync , 없으면 run
            String url = githubApiUrl+"/users/"+username+"/repos";
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("Authorization" , "Bearer "+githubApiToken);

            HttpEntity<String> entity = new HttpEntity<>(httpHeaders);

            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,entity,String.class);

            try {
                return objectMapper.readValue(response.getBody(), new TypeReference<List<Repository>>() {});
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        });
    }
    //팔로워목록
    //getuserFollowers(String username) -- /users/{username}/followers

    @Async("taskExecutor")
    public CompletableFuture<List<User>> getUserFollowers(String username){
        return CompletableFuture.supplyAsync(()->{//리턴값이 있으면 supplyAsync , 없으면 run
            String url = githubApiUrl+"/users/"+username+"/followers";
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("Authorization" , "Bearer "+githubApiToken);

            HttpEntity<String> entity = new HttpEntity<>(httpHeaders);

            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,entity,String.class);

            try {
                return objectMapper.readValue(response.getBody(), new TypeReference<List<User>>() {});
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        });
    }

    //팔로잉목록
    //getUserFollowing(String username) -- /users/{username}/following
    @Async("taskExecutor")
    public CompletableFuture<List<User>> getUserFollowings(String username){
        return CompletableFuture.supplyAsync(()->{//리턴값이 있으면 supplyAsync , 없으면 run
            String url = githubApiUrl+"/users/"+username+"/following";
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("Authorization" , "Bearer "+githubApiToken);

            HttpEntity<String> entity = new HttpEntity<>(httpHeaders);

            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,entity,String.class);

            try {
                return objectMapper.readValue(response.getBody(), new TypeReference<List<User>>() {});
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
