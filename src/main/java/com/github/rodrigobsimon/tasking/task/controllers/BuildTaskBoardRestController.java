package com.github.rodrigobsimon.tasking.task.controllers;

import com.github.rodrigobsimon.tasking.task.domain.TaskBoardItem;
import com.github.rodrigobsimon.tasking.task.domain.TaskStatus;
import com.github.rodrigobsimon.tasking.task.ports.BuildTaskBoardPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class BuildTaskBoardRestController {

	private final BuildTaskBoardPort buildTaskBoardPort;

	@GetMapping(path = "/api/v1/tasks/board")
	public ResponseEntity<Map<TaskStatus, List<TaskBoardItem>>> buildTaskBoard() {

		return ResponseEntity.ok()
		                     .body(buildTaskBoardPort.buildTaskBoard());
	}
}
