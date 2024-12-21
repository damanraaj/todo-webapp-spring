package com.daman.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

	private static List<Todo> todos = new ArrayList<Todo>();
	static {
		todos.add(new Todo(1, "admin", "Learn Spring", false, LocalDate.now().plusMonths(1)));
		todos.add(new Todo(2, "admin", "Learn Spring MVC", false, LocalDate.now().plusMonths(2)));
		todos.add(new Todo(3, "admin", "Learn Angular", false, LocalDate.now().plusMonths(3)));
		todos.add(new Todo(4, "admin", "Learn React", false, LocalDate.now().plusMonths(4)));
	}

	public List<Todo> findByUserName(String name) {
		return todos.stream().filter(todo -> todo.getUsername().equals(name)).collect(Collectors.toList());
	}

	public void addTodo(String username, String description, LocalDate targetDate) {
		todos.add(new Todo(todos.size() + 1, username, description, false, targetDate));
	}

	public void deleteTodoById(long id) {
		todos.removeIf(todo -> todo.getId() == id);
	}

	public Todo findById(long id) {
		return todos.stream().filter(todo -> todo.getId() == id).findFirst().get();
	}

	public void updateTodo(Todo newTodo) {
		findById(newTodo.getId()).setDescription(newTodo.getDescription());
		findById(newTodo.getId()).setTargetDate(newTodo.getTargetDate());

	}
}
