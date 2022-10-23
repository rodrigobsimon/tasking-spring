package com.github.rodrigobsimon.tasking.task.usecases;

import com.github.rodrigobsimon.tasking.task.domain.Task;
import com.github.rodrigobsimon.tasking.task.ports.AddTaskPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AddTaskUseCase {

	private final AddTaskPort addTaskPort;

	public void execute(Task task) {

		addTaskPort.addTask(task);
	}
}
