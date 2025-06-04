package com.tmnt.test.moshtest;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TodoService {
    private final List<Todo> todos=new ArrayList<>();
    private final AtomicLong idCount=new AtomicLong(1);


    //creating

    public Todo addTodo(String task){
        //for thread safety and yep its in atomic shiiii
        Todo tempTodo=new Todo(idCount.getAndIncrement(),task,false);
        todos.add(tempTodo);
        return tempTodo;
    }

    //read
    public List<Todo> getAllTodos(){
        return todos;
    }

    //read with id
    public Todo getTodoWithId(Long id){
        //bruh before filter/foreach u gotta stream =>one thing at a time like forEach
        //be aware what u returning ft javashit
        return todos.stream()
                .filter(todo -> todo.getId().equals(id))
                .findFirst().orElse(null);
    }

    public Todo updateTodo(Long id,String task,Boolean isDone){
        Todo gottenTodo=getTodoWithId(id);

        if(gottenTodo!=null){
            if(task!=null)
                gottenTodo.setTask(task);
            if(isDone!=null)
                gottenTodo.setDone(isDone);
        }

        return gottenTodo;
    }

    public boolean deleteTodo(Long id){
        //bruh returns boolean and removes
        return todos.removeIf(todo -> todo.getId().equals(id));
    }

}
