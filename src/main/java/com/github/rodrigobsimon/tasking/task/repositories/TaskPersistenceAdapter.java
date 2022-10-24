package com.github.rodrigobsimon.tasking.task.repositories;

import com.github.rodrigobsimon.tasking.task.domain.Task;
import com.github.rodrigobsimon.tasking.task.domain.TaskBoardItem;
import com.github.rodrigobsimon.tasking.task.domain.TaskStatus;
import com.github.rodrigobsimon.tasking.task.ports.AddTaskPort;
import com.github.rodrigobsimon.tasking.task.ports.BuildTaskBoardPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TaskPersistenceAdapter implements AddTaskPort,
                                               BuildTaskBoardPort {

	private final TaskRepository taskRepository;

	@Override
	public void addTask(Task task) {

		TaskEntity taskEntity =
				new TaskEntity(task.getId(), task.getDescription(), task.getCreationMoment(), task.getStatus());
		taskRepository.save(taskEntity);
	}

	@Override
	public Map<TaskStatus, List<TaskBoardItem>> buildTaskBoard() {

		return taskRepository.findAll()
		                     .stream()
		                     .collect(Collectors.groupingBy(TaskBoardItem::getStatus));
	}
}
