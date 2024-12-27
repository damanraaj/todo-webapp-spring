package com.daman.todowebapp.todo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface TodoRepository extends JpaRepository<Todo, Integer> {

    public List<Todo> findByUsername(String name);

    public Optional<Todo> findByIdAndUsername(int id, String username);

    @Transactional
    public void deleteByIdAndUsername(int id, String username);
}
