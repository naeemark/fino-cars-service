package com.naeemark.fcs.repositories;

import com.naeemark.fcs.models.Car;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

/**
 * Created by Naeem <naeemark@gmail.com>.
 * <p>
 * Created on: 2023-03-27
 */
@Component
public interface CarRepository extends PagingAndSortingRepository<Car, Integer> {
    Iterable<Car> findByIdOrMakeOrModelYearOrYearOrTypeOrFuelType(Integer id, String make, String modelYear, Integer year, String type, String fuelType);
}