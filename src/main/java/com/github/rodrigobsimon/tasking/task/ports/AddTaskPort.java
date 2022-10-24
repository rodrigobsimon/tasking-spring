package com.github.rodrigobsimon.tasking.task.ports;

import com.github.rodrigobsimon.tasking.task.domain.Task;

public interface AddTaskPort {

	void addTask(Task task);
}
