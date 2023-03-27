package com.naeemark.fcs.services;

import com.naeemark.fcs.models.Car;
import com.naeemark.fcs.repositories.CarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;

import static com.naeemark.fcs.utils.Constants.ERROR_DATA_NOT_FOUND;
import static com.naeemark.fcs.utils.TestUtil.getCar;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class CarServiceImplTest {
    @InjectMocks
    private CarServiceImpl service;

    @Mock
    private CarRepository repository;

    private Car car;

    @BeforeEach
    public void setup() {
        car = getCar();
    }

    @Test
    @DisplayName("FindAll - Success")
    void findAll() {
        when(repository.findAll()).thenReturn(Collections.singletonList(car));

        List<Car> list = service.findAll();
        assertNotNull(list);
        assertEquals(list.get(0).getId(), car.getId());
        verify(repository, times(1)).findAll();
    }

    @Test
    @DisplayName("FindAll - Exception")
    void findAll_Exception() {
        when(repository.findAll()).then(invocation -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ERROR_DATA_NOT_FOUND);
        });
        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> service.findAll());
        assertNotNull(exception);
        assertEquals(HttpStatus.NOT_FOUND, exception.getStatus());
        assertEquals(ERROR_DATA_NOT_FOUND, exception.getReason());
        verify(repository, times(1)).findAll();
    }

    @Test
    @DisplayName("Find Page - Success")
    void findPage() {
        Pageable pageRequest = PageRequest.of(0, 1, Sort.by("id"));
        Page<Car> page = new PageImpl<>(Collections.singletonList(car));
        when(repository.findAll(pageRequest)).thenReturn(page);
        List<Car> list = service.findPage(0, 1, "id");
        assertNotNull(list);
        assertEquals(list.get(0).getId(), car.getId());
        verify(repository, times(1)).findAll(pageRequest);
    }

    @Test
    @DisplayName("Find Page - Exception")
    void findPage_Exception() {
        Pageable pageRequest = PageRequest.of(0, 1, Sort.by("id"));
        when(repository.findAll(pageRequest)).then(invocation -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ERROR_DATA_NOT_FOUND);
        });
        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> service.findPage(1, 2, "id"));
        assertNotNull(exception);
        assertEquals(HttpStatus.NOT_FOUND, exception.getStatus());
        assertEquals(ERROR_DATA_NOT_FOUND, exception.getReason());
    }
}