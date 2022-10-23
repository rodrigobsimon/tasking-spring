package com.github.rodrigobsimon.tasking.task.controllers;

import com.github.rodrigobsimon.tasking.task.controllers.requests.AddTaskRequest;
import com.github.rodrigobsimon.tasking.task.domain.Task;
import com.github.rodrigobsimon.tasking.task.usecases.AddTaskUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class AddTaskRestController {

	private final AddTaskUseCase addTaskUseCase;

	@PostMapping(path = "/api/v1/tasks/add-task")
	public ResponseEntity<Void> addTask(@RequestBody @Valid AddTaskRequest request) {

		addTaskUseCase.execute(new Task(request.description()));

		return ResponseEntity.status(HttpStatus.CREATED)
		                     .build();
	}
}
