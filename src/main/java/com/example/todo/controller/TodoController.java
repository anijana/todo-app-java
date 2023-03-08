package com.example.todo.controller;

import com.example.todo.model.Todo;
import com.example.todo.service.ITodoService;
import com.example.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todo-app")
public class TodoController {
    @Autowired
    private ITodoService todoService; // DI
    @PostMapping("/add-todo")
    public void addTodo(@RequestBody Todo todo){
        todoService.addTodo(todo);
    }
    @GetMapping("/get-todo/id/{id}")
    public Todo findTodoById(@PathVariable int id){
        return todoService.findById(id);
    }

    @GetMapping("/get-all")
    public List<Todo> findAllTodo(){
        return todoService.findAll();
    }
    @PutMapping("/update-todo/id/{id}")
    public void updateTodo(@PathVariable int id, @RequestBody Todo todo){
        todoService.updateTodo(id,todo);
    }
    @DeleteMapping("/delete-todo/id/{id}")
    public void deleteTodo(@PathVariable int id){
        todoService.deleteTodo(id);
    }
}
