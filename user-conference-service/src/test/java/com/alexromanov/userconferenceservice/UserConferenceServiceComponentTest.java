package com.alexromanov.userconferenceservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserConferenceServiceComponentTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnUserInformationIfUserIsFound() throws Exception {
        mockMvc.perform(get("/user/111111"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.id").value(111111))
               .andExpect(jsonPath("$.name").value("Jack"))
               .andExpect(jsonPath("$.surname").value("Ice"))
               .andExpect(jsonPath("$.bonuses").isEmpty());
    }

    @Test
    public void shouldReturnEmptyInformationIfUserNotFound() throws Exception {
        mockMvc.perform(get("/user/2"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.id").value(0))
               .andExpect(jsonPath("$.name").isEmpty())
               .andExpect(jsonPath("$.surname").isEmpty())
               .andExpect(jsonPath("$.bonuses").isEmpty());
    }
}
