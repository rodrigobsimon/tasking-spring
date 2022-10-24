package com.github.rodrigobsimon.tasking.task.repositories;

import com.github.rodrigobsimon.tasking.task.domain.TaskBoardItem;
import com.github.rodrigobsimon.tasking.task.domain.TaskStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED, onConstructor = @__(@Deprecated))
@Getter
public class TaskEntity implements TaskBoardItem {

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE) private Long internalId;
	private String id;
	private String description;
	private LocalDateTime creationMoment;
	@Enumerated(EnumType.STRING) private TaskStatus status;

	public TaskEntity(String id, String description, LocalDateTime creationMoment, TaskStatus status) {

		this.id = id;
		this.description = description;
		this.creationMoment = creationMoment;
		this.status = status;
	}
}
