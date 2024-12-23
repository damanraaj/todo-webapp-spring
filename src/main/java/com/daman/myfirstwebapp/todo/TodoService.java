package com.daman.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

	private Logger logger = LoggerFactory.getLogger(getClass());

	private static List<Todo> todos = new ArrayList<Todo>();
	static {
		todos.add(new Todo(1, "daman", "Learn Spring", false, LocalDate.now().plusMonths(1)));
		todos.add(new Todo(2, "admin", "Learn Spring MVC", false, LocalDate.now().plusMonths(2)));
		todos.add(new Todo(3, "admin", "Learn Angular", false, LocalDate.now().plusMonths(3)));
		todos.add(new Todo(4, "daman", "Learn React", false, LocalDate.now().plusMonths(4)));
	}
	static int todoCount = todos.size();

	public List<Todo> findByUserName(String name) {
		return todos.stream().filter(todo -> todo.getUsername().equals(name)).toList();
	}

	public void addTodo(String username, String description, LocalDate targetDate) {
		todos.add(new Todo(++todoCount, username, description, false, targetDate));
	}

	public void deleteTodoById(String user, long id) {
		todos.removeIf(todo -> todo.getId() == id && todo.getUsername().equals(user));
	}

	public Todo findById(long id) {
		return todos.stream().filter(todo -> todo.getId() == id).findFirst().get();
	}

	public void updateTodo(Todo newTodo) {
		Todo todo = findById(newTodo.getId());
		if (todo.getUsername().equals(newTodo.getUsername())) {
			todo.setDescription(newTodo.getDescription());
			todo.setTargetDate(newTodo.getTargetDate());
			logger.debug("Updated todo {}", todo.toString());
		} else {
			logger.debug("Invalid - User {} tried to update todo id {}", newTodo.getUsername(), todo.getId());
		}

	}
}
