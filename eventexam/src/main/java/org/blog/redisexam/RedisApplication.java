package org.blog.redisexam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class RedisApplication implements CommandLineRunner {

    @Autowired
    PersonService personService;
    @Autowired
    RedisService redisService;
    public static void main(String[] args) {
        SpringApplication.run(RedisApplication.class,args);
    }

    @Override
    public void run(String... args) throws Exception {
        Person person = new Person();
        person.setId("kim");
        person.setName("kimhoho");
        person.setAge(44);

//        personService.savePerson(person);
//
//        Optional<Person> kim = personService.getPersonById("kim");
//        System.out.println(kim.get().getName());
//
//        Iterable<Person> allPerson = personService.getAllPersons();
//        allPerson.forEach(System.out::println);

        //redisService 이용
        String key = "123key";
        String value="{\"name\":\"John\",\"age\":30}";
        redisService.saveJsonWithTTL(key,value,20);//20초동안 유지

        String retrievedValue = redisService.getJson(key);//20초 전 데이터검색
        System.out.println("Retrieved JSON: "+retrievedValue);

        Thread.sleep(61000);
        retrievedValue = redisService.getJson(key);//20초 후 데이터검색 null
        System.out.println("Retrieved JSON after TTL:"+retrievedValue);
    }
}
