package com.naeemark.fcs.api.cars;

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
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

/**
 * Created by Naeem <naeemark@gmail.com>.
 * <p>
 * Created on: 2023-03-27
 */

@Api(tags = "1 - Cars", description = "Operations related to Cars")
@RestController
@RequestMapping("/api/cars")
public class CarController {

    @Autowired
    private CarService carService;

    private static final Logger logger = LoggerFactory.getLogger(CarController.class);

    /**
     * Gets Cars List
     *
     * @return Car Response
     */
    @ApiOperation(value = "List Cars", notes = "Gets all cars with balance", response = Collection.class, tags = {"1 - Cars"})
    @ApiResponses(value = {
            @ApiResponse(code = 304, message = "Operation was not successful"),
            @ApiResponse(code = 417, message = "Expectations failed"),
            @ApiResponse(code = 422, message = "Request not processable")
    })
    @GetMapping
    public ResponseEntity<List<Car>> list() {
        logger.info("Request received for Cars List");
        List<Car> cars = carService.list();
        return ResponseEntity.ok(cars);
    }
}
