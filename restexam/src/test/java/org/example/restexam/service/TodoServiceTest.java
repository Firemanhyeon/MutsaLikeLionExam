package org.example.restexam.service;

import org.example.restexam.domain.Todo;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

class TodoServiceTest {

    @Autowired TodoService todoService;

    private static final Logger log = LoggerFactory.getLogger(TodoServiceTest.class);
    @Test
    void getTodos() {
        List<Todo> todos = todoService.getTodos();
        todos.forEach(todo->log.info("Todo:"+todo));
    }

    @Test
    void getTodo() {
        Todo todo = todoService.getTodo(1L);
        log.info("getTodo:"+todo);
    }

    @Test
    void addTodo() {
        Todo todo1 = todoService.addTodo("할일10");
        log.info("add:"+todo1);
    }

    @Test
    void updateTodo() {
        Todo todo = todoService.updateTodo(1L);
        log.info("updateTodo:"+todo);
    }

    @Test
    void testUpdateTodo() {
        Todo todo1 = todoService.getTodo(1L);
        todo1.setTodo("할일수정");
        Todo todo = todoService.updateTodo(todo1);
        log.info("update:"+todo);
    }

    @Test
    void deleteTodo() {
        todoService.deleteTodo(2L);
        Todo todo1 = todoService.getTodo(2L);
        log.info("삭제Test"+todo1);

    }
}