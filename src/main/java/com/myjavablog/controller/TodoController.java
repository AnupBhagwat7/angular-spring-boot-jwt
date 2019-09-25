package com.myjavablog.controller;

import com.myjavablog.model.Todo;
//import com.myjavablog.model.User;
//import com.myjavablog.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class TodoController {

    //@Autowired
    //private TodoRepository todoRepository;

    static List<Todo> list = new ArrayList<>();

/*
    @GetMapping(produces = "application/json")
    @RequestMapping({ "/validateLogin" })
    public User validateLogin()
    {
        return new User("User successfully authenticated");
    }
*/

    @GetMapping(produces = "application/json")
    @RequestMapping("/todos")
    public List<Todo> getTodos(){
        return list;
    }

    TodoController(){

        list.add(new Todo(1l,"Badminton", "Badminton at 6 am", "Pending"));
        list.add(new Todo(2l,"Cricket", "Cricket at 7 am", "Pending"));
        list.add(new Todo(3l,"Football", "Football at 8 am", "Pending"));
        list.add(new Todo(4l,"Cards", "Cards at 6 am", "Pending"));
        list.add(new Todo(5l,"TT", "TT at 6 am", "Completed"));
        list.add(new Todo(6l,"Golf", "Golf at 6 am", "Pending"));
        list.add(new Todo(7l,"Running", "Running at 6 am", "Pending"));
        list.add(new Todo(8l,"Walking", "Walking at 6 am", "Pending"));
        list.add(new Todo(9l,"Swimming", "Swimming at 6 am", "Completed"));
        list.add(new Todo(10l,"Reading", "Reading at 6 am", "Pending"));

        //return list;
    }

    @GetMapping("/todo/{id}")
    public Todo getTodo(@PathVariable Long id)
    {
        //return todoRepository.findById(id);

        for(Todo todo : list){

            if(todo.getId() == id){
                return todo;
            }
        }

        return null;
    }

    @DeleteMapping("/todo/{id}")
    public boolean deleteTodo(@PathVariable Long id){
        //todoRepository.deleteById(id);

        for(Todo todo : list){

            if(todo.getId() == id){
                list.remove(todo);
            }
        }

        return true;
    }

    @PostMapping("/todo")
    public Todo createTodo(@RequestBody Todo todo){

        list.add(todo);
        return todo;
        //return todoRepository.save(todo);
    }

    @PutMapping("/todo")
    public Todo updateTodo(@RequestBody Todo todo){


        for(Todo t : list){

            if(todo.getId() == t.getId()){
                list.remove(t);
                list.add(todo);
                return todo;
            }
        }

        return null;
        //return todoRepository.save(todo);
    }

}
