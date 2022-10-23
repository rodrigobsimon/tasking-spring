package com.github.rodrigobsimon.tasking.task.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Task {

	@EqualsAndHashCode.Include private final String id = UUID.randomUUID()
	                                                         .toString();
	private final String description;
	private final LocalDateTime creationMoment = LocalDateTime.now();
	private TaskStatus status = TaskStatus.TODO;
}
