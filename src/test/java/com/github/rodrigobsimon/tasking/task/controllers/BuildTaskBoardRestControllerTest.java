package com.github.rodrigobsimon.tasking.task.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.rodrigobsimon.tasking.task.domain.TaskBoardItem;
import com.github.rodrigobsimon.tasking.task.domain.TaskStatus;
import com.github.rodrigobsimon.tasking.task.ports.BuildTaskBoardPort;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = BuildTaskBoardRestController.class)
class BuildTaskBoardRestControllerTest {

	@Autowired MockMvc mockMvc;
	@Autowired ObjectMapper objectMapper;
	@MockBean private BuildTaskBoardPort buildTaskBoardPort;

	@Test
	void shouldReturn200AndJsonWhenBuildTaskBoard() throws Exception {

		Map<TaskStatus, List<TaskBoardItem>> board = Map.of(TaskStatus.TODO,
		                                                    Collections.emptyList(),
		                                                    TaskStatus.DOING,
		                                                    Collections.emptyList(),
		                                                    TaskStatus.DONE,
		                                                    Collections.emptyList());

		given(buildTaskBoardPort.buildTaskBoard()).willReturn(board);
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/tasks/board"))
		                          .andExpect(status().isOk())
		                          .andReturn();

		then(buildTaskBoardPort).should()
		                        .buildTaskBoard();

		assertThat(result.getResponse()
		                 .getContentAsString()).isEqualTo(objectMapper.writeValueAsString(board));
	}
}
