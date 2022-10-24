package com.github.rodrigobsimon.tasking.task.controllers;

import com.github.rodrigobsimon.tasking.task.controllers.requests.AddTaskRequest;
import com.github.rodrigobsimon.tasking.task.domain.TaskStatus;
import com.github.rodrigobsimon.tasking.task.ports.BuildTaskBoardPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class TasksController {

	private final BuildTaskBoardPort buildTaskBoardPort;

	@GetMapping(path = "/tasks")
	public String tasks(Model model) {

		var board = buildTaskBoardPort.buildTaskBoard();

		model.addAttribute("request", new AddTaskRequest());
		model.addAttribute("todos", board.get(TaskStatus.TODO));
		model.addAttribute("doings", board.get(TaskStatus.DOING));
		model.addAttribute("dones", board.get(TaskStatus.DONE));
		return "tasks";
	}
}
