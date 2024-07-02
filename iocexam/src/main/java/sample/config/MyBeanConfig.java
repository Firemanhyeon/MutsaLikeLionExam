package sample.config;

import org.springframework.context.annotation.*;
import sample.bean.MyBean;

@ComponentScan(basePackages = "sample")

public class MyBeanConfig {
    //<bean id="myBean" class = "sample.bean.MyBean"/>
    //1과2는 싱글톤 3은 프로토타입


//    @Bean
//    public MyBean myBean1(){
//        return new MyBean();
//    }

    @Bean
    public MyBean myBean2(){
        return new MyBean();
    }
    @Bean
    @Scope("prototype")
    public MyBean myBean3(){
        return new MyBean();
    }
    @Bean
    @Scope("prototype")
    public MyBean myBean4(){
        return new MyBean("hahah",123);
    }

}
