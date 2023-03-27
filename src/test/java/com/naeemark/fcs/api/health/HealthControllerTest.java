package com.naeemark.fcs.api.health;

import com.naeemark.fcs.utils.Constants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * Created by Naeem <naeemark@gmail.com>.
 * <p>
 * Created on: 2023-03-27
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(HealthController.class)
@DisplayName("Unit tests for HealthController")
class HealthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Check HealthResponse")
    void checkHealth_success() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/health/"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.serviceName").value(Constants.SERVICE_NAME))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("OK"));
    }
}