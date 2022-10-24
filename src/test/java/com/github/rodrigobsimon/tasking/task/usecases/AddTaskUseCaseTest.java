package com.github.rodrigobsimon.tasking.task.usecases;

import com.github.rodrigobsimon.tasking.task.domain.Task;
import com.github.rodrigobsimon.tasking.task.domain.TaskStatus;
import com.github.rodrigobsimon.tasking.task.ports.AddTaskPort;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.BDDMockito.then;

class AddTaskUseCaseTest {

	private final AddTaskPort addTaskPort = Mockito.mock(AddTaskPort.class);
	private final AddTaskUseCase sut = new AddTaskUseCase(addTaskPort);

	@Test
	void shouldAddTaskWithRightParameters() {

		Task task = new Task("any_task_description");
		sut.execute(task);
		then(addTaskPort).should()
		                 .addTask(task);

		try {
			UUID ignored = UUID.fromString(task.getId());
		} catch (Exception ignored) {
			fail("Invalid UUID");
		}

		assertThat(task.getDescription()).isEqualTo("any_task_description");
		assertThat(task.getCreationMoment()).isEqualToIgnoringSeconds(LocalDateTime.now());
		assertThat(task.getStatus()).isEqualTo(TaskStatus.TODO);
	}
}
