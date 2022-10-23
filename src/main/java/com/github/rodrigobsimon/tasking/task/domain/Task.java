package com.github.rodrigobsimon.tasking.task.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@RequiredArgsConstructor
@Getter
public class Task {

	private final String id = UUID.randomUUID()
	                              .toString();
	private final String description;
	private final LocalDateTime creationMoment = LocalDateTime.now();
	private TaskStatus status = TaskStatus.TODO;
}
