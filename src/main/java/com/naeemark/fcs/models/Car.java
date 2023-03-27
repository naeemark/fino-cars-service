package com.naeemark.fcs.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by Naeem <naeemark@gmail.com>.
 * <p>
 * Created on: 2023-03-27
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "cars")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "make")
    private String make;
    @Column(name = "model_year")
    private String modelYear;
    @Column(name = "year")
    private int year;
    @Column(name = "engine_type")
    private String engineType;
    @Column(name = "type")
    private String type;
    @Column(name = "fuel_type")
    private String fuelType;
    @Column(name = "driveline")
    private String driveline;
    @Column(name = "classification")
    private String classification;
    @Column(name = "number_of_forward_gears")
    private int forwardGears;
    @Column(name = "transmission")
    private String transmission;
    @Column(name = "horsepower")
    private int horsepower;
    @Column(name = "city_miles_per_gallon")
    private int cityMilesPerGallon;
    @Column(name = "highway_miles_per_gallon")
    private int highwayMilesPerGallon;
    @Column(name = "width")
    private int width;
    @Column(name = "height")
    private int height;
    @Column(name = "length")
    private int length;
    @Column(name = "image_uri")
    private String imageUri;
}
