package com.naeemark.fcs.repositories;

import com.naeemark.fcs.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * Created by Naeem <naeemark@gmail.com>.
 * <p>
 * Created on: 2023-03-27
 */
@Component
public interface CarRepository extends JpaRepository<Car, Integer> {
}