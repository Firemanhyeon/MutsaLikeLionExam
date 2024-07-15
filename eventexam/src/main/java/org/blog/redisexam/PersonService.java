package org.blog.redisexam;

import lombok.RequiredArgsConstructor;
import org.blog.securitychat.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;


    public Person savePerson(Person person){
        return personRepository.save(person);
    }
    public Optional<Person> getPersonById(String id){
        return personRepository.findById(id);
    }
    public Iterable<Person> getAllPersons(){
        return personRepository.findAll();
    }
    public void deletePerson(String id){
        personRepository.deleteById(id);
    }
}
