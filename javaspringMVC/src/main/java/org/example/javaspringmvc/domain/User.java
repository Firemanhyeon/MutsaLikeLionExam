package org.example.javaspringmvc.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class User {
    private String name ;
    private boolean checkAuth;

}
