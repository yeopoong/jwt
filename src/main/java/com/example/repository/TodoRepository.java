package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer> {

}
