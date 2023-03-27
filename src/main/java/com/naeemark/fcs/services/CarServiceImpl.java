package com.naeemark.fcs.services;

import com.naeemark.fcs.models.Car;
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
    @Override
    public List<Car> list() {
        return Collections.emptyList();
    }
}
