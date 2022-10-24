package com.github.rodrigobsimon.tasking.task.ports;

import com.github.rodrigobsimon.tasking.task.domain.TaskBoardItem;
import com.github.rodrigobsimon.tasking.task.domain.TaskStatus;

import java.util.List;
import java.util.Map;

public interface BuildTaskBoardPort {

	Map<TaskStatus, List<TaskBoardItem>> buildTaskBoard();
}
