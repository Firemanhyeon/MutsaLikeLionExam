package org.example.message2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//설정들을 분할한다.
@Configuration
@Import(ServiceConfig.class)
public class MainConfig {
    //추가적인 설정이 있다면 여기에

    MainConfig(){
        System.out.println("main config loaded");
    }
}
