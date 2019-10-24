package com.alexromanov.bonusconferenceservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BonusConferenceServiceComponentTest {
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void shouldReturnUserBonusIfUserIsFound() throws Exception {
		mockMvc.perform(get("/userBalance")
				.param("userId", "111111")
				.param("sessionId", "222222"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.[0].id").value(111111))
				.andExpect(jsonPath("$.[0].type").value("TICKET"));
	}

	@Test
	public void shouldReturnEmptyBonusesIfUserNotFound() throws Exception {
		mockMvc.perform(get("/userBalance")
								.param("userId", "222222")
								.param("sessionId", "111111"))
			   .andExpect(status().isOk())
			   .andExpect(jsonPath("$").isEmpty());
	}
}
