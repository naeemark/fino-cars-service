package com.naeemark.fcs.services;

import com.naeemark.fcs.models.Car;
import com.naeemark.fcs.repositories.CarRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static com.naeemark.fcs.utils.Constants.ERROR_DATA_NOT_FOUND;


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
            return carRepository.findAll();
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ERROR_DATA_NOT_FOUND);
        }
    }
}
