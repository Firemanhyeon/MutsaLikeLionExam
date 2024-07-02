package org.example.jdbc02.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
@Setter
public class User {
    private Long id;
    private String name;
    private String email;
}
