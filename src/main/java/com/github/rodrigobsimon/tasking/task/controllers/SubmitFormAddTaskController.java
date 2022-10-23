package com.github.rodrigobsimon.tasking.task.controllers;

import com.github.rodrigobsimon.tasking.task.controllers.requests.AddTaskRequest;
import com.github.rodrigobsimon.tasking.task.domain.Task;
import com.github.rodrigobsimon.tasking.task.usecases.AddTaskUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class SubmitFormAddTaskController {

	private final AddTaskUseCase addTaskUseCase;

	@PostMapping(path = "/tasks/add-task")
	public String addTask(@ModelAttribute @Valid AddTaskRequest request, Model model) {

		addTaskUseCase.execute(new Task(request.getDescription()));
		return "tasks";
	}
}
