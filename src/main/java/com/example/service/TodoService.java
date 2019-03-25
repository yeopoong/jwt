package com.example.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.domain.Todo;
import com.example.repository.TodoRepository;

@Service
public class TodoService {

    @Resource
    private TodoRepository todoRepository;

    public List<Todo> getTodos() {
        return todoRepository.findAll();
    }

    public Todo getTodo(int id) {
        return todoRepository.getOne(id);
    }

    public void addTodo(Todo todo) {
        todoRepository.save(todo);
    }

    public void updateTodo(Todo todo) {
        todoRepository.save(todo);
    }

    public void deleteTodo(int id) {
        todoRepository.deleteById(id);
    }
}
