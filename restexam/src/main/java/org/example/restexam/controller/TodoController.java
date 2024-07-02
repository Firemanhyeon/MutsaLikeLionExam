package org.example.restexam.controller;

import lombok.RequiredArgsConstructor;
import org.example.restexam.domain.Todo;
import org.example.restexam.service.TodoService;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
public class TodoController {
    private final TodoService service;
    private final TodoService todoService;

    @GetMapping
    public List<Todo> getTodos(){
        return service.getTodos();
    }

    @GetMapping("/{id}")
    public Todo getTodo(@PathVariable("id") Long id){
        return service.getTodo(id);
    }
    @PostMapping
    public Todo addTodo(@RequestBody Todo todo){
        return todoService.addTodo(todo.getTodo());
    }
    //put vs patch -- 엔티티 자체가 수정될때? 그럴땐 put 그안에 한개정도만 수정될때 patch
    @PatchMapping("/{id}")
    public Todo updateId (@PathVariable("id") Long id){
        return todoService.updateTodo(id);
    }

    @PatchMapping
    public Todo updateTodo (@RequestBody Todo todo){
        return todoService.updateTodo(todo);
    }

    @DeleteMapping
    public String deleteTodo(@RequestBody Todo todo){
        todoService.deleteTodo(todo.getId());
        return "ok";
    }
}
