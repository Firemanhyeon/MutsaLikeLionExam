package org.example.javaspringmvc.friend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Friend {
    private Long id;
    private String name;
    private String email;
}
