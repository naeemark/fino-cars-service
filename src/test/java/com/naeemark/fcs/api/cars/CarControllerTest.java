package com.naeemark.fcs.api.cars;

import com.naeemark.fcs.models.Car;
import com.naeemark.fcs.repositories.CarRepository;
import com.naeemark.fcs.utils.TestUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("test")
@DisplayName("Tests for CarController")
class CarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarRepository repository;

    @Test
    @DisplayName("GET List - success")
    void list_Success() throws Exception {
        Car car = TestUtil.getCar();
        when(repository.findAll()).thenReturn(Collections.singletonList(car));
        mockMvc.perform(get("/api/cars"))
                // then
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$.[*].id").exists())
                .andExpect(jsonPath("$.[*].make").exists())
                .andExpect(jsonPath("$.[*].id").exists())
                .andExpect(jsonPath("$.[*].make").exists())
                .andExpect(jsonPath("$.[*].modelYear").exists())
                .andExpect(jsonPath("$.[*].year").exists())
                .andExpect(jsonPath("$.[*].engineType").exists())
                .andExpect(jsonPath("$.[*].type").exists())
                .andExpect(jsonPath("$.[*].fuelType").exists())
                .andExpect(jsonPath("$.[*].driveline").exists())
                .andExpect(jsonPath("$.[*].classification").exists())
                .andExpect(jsonPath("$.[*].forwardGears").exists())
                .andExpect(jsonPath("$.[*].transmission").exists())
                .andExpect(jsonPath("$.[*].horsepower").exists())
                .andExpect(jsonPath("$.[*].cityMilesPerGallon").exists())
                .andExpect(jsonPath("$.[*].highwayMilesPerGallon").exists())
                .andExpect(jsonPath("$.[*].width").exists())
                .andExpect(jsonPath("$.[*].height").exists())
                .andExpect(jsonPath("$.[*].length").exists())
                .andExpect(jsonPath("$.[*].imageUri").exists());
    }

    @Test
    @DisplayName("GET List - success empty")
    void list_Success_empty() throws Exception {
        when(repository.findAll()).thenReturn(Collections.emptyList());
        mockMvc.perform(get("/api/cars"))
                // then
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(0)));
    }
}