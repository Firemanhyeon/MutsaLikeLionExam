package org.example.githubclientasync.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)//JSON에 값을 가져왔더니 다른값들도 많은데 필드에 없는건 무시한다.
@Getter
@Setter
public class Repository {
    private String name;

}
