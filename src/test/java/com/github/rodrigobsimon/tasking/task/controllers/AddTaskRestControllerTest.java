package com.github.rodrigobsimon.tasking.task.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.rodrigobsimon.tasking.task.controllers.requests.AddTaskRequest;
import com.github.rodrigobsimon.tasking.task.usecases.AddTaskUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = AddTaskRestController.class)
class AddTaskRestControllerTest {

	@MockBean private AddTaskUseCase addTaskUseCase;
	@Autowired private MockMvc mockMvc;
	@Autowired private ObjectMapper objectMapper;

	@Test
	void shouldReturn201WhenAddTask() throws Exception {

		AddTaskRequest request = new AddTaskRequest("any_task_description");

		mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/tasks/add-task")
		                                      .accept("application/json")
		                                      .contentType("application/json")
		                                      .content(objectMapper.writeValueAsString(request)))
		       .andExpect(status().isCreated());

		then(addTaskUseCase).should()
		                    .execute(any());
	}
}
