package com.naeemark.fcs.services;

import com.naeemark.fcs.models.Car;

import java.util.List;


/**
 * Created by Naeem <naeemark@gmail.com>.
 * <p>
 * Created on: 2023-03-27
 */
public interface CarService {
    List<Car> findAll();

    List<Car> findPage(int pageNo, int pageSize, String sortBy);

    List<Car> search(Integer id, String make, String modelYear, Integer year, String engineType, String type);

}
