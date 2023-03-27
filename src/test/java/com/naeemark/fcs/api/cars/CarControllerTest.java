package com.naeemark.fcs.api.cars;

import com.naeemark.fcs.models.Car;
import com.naeemark.fcs.services.CarService;
import com.naeemark.fcs.utils.TestUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("Tests for CarController")
@ExtendWith(SpringExtension.class)
@WebMvcTest(CarController.class)
class CarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarService service;

    @Test
    @DisplayName("GET List - success")
    void list_Success() throws Exception {
        Car car = TestUtil.getCar();
        when(service.findAll()).thenReturn(Collections.singletonList(car));
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
        when(service.findAll()).thenReturn(Collections.emptyList());
        mockMvc.perform(get("/api/cars"))
                // then
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(0)));
    }


    @Test
    @DisplayName("GET Page - success")
    void page_Success() throws Exception {
        Car car = TestUtil.getCar();
        when(service.findPage(anyInt(), anyInt(), anyString())).thenReturn(Collections.singletonList(car));
        mockMvc.perform(get("/api/cars/page?number=1&size=10"))
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
    @DisplayName("GET Search - success")
    void search_Success() throws Exception {
        when(service.search(anyInt(), anyString(), anyString(), anyInt(), anyString(), anyString())).thenReturn(Collections.emptyList());
        mockMvc.perform(get("/api/cars/search?id=1"))
                // then
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(0)));
    }
}