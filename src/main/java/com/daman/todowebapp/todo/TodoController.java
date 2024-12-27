package com.daman.todowebapp.todo;

import java.time.LocalDate;
import java.util.Optional;

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
	private TodoRepository todoRepository;

	@GetMapping("list-todos")
	public String getTodoList(ModelMap map) {
		String loggedInUser = getLoggedInUser(map);
		map.put("todo", todoRepository.findByUsername(loggedInUser));
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

		todo.setUsername(getLoggedInUser(map));
		todoRepository.save(todo);
		return "redirect:/list-todos";
	}

	@GetMapping("delete-todo")
	public String handleDeleteTodo(ModelMap map, @RequestParam int id) {
		todoRepository.deleteByIdAndUsername(id, getLoggedInUser(map));
		return "redirect:/list-todos";
	}

	@GetMapping("update-todo")
	public String goToUpdateTodoPage(ModelMap map, @RequestParam int id) {
		String loggedInUser = getLoggedInUser(map);
		Optional<Todo> todoById = todoRepository.findByIdAndUsername(id, loggedInUser);
		if (!todoById.isPresent()) {
			logger.debug("Invalid - todo with id {} not found", id);
			return "redirect:/list-todos";
		}
		Todo todo = todoById.get();
		logger.debug("User {} opened update page for {}", loggedInUser, todo.toString());
		map.put("todo", todo);
		return "updateTodo";

	}

	@PostMapping("update-todo")
	public String handleUpdateTodo(ModelMap map, Todo todo, BindingResult result) {
		if (result.hasErrors()) {
			return "updateTodo";
		}
		String loggedInUser = getLoggedInUser(map);
		Optional<Todo> todoById = todoRepository.findByIdAndUsername(todo.getId(), loggedInUser);
		if (!todoById.isPresent()) {
			logger.debug("Invalid - todo with id {} not found", todo.getId());
		} else {
			todo.setUsername(loggedInUser);
			todoRepository.save(todo);
			logger.debug("User {} updated todo {}", loggedInUser, todo.toString());
		}
		return "redirect:/list-todos";
	}

	private String getLoggedInUser(ModelMap map) {
		SecurityContext context = SecurityContextHolder.getContext();
		String userName = context.getAuthentication().getName();
		map.addAttribute("name", userName);
		return userName;
	}
}
