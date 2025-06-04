package com.tmnt.test.moshtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    //better than using new TodoService()
    //cause it keeps same state bruh and injects that object on every controller
    @Autowired
    private TodoService todoService;

    //basically extracting payload from body huh
    @PostMapping
    public Todo createTodo(@RequestBody String task){
        return todoService.addTodo(task);
    }

    @GetMapping
    public List<Todo> readAllTodos(){
        return todoService.getAllTodos();
    }

    //usage of path variable
    @GetMapping("/{id}")
    public Todo getById(@PathVariable Long id){
        return todoService.getTodoWithId(id);
    }

    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable Long id,
                           @RequestParam(required = false) String task,
                           @RequestParam(required = false) Boolean isDone
                           ){
        return todoService.updateTodo(id,task,isDone);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteTodo(@PathVariable Long id){
        return todoService.deleteTodo(id);
    }




}
