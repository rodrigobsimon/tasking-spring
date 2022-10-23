package com.github.rodrigobsimon.tasking.task.controllers.requests;

import javax.validation.constraints.NotBlank;

public record AddTaskRequest(@NotBlank(message = "Task description should not be null or blank!") String description) {

}
