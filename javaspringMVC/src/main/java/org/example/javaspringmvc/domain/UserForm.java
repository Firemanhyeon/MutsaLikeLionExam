package org.example.javaspringmvc.domain;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class UserForm {

    @NotEmpty(message="Username 은 공백을 허용하지 않습니다")
    @Size(min=4,max=20, message = "Username은 4~20자 까지만 가능합니다")
    private String username;

    @NotEmpty(message="password 는 공백을 허용하지 않습니다")
    @Size(min=6,message = "비밀번호는 최소 5자이상입니다")
    private String password;
}
