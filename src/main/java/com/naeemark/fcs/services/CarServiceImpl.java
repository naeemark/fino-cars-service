package com.naeemark.fcs.services;

import com.naeemark.fcs.models.Car;
import com.naeemark.fcs.repositories.CarRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;


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
    public List<Car> list() {
        return carRepository.findAll();
    }
}
