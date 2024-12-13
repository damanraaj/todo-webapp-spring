package com.daman.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@SessionAttributes("name")
public class TodoController {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private TodoService todoService;

	@GetMapping("list-todos")
	public String getTodoList(ModelMap map) {
		if (!isUserLoggedIn(map)) {
			return "redirect:/login";
		}
		logger.debug("User {} opened list todos", map.get("name"));
		map.put("todo", todoService.findByUserName(map.get("name").toString()));
		return "listTodos";
	}

	private boolean isUserLoggedIn(ModelMap map) {
		if (!map.containsAttribute("name")) {
			return false;
		}
		return true;
	}

	@GetMapping("add-todo")
	public String goToAddTodoPage(ModelMap map) {
		if (!isUserLoggedIn(map)) {
			return "redirect:/login";
		}
		return "addTodo";
	}

	@PostMapping("add-todo")
	public String handleAddTodo(@RequestParam String description, @RequestParam Optional<LocalDate> targetDate,
			ModelMap map) {
		if (!isUserLoggedIn(map)) {
			return "redirect:/login";
		}

		todoService.addTodo(map.get("name").toString(), description, targetDate.orElse(null));
		return "redirect:/list-todos";
	}

}
