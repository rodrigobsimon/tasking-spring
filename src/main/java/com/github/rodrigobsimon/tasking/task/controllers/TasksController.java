package com.github.rodrigobsimon.tasking.task.controllers;

import com.github.rodrigobsimon.tasking.task.controllers.requests.AddTaskRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TasksController {

	@GetMapping(path = "/tasks")
	public String tasks(Model model) {

		model.addAttribute("request", new AddTaskRequest());
		return "tasks";
	}
}
