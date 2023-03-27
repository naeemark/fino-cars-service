package com.naeemark.fcs.api.cars;

import com.naeemark.fcs.config.SwaggerConfiguration;
import com.naeemark.fcs.models.Car;
import com.naeemark.fcs.services.CarService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

/**
 * Created by Naeem <naeemark@gmail.com>.
 * <p>
 * Created on: 2023-03-27
 */

@RestController
@RequestMapping("/api/cars")
@Api(tags = {SwaggerConfiguration.CARS_TAG})
public class CarController {

    @Autowired
    private CarService carService;

    private static final Logger logger = LoggerFactory.getLogger(CarController.class);

    /**
     * Gets Cars List
     *
     * @return List of Car Response
     */
    @ApiOperation(value = "List Cars", notes = "Gets all cars", response = Collection.class, tags = {SwaggerConfiguration.CARS_TAG})
    @ApiResponses(value = {
            @ApiResponse(code = 304, message = "Operation was not successful"),
            @ApiResponse(code = 422, message = "Request not processable")
    })
    @GetMapping
    public ResponseEntity<List<Car>> listAll() {
        logger.info("Request received for Cars List");
        List<Car> cars = carService.findAll();
        return ResponseEntity.ok(cars);
    }

    /**
     * Gets Cars List with Pagination
     *
     * @return List of Car Response
     */
    @ApiOperation(value = "List Cars with Pagination", notes = "Gets all cars with pagination", response = Collection.class, tags = {SwaggerConfiguration.CARS_TAG})
    @ApiResponses(value = {
            @ApiResponse(code = 304, message = "Operation was not successful"),
            @ApiResponse(code = 422, message = "Request not processable")
    })
    @GetMapping("/page")
    public ResponseEntity<List<Car>> listWithPagination(
            @RequestParam(defaultValue = "1") Integer number,
            @RequestParam(defaultValue = "3") Integer size,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        logger.info("Request received for Cars List");
        List<Car> cars = carService.findPage(number-1, size, sortBy);
        return ResponseEntity.ok(cars);
    }

    /**
     * Gets Cars List by search
     *
     * @return List of Car Response
     */
    @ApiOperation(value = "List Cars by Search", notes = "Gets cars by Search", response = Collection.class, tags = {SwaggerConfiguration.CARS_TAG})
    @ApiResponses(value = {
            @ApiResponse(code = 304, message = "Operation was not successful"),
            @ApiResponse(code = 422, message = "Request not processable")
    })
    @GetMapping("/search")
    public ResponseEntity<List<Car>> search(
            @RequestParam(required = false) Integer id,
            @RequestParam(required = false) String make,
            @RequestParam(required = false) String modelYear,
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String fuelType
    ) {
        logger.info("Request received for Cars List by Search param");
        List<Car> cars = carService.search(id,
                make,
                modelYear,
                year,
                type,
                fuelType);
        return ResponseEntity.ok(cars);
    }
}
