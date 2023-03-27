package com.naeemark.fcs.services;

import com.naeemark.fcs.models.Car;
import com.naeemark.fcs.repositories.CarRepository;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static com.naeemark.fcs.utils.Constants.ERROR_DATA_NOT_FOUND;
import static com.naeemark.fcs.utils.Constants.ERROR_PARAM_NOT_ALLOWED;


/**
 * Created by Naeem <naeemark@gmail.com>.
 * <p>
 * Created on: 2023-03-27
 */

@Service
@Transactional
public class CarServiceImpl implements CarService {

    private static final Logger logger = LoggerFactory.getLogger(CarServiceImpl.class);
    @Autowired
    CarRepository carRepository;

    @Override
    public List<Car> findAll() {
        try {
            Iterable<Car> all = carRepository.findAll();
            return StreamSupport.stream(all.spliterator(), false).collect(Collectors.toList());
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ERROR_DATA_NOT_FOUND);
        }
    }

    @Override
    public List<Car> findPage(int pageNo, int pageSize, String sortBy) {
        try {
            Pageable pageRequest = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
            Iterable<Car> all = carRepository.findAll(pageRequest);
            return StreamSupport.stream(all.spliterator(), false).collect(Collectors.toList());
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ERROR_DATA_NOT_FOUND);
        }
    }

    @Generated
    @Override
    public List<Car> search(Integer id, String make, String modelYear, Integer year, String type, String fuelType) {
        try {
            validateParams(id, make, modelYear, year, type, fuelType);
            Iterable<Car> search = carRepository.findByIdOrMakeOrModelYearOrYearOrTypeOrFuelType(id, make, modelYear, year, type, fuelType);
            return StreamSupport.stream(search.spliterator(), false).collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            logger.error(e.getMessage());
            throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED, ERROR_PARAM_NOT_ALLOWED);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ERROR_DATA_NOT_FOUND);
        }
    }

    /**
     * Utility Method to validate provide number of search parameters
     * @param params Array
     */
    @Generated
    private void validateParams(Object... params) {
        long count = Arrays.stream(params).filter(Objects::nonNull).count();
        if (count > 1) {
            throw new IllegalArgumentException(ERROR_PARAM_NOT_ALLOWED);
        }
    }
}
