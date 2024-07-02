package org.example.restexam.service;

import lombok.RequiredArgsConstructor;
import org.example.restexam.domain.Todo;
import org.example.restexam.repository.TodoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

    @Transactional(readOnly = true)
    public List<Todo> getTodos(){
        return todoRepository.findAll();
    }
    @Transactional(readOnly = true)
    public Todo getTodo(Long id){
        Optional<Todo> todo = todoRepository.findById(id);
        return todo.orElse(null);
    }

    @Transactional
    public Todo addTodo(String todo){
        Todo savetodo = todoRepository.save(new Todo(todo));
        return savetodo;
    }

    @Transactional
    public Todo updateTodo(Long id){ //id 값에 해당하는 done을 토글하도록
        Todo todo =todoRepository.findById(id).orElse(null);
        if(todo.isDone()){
            todo.setDone(false);
        }else{
            todo.setDone(true);
        }
        return todoRepository.save(todo);

    }

    @Transactional
    public Todo updateTodo(Todo todo){//id에 해당하는 todo정보를 바꾸게 //메소드오버로딩
        Todo updateTodo = todoRepository.save(todo);

        return updateTodo;
    }

    @Transactional
    public void deleteTodo(Long id){
        todoRepository.deleteById(id);

    }
}
