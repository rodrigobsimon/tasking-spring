package com.github.rodrigobsimon.tasking.task.repositories;

import com.github.rodrigobsimon.tasking.task.domain.Task;
import com.github.rodrigobsimon.tasking.task.ports.AddTaskPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TaskPersistenceAdapter implements AddTaskPort {

	private final TaskRepository taskRepository;

	@Override
	public void addTask(Task task) {

		TaskEntity taskEntity =
				new TaskEntity(task.getId(), task.getDescription(), task.getCreationMoment(), task.getStatus());
		taskRepository.save(taskEntity);
	}
}
