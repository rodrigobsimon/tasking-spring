package com.github.rodrigobsimon.tasking.task.domain;

import java.time.LocalDateTime;

public interface TaskBoardItem {

	String getId();

	String getDescription();

	TaskStatus getStatus();

	LocalDateTime getCreationMoment();
}
