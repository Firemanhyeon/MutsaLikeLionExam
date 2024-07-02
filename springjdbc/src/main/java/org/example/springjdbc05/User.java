package org.example.springjdbc05;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@ToString
public class User {
    private Long id;
    private String name;
    private String email;
}
