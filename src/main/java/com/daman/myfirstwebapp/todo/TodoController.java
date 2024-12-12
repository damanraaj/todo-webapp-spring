package com.daman.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.Optional;

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

	@Autowired
	private TodoService todoService;

	@GetMapping("list-todos")
	public String getTodoList(ModelMap map) {
		map.put("todo", todoService.findByUserName(map.get("name").toString()));
		return "listTodos";
	}

	@GetMapping("add-todo")
	public String goToAddTodoPage() {
		return "addTodo";
	}

	@PostMapping("add-todo")
	public String handleAddTodo(@RequestParam String description, @RequestParam Optional<LocalDate> targetDate,
			ModelMap map) {
		todoService.addTodo(map.get("name").toString(), description, targetDate.orElse(null));
		return getTodoList(map);
	}

}
