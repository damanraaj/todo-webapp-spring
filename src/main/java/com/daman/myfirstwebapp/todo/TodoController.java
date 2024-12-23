package com.daman.myfirstwebapp.todo;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoController {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private TodoService todoService;

	@GetMapping("list-todos")
	public String getTodoList(ModelMap map) {
		String loggedInUser = getLoggedInUser(map);
		logger.debug("User {} opened list todos", loggedInUser);
		map.put("todo", todoService.findByUserName(loggedInUser));
		return "listTodos";
	}

	@GetMapping("add-todo")
	public String goToAddTodoPage(ModelMap map) {
		Todo newTodo = new Todo(0, getLoggedInUser(map), "", false, LocalDate.now());
		map.put("todo", newTodo);
		return "addTodo";
	}

	@PostMapping("add-todo")
	public String handleAddTodo(ModelMap map, @Valid Todo todo, BindingResult result) {
		if (result.hasErrors()) {
			return "addTodo";
		}

		todoService.addTodo(getLoggedInUser(map), todo.getDescription(), todo.getTargetDate());
		return "redirect:/list-todos";
	}

	@GetMapping("delete-todo")
	public String handleDeleteTodo(ModelMap map, @RequestParam long id) {
		todoService.deleteTodoById(id);
		return "redirect:/list-todos";
	}

	@GetMapping("update-todo")
	public String goToUpdateTodoPage(ModelMap map, @RequestParam long id) {
		Todo todo = todoService.findById(id);
		logger.debug("Open update todo page for {}", todo.toString());
		map.put("todo", todo);
		return "updateTodo";
	}

	@PostMapping("update-todo")
	public String handleUpdateTodo(ModelMap map, Todo todo, BindingResult result) {
		if (result.hasErrors()) {
			return "updateTodo";
		}
		todo.setUsername(getLoggedInUser(map));
		todoService.updateTodo(todo);
		logger.debug("Updated todo {}", todo.toString());
		return "redirect:/list-todos";
	}

	private String getLoggedInUser(ModelMap map) {
		SecurityContext context = SecurityContextHolder.getContext();
		return context.getAuthentication().getName();
	}
}
