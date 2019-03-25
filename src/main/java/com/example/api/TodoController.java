package com.example.api;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Todo;
import com.example.service.TodoService;

@RestController
@RequestMapping("/todos")
public class TodoController {
    
    @Resource
    private TodoService todoService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Todo> getTodos() {
        
        List<Todo> todoVoList = todoService.getTodos();

        return todoVoList;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Todo getTodo(@PathVariable Integer id) {

        Todo todo = todoService.getTodo(id);

        return todo;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Todo addTodo(@RequestBody Todo todo) {

        todoService.addTodo(todo);
        
        return todo;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTodo(@RequestBody Todo todo, @PathVariable Integer id) {

        todoService.updateTodo(todo);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTodo(@PathVariable Integer id) {

        todoService.deleteTodo(id);
    }
}
