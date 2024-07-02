package org.example.jdbc01;

import lombok.*;


@AllArgsConstructor
@Getter
@ToString
@NoArgsConstructor
@Setter
public class User {
    private Long id ;
    private String name ;
    private String email;

}
