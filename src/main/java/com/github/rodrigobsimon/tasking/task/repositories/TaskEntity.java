package com.github.rodrigobsimon.tasking.task.repositories;

import com.github.rodrigobsimon.tasking.task.domain.TaskStatus;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED, onConstructor = @__(@Deprecated))
public class TaskEntity {

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE) private Long id;
	private String internalId;
	private String description;
	private LocalDateTime creationMoment;
	@Enumerated(EnumType.STRING) private TaskStatus taskStatus;

	public TaskEntity(String internalId, String description, LocalDateTime creationMoment, TaskStatus taskStatus) {

		this.internalId = internalId;
		this.description = description;
		this.creationMoment = creationMoment;
		this.taskStatus = taskStatus;
	}
}
